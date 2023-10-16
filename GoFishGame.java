package goFish;
import java.util.*;

public class GoFishGame implements Game {
    private List<Player> players;
    private GoFishDeck deck;

    public GoFishGame(List<Player> players, GoFishDeck deck) {
        this.players = players;
        this.deck = deck;
    }

    @Override
    public void startGame() {
        // Implement the game initialization here
    }

    @Override
    public boolean isGameOver() {
    	List<Card> l = new ArrayList<Card>(deck.getCards());
    	if(l.isEmpty() || !this.deck.checkBooks())
		{
			return true;
		}
        return false; 
    }

    @Override
    public void playTurn(Player player) {
        // Implement the game logic for playing a turn here
    }

    @Override
    public void endGame() {
        if(this.isGameOver())
        {
        	for(int i=0;i<players.size(); i++)
        	{
        		if(players.get(i).get)
        	}
        }
    }
}
