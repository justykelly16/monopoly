package monoversity;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class GoSquareTest {
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
	public void testGoSquare() {
		GoSquare go = new GoSquare();
		assertNotNull(go);
	}

	@Test
	public void testGoSquareConstructorWithArgs() {
		GoSquare go = new GoSquare(nameValid, boardLocationValid);
		assertNotNull(go);
		
		assertEquals(nameValid, go.getName());
		assertEquals(boardLocationValid, go.getBoardLocation());
	}

	@Test
	public void testModify() {
	}		
		
		

		
	
	@Test
	public void testSetGetName() {
		GoSquare go = new GoSquare();
		go.setName(nameValid);
		assertEquals(nameValid, go.getName());
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidLower() {
		GoSquare go = new GoSquare();
		go.setName(nameInvalidLower);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidUpper() {
		GoSquare go = new GoSquare();
		go.setName(nameInvalidUpper);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidWhiteSpace() {
		GoSquare go = new GoSquare();
		go.setName(nameInvalidWhiteSpace);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidNullValue() {
		GoSquare go = new GoSquare();
		go.setName(null);
	}

	@Test 
	public void testSetGetBoardLocation() {
		GoSquare go = new GoSquare();
		go.setBoardLocation(boardLocationValid);
		assertEquals(boardLocationValid, go.getBoardLocation());
		
		go.setBoardLocation(boardLocationValidLower);
		assertEquals(boardLocationValidLower, go.getBoardLocation());
		
		go.setBoardLocation(boardLocationValidLowerPlusOne);
		assertEquals(boardLocationValidLowerPlusOne, go.getBoardLocation());
		
		go.setBoardLocation(boardLocationValidUpper);
		assertEquals(boardLocationValidUpper, go.getBoardLocation());
		
		go.setBoardLocation(boardLocationValidUpperMinusOne);
		assertEquals(boardLocationValidUpperMinusOne, go.getBoardLocation());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetBoardLocationInvalidLower() {
		GoSquare go = new GoSquare();
		go.setBoardLocation(boardLocationInvalidLower);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetBoardLocationInvalidUpper() {
		GoSquare go = new GoSquare();
		go.setBoardLocation(boardLocationInvalidUpper);
	}

}
