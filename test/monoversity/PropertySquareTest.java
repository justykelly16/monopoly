package monoversity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PropertySquareTest {
String nameValid, nameInvalidLower, nameInvalidUpper, nameInvalidWhiteSpace;
	
	int boardLocationValid, boardLocationValidLower, boardLocationValidLowerPlusOne, boardLocationValidUpper,
	boardLocationValidUpperMinusOne, boardLocationInvalidLower, boardLocationInvalidUpper;
	
	int priceValid, priceValidLower, priceValidLowerPlusOne, priceValidUpper, priceValidUpperMinusOne,
	priceInvalidLower, priceInvalidUpper;
	
	int rentValid, rentValidLower, rentValidLowerPlusOne, rentValidUpper, rentValidUpperMinusOne,
	rentInvalidLower, rentInvalidUpper;
	
	int rentMultiplierValid, rentMultiplierValidLower, rentMultiplierValidLowerPlusOne, rentMultiplierValidUpper,
	rentMultiplierValidUpperMinusOne, rentMultiplierInvalidLower, rentMultiplierInvalidUpper;
	
	int priceOfHouseValid, priceOfHouseValidLower, priceOfHouseValidLowerPlusOne, priceOfHouseValidUpper, priceOfHouseValidUpperMinusOne,
	priceOfHouseInvalidLower, priceOfHouseInvalidUpper;
	
	int numberOfHousesValid, numberOfHousesValidLower, numberOfHousesValidLowerPlusOne, numberOfHousesValidUpper, numberOfHousesValidUpperMinusOne,
	numberOfHousesInvalidLower, numberOfHousesInvalidUpper;
	
	


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
		
		priceValid=100;
		priceValidLower = 0;
		priceValidLowerPlusOne=1;
		priceValidUpper=200;
		priceValidUpperMinusOne=199;
		priceInvalidLower=-1;
		priceInvalidUpper=201;
		
		rentValid = 224;
		rentValidLower=24;
		rentValidLowerPlusOne=25;
		rentValidUpper=400;
		rentValidUpperMinusOne=399;
		rentInvalidLower=23;
		rentInvalidUpper=401;
		
		rentMultiplierValid=3;
		rentMultiplierValidLower=1;
		rentMultiplierValidLowerPlusOne=2;
		rentMultiplierValidUpper=5;
		rentMultiplierValidUpperMinusOne=4;
		rentMultiplierInvalidLower=0;
		rentMultiplierInvalidUpper=6;
		
		priceOfHouseValid=100;
		priceOfHouseValidLower=50;
		priceOfHouseValidLowerPlusOne=51;
		priceOfHouseValidUpper=150;
		priceOfHouseValidUpperMinusOne=149;
		priceOfHouseInvalidLower=49;
		priceOfHouseInvalidUpper=151;
		
		numberOfHousesValid=2;
		numberOfHousesValidLower=0;
		numberOfHousesValidUpper=4;
		numberOfHousesValidUpperMinusOne=3;
		numberOfHousesInvalidLower=-1;
		numberOfHousesInvalidUpper=5;
		
		
	}

	@Test
	public void testDefaultConstructorPropertySquare() {
		PropertySquare p1 = new PropertySquare();
		assertNotNull(p1);
	}

	@Test
	public void testPropertySquareConstructorWithArgs() {
		PropertySquare p1 = new PropertySquare(nameValid, boardLocationValid, priceValid, rentValid);
		assertNotNull(p1);
		
		assertEquals(nameValid, p1.getName());
		assertEquals(boardLocationValid, p1.getBoardLocation());
		assertEquals(priceValid, p1.getPrice());
		assertEquals(rentValid, p1.getRent());
	}

	@Test
	public void testSetRentMultiplier() {
		PropertySquare p1 = new PropertySquare();
		p1.setRentMultiplier(rentMultiplierValid);
		assertEquals(rentMultiplierValid, p1.getRentMultiplier());
		
		p1.setRentMultiplier(rentMultiplierValidLower);
		assertEquals(rentMultiplierValidLower, p1.getRentMultiplier());
		
		p1.setRentMultiplier(rentMultiplierValidLowerPlusOne);
		assertEquals(rentMultiplierValidLowerPlusOne, p1.getRentMultiplier());
		
		p1.setRentMultiplier(rentMultiplierValidUpper);
		assertEquals(rentMultiplierValidUpper, p1.getRentMultiplier());
		
		p1.setRentMultiplier(rentMultiplierValidUpperMinusOne);
		assertEquals(rentMultiplierValidUpperMinusOne, p1.getRentMultiplier());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetRentMultiplierInvalidLower() {
		PropertySquare p1 = new PropertySquare();
		p1.setRentMultiplier(rentMultiplierInvalidLower);
	
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetRentMultiplierInvalidUpper() {
		PropertySquare p1 = new PropertySquare();
		p1.setRentMultiplier(rentMultiplierInvalidUpper);
	
	}
	

	@Test
	public void testSetGetNumberOfHouses() {
		PropertySquare p1 = new PropertySquare();
		p1.setNumberOfHouses(numberOfHousesValid);
		assertEquals(numberOfHousesValid, p1.getNumberOfHouses());
		
		p1.setNumberOfHouses(numberOfHousesValidLower);
		assertEquals(numberOfHousesValidLower, p1.getNumberOfHouses());
		
		p1.setNumberOfHouses(numberOfHousesValidLowerPlusOne);
		assertEquals(numberOfHousesValidLowerPlusOne, p1.getNumberOfHouses());
		
		p1.setNumberOfHouses(numberOfHousesValidUpper);
		assertEquals(numberOfHousesValidUpper, p1.getNumberOfHouses());
		
		p1.setNumberOfHouses(numberOfHousesValidUpperMinusOne);
		assertEquals(numberOfHousesValidUpperMinusOne, p1.getNumberOfHouses());
	}
	
	@Test  (expected=IllegalArgumentException.class)
	public void testSetGetNumberOfHousesInvalidLower() {
		PropertySquare p1 = new PropertySquare();
		p1.setNumberOfHouses(numberOfHousesInvalidLower);
		
	}
	
	@Test  (expected=IllegalArgumentException.class)
	public void testSetGetNumberOfHousesInvalidUpper() {
		PropertySquare p1 = new PropertySquare();
		p1.setNumberOfHouses(numberOfHousesInvalidUpper);
		
	}

	@Test 
	public void testSetGetPrice() {
		PropertySquare p1 = new PropertySquare();
		p1.setPrice(priceValid);
		assertEquals(priceValid, p1.getPrice());
		
		p1.setPrice(priceValidLower);
		assertEquals(priceValidLower, p1.getPrice());
		
		p1.setPrice(priceValidLowerPlusOne);
		assertEquals(priceValidLowerPlusOne, p1.getPrice());
		
		p1.setPrice(priceValidUpper);
		assertEquals(priceValidUpper, p1.getPrice());
		
		p1.setPrice(priceValidUpperMinusOne);
		assertEquals(priceValidUpperMinusOne, p1.getPrice());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetPriceInalidLower() {
		PropertySquare p1 = new PropertySquare();
		p1.setPrice(priceInvalidLower);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetPriceInvalidUpper() {
		PropertySquare p1 = new PropertySquare();
		p1.setPrice(priceInvalidUpper);
	}

	@Test
	public void testSetGetRent() {
		PropertySquare p1 = new PropertySquare();
		p1.setRent(rentValid);
		assertEquals(rentValid, p1.getRent());
		
		p1.setRent(rentValidLower);
		assertEquals(rentValidLower, p1.getRent());
		
		p1.setRent(rentValidLowerPlusOne);
		assertEquals(rentValidLowerPlusOne, p1.getRent());
		
		p1.setRent(rentValidUpper);
		assertEquals(rentValidUpper, p1.getRent());
		
		p1.setRent(rentValidUpperMinusOne);
		assertEquals(rentValidUpperMinusOne, p1.getRent());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetRentInvalidLower() {
		PropertySquare p1 = new PropertySquare();
		p1.setRent(rentInvalidLower);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetRentInvalidUpper() {
		PropertySquare p1 = new PropertySquare();
		p1.setRent(rentInvalidUpper);
	}

	@Test  
	public void testSetPriceOfHouse() {
		PropertySquare p1 = new PropertySquare();
		p1.setPriceOfHouse(priceOfHouseValid);
		assertEquals(priceOfHouseValid, p1.getPriceOfHouse());
		
		p1.setPriceOfHouse(priceOfHouseValidLower);
		assertEquals(priceOfHouseValidLower, p1.getPriceOfHouse());
		
		p1.setPriceOfHouse(priceOfHouseValidLowerPlusOne);
		assertEquals(priceOfHouseValidLowerPlusOne, p1.getPriceOfHouse());
		
		p1.setPriceOfHouse(priceOfHouseValidUpper);
		assertEquals(priceOfHouseValidUpper, p1.getPriceOfHouse());
		
		p1.setPriceOfHouse(priceOfHouseValidUpperMinusOne);
		assertEquals(priceOfHouseValidUpperMinusOne, p1.getPriceOfHouse());
	}
	
	@Test  (expected=IllegalArgumentException.class)
	public void testSetPriceOfHouseInvalidLower() {
		PropertySquare p1 = new PropertySquare();
		p1.setPriceOfHouse(priceOfHouseInvalidLower);
	}
	
	@Test  (expected=IllegalArgumentException.class)
	public void testSetPriceOfHouseInvalidUpper() {
		PropertySquare p1 = new PropertySquare();
		p1.setPriceOfHouse(priceOfHouseInvalidUpper);
	}


	@Test
	public void testSetGetName() {
		PropertySquare p1 = new PropertySquare();
		p1.setName(nameValid);
		assertEquals(nameValid, p1.getName());
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidLower() {
		PropertySquare p1 = new PropertySquare();
		p1.setName(nameInvalidLower);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidUpper() {
		PropertySquare p1 = new PropertySquare();
		p1.setName(nameInvalidUpper);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidWhiteSpace() {
		PropertySquare p1 = new PropertySquare();
		p1.setName(nameInvalidWhiteSpace);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetNameInvalidNullValue() {
		PropertySquare p1 = new PropertySquare();
		p1.setName(null);
	}

	@Test 
	public void testSetGetBoardLocation() {
		PropertySquare p1 = new PropertySquare();
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
		PropertySquare p1 = new PropertySquare();
		p1.setBoardLocation(boardLocationInvalidLower);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetGetBoardLocationInvalidUpper() {
		PropertySquare p1 = new PropertySquare();
		p1.setBoardLocation(boardLocationInvalidUpper);
	}

}
