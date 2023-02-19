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
		 * Check there are 17 non-zeros. If not, return false. (Just a brief pre-validation)
		 * Cycle through each element.
		 * 
		 * When a letter is hit, check the next element to see if it matches.
		 * If it matches, it's horizontal. If not, it's vertical.
		 * 
		 * If horiztonal, check that there are that many sequential letters.
		 * If vertical, check if there are that many sequential letters with 10 space in between them.
		 * 
		 * This actually inherently takes care of placing boats in an L-shape.
		 * The reason is because when a boat is discoverd (its letter is found),
		 * The algorithm is expecting to find 5, 4, 3, or 2 spaces.
		 * And because of the 17 count check before the algorithm starts,
		 * the ships MUST be in this configuration.
		 * 
		 * */
		
		ArrayList<String> flatFleet = new ArrayList<String>();
		String shipID[] = {"C", "B", "D", "S", "P"};
		int shipSize[] = {5, 4, 3, 3, 2};
		int totalShipSize = 0;
		
		int runningCarrierCount = 0;
		int runningBattleshipCount = 0;
		int runningDestroyerCount = 0;
		int runningSubmarineCount = 0;
		int runningPatrolCount = 0;
		
		boolean returnType = false;
		
		// First, flatten the array into a 1D array.
		for(int i = 0; i < 10; i++) {		// Check each row.
			for(int j = 0; j < 10; j++) {	// Check each column.
				flatFleet.add(fleetArray[i][j]);
			}
		}
		
		
		
		// A quick validation to ensure correct size of ships.
		for(int i = 0; i < 100; i++) {
			if(!flatFleet.get(i).equals("0")) { totalShipSize++; }
		}
		
		if (totalShipSize != 17) {
			return false;
		}
		
		
		
		// Do ship checking.
		
		// Carrier
		for(int i = 0; i < 100; i++) {
			if(flatFleet.get(i) == "C") {
				if(flatFleet.get(i+1) == "C") {	// Check orientation of ship.
				
					for(int j = 0; j < 5; j++) {
						if(flatFleet.get(i+j).equals("C")) {
							runningCarrierCount++;
						}
					}
					break;
				} else {
					for(int j = 0; j < 5; j++) {
						if(flatFleet.get(i+(j*10)).equals("C")) {
							runningCarrierCount++;
						}
					}
					break;
				}
			}
		}

		

		// Debugging
		for (String string : flatFleet) {
			System.out.print(string);
		}
		
		if(runningCarrierCount == 5) {
			return true;
		}
		
		return false;
	
	}

	public static void main(String[] args) {

		String player1FleetArray[][] = {{"0","0","0","0","0","0","0","0","0","0"},
										{"0","C","0","P","P","0","0","0","0","0"},
										{"0","C","0","0","0","0","0","0","0","0"},
										{"0","C","0","0","B","B","B","B","0","0"},
										{"0","C","0","0","0","0","0","0","0","0"},
										{"0","C","0","0","0","0","0","0","0","0"},
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
