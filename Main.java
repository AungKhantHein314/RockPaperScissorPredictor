package assignments.RockPaperScissorPredictor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	ArrayList<Integer> temps = new ArrayList<Integer>();
	Predictor predictor = new Predictor();
	
	private int[] computerChoices = {1,3,2,1,3,2,1,2,3,2,1,2,3,2,1,2,3,2,1,2,3,2,1,2,3,2,1,2,3,2,1,2,3,2,12,2,3,2,1,2,3}; // random
	private int currentIndex = 0;
	
	private int winCount = 0;
	private int drawCount = 0;
	private int loseCount = 0;
	
	public Main() {
		for(int i = 0; i < computerChoices.length; i++) {
			System.out.println("");
			int computerChoice = generateComputerChoice();
			matchResult(getInput(), computerChoice);
		}
		System.out.println("WinCount: " + winCount + "\r\nDrawCount: " + drawCount + "\r\nLoseCount: " + loseCount);
	}

	private int generateComputerChoice() {
//		int computerChoice = computerChoices[currentIndex];
		int computerChoice = (int) (Math.random() * 3) + 1;
		currentIndex++;
		temps.add(computerChoice);
		if (temps.size() == 4) {
			predictor.addRecord(temps.get(0), temps.get(1), temps.get(2), computerChoice);
			predictor.addRecord(temps.get(1), temps.get(2), computerChoice);
			
			predictor.predict(temps.get(0), temps.get(1), temps.get(2), computerChoice);
			
			temps.remove(0);
		} else if(temps.size() == 3) {
			predictor.addRecord(temps.get(0), temps.get(1), computerChoice);
			predictor.predict(temps.get(0), temps.get(1), computerChoice, 0);
		}
		return computerChoice;
	}

	private int getInput() {
		System.out.println("Input Your Choice \n (1) Rock \n (2) Paper \n (3) Scissors");
		return Integer.parseInt(scanner.nextLine());
	}

	private void matchResult(int userChoice, int computerChoice) {
		if(userChoice == computerChoice) {
			System.out.println("draw");
			drawCount++;
		} else if (userChoice - computerChoice == 1 || userChoice - computerChoice == -2 ) {
			System.out.println("You Win!");
			winCount++;
		} else {
			System.out.println("You lose");
			loseCount++;
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}
