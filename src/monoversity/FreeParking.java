package monoversity;

/**
 * This class represents the Free parking square
 *
 *
 */

public class FreeParking implements ISquare {

	private String Name;
	private int boardLocation;

	/**
	 * Default Constructor
	 */
	public FreeParking() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param name
	 * @param boardLocation
	 */
	public FreeParking(String name, int boardLocation) {
		this.setName(name);
		this.setBoardLocation(boardLocation);
	}

	/**
	 * Gets the name of the square
	 */
	public final String getName() {
		return Name;
	}

	/**
	 * sets the name of the square
	 */
	public final void setName(String value) {
		Name = value;
	}

	/**
	 * @return the boardLocation
	 */
	public int getBoardLocation() {
		return boardLocation;
	}

	/**
	 * @param boardLocation
	 *            the boardLocation to set
	 */
	public void setBoardLocation(int boardLocation) {
		this.boardLocation = boardLocation;
	}

	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void Modify(Player players) {
		System.out.println("Park up, get your laptop out and do some project work!");

	}

}
