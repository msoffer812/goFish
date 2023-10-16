package goFish;
import java.util.List;

public class ComputerPlayer implements Player {
    private String name;
    private UserDeck hand;

    public ComputerPlayer(String name, List<Card> hand) {
        this.name = name;
        this.hand = new UserDeck(hand);
    }

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
        hand.add(card);
    }

    @Override
    public void play() {
        for(int i=0;i<hand.size();i++)
        {
        	
        }
    }
}
