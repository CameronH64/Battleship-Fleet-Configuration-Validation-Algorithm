
public class Main {

	public static boolean checkValidSizeShip(String shipID, int shipSize, String[][] fleetArray, int i, int j) {

		boolean vertical = false;
		boolean horizontal = false;

		for(int k = 0; k < shipSize-1; k++) {

			if(fleetArray[i + k][j].equals(shipID)) {
				continue;
			} else {
				vertical = true;
			}
		}

		for(int k = 0; k < shipSize-1; k++) {

			if(fleetArray[i][j+k].equals(shipID)) {
				continue;
			} else {
				horizontal = true;
			}
		}

		return vertical ^ horizontal;

	}

	public static boolean checkValidFleetConfiguration(String[][] fleetArray) {
		
		boolean returnType = false;
		
		String shipID[] = {"C", "B", "D", "S", "P"};
		int shipCount[] = {5, 4, 3, 3, 2};

		// Carrier
		for(int i = 0; i < 10; i++) {		// Check each row.

			for(int j = 0; j < 10; j++) {	// Check each column.
					if(fleetArray[i][j].equals("C")) {
						
						if (checkValidSizeShip(shipID[0], 5, fleetArray, i, j)) {
							continue;
						} else {
							returnType = true;
							
					}
				}
			}
		}

		// Carrier
		for(int i = 0; i < 10; i++) {		// Check each row.

			for(int j = 0; j < 10; j++) {	// Check each column.
					if(fleetArray[i][j].equals("B")) {
						
						if (checkValidSizeShip(shipID[1], 4, fleetArray, i, j)) {
							continue;
						} else {
							returnType = true;
							
					}
				}
			}
		}
			
		// Carrier
		for(int i = 0; i < 10; i++) {		// Check each row.

			for(int j = 0; j < 10; j++) {	// Check each column.
					if(fleetArray[i][j].equals("D")) {
						
						if (checkValidSizeShip(shipID[2], 3, fleetArray, i, j)) {
							continue;
						} else {
							returnType = true;
							
					}
				}
			}
		}
		
		
		// Carrier
		for(int i = 0; i < 10; i++) {		// Check each row.

			for(int j = 0; j < 10; j++) {	// Check each column.
					if(fleetArray[i][j].equals("S")) {
						
						if (checkValidSizeShip(shipID[3], 3, fleetArray, i, j)) {
							continue;
						} else {
							returnType = true;
							
					}
				}
			}
		}
		
		
		
		// Carrier
		for(int i = 0; i < 10; i++) {		// Check each row.

			for(int j = 0; j < 10; j++) {	// Check each column.
					if(fleetArray[i][j].equals("P")) {
						
						if (checkValidSizeShip(shipID[4], 2, fleetArray, i, j)) {
							continue;
						} else {
							returnType = true;
							
					}
				}
			}
		}
			
		return returnType;

	}

	public static void main(String[] args) {

		String player1FleetArray[][] = {{"0","0","0","0","0","0","0","0","0","0"},
										{"0","C","0","P","P","B","0","0","0","0"},
										{"0","C","0","0","0","B","0","0","0","0"},
										{"0","C","0","0","0","B","0","0","0","0"},
										{"0","C","0","0","0","B","0","0","0","0"},
										{"0","C","0","0","0","0","0","0","0","0"},
										{"0","0","0","0","D","0","S","0","0","0"},
										{"0","0","0","0","D","0","S","0","0","0"},
										{"0","0","0","0","D","0","S","0","0","0"},
										{"0","0","0","0","0","0","0","0","0","0"}};

		boolean isValid = checkValidFleetConfiguration(player1FleetArray);

		System.out.println(isValid);

	}

}
