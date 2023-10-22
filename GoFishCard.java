package goFish;

public class GoFishCard implements Card{
	private String rank;
	private String suit;
	
	//constructor
	public GoFishCard(String r, String s)
	{
		this.rank = r;
		this.suit = s;
	}
	//copy constructor
	public GoFishCard(Card c)
	{
		this.rank = c.getRank();
		this.suit = c.getSuit();
	}
	@Override
	public String getRank()
	{
		return this.rank;
	}
	@Override
	public String getSuit()
	{
		return this.suit;
	}
	@Override
	public String toString()
	{
		String message = this.rank + " of " + this.suit;
		return message;
	}
}
