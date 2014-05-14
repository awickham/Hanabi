import java.util.HashMap;
import java.util.ArrayList;

public class Game {
	public static String[] VALID_COLORS = new String[] {"Red", "White", "Blue", "Green", "Yellow"};
	// Store the highest number of each color that have been played.
	public static HashMap<String, Integer> highestValues = new HashMap<String, Integer>();;
	public static ArrayList<Card> discardPile = new ArrayList<Card>();
	public static Deck deck = new Deck();
	public static int numHints = 8;
	public static int numBombs = 3;
	
	public static void initialize() {
		// Highest value for each card is initialized to 0 because none have been played.
		for (String color : VALID_COLORS) {
			highestValues.put(color, 0);
		}
	}
	public static boolean isValidPlay(Card card) {
		return card != null && card.getNumber() == highestValues.get(card.getColor()) + 1;
	}
	public static void playCard(Card card) {
		if (!isValidPlay(card)) {
			if (card != null)  discardPile.add(card);
			numBombs -= 1;
			// TODO handle game over when no bombs left.
		} else {
			highestValues.put(card.getColor(), card.getNumber());
			// Get a hint for completing a set of 5 for a color.
			if (card.getNumber() == 5 && numHints < 8) {
				numHints += 1;
				// TODO handle win state if last 5 played.
			}
		}
	}
	public static boolean isValidDiscard(Card card) {
		return card != null;
	}
	public static void discardCard(Card card) {
		discardPile.add(card);
		// Get a hint for discarding, up to a max of 8 hints.
		if (numHints < 8) {
			numHints += 1;
		}
	}
}