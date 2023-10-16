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
		Card card = this.cards.get(0);
		//Because you can't draw a card and it's still in the pile
		this.cards.remove(0);
		return card; 
	}
	
	//shuffle method
	@Override
	public void shuffleDeck()
	{
		Collections.shuffle(cards);
	}
	
	public boolean checkBooks()
	{
		String rank;
		int count;
		for(int i=0;i<cards.size();i++)
		{
			rank = cards.get(i).getRank();
			count=0;
			for(int z=0;z<cards.size();z++)
			{
				if(cards.get(z).equals(rank))
				{
					count++;
				}
			}
			if (count == 4)
			{
				return true;
			}
		}
		return false;
	}
}
