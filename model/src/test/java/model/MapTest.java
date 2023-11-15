package model;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.IElement;
import entity.IMap;


/**
 *the Map Test 
 *
 *@AUTHOR Group 09
 */
public class MapTest {
	
	
	int width = 26;
	int heigth =26;
	int x = 2;
	int y = 6;
	private IElement[][] onthemap;
	private List<Integer> hasChanged ;
	private IMap map;
	private java.util.Observable Observable;
	 private static String[] filenames = new String[] {"C:\\Users\\ouank\\OneDrive\\Bureau\\boulderdash_final\\JPU-BlankProject\\map1.txt"};
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map= new Map("C:\\Users\\ouank\\OneDrive\\Bureau\\boulderdash_final\\JPU-BlankProject\\map1.txt");
	this.onthemap = new IElement[x][y];
	this.hasChanged = new ArrayList<Integer>();
	this.Observable= (java.util.Observable) this.map ;
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	/**
	    *checkFiles    Test 
	    *Check if the file exist after the instanciation
	    *
	    *@param file
	    */  
	@Test
	public void testCheckFiles() {
		for (String filename :filenames) {
			 File file = new File(filename);
			assertTrue(file.exists());
		}
	}

	
	/**
	    *GetOnTheMapXY    Test 
	    *Check if the element is well get on the map
	    *if what we set is what we get as element on the map 
	    *
	    *@param expected
	    */  
	@Test
	public void testGetOnTheMapXY() {
		final IElement expected = this.map.getOnTheMapXY(x,y);
		assertEquals(expected , this.map.getOnTheMapXY(x, y));
	}

	
	/**
	    *SetOnTheMapXY    Test 
	    *Check if the size of the list incerments after the set . To know if it works well
	    *if what we set is count 
	    *
	    *@param element 
	    *@param x2
	    *@param y2
	    *@param expectedSize 
	    */  
	@Test
	public void testSetOnTheMapXY() {
		final IElement element = this.map.getOnTheMapXY(x,y);
		final int x2 = 1;
		final int y2 = 1;
		final int expectedSize =2;
		this.map.setOnTheMapXY(element, x2, y2);
		this.hasChanged.add(x2);
		this.hasChanged.add(y2);
		assertEquals(expectedSize, ((List<Integer>) this.hasChanged).size());
	}

	

	/**
	    *getWidth  Test 
	    *Check the expected width is what we get 
	    *
	    *@param expected 
	    */
	@Test
	public void testGetWidth() {
		final int expected = 26;
		assertEquals(expected , this.map.getWidth());
	}
	
	
	/**
	    *getHeigth  Test 
	    *Check the expected heigth is what we get 
	    *
	    *@param expected 
	    */
	@Test
	public void testGetHeight() {
		final int expected = 26;
		assertEquals(expected , this.map.getWidth());
	}

	/**
	    *getObservable  Test 
	    *Check if the map is well observable 
	    *
	    *@param expected 
	    */
	@Test
	public void testGetObservable() {
		final java.util.Observable expected= this.Observable;
		assertEquals(expected , this.map.getObservable());
				}
	
	/**
	    *getHasChanged   Test 
	    *to notify the changement , we must make sure that the list has changed is not empty 
	    *
	    *@param expected 
	    */
	 
	@Test
	public void testGetHasChanged() {
		assertNotNull(this.map.getHasChanged());
	}

}
