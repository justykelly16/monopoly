package monoversity;

/**
 * This class represents the Free parking square
 *
 *
 */

public class FreeParking extends Square implements ISquare {


	/**
	 * Default Constructor
	 */
	public FreeParking() {

	}

	/**
	 * @param name
	 * @param boardLocation
	 */
	
		
	/**
	 * @param name
	 * @param boardLocation
	 * @param owner
	 */
	public FreeParking(String name, int boardLocation, Player owner) {
		super(name, boardLocation, owner);
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void modify(Player players) {
		System.out.printf("You landed on the %s square.\n", this.getName());
		System.out.println("Park up, get your laptop out and do some project work!");

	}

}
