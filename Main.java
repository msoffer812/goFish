package goFish;
import java.io.IOException;
import java.util.*;
public class Main {
	public static void main(String[] args)throws IOException
	{
		GoFishGame game;
		HumanPlayer player;
		List<Player> people;
		int cont, players;
		String name;
		//Initializing the players:
		do
		{
			people = new ArrayList<>();
			players = intInput(1, 4, "Enter the amount of players, max 4:");
			for(int i=0;i<players;i++)
			{
				name = stringInput("Enter a name for Player " + (i+1));
				player = new HumanPlayer(name , i+1);
				people.add(player);
			}
			game = new GoFishGame(people);
			game.startGame();
			cont = intInput(1, 2, "1. Play a new game \n2.Quit");
		}while(cont == 1);
		System.out.println("Goodbye.");
		System.exit(0);
	}
	public static String stringInput(String message)throws IOException
	{
		Scanner in;
		String input="";
		boolean cont;
		do
		{
			cont = false;
			System.out.println(message);
			in = new Scanner(System.in);
			try
			{
				input = in.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("Invalid input, please reenter");
				cont = true;
			}
		}
		while(cont || input.length()<=0);
		return input;
	}
	public static int intInput(int min, int max, String message)throws IOException
	{
		int cont=0;
		Scanner in;
		do
		{
			System.out.println(message);
			in = new Scanner(System.in);
			try
			{
				cont = in.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
			}
		}
		while(cont > max);
		return cont;
	}
}
