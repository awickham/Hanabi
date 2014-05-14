import org.fusesource.jansi.*;
import java.util.Scanner;

public class Hanabi {
	public static void main(String[] args) {
		Game.initialize();
		Scanner input = new Scanner(System.in);
		int numPlayers;
		if (args.length == 1) {
			numPlayers = Integer.valueOf(args[0]);
		} else {
			numPlayers = 4;
		}
		Player[] players = new Player[numPlayers];
		for (int id = 0; id < numPlayers; id++) {
			players[id] = new Player(id);
		}
		for (int currentTurn = 0; currentTurn < numPlayers; currentTurn++) {
			Util.clearScreen();
			System.out.print("Player " + (currentTurn + 1) + ": Press enter when ready to start. ");
			input.nextLine();
			for (Player p : players) {
				System.out.println("***Player " + (p.getId()+1) + "***");
				if (p.getId() != currentTurn) {
					p.printHand();
				} else {
					for (int k = 0; k < p.getCards().size(); k++) {
						System.out.println("???");
					}
				}
				System.out.println();
			}
			System.out.print("Press enter when done with turn. ");
			input.nextLine();
		}
	}
}