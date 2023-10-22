package goFish;
import java.util.*;

public class GoFishGame implements Game {
    private List<Player> players;
    private GoFishDeck deck;

    public GoFishGame(List<Player> players)//This is the constructor I will use.
    {
    	initializeDeck();
    	//initializing computer player bec automatic
    	ComputerPlayer p = new ComputerPlayer();
    	this.players = new ArrayList<>();
    	this.players.add(p);
    	this.players.addAll(players);
    }
    //No-arg constructor, not going to be using
    public GoFishGame()
    {
    	initializeDeck();
    	this.players = new ArrayList<>();
    	//initializing computer player bec automatic
    	ComputerPlayer p = new ComputerPlayer();
    	players.add(p);
    }
    //initializes the deck
    private void initializeDeck()
    {
    	String[] rank = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    	String[] suite = {"Spades", "Diamonds", "Hearts", "Clovers"};
    	Card c;
    	List<Card> cards = new ArrayList<>();
    	for(int i=0;i<4;i++)
    	{
    		for(int a=0;a<13;a++)
    		{
    			c = new GoFishCard(rank[a], suite[i]);
    			cards.add(c);
    		}
    	}
    	deck = new GoFishDeck(cards);
    	deck.shuffleDeck();
    }

    @Override
    public void startGame() {
        //We deal the cards:
    	Card c;
    	for(int i=0;i<players.size();i++)
    	{
    		for(int a=0;a<7;a++)
    		{
    			c = deck.drawCard();
    			players.get(i).addToHand(c);
    		}
    	}
    	//Now we have a loop that plays the game
    	boolean endGame = false;
    	while(!isGameOver() && !endGame)
    	{
    		for(int z=0;z<players.size();z++)
    		{
    			playTurn(players.get(z));
    			//If we run out of cards in the deck or a player ends up with only full books, 
    			//then the game ends and we don't want to go over the rest of the players in the round
    			if(players.get(z).deckSize() == 0)
    			{
    				endGame = true;
    				break;
    			}else if(isGameOver())
    			{
    				break;
    			}
    		}
    	}
    	this.endGame();
    }

    @Override
    public boolean isGameOver() {
    	if(deck.isEmpty())
		{
    		if(deck.isEmpty())
    		{
    			System.out.println("Deck is empty");
    		}
			return true;
		}
        return false; 
    }
    // Implement the game logic for playing a turn here
    @Override
    public void playTurn(Player player) {
    	//Saying who's turn it is:
    	System.out.println(player.getName() + "'s turn:");
    	Player p;
    	Player person;
    	//Find the player with the most cards. This is good for deciding who to request cards from
    	int index = player.getID();
    	if(index == 0)//Player person is the person with the most cards besides the current player
    	{
    		person = players.get(1);
    	}else
    	{
    		person = players.get(0);
    	}
    	for(int i=0;i<players.size();i++)
    	{
    		if(i != index)
    		{
    			p = players.get(i);
        		if(p.deckSize() > person.deckSize())
        		{
        			person = p;
        		}
        		System.out.println(p.getID()+1 + ": " + p.getName() + " has " + p.deckSize() + " cards.");
    		}
    	}
    	System.out.println("Your cards are: " + player.getHand().toString());
    	System.out.println("You can now request a card from another player which you already possess.");
    	Request r;
    	if(player.getID() == 0)
    	{
    		r = player.play(person.getID());//Passing into computerPlayer the info of who has the biggest deck
    	}else
    	{
    		r = player.play(players.size());//Passing into them the info of how many players there are - used for validation
    	}
    	String rank = r.getRank();
    	int requestee = r.getReq();
    	System.out.println("Requesting " + rank + "s from " + players.get(requestee).getName());
    	Hand h = players.get(requestee).giveHand(rank);
    	if(h == null)
    	{
    		System.out.println("Go Fish");
    		Card c = deck.drawCard();
    		player.addToHand(c);
    		System.out.println("Picked " + c.toString());
    	}else
    	{
    		System.out.println("Received " + h.size() + " " + h.getRank() + "s");
    		player.addToHand(h);
    	}
    	System.out.println("Winnings: " + player.getWinnings().toString());
		System.out.println("");
		System.out.println("");
    }

    @Override
    public void endGame() {
    	Stack<Player> winners = new Stack<>();
        for(Player p:players)
        	{
        		System.out.println(p.getName() + ": " + p.getWinnings().toString() + "; " + p.getWinnings().size() + " matches");
        		if(winners.empty())
        		{
        			winners.push(p);
        		}else
        		{
        			if(winners.peek().getWinnings().size() < p.getWinnings().size())
            		{
        				winners = new Stack<>();
            			winners.push(p);
            		}else if(winners.peek().getWinnings().size() == p.getWinnings().size())
            		{
            			winners.push(p);
            		}
        		}
        	}
        if(winners.size() > 1)
        {
        	System.out.println("It's a tie! The winners are ");
        	int winningAmount = winners.peek().getWinnings().size();
        	while(!winners.empty())
        	{
        		System.out.print("The winner is: " + winners.pop().getName() + ", ");
        	}
        }
        
    }
}
