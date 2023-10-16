package goFish;
import java.util.*;

public class Hand{
	String rank;
	List<Card> cards;
	
	public Hand(Card c)
	{
		cards.add(c);
		this.rank = c.getRank();
	}
	public Hand()
	{
		rank = "Go Fish";
		cards = new ArrayList<Card>();
	}
	public String getRank()
	{
		return rank;
	}
	
	public boolean compareRank(Card c)
	{
		if(c.getRank().equals(this.rank))
		{
			return true;
		}
		return false;
	}
	public void addCard(Card c)
	{
		this.cards.add(c);
	}
	@Override
	public String toString()
	{
		String s = cards.size() + " " + this.rank;
		return s;
	}
	public boolean isComplete()
	{
		if(cards.size() == 4)
		{
			return true;
		}
			return false;
	}
	public List<Card> getCards()
	{
		List<Card> cards = new ArrayList<Card>();
		for(int i=0;i<cards.size();i++)
		{
			cards.add(cards.get(i));
		}
		return cards;
	}
	//can override?
	public int size()
	{
		return cards.size();
	}
}
