package monoversity;
/**
 * This class represents the pub crawl square
 */

import monoversity.Player;;

public class PubCrawl extends Square implements ISquare {
	
	public final int PUB_CRAWL_FEE = 30;


	
	/**
	 * 
	 */
	public PubCrawl() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param name
	 * @param boardLocation
	 */
	public PubCrawl(String name, int boardLocation) {
		super(name, boardLocation);
		
	}



	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void Modify(Player players)
	{
		
		System.out.println("You landed on the Pubcrawl square.");
		System.out.println("Please prepare for your night on the town with a fee of �"+PUB_CRAWL_FEE);
		
		players.setPlayerBalance(players.getPlayerBalance() - PUB_CRAWL_FEE);
		System.out.println("Your balance is now �"+ players.getPlayerBalance());
		
	}

		
}
