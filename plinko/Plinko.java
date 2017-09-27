package plinko;

import java.util.Random; // import the random class from java.util package

public class Plinko {
	
	private PlinkoChip chip = new PlinkoChip();
	private RedRow row1 = new RedRow();
	private BlackRow row2 = new BlackRow();
	private RedRow row3 = new RedRow();
	private BlackRow row4 = new BlackRow();
	private RedRow row5 = new RedRow();
	private BlackRow row6 = new BlackRow();
	private RedRow row7 = new RedRow();
	private BlackRow row8 = new BlackRow();
	private RedRow row9 = new RedRow();
	private BlackRow row10 = new BlackRow();

	public void simulateOnce() {
		double winnings = 0.00;
		winnings = dropChip(chip.pickStartPosition());
		System.out.println("You won a total of: " + winnings);
	}
	
	public void totalWinningsEachSlotGivenXDropsEach(int x) {
		double[] totalWinningsForSlot = new double[9];
		
		for (int i = 0; i< 9; i++) {
			for (int j = 0; j < x; j++) {
				totalWinningsForSlot[i] += dropChip(i);
			}
		}
		
		System.out.println("total winnings for each starting slot given " + x + " drops per slot.");
		for (int i = 0; i<9; i++) {
			System.out.println("Slot " + i + ": " + (totalWinningsForSlot[i]));
		}
	}
	
	private double dropChip(int startChipPosition) {
		// simulates dropping chip through 10 rows plus the final row.
		System.out.println("dropChip START Position: " + chip.getCurrentPosition());
		
		System.out.print("Row 1: ");
		moveThroughRow(row1, chip.getCurrentPosition());
		System.out.print("Row 2: ");
		moveThroughRow(row2, chip.getCurrentPosition());
		System.out.print("Row 3: ");
		moveThroughRow(row3, chip.getCurrentPosition());
		System.out.print("Row 4: ");
		moveThroughRow(row4, chip.getCurrentPosition());
		System.out.print("Row 5: ");
		moveThroughRow(row5, chip.getCurrentPosition());
		System.out.print("Row 6: ");
		moveThroughRow(row6, chip.getCurrentPosition());
		System.out.print("Row 7: ");
		moveThroughRow(row7, chip.getCurrentPosition());
		System.out.print("Row 8: ");
		moveThroughRow(row8, chip.getCurrentPosition());
		System.out.print("Row 9: ");
		moveThroughRow(row9, chip.getCurrentPosition());
		System.out.print("Row 10: ");
		moveThroughRow(row10, chip.getCurrentPosition());
		System.out.print("FINAL ROW: ");
		double winnings = moveThroughFinalRow();
		return winnings;
	}
	
	private void moveThroughRow(Row row, int currentChipPosition) {
		String move = leftOrRight();
		System.out.println("moveThroughRow CURRENT Position: " + chip.getCurrentPosition());
		System.out.println(move);
		// red row.
		if (row.getClass() == row1.getClass()) {
			if(chip.getCurrentPosition() == 0 && move == "left") {
				chip.stayAtPosition();
			} else if (chip.getCurrentPosition() == 8 && move == "right") {
				chip.moveRightAPosition();
			} else {
				if (move == "left") {
					chip.stayAtPosition();
				} else if (move == "right") {
					chip.moveRightAPosition();
				}
			}
		// black row.
		} else if (row.getClass() == row2.getClass()) {
			if(chip.getCurrentPosition() == 0 && move == "left") {
				chip.stayAtPosition();
			} else if (chip.getCurrentPosition() == 9 && move == "right") {
				chip.moveLeftAPosition();
			} else {
				if (move == "left") {
					chip.moveLeftAPosition();
				} else if (move == "right") {
					chip.stayAtPosition();
				}
			}
		}
	}
	
	private double moveThroughFinalRow() {
		System.out.println("moveThroughFinalRow FINAL Position: " + chip.getCurrentPosition());
		switch (chip.getCurrentPosition()) {
		case 0:
			return 100.00;
		case 1:
			return 500.00;
		case 2:
			return 1000.00;
		case 3:
			return 00.00;
		case 4:
			return 10000.00;
		case 5:
			return 00.00;
		case 6:
			return 1000.00;
		case 7:
			return 500.00;
		case 8:
			return 100.00;
		default:
			return 0.00;
		}
	}
	
	private String leftOrRight() {
		Random rand = new Random();
		int randomNumber = rand.nextInt();
		if (randomNumber % 2 == 0) {
			return "left";
		} else {
			return "right";
		}
	}
}


