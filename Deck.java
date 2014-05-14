import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private Random rand;
	
	public Deck() {
		rand = new Random();
		cards = new ArrayList<Card>(50);
		generateUnshuffledDeck();
		shuffleCards();
	}
	
	private void generateUnshuffledDeck() {
		for (int number = 1; number <= 5; number++) {
			// Number of copies of a card for this number (3 1's, 2 2's, etc.).
			int numCopies;
			switch (number) {
				case 1: numCopies = 3; break;
				case 2: numCopies = 2; break;
				case 3: numCopies = 2; break;
				case 4: numCopies = 2; break;
				case 5: numCopies = 1; break;
				default: numCopies = 0;
			}
			for (String color : Game.VALID_COLORS) {
				for (int j = 0; j < numCopies; j++)
					cards.add(new Card(color, number));
			}
		}
	}
	
	public void shuffleCards() {
		for (int i = 0; i < cards.size(); i++) {
			// Pick a random index from j to the end of the list.
			int j = i + rand.nextInt(cards.size() - i);
			Card temp = cards.get(i);
			cards.set(i, cards.get(j));
			cards.set(j, temp);
		}
	}
	
	public Card drawCard() {
		if (cards == null || cards.size() == 0)
			return null;
		// Draw from the end of the array list to avoid shifting everything over.
		return cards.remove(cards.size()-1);
	}

	public String toString() {
		if (cards == null || cards.size() == 0)  return "No cards in deck.";
		String out = "";
		for (Card card : cards) {
			if (card != null)
				out += card.getColor() + " " + card.getNumber() + "\n";
		}
		return out;
	}
}