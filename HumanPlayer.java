package goFish;
import java.util.*;

public class HumanPlayer implements Player {
    private String name;
    private UserDeck hand;

    public HumanPlayer(String name, List<Card> hand) {
        this.name = name;
  		this.hand = new UserDeck(hand);
    }
    public HumanPlayer(String n)
    {
    	this.name = n;
    	this.hand = new UserDeck();
    }
    
    //Getters
    @Override
    public String getName() {
        return name;
    } 
    @Override
    public List<Card> getHand() {
    	List<Card> cards = new ArrayList<Card>(hand.getListUserDeck());
		return cards;
    }

    @Override
    public void addToHand(Card card) {
    	hand.addCardFromDeck(card);
    }
    public void addCardsFromOtherPlayer(List<Card> cards) {
    	hand.addCardFromOtherPlayer(cards);
    }

    @Override
    public void play() {
    	
    }
}
