package goFish;
import java.util.List;

public class ComputerPlayer implements Player {
    private String name;
    private int id;//computer index will always be zero
    private UserDeck hand;
    private WinningDeck winnings;

    public ComputerPlayer(List<Card> hand) {
    	this.id = 0;
        this.name = "Computer";
        this.hand = new UserDeck(hand);
        this.winnings = new WinningDeck();
    }
    public ComputerPlayer() {
        this.name = "Computer";
        this.hand = new UserDeck();
        this.winnings = new WinningDeck();
        this.id = 0;
    }

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
        	System.out.println("Book Completed! Setting aside " + card.getRank() + "s");
    		winnings.addCards(hand.remove(card.getRank()));
    	}
    }
    @Override
    public void addToHand(Hand cards) {
    	hand.addCards(cards);
    	if(hand.getMatch(cards.getRank()).isComplete())
    	{
    		System.out.println("Book Completed! Setting aside " + cards.getRank() + "s");
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
    //formats the request and sends it in
    @Override
    public Request play(int indexBiggest) {
    	String rankRequest;
    	if(hand.size() > 1)
    	{
    		rankRequest = hand.getBiggestBookRank();
    	}else
    	{
    		//if only group of matches in your hand, just request that one
    		rankRequest = hand.getRank(0);
    	}
    	//The computer will decide which rank to request based on the rank it has the most of
    	//The computer will decide who to request cards from based on who has the most cards
    	Request r = new Request(rankRequest, indexBiggest);
    	return r;//return the request
    }
}
