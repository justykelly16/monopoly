package monoversity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PubcrawlTest {
String nameValid, nameInvalidLower, nameInvalidUpper, nameInvalidWhiteSpace;
	
	int boardLocationValid, boardLocationValidLower, boardLocationValidLowerPlusOne, boardLocationValidUpper,
	boardLocationValidUpperMinusOne, boardLocationInvalidLower, boardLocationInvalidUpper;


	@Before
	public void setUp() throws Exception {
		
		
		nameValid ="valid name";
		nameInvalidLower="";
		nameInvalidUpper="over twenty characters long";
		nameInvalidWhiteSpace=" ";
		
		boardLocationValid = 4;
		boardLocationValidLower=1;
		boardLocationValidLowerPlusOne=2;
		boardLocationValidUpper=8;
		boardLocationValidUpperMinusOne=7;
		boardLocationInvalidLower=0;
		boardLocationInvalidUpper=9;
	}

	@Test
	public void testPubCrawl() {
		PubCrawl p1 = new PubCrawl();
		assertNotNull(p1);
	}

	@Test
	public void testPubCrawlStringInt() {
		PubCrawl p1 = new PubCrawl(nameValid, boardLocationValid, null);
		assertNotNull(p1);
		
		assertEquals(nameValid, p1.getName());
		p1.setBoardLocation(boardLocationValid);
		
	}

	@Test
	public void testModify() {
		PubCrawl p1 = new PubCrawl();
		Player player = new Player();
		p1.modify(player);
		
		
		
	
	}

	@Test
	public void testSetGetName() {
		PubCrawl p1 = new PubCrawl();
		p1.setName(nameValid);
		assertEquals(nameValid, p1.getName());
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidLower() {
		PubCrawl p1 = new PubCrawl();
		p1.setName(nameInvalidLower);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidUpper() {
		PubCrawl p1 = new PubCrawl();
		p1.setName(nameInvalidUpper);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidWhiteSpace() {
		PubCrawl p1 = new PubCrawl();
		p1.setName(nameInvalidWhiteSpace);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidNullValue() {
		PubCrawl p1 = new PubCrawl();
		p1.setName(null);
	}

	@Test 
	public void testSetGetBoardLocation() {
		PubCrawl p1 = new PubCrawl();
		p1.setBoardLocation(boardLocationValid);
		assertEquals(boardLocationValid, p1.getBoardLocation());
		
		p1.setBoardLocation(boardLocationValidLower);
		assertEquals(boardLocationValidLower, p1.getBoardLocation());
		
		p1.setBoardLocation(boardLocationValidLowerPlusOne);
		assertEquals(boardLocationValidLowerPlusOne, p1.getBoardLocation());
		
		p1.setBoardLocation(boardLocationValidUpper);
		assertEquals(boardLocationValidUpper, p1.getBoardLocation());
		
		p1.setBoardLocation(boardLocationValidUpperMinusOne);
		assertEquals(boardLocationValidUpperMinusOne, p1.getBoardLocation());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetBoardLocationInvalidLower() {
		PubCrawl p1 = new PubCrawl();
		p1.setBoardLocation(boardLocationInvalidLower);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetBoardLocationInvalidUpper() {
		PubCrawl p1 = new PubCrawl();
		p1.setBoardLocation(boardLocationInvalidUpper);
	}

}
