package CardGame_Question1;

import java.util.List;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestGameProcess {

	private Scanner scanner;
	private PrintStream printStream;

	public TestGameProcess(InputStream inputStream, PrintStream printStream) {
		this.scanner = new Scanner(inputStream);
		this.printStream = printStream;
	}

	public TestGameProcess() {
		// TODO Auto-generated constructor stub
	}

	public void start(List<Integer> listInput) {

//		printStream.println("Enter number 1");
//		i = scanner.nextInt();
//		System.out.println(" this " + i);
//		printStream.println("Enter number 2");
//		j = scanner.nextInt();
//		printStream.println("output: " + (i + j));

		CardGame cardGame = new CardGame();

		System.out.println("Card Game \n Player Options");
		System.out.println("1. Start Game \n  \n2. Exit Game");
		System.out.print("Please provide your option : ");
		
		System.out.println("");

		listInput.get(0);
		
		
		

		int i = 2;
		int times = 0;

		while (listInput.size() > times) {
//			Scanner scanner = new Scanner(System.in);
//			i = scanner.nextInt();
			
			if(listInput.size() > times) {
				times++;
			}

			switch (i) {
			case 1:
				System.out.println("Provide the Players( between 1 - 4 player) : ");
				//String v = System.setIn(new ByteArrayInputStream(String.valueOf(listInput.get(times)).getBytes()));
				//scanner = new Scanner(System.in);
				i = listInput.get(times++);
				cardGame.playGame(i);

				cardGame.displayWinners();
				//times++;
				break;

			case 2:
				System.out.println("Game stop");
				System.exit(0);
			}

			System.out.println();
			System.out.println("Card Game \n Select User Options");
			System.out.println("1. Start Game \n2. Exit Game");
			System.out.print("Please provide your option : ");
		}
	}

}
