package entity.motionless;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Permeability;
import entity.Sprite;


/**
 *MotionlessElement Test
 *
 * @author ouank 
 */
public class MotionlessElementTest {

	Wall wall ;
	private boolean hasChanged = false;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.wall = new Wall();
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/**
	    *getSprite  Test 
	    *Check the sprite expected is the sprite got  
	    *@param Sexpected 
	    */
	@Test
	public void testGetSprite() {
		final Sprite SExpected = this.wall.getSprite();
		assertEquals(SExpected, wall.getSprite());
	}

	
	
	/**
	    *getPermeability Test 
	    *Check the element permeability expected is the element permeability got  
	    *@param Pexpected 
	    */
	@Test
	public void testGetPermeability() {
		final Permeability PExpected = Permeability.WALL;
		assertEquals(PExpected, wall.getPermeability());
	}

	
	/**
	    *getHasChanged   Test 
	    *Check if we can get the changes 
	    *@param expected 
	    */
	@Test
	public void testGetHasChanged() {
		final boolean expected =this.hasChanged;
		assertEquals(expected, this.wall.getHasChanged());
	}

	
	/**
	    *setHasChamged   Test 
	    *Check the set change is the change that we get   
	    *@param expected 
	    */
	@Test
	public void testSetHasChanged() {
		final boolean expected =true;
		this.wall.setHasChanged(expected);
		assertEquals(expected, this.wall.getHasChanged());
	}

}
