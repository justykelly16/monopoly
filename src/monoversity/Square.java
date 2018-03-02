/**
 * 
 */
package monoversity;

/**
 * @author Owner
 *
 */
public abstract class Square implements ISquare {
	private String name;
	private int boardLocation;

	/**
	 * 
	 */
	public Square() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param boardLocation
	 */
	public Square(String name, int boardLocation) {
		super();
		this.name = name;
		this.boardLocation = boardLocation;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the boardLocation
	 */
	public int getBoardLocation() {
		return boardLocation;
	}

	/**
	 * @param boardLocation the boardLocation to set
	 */
	public void setBoardLocation(int boardLocation) {
		this.boardLocation = boardLocation;
	}

}
