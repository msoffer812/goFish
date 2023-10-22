package goFish;

import java.util.List;
//I added some methods to the interface because it helps with polymorphism and I don't need to specify whether the player is a computerPlayer or a humanPlayer
public interface Player {
	String getName();
	int getID();
	Hand giveHand(String Hand);//method gives another player matching hand
    UserDeck getHand();
  //I have three different methods for addCards because three different ways to give over cards, and they're all handled differently
    void addToHand(Hand cards);
    void addToHand(Card card);
    Request play(int index);
    WinningDeck getWinnings();
    int deckSize();
}
