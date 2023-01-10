package CardGame_Question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CardGame implements Game {
	private List<Card> cards;

	private List<Player> players = new ArrayList<Player>();

	private Map<Player, List<Card>> cardsPlayerMap = new HashMap<Player, List<Card>>();

	private int currentPlayerIdx = 0;

	private static final int numberOfCardsPerPlayer = 4;

	private int numberOfPlayers = 2;

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public CardGame() {
		cards = Card.getPackOfCards();
	}

	public void distributeCardsForPlayers(List<Player> players) {
		this.players = players;
		Card.shuffleCards(cards);
		if (cardsPlayerMap.size() == 0)
			cardsPlayerMap.clear();

		int m = 0;
		for (Player pl : players) {
			pl.setPoints(0);
			List<Card> cds = new ArrayList<Card>();
			int CardLimit = m + numberOfCardsPerPlayer;
			for (int i = m; i < CardLimit; i++) {
				cds.add(cards.get(i));
			}
			m = CardLimit;
			cardsPlayerMap.put(pl, cds);
		}
	}

	public void playGame(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
		createMultipleUser(numberOfPlayers);
		int i = 0;
		System.out.println("Game Started  ");
		List<Card> selectedCards = new ArrayList<Card>();
		Card maxCard = null;
		Player maxPlayer = new Player(0);
		distributeCardsForPlayers(players);
		for (int j = 0; j < numberOfCardsPerPlayer; j++) {
			int s = 0;
			do {
				Player player = getNextPlayer();
				System.out.println("1. display Cards available  \n2. Stop Game");
				System.out.println("Chance for Player..." + player.getPlayerId());
				System.out.print("Please provide your option : ");

				Scanner scanner = new Scanner(System.in);
				i = scanner.nextInt();

				switch (i) {
				case 1:
					displayCardsForPlayer(player);
					System.out.println("Select your Card number :");

					scanner = new Scanner(System.in);
					int m = scanner.nextInt();
					Card card = cardsPlayerMap.get(player).get(m - 1);
					System.out.println("Card Selected -> " + card.toString());
					cardsPlayerMap.get(player).remove(m - 1);
					if (maxCard == null) {
						maxCard = card;
						maxPlayer = player;
					} else {
						if (maxCard.compareTo(card) < 0) {
							maxCard = card;
							maxPlayer = player;
						}
					}
					selectedCards.add(card);

					break;
				case 2:
					return;
				}

				s++;
			} while (s < players.size());
			if (maxPlayer.getPlayerId() > 0)
				maxPlayer.setPoints((maxPlayer.getPoints()) + 1);
			maxCard = null;
			maxPlayer = null;
			displayScores();
		}
	}

	private void displayScores() {
		for (Player player : players) {
			System.out.println("Player " + player.getPlayerId() + " Score -> " + player.getPoints());
		}

	}

	private void displayCardsForPlayer(Player player) {
		int cards = cardsPlayerMap.get(player).size();
		for (int i = 0; i < cards;) {
			System.out.print((++i) + " ");
		}
	}

	public void displayWinners() {
		Collections.sort(players);
		int maxPoints = 0;
		Map<String, List<Player>> playerPointsMap = new TreeMap<String, List<Player>>();
		for (Player p : players) {

			maxPoints = p.getPoints();
			if (playerPointsMap.get(maxPoints + "") != null) {
				List<Player> playerList = playerPointsMap.get(maxPoints + "");
				playerList.add(p);
				playerPointsMap.put(maxPoints + "", playerList);
			} else {
				List<Player> playerList = new ArrayList<Player>();
				playerList.add(p);
				playerPointsMap.put(maxPoints + "", playerList);
			}
		}

		String points = new Integer(players.get(players.size() - 1).getPoints()).toString();
		if (playerPointsMap.get(points) != null && playerPointsMap.get(points).size() > 1) {
			System.out.println("Its a draw among the following players ");
			for (Player p : players) {
				System.out.println("Player -> " + p.getPlayerId());
			}
		} else if (playerPointsMap.get(points) != null) {
			System.out.println("And the winner is :");
			System.out.println("Player -> " + playerPointsMap.get(points).get(0).getPlayerId());
		}
	}

	private void createMultipleUser(int j) {
		if (players.size() != 0) {
			players.clear();
		}

		for (int i = 0; i < j; i++) {
			int id = i + 1;
			Player usr = new Player(id);
			players.add(usr);
		}
		distributeCardsForPlayers(players);
	}

	private Player getNextPlayer() {

		Player player = null;
		if (currentPlayerIdx == players.size()) {
			currentPlayerIdx = 1;
			player = players.get(0);
		} else {
			player = players.get(currentPlayerIdx);
			currentPlayerIdx++;
		}

		return player;
	}

}
