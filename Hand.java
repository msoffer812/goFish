package goFish;
import java.util.*;

public class Hand{
	String rank;
	List<Card> cards;
	
	public Hand(Card c)
	{
		cards = new ArrayList<>();
		cards.add(c);
		this.rank = c.getRank();
	}
	public Hand()
	{
		
	}
	public String getRank()
	{
		return rank;
	}
	public boolean compareRank(String rank)//for rank comparisons given a string, good for requesting cards from a player. convert both to lowercase so case isn't included
	{
		if(this.rank.toLowerCase().equals(rank.toLowerCase()))
		{
			return true;
		}
		return false;
	}
	public boolean compareRank(Card c)
	{
		if(c.getRank().equals(this.rank))
		{
			return true;
		}
		return false;
	}
	public boolean compareRank(Hand h)
	{
		if(h.getRank().equals(this.rank))
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
		String s = cards.size() + " " + this.rank + "s";
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
		return cards;
	}
	
	public int size()
	{
		return cards.size();
	}
}
