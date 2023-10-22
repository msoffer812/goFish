package goFish;
import java.util.*;
public class WinningDeck extends UserDeck{
	public WinningDeck()
	{
		super();
	}
	public WinningDeck(WinningDeck d)
	{
		super(d);
	}
	@Override
	public void addCards(Hand fullBook)
	{
		super.hand.add(fullBook);
	}
	@Override
	public int size()
	{
		return super.hand.size();
	}
	@Override
	public String toString()//Prints out winnings, just good for debugging
    {
    	StringBuilder str = new StringBuilder();
    	int i = 0;
    	if(hand.size() == 0)
    	{
    		return "No winnings yet";
    	}
    	for(i = 0;i<hand.size()-1;i++)
    	{
    		str.append(getRank(i));
    		str.append(", ");
    	}
    	str.append(getRank(i));
    	return str.toString();
    }
}
