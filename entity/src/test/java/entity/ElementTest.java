package entity;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Boulder;


/**
 * Element Test
 *
 * @author Group 09
 */

public class ElementTest {
	
	Boulder boulder ;
	private boolean hasChanged = false;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.boulder = new Boulder();
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
     * GetSprite Test 
     * to check if what we get its what we expected
     * 
     * @param SExpected
  
     */
	@Test
	public void testGetSprite() {
		final Sprite SExpected = this.boulder.getSprite();
		assertEquals(SExpected, boulder.getSprite());
	}

	

	/**
     * SetSprite Test 
     * to check if what we set its what we get
     * 
     * @param SExpected
  
     */
	@Test
	public void testSetSprite() {
		final Sprite SExpected = this.boulder.getSprite();
		this.boulder.setSprite(SExpected);
		assertEquals(SExpected, boulder.getSprite());
	}

	
	/**
     * GetPermeability  Test 
     * to check if what we get its what we expected
     * 
     * @param PExpected
  
     */
	@Test
	public void testGetPermeability() {
		final Permeability PExpected = Permeability.BOULDER;
		assertEquals(PExpected, boulder.getPermeability());
	}

	
	/**
     * GetImage  Test 
     * to check if what we get its what we expected.and then we must make sure that the images file exists before get it 
     * 
     * @param image 
  
     */
	@Test
	public void testGetImage() {
		File image= new File("C:\\Users\\ouank\\OneDrive\\Bureau\\boulderdash_final\\JPU-BlankProject\\sprites\\" + this.boulder.getSprite().getImageName());
		assertTrue(image.exists());
	}

	/**
     * GetHasChanged  Test 
     * we check if what we get its what we expected to make sure that the changed will correctly get 
     * 
     * @param expected 
  
     */
	@Test
	public void testGetHasChanged() {
		final boolean expected =this.hasChanged;
		assertEquals(expected, this.boulder.getHasChanged());
	}

	
	/**
     * SetHasChanged  Test 
     * to check if what we set as change will be correctly get
     * 
     * @param expected 
  
     */
	@Test
	public void testSetHasChanged() {
		final boolean expected =true;
		this.boulder.setHasChanged(expected);
		assertEquals(expected, this.boulder.getHasChanged());
	}

}
