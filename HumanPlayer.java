package goFish;
import java.util.*;

public class HumanPlayer implements Player {
    private String name;//This is the name of the player - makes it more fun
    private int id;//this is their index in the goFishGame
    private UserDeck hand;
    private WinningDeck winnings;

    public HumanPlayer(String n, int index)
    {
    	this.id = index;
    	this.name = n;
    	this.hand = new UserDeck();
    	this.winnings = new WinningDeck();
    }
    
    //Getters
    @Override
    public String getName() {
        return name;
    } 
    @Override
    public UserDeck getHand() {
    	return hand;
    }
    public int getID()
    {
    	return this.id;
    }
    
    public Hand giveHand(String rank)
    {
    	return hand.remove(rank);
    }
    
    @Override
    public void addToHand(Card card) {
    	hand.addCards(card);
    	if(hand.getMatch(card.getRank()).isComplete())
    	{
    		winnings.addCards(hand.remove(card.getRank()));
    	}
    }
    @Override
    public void addToHand(Hand cards) {
    	hand.addCards(cards);
    	if(hand.getMatch(cards.getRank()).isComplete())
    	{
    		winnings.addCards(hand.remove(cards.getRank()));
    	}
    }
    @Override
    public WinningDeck getWinnings()
    {
    	WinningDeck d = new WinningDeck(winnings);
    	return d;
    }
    @Override
    public int deckSize()//When playing go fish, you usually decide who to request the card from based off of who has the most. This is essential for that decision
    {
    	return hand.size();
    }
    @Override
    public Request play(int amountOfUsers) {
    	//I really couldn't think up a practical way to implement user interaction without having input directly in the class
    	System.out.println("Rank: ");
    	Scanner in;
    	String rank = "";
    	int i = -1;
    	do {
    		if(i>0)
    		{
    			System.out.println("Invalid input, please give a rank that you posses");
    		}
    		in  = new Scanner(System.in);
        	rank = in.nextLine();
        	i = 1;
    	}while(hand.getMatch(rank) == null);
    	System.out.println("Requestee: ");
    	int user = 0;
    	boolean error=false, cont;
    	do
    	{
    		if(error)
    		{
    			System.out.println("Invalid input, please reenter");
    		}
    		cont = false;
    		try
    		{
    			in = new Scanner(System.in);
            	user = in.nextInt();
    		}catch(InputMismatchException e)
    		{
    			cont = true;
    		}
    		error = true;
    	}while(user<1 || user > amountOfUsers || user == id+1 || cont);
    	Request r = new Request(rank, user-1);
    	return r;
    }
    
}
