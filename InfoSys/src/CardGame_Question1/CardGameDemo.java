package CardGame_Question1;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CardGameDemo {

	private Scanner scanner;
	private PrintStream printStream;

	public CardGameDemo(InputStream inputStream, PrintStream printStream) {
		this.scanner = new Scanner(inputStream);
		this.printStream = printStream;
	}

	public void start() {
		printStream.println("Enter number 1");
		int i = scanner.nextInt();
		System.out.println( " this " + i);
		printStream.println("Enter number 2");
		int j = scanner.nextInt();
		printStream.println("output: " + (i + j));
		
		
		
		CardGame cardGame = new CardGame();

		System.out.println("Card Game \n Player Options");
		System.out.println("1. Start Game \n  \n2. Exit Game");
		System.out.print("Please provide your option : ");

//		int i = 1;

		while (i != 0) {
//			Scanner scanner = new Scanner(System.in);
//			i = scanner.nextInt();

			switch (i) {
			case 1:
				System.out.println("Provide the Players( between 1 - 4 player) : ");
				scanner = new Scanner(System.in);
				i = scanner.nextInt();
				cardGame.playGame(i);

				cardGame.displayWinners();
				break;

			case 2:
				System.exit(0);
			}

			System.out.println();
			System.out.println("Card Game \n Select User Options");
			System.out.println("1. Start Game \n2. Exit Game");
			System.out.print("Please provide your option : ");
		}
		
		
	}

	public static void main(String[] args) {
		
		int x = 1;
		int y = 2;
		
		CardGameDemo cardGameDemo = new CardGameDemo(System.in, System.out);
		cardGameDemo.start();
		
		
		//
//		
		
	}
}
