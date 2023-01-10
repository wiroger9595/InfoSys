package CardGame_Question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card> {
//	private Card() {
//	}

	public enum CardNumber {
		TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13),
		ACE(14);

		private int cardNumber;

		private CardNumber(int cardNumber) {
			this.cardNumber = cardNumber;
		}

		
		public int getOrder() {
			return cardNumber;
		}
	}

	public enum CardType {
		CLUB, DIAMOND, HEARTS, SPADE;
	}

	private CardNumber cardNumber;
	private CardType cardType;

	public CardNumber getCardNumber() {
		return cardNumber;
	}

	public CardType getCardType() {
		return cardType;
	}

	public static List<Card> getPackOfCards() {
		List<Card> cardList = new ArrayList<Card>();

		for (CardType cardType : CardType.values()) {
			for (CardNumber cardNumber : CardNumber.values()) {
				Card card = new Card();
				card.cardNumber = cardNumber;
				card.cardType = cardType;
				cardList.add(card);
			}
		}
		return cardList;
	}

	public static void shuffleCards(List<Card> cards) {
		Collections.shuffle(cards);
	}

	@Override
	public int compareTo(Card card) {
		if (this.getCardNumber() == card.getCardNumber()) {
			return 0;
		} else if (this.getCardNumber().getOrder() > card.getCardNumber().getOrder()) {
			return 1;
		} else
			return -1;
	}

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", cardType=" + cardType + "]";
	}
}