package monoversity;
/**
 * This class represents the Go Square 
 * 
 *
 */


public class GoSquare implements ISquare {
	// Public properties
	private String Name;
	private int boardLocation;

	public final String getName() {
		return Name;
	}

	/**
	 * Constructor with Arguments
	 * @param name
	 * @param boardLocation
	 */
	public GoSquare(String name, int boardLocation) {
		super();
		Name = name;
		this.boardLocation = boardLocation;
	}
	/**
	 * sets the name of the GO square
	 */
	public final void setName(String value) {
		Name = value;
	}
	/**
	 * Gets the board location of the GO Square
	 */
	@Override
	public int getBoardLocation() {
		return boardLocation;
	}
	
	/**
	 * Sets the board location of the GO Square
	 */
	@Override
	public void setBoardLocation(int boardLocation) {
		this.boardLocation = boardLocation;
	}

	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void Modify(Player player) {

		System.out.println("You have landed on GO");

	}

}