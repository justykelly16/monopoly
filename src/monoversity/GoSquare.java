package monoversity;
/**
 * This class represents the Go Square 
 * 
 *
 */


public class GoSquare extends Square implements ISquare {
	
	

	/**
	 * 
	 */
	public GoSquare() {
		super();
		
	}

	/**
	 * @param name
	 * @param boardLocation
	 */
	public GoSquare(String name, int boardLocation) {
		super(name, boardLocation);
		
	}

	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void Modify(Player player) {

		System.out.println("You have landed on GO");

	}

}