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
	private Player owner;
	
	public final static int MIN_NAME_LENGTH = 1;
	public final static int MAX_NAME_LENGTH = 20;
	public final static int MIN_BOARD_LOCATION =1;
	public final static int MAX_BOARD_LOCATION =8;
	

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
	public Square(String name, int boardLocation, Player owner) {
		
		this.setName(name);
		this.setBoardLocation(boardLocation);
		this.owner=owner;
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
	public void setName(String name) throws IllegalArgumentException {
		if((name!=null) && (name.trim().length()>=MIN_NAME_LENGTH) && (name.trim().length()<=MAX_NAME_LENGTH)){
		this.name = name;
		}else {
			throw new IllegalArgumentException("Invalid name");
		}
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
	public void setBoardLocation(int boardLocation)throws IllegalArgumentException {
		if(boardLocation>=MIN_BOARD_LOCATION && boardLocation <= MAX_BOARD_LOCATION) {
		this.boardLocation = boardLocation;
		}else {
			throw new IllegalArgumentException("Invalid board location");
		}
	}



	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
