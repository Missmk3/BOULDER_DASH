package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.IMap;
import entity.mobile.IMobile;
import entity.mobile.MyPlayer;



/**
 *the BoulderDashModel Test 
 *
 *@AUTHOR Group 09
 */
public class BoulderDashModelTest {
	

	
	String fileName = "C:\\Users\\ouank\\OneDrive\\Bureau\\boulderdash_final\\JPU-BlankProject\\map1.txt";
	
	private IMobile player;
	
	int  X=2;
	int  Y=1;

	
	BoulderDashModel bould = new BoulderDashModel(fileName, X, Y);

	private IMap map;

	

	

	
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		IMap map = new Map(fileName);
		this. player = new MyPlayer(X, Y, map);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/**
	    *boulderdashmodel   Test 
	    *Check the boulderdashmodel constructor 
	    *
	    *@param fileName
	    *@param X
	    *@param Y
	    */
	@Test
	public void testBoulderDashModel() {
		assertNotNull(this.bould);
	}

	
	/**
	    *getMap   Test 
	    *Check the expected map is what we get 
	    *
	    *@param expected 
	    */
	@Test
	public void testGetMap() {
		final IMap expected = this.map ;
		this.bould.setMap(this.map);
		assertEquals(expected, this.bould .getMap());
	}

	
	/**
	    *getMyPlayer    Test 
	    *Check the expected param player is what we get 
	    *
	    *@param expected 
	    */
	@Test
	public void testGetMyPlayer() {
		final IMobile expected = this.player ;
		this.bould.setMyPlayer(this.player);
		assertEquals(expected, this.bould .getMyPlayer());
	}

}
