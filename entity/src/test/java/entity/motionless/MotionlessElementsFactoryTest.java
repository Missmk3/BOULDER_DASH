package entity.motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *MotionlessElementsFactory Test 
 *
 *@author ouank 
 */
public class MotionlessElementsFactoryTest {

	private final Wall wall = new Wall();
	private final Door door = new Door();
	private final Background background = new Background();
	private final Ground ground = new Ground();
	
	MotionlessElementsFactory elemnt ;

	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */
	private final  MotionlessElement[] motionlessElements = {wall, background, door, ground};

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/**
	    *CreateWall Test 
	    *Check the  rigth keywords before create Wall  
	    *@param expected 
	    *@param wallcreated 
	    */
	@Test
	public void testCreateWall() {
		final boolean wallcreated= true;
		final MotionlessElement expected= this.elemnt.createWall();
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if(expected == motionlessElement) {
				assertTrue(wallcreated);
			}
		}
		
	}

	
	/**
	    *CreateDoor Test 
	    *Check the  rigth keywords before create Door   
	    *@param expected 
	    *@param doorcreated 
	    */
	@Test
	public void testCreateDoor() {
		final boolean doorcreated= true;
		final MotionlessElement expected= this.elemnt.createDoor();
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if(expected == motionlessElement) {
				assertTrue(doorcreated);
			}
		}
	}

	
	/**
	    *CreateBackGround Test 
	    *Check the  rigth keywords before create Background   
	    *@param expected 
	    *@param backgroundcreated 
	    */
	@Test
	public void testCreateBackground() {
		final boolean backgcreated= true;
		final MotionlessElement expected= this.elemnt.createBackground();
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if(expected == motionlessElement) {
				assertTrue(backgcreated);
			}
		}
	}

	
	/**
	    *CreateGround Test 
	    *Check the  rigth keywords before create Ground   
	    *@param expected 
	    *@param groundcreated 
	    */
	@Test
	public void testCreateGround() {
		final boolean groundcreated= true;
		final MotionlessElement expected= this.elemnt.createGround();
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if(expected == motionlessElement) {
				assertTrue(groundcreated);
		
		}
	}
	}

	
	/**
	    *CreateWall Test 
	    *Check the  rigth character  before get it 
	    * 
	    *@param filesymbolFound 
	    */
	@Test
	public void testGetFromFileSymbol() {
		final boolean filesymbolfound = true;
		for (final MotionlessElement motionlessElement : motionlessElements) {
			char fileSymbol = '#';
			if (this.wall.getSprite().getConsoleImage() == fileSymbol) {
				assertTrue(filesymbolfound);
			}
		}
		
	}

}
