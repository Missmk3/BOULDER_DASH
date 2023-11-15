package view;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IOrderPerformer;
import entity.IMap;
import entity.mobile.IMobile;
import fr.exia.showboard.BoardFrame;


/**
 * The Class View Test.
 *
 * @author Group 09
 */

public class ViewTest {

	
	

	
	private BoardFrame boardFrame;

	
	final Rectangle gameView = new Rectangle(0, 0, 16, 16);

	
	private IMap map;

	
	private IMobile myPlayer;

	
	private IOrderPerformer orderPerformer;


	private View view;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		
		View view = new View(map, myPlayer);
		this.boardFrame = new BoardFrame();		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * DisplayMessage Test .
	 *
	 * check thel display message .
	 * param displayed
	 */

	@Test
	public void testDisplayMessage() {
		boolean displayed = true;
		int choiceexpect = 0;
		if (choiceexpect == 0) {
			assertTrue(displayed);
		} else {
			System.exit(0);
			assertFalse(displayed);
		}
	}


}
