package goFish;
import java.util.*;

public class GoFishDeck implements Deck{
	private List<Card> cards;
	
	//constructors
	public GoFishDeck(List<Card> c)
	{
		this.cards = c;
	}
	public GoFishDeck()
	{
		this.cards = new ArrayList<Card>();
	}
	
	//Getter -good for debugging
	public List<Card> getCards()
	{
		return this.cards;
	}
	
	//Drawing a card
	@Override
	public Card drawCard()
	{
		//Because you can't draw a card and it's still in the pile, we remove it
		Card card = this.cards.remove(0);
		return card; 
	}
	//shuffle method
	@Override
	public void shuffleDeck()
	{
		Collections.shuffle(cards);
	}
	public boolean isEmpty()
	{
		return this.cards.isEmpty();
	}
}
