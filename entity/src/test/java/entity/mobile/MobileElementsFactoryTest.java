package entity.mobile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.IElement;


/**
 *MobileElementsFactory Test 
 *
 *@author Group 09
 */
public class MobileElementsFactoryTest {

	MobileElementsFactory mobile;
	
	char expected;

	@Before
	public void setUp() throws Exception {
		this.mobile = new MobileElementsFactory();

	}

	
	 /**
	    *GetFromFileSymbol Test 
	    *Check if what we Expected is what we get as Symbol From File 
	    *
	    *@param element 
	    */
	@Test
	public void testGetFromFileSymbol() {
		IElement element = new Boulder();
		assertEquals(element.getSprite().getImage(), MobileElementsFactory.getFromFileSymbol('O').getSprite().getImage());
	}

	
	/**
	    *CreateMonsterG Test 
	    *Check we can create a monster by ConsoleImage 
	    *
	    *@param expected 
	    */
	@Test
	public void testCreateMonsterG() {
		this.expected = 'G';
		assertEquals(expected, MobileElementsFactory.createMonsterG().getSprite().getConsoleImage());
	}

	/**
	    *CreateDiamond Test 
	    *Check we can create a Diamond by ConsoleImage 
	    *
	    *@param expected 
	    */
	@Test
	public void testCreateDiamond() {
		this.expected = '*';
		assertEquals(expected, MobileElementsFactory.createDiamond().getSprite().getConsoleImage());
	}

	/**
	    *CreateRock Test 
	    *Check we can create Rock by ConsoleImage 
	    *
	    *@param expected 
	    */
	@Test
	public void testCreateRock() {
		this.expected = 'O';
		assertEquals(expected, MobileElementsFactory.createRock().getSprite().getConsoleImage());

	}

}
