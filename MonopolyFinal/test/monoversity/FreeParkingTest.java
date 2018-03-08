package monoversity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class FreeParkingTest {
	String nameValid, nameInvalidLower, nameInvalidUpper, nameInvalidWhiteSpace;
	
	int boardLocationValid, boardLocationValidLower, boardLocationValidLowerPlusOne, boardLocationValidUpper,
	boardLocationValidUpperMinusOne, boardLocationInvalidLower, boardLocationInvalidUpper;
	
	Player player;


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
	public void testFreeParking() {
	FreeParking fp1 = new FreeParking();
	assertNotNull(fp1);
	}

	@Test
	public void testFreeParkingStringInt() {
		FreeParking fp1 = new FreeParking(nameValid, boardLocationValid, null);
		assertNotNull(fp1);
		
		assertEquals(nameValid, fp1.getName());
		assertEquals(boardLocationValid, fp1.getBoardLocation());
	}

	@Test
	public void testModify() {
	

		
	
	}

	@Test
	public void testSetGetName() {
		FreeParking fp1 = new FreeParking();
		fp1.setName(nameValid);
		assertEquals(nameValid, fp1.getName());
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidLower() {
		FreeParking fp1 = new FreeParking();
		fp1.setName(nameInvalidLower);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidUpper() {
		FreeParking fp1 = new FreeParking();
		fp1.setName(nameInvalidUpper);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidWhiteSpace() {
		FreeParking fp1 = new FreeParking();
		fp1.setName(nameInvalidWhiteSpace);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidNullValue() {
		FreeParking fp1 = new FreeParking();
		fp1.setName(null);
	}

	@Test 
	public void testSetGetBoardLocation() {
		FreeParking fp1 = new FreeParking();
		fp1.setBoardLocation(boardLocationValid);
		assertEquals(boardLocationValid, fp1.getBoardLocation());
		
		fp1.setBoardLocation(boardLocationValidLower);
		assertEquals(boardLocationValidLower, fp1.getBoardLocation());
		
		fp1.setBoardLocation(boardLocationValidLowerPlusOne);
		assertEquals(boardLocationValidLowerPlusOne, fp1.getBoardLocation());
		
		fp1.setBoardLocation(boardLocationValidUpper);
		assertEquals(boardLocationValidUpper, fp1.getBoardLocation());
		
		fp1.setBoardLocation(boardLocationValidUpperMinusOne);
		assertEquals(boardLocationValidUpperMinusOne, fp1.getBoardLocation());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetBoardLocationInvalidLower() {
		FreeParking fp1 = new FreeParking();
		fp1.setBoardLocation(boardLocationInvalidLower);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetBoardLocationInvalidUpper() {
		FreeParking fp1 = new FreeParking();
		fp1.setBoardLocation(boardLocationInvalidUpper);
	}

}
