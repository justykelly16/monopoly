package monoversity;
/**
 * This class represents the pub crawl square
 */

import monoversity.Player;;

public class PubCrawl implements ISquare {
	
	public final int PUB_CRAWL_FEE = 30;

	private String Name;
	private int boardLocation;
	
	
	/**
	 * Returns the name of the square
	 */
	public final String getName(){
		return Name;
	}
	
	/**
	 * Sets the name of the square
	 */
	public final void setName(String value){
		Name = value;
	}
	
	
	/**
	 * Constructor with args
	 * @param name
	 * @param boardLocation
	 */
	public PubCrawl(String name, int boardLocation){
		this.setName(name);
		this.setBoardLocation(boardLocation);
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
	
	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void Modify(Player players)
	{
		
		System.out.println("You landed on pubcrawl please prepare for your night on the town with a fee of £"+PUB_CRAWL_FEE);

		
		players.setPlayerBalance(players.getPlayerBalance() - PUB_CRAWL_FEE);
		
	}

		
}
