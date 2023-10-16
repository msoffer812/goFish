package goFish;
import java.util.*;

public class UserDeck {
	List<Hand> hand;
	
	public UserDeck(List<Card> firstPick)
	{
		hand = new ArrayList<Hand>();
		addCards(firstPick);
	}
	public UserDeck() {
		hand = new ArrayList<Hand>();
	}
	public Hand getMatch(String rank)
	{
		for(int i=0;i<hand.size();i++)
		{
			if(hand.get(i).getRank().equals(rank))
			{
				return hand.get(i);
			}
		}
		Hand h = new Hand();
		return h;
	}
	public List<Hand> getSortedUserDeck()
	{
		List<Hand> h = new ArrayList<Hand>(this.hand);
		return h;
	}
	public String getBiggestBookRank()
	{
		int index = 0;
		for(int i=0; i<(hand.size()-1); i++)
		{
			if (hand.get(i).size() > hand.get(i-1).size())
			{
				index = i;
			}
		}
		return hand.get(index).getRank();
	}
	public List<Card> getListUserDeck()
	{
		List<Card> cards = new ArrayList<Card>();
		for(int i=0; i<hand.size(); i++)
		{
			cards.addAll(hand.get(i).getCards());
		}
		return cards;
	}
	public void addCardFromDeck(Card card)
	{
		GoFishCard c = new GoFishCard(card);
		boolean added = false;
		for(int i=0;i<hand.size();i++)
		{
			if(hand.get(i).compareRank(c))
			{
				hand.get(i).addCard(c);
				added = true;
			}
		}
		if(!added)
		{
			Hand h = new Hand(c);
			hand.add(h);
		}
	}
	public void addCardFromOtherPlayer(List<Card> cards)
	{
		addCards(cards);
	}
	public void addCards(List<Card> cards)
	{
		String rank;
		Hand h;
  		while(!cards.isEmpty())
  		{
  			rank = cards.get(0).getRank();
  			h = new Hand(cards.get(0));
  			hand.remove(0);
  			for(int i=0; i<hand.size(); i++)
  			{
  				if(h.compareRank(cards.get(i)))
  				{
  					h.addCard(cards.get(i));
  					cards.remove(i);
  				}
  			}
  			this.hand.add(h);
  		}
	}
}
