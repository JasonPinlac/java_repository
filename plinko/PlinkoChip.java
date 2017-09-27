package plinko;

import java.util.Scanner; // import the scanner class from java.util package

public class PlinkoChip {
	
	// MEMBER VARIABLES
	private int currentPosition;
	private Scanner inputObject = new Scanner(System.in);
	
	// MEMBER METHODS
	public int pickStartPosition() {
		int startPosition = -1;
		do {
			System.out.print("Pick a starting position. (0-8) inclusive: ");
			startPosition = inputObject.nextInt();
			currentPosition = startPosition;
		} while (startPosition < 0 || startPosition > 8);
		return startPosition;
	}
	
	public int getCurrentPosition() {
		return currentPosition;
	}
	
	public void moveLeftAPosition() {
		currentPosition -= 1;
	}
	
	public void moveRightAPosition() {
		currentPosition += 1;
	}
	
	public void stayAtPosition() {
		currentPosition += 0;
	}
}
