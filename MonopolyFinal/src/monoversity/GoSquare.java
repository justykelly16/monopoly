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
	public GoSquare(String name, int boardLocation, Player owner) {
		super(name, boardLocation, owner);
		
	}

	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void modify(Player player) {

		System.out.println("You have landed on GO");

	}

}