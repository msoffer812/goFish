package goFish;
import java.util.*;

public class UserDeck {
	protected List<Hand> hand;
	protected int size;//this is the amount of cards in the deck, useful for people to decide from whom to pick from
	
	public UserDeck(List<Card> firstPick)
	{
		hand = new ArrayList<Hand>();
		addCards(firstPick);
		size = firstPick.size();
	}
	public UserDeck() {
		hand = new ArrayList<Hand>();
		size = 0; 
	}
	public UserDeck(UserDeck d)
	{
		this.hand = new ArrayList<Hand>(d.getUserDeck());
		this.size = d.size();
	}
	public Hand getMatch(String rank)
	{
		for(int i=0;i<hand.size();i++)
		{
			if(hand.get(i).getRank().toLowerCase().equals(rank.toLowerCase()))
			{
				return hand.get(i);
			}
		}
		return null;
	}
	public List<Hand> getUserDeck()
	{
		return this.hand;
	}
	public String getBiggestBookRank()
	{
		Hand h = hand.get(0);
		for(int i=1; i<hand.size(); i++)
		{
			if (hand.get(i).size() > h.size())
			{
				h = hand.get(i);
			}
		}
		return h.getRank();
	}
	public String getRank(int i)
	{
		return hand.get(i).getRank();
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
	public void addCards(Card card)
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
		this.size++;
	}
	//this is for the occasion that another player gives cards of the same rank
	public void addCards(Hand cards)
	{
		boolean added = false;
		for(Hand h: hand)
		{
			if(h.compareRank(cards))
			{
				List<Card> c = cards.getCards();
				for(int i=0;i<cards.size();i++)
				{
					h.addCard(c.get(i));
					added = true;
				}
				break;
			}
		}
		this.size += cards.size();
		//There is no else for adding cards - the only situation where they would get a hand is from someone else, and they are only allowed to add if they already possess the rank
	}
	//When initially picking, this is necessary to sort deck into hands
	public void addCards(List<Card> cards)
	{
		String rank;
		Hand h;
  		while(!cards.isEmpty())
  		{
  			rank = cards.get(0).getRank();
  			h = new Hand(cards.get(0));
  			hand.remove(0);
  			for(int i=hand.size()-1; i>=0; i--)//Set up like this so no card is skipped if it's removed
  			{
  				if(h.compareRank(cards.get(i)))
  				{
  					h.addCard(cards.get(i));
  					cards.remove(i);
  				}
  			}
  			this.hand.add(h);
  		}
  		this.size += cards.size();
	}
	
	//This is either to give to another player who requests or to put in winnings deck once it's full
	public Hand remove(String rank)
	{
		for(int i=0;i<hand.size();i++)
		{
			if(hand.get(i).compareRank(rank))
			{
				size -= hand.get(i).size();
				return hand.remove(i);
			}
		}
		return null;//The receiver will interpret this as 'go fish' if returns null, meaning the player has no hands of the requested rank
	}
	//returns amount of cards in the deck, good for deciding from whom to pick from.
	public int size()
	{
		return this.size;
	}
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		String s;
		for(int i=0;i<hand.size();i++)
		{
			s = hand.get(i).toString();
			str.append("\n");
			str.append(s);
		}
		return str.toString();
	}
}
