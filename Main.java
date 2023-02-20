// Cameron Holbrook
// 02/19/23
// Battleship Fleet Configuration Validation Checker

import java.util.ArrayList;

public class Main {
	
	public static boolean checkValidFleetConfiguration(String[][] fleetArray) {
		
		/*
		 * EXPLANATION:
		 * 
		 * There's no need to use such a complicated algorithm that I made up!
		 * We should instead use this much simpler algorithm (that I also made up)!
		 * 
		 * Take any 2D fleet configuration, and then flatten it to 1D.
		 * Battleships can only have two orientations: vertical or horizontal.
		 * 
		 * In this new 1D format:
		 * Horizontal ships's letters will be bunched together with no spaces in between them.
		 * Vertical ships's letters will be spaced EXACTLY THE WIDTH OF THE GAME BOARD (in this case, 10 spaces).
		 * 
		 * These principles hold for any number of ships, however long they are, and any size game board!
		 * 
		 * Example:
		 * 00000000000C0PP000000C000000000C00BBBB000C000B00000C000000000000D0S0000000D0S0000000D0S0000000000000
		 * This is a valid fleet configuration. Why?
		 * 
		 * Either:
		 * Each letter has exactly 10 spaces in between them OR
		 * Each letter is grouped together.
		 * 
		 * Pseudocode:
		 * Flatten 2D array to 1D array.
		 * 
		 * Check there are 17 non-zeros. If not, return false. (A brief, but necessary pre-validation)
		 * Cycle through each element.
		 * 
		 * When a letter is hit, check the next element to see if it matches.
		 * If it matches, it's horizontal. If not, it's vertical.
		 * 
		 * If horizontal, check that there are that many sequential letters.
		 * If vertical, check if there are that many sequential letters with 10 space in between them.
		 * 
		 * This actually inherently takes care of placing boats in an L-shape.
		 * The reason is because when a boat is discovered (its letter is found),
		 * The algorithm is expecting to find 5, 4, 3, or 2 spaces.
		 * And because of the 17 count check before the algorithm starts,
		 * the ships MUST be in this configuration.
		 * 
		 * */
		
		
		ArrayList<String> flatFleet = new ArrayList<String>();
		int totalShipSize = 0;
		
		int runningCarrierCount = 0;
		int runningBattleshipCount = 0;
		int runningDestroyerCount = 0;
		int runningSubmarineCount = 0;
		int runningPatrolCount = 0;
		
		
		
		// First, flatten the array into a 1D array.
		for(int i = 0; i < 10; i++) {				// Check each row.
			for(int j = 0; j < 10; j++) {			// Check each column.
				flatFleet.add(fleetArray[i][j]);
			}
		}
		
		
		
		// Debugging; print out the whole 1D array.
		for (String string : flatFleet) {
			System.out.print(string);
		}
		
		
		
		// A quick validation to ensure correct size of ships.
		for(int i = 0; i < 100; i++) {
			if(!flatFleet.get(i).equals("0")) { totalShipSize++; }
		}
		
		if (totalShipSize != 17) {
			return false;
		}
		
		
		
		// Do ship checking.
		// The comments for the carrier are the same for the other four ships.
		
		// Carrier
		for(int i = 0; i < 100; i++) {				// Cycle through 1D array.
			if(flatFleet.get(i) == "C") {			// ... Until it hits a carrier ship (represented by a C).
				if(flatFleet.get(i+1) == "C") {		// Check if orientation is vertical.
				
					for(int j = 0; j < 5; j++) {					// If vertical, check the C's in the downward direction.
						if(flatFleet.get(i+j).equals("C")) {
							runningCarrierCount++;
						}
					}
					break;
				} else {
					
					for(int j = 0; j < 5; j++) {	// Check if orientation is horizontal.	
						if(flatFleet.get(i+(j*10)).equals("C")) {		// If vertical, check the C's in the downward direction.
							runningCarrierCount++;
						}
					}
					break;
				}
			}
		}


		
		// Battleship
		for(int i = 0; i < 100; i++) {
			if(flatFleet.get(i) == "B") {
				if(flatFleet.get(i+1) == "B") {	// Check orientation of ship.
				
					for(int j = 0; j < 4; j++) {
						if(flatFleet.get(i+j).equals("B")) {
							runningBattleshipCount++;
						}
					}
					break;
				} else {
					
					for(int j = 0; j < 4; j++) {
						if(flatFleet.get(i+(j*10)).equals("B")) {
							runningBattleshipCount++;
						}
					}
					break;
				}
			}
		}
		

		// Destroyer
		for(int i = 0; i < 100; i++) {
			if(flatFleet.get(i) == "D") {
				if(flatFleet.get(i+1) == "D") {	// Check orientation of ship.
				
					for(int j = 0; j < 3; j++) {
						if(flatFleet.get(i+j).equals("D")) {
							runningDestroyerCount++;
						}
					}
					break;
				} else {
					
					for(int j = 0; j < 3; j++) {
						if(flatFleet.get(i+(j*10)).equals("D")) {
							runningDestroyerCount++;
						}
					}
					break;
				}
			}
		}

		// Submarine
		for(int i = 0; i < 100; i++) {
			if(flatFleet.get(i) == "S") {
				if(flatFleet.get(i+1) == "S") {	// Check orientation of ship.
				
					for(int j = 0; j < 3; j++) {
						if(flatFleet.get(i+j).equals("S")) {
							runningSubmarineCount++;
						}
					}
					break;
				} else {
					
					for(int j = 0; j < 3; j++) {
						if(flatFleet.get(i+(j*10)).equals("S")) {
							runningSubmarineCount++;
						}
					}
					break;
				}
			}
		}
		
		
		// Patrol
		for(int i = 0; i < 100; i++) {
			if(flatFleet.get(i) == "P") {
				if(flatFleet.get(i+1) == "P") {	// Check orientation of ship.
				
					for(int j = 0; j < 3; j++) {
						if(flatFleet.get(i+j).equals("P")) {
							runningPatrolCount++;
						}
					}
					break;
				} else {
					
					for(int j = 0; j < 3; j++) {
						if(flatFleet.get(i+(j*10)).equals("P")) {
							runningPatrolCount++;
						}
					}
					break;
				}
			}
		}

		
		// If every single battleship is the length that they should be, then it's a valid fleet configuration.
		// This is why the check for 17 spaces is not sufficient.
		// For example, a carrier could be 6 spaces and a battleship could be 3.
		// That method alone would fail this test.
		if(runningCarrierCount == 5 && runningBattleshipCount == 4 && runningDestroyerCount == 3 && runningSubmarineCount == 3 && runningPatrolCount == 2) {
			return true;
		}
		
		return false;
	
	}

	public static void main(String[] args) {

		String player1FleetArray[][] = {{"0","C","C","C","C","C","0","0","0","0"},
										{"0","0","0","P","P","0","0","0","0","0"},
										{"0","0","0","0","0","0","0","0","0","0"},
										{"0","0","0","0","B","B","B","B","0","0"},
										{"0","0","0","0","0","0","0","0","0","0"},
										{"0","0","0","0","0","0","0","0","0","0"},
										{"0","0","0","0","D","0","S","0","0","0"},
										{"0","0","0","0","D","0","S","0","0","0"},
										{"0","0","0","0","D","0","S","0","0","0"},
										{"0","0","0","0","0","0","0","0","0","0"}};

		System.out.println();
		boolean configuration = checkValidFleetConfiguration(player1FleetArray);
		System.out.println();
		System.out.println(configuration);

	}

}
