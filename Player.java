import java.util.ArrayList;

public class Player {
	private int id;
	private ArrayList<Card> cards;
	
	public Player(int id) {
		// Use 4 cards as default hand size.
		this(id, 4);
	}
	public Player(int id, int numCards) {
		this.id = id;
		cards = new ArrayList<Card>();
		drawCards(numCards);
	}
	public void drawCard() {
		drawCards(1);
	}
	public void drawCards(int numCards) {
		for (int i = 0; i < numCards; i++) {
			Card card = Game.deck.drawCard();
			if (card != null)  cards.add(card);
		}
	}
	public int getId() {
		return id;
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void printHand() {
		if (cards == null || cards.size() == 0) {
			System.out.println("No cards in hand.");
			return;
		}
		for (Card card : cards) {
			if (card != null) {
				AnsiColors.printStringInColor(card.getColor() + " " + card.getNumber(), card.getColor());
			}
		}
	}
}