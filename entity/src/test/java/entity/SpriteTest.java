package entity;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Boulder;


/**
 * Sprite Test Class .
 *
 * @author Group 09
 */
public class SpriteTest {
	
	Boulder boulder ;
	private Image image;
	private Sprite sprite;
	private boolean IsImageLoaded  ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.sprite = new Sprite('O', "boulder.png");
		this.boulder= new Boulder ()	;
		this.IsImageLoaded = false;
		}

	@After
	public void tearDown() throws Exception {
	}

	 /**
     * GetImage Test 
     *
     *to check if the image is succefully get , we check  if we can read it .
     *@param image 
     */
	
	@Test
	public void testGetImage() throws IOException {
		File image= new File("C:\\Users\\ouank\\OneDrive\\Bureau\\boulderdash_final\\JPU-BlankProject\\sprites\\" + this.boulder.getSprite().getImageName());
		assertTrue(image.canRead());
	}
	
	

	 /**
    * LoadedImage  Test 
    *
    *to check if the image is succefully loaded , we check  if the image file exists  .
    *the file must exists before the image's loading
    *@param image
    */

	@Test
	public void testLoadImage() {
		File image= new File("C:\\Users\\ouank\\OneDrive\\Bureau\\boulderdash_final\\JPU-BlankProject\\sprites\\" + this.boulder.getSprite().getImageName());
		assertTrue(image.exists());
    }
	

	 /**
	    *GetConsoleImage Test 
	    *
	    *we check if the Console Image expected for the sprite  is what we get 
	    *
	    *@param CExpected
	    */

	@Test
	public void testGetConsoleImage() {
		final char CExpected = 'O';
		assertEquals(CExpected, boulder.getSprite().getConsoleImage());
	}

	 /**
	    * GetImageName  Test 
	    *
	    *check if the image Name set in the instantiation is what we get 
	    *@param SExpected
	    */

	@Test
	public void testGetImageName() {
		final String SExpected = "boulder.png";
		assertEquals(SExpected, boulder.getSprite().getImageName());

	}

	
	 /**
	    * IsLoadedImage  Test 
	    *the test Check if the file exist and can read 
	    *if the file doesn't exist and we can't read it that's mean that the image is not loaded
	    *@param image
	    */
	@Test
	public void testIsImageLoaded() {
		File image= new File("C:\\Users\\ouank\\OneDrive\\Bureau\\boulderdash_final\\JPU-BlankProject\\sprites\\" + this.boulder.getSprite().getImageName());
		if ( !image .exists() && image.canRead()) {
			assertTrue(this.sprite.isImageLoaded());
		}
	}

	
	/**
	    * SetImageLoaded  Test 
	    *the test Check if what we set as isImageLoaded is what we get 
	    *
	    *@param expected
	    */
	@Test
	public void testSetImageLoaded() {
		final boolean expected= true;
		this.sprite.setImageLoaded(expected);
		assertEquals(expected, this.sprite.isImageLoaded());
	}

}
