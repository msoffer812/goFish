package goFish;

public class GoFishPlayer implements Player{
    private UserDeck hand;
    private UserDeck winnings;

    public GoFishPlayer()
    {
    	this.hand = new UserDeck();
    	this.winnings = new UserDeck();
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

    @Override
    public void addToHand(Card card) {
    	hand.addCard(card);
    	if(hand.getMatch(card.getRank()).isComplete())
    	{
    		winnings.addHand(hand.remove(card.getRank()));
    	}
    }
    public void addToHand(Hand cards) {
    	hand.addHand(cards);
    }

    public int getWinnings()
    {
    	return winnings.size();
    }
    public int deckSize()//When playing go fish, you usually decide who to request the card from based off of who has the most. This is essential for that decision
    {
    	return hand.size();
    }
    @Override
    public Request play(int index, String rank) {
    	Request r = new Request(rank, index);
    	return r;
    }
}
