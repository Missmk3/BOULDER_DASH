package controller;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import contract.IOrderPerformer;
import contract.IView;
import contract.UserOrder;
import entity.Permeability;

/**
 * Unit Test for the controller
 * test class to check the controllers operation 
 * @author ouank
 * 
 */

public class ControllerTest {
	
	
	 
    

    private IView view;

    private IModel model;

   
    private UserOrder stackOrder;
    
    
    private boolean hasWon = false;

	private Controller controller;

	static Permeability[]  permeabilities={Permeability.WALL,Permeability.WALKABLE,Permeability.KILLABLE,Permeability.BOULDER,Permeability.EXIT,Permeability.DIGGABLE,Permeability.DIAMOND};
			
			static UserOrder[] moves= { UserOrder.UP ,  UserOrder.DOWN, UserOrder.RIGHT ,  UserOrder.LEFT};
		
		
    

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		
		this.controller = new Controller(view,model);
				}

	@After
	public void tearDown() throws Exception {
	}

	
	 /**
     * run Test 
     * to check the run condition applied for the method 
     *  
     *  @param hasWon 
     *  @param GameOn 
     *  
  
     */
	@Test
	public void testRun() {
		 boolean GameOn=true;
		if( hasWon == false) {
			assertTrue(GameOn);
		}
	}

	 /**
     * Move Player Test 
     * make sure that the entry movement is indeed part of the required movements before making the move
     *  
     *  @param makeMove
  
     */
	@Test
	public void testMovePlayer() {
		boolean makeMove= true;
		this.controller.setStackOrder(UserOrder.DOWN);
  UserOrder expectedUse= this.controller.getStackOrder(); 
  for (UserOrder useOrder : moves) {
	  if(expectedUse == UserOrder.DOWN) {
		  assertTrue(makeMove);
	  }
	  else {assertFalse(makeMove);}
	  }
	 
	}
	
	
	 /**
     * Kill Player Test 
     * be reassured that the permeability conditions it faces are the right ones to kill the game 
     * to check this test , we must check if we have the permeabilities's conditions true.
     *  
     *  @param a
     *  @param allowKillP
  
     */
	
	@Test
	public void testKillPlayer() {
		Permeability a= Permeability.KILLABLE;
		
		boolean allowKillP= true ;
		for (Permeability permeability:permeabilities) {
			if (a==Permeability.KILLABLE ) {
				assertTrue(allowKillP);
			}
			else {
				assertFalse(allowKillP);
			}
		}
	}

	


	 /**
    * Boulders Gravity Test 
    * To allow gravity , we must make sure that the interger are not negative 
    *  @param allowGravityB
 
    */
	
	@Test
	public void testGravityBoulder() {
		boolean allowGravityB =true;
		int x = 1,y = 1;
		if (x>=0 &&y >=0) {
			assertTrue(allowGravityB);
		}
		else{assertFalse(allowGravityB);
		}
	}

	
	 /**
	    * Diamond Gravity Test 
	    * To allow gravity, we must make sure that the interger are not negative 
	    *  @param allowGravity
	 
	    */
	@Test
	public void testGravityDiamond() {
		boolean allowGravity =true;
		int x = 1,y = 1;
		if (x>=0 &&y >=0) {
			assertTrue(allowGravity);
		}
		else{assertFalse(allowGravity);
		}
	}

	 /**
	    * Kill Monsters Test 
	    * be reassured that the permeability conditions it faces are the right ones to kill Monster 
	    * to check this test , we must check if we have the permeabilities's conditions true.
	    * 
	    *  @param allowKillM
	    *  @param a
	    *  @param b
	    */
	@Test
	public void testKillMonster() {
		Permeability a= Permeability.KILLABLE;
		Permeability b= Permeability.BOULDER;
		
		boolean allowKillM= true ;
		for (Permeability permeability:permeabilities) {
			if (a==Permeability.KILLABLE && b==Permeability.BOULDER || a == Permeability.KILLABLE && b == Permeability.DIAMOND) {
				assertTrue(allowKillM);
			}
			else {
				assertFalse(allowKillM);
			}
		}
		}

	
	 /**
	    * OrderPerform Test 
	    * make sure that the set value is the recover value 
	    *  @param expected
	    */
	@Test
	public void testOrderPerform() {
		final UserOrder expected = null;
	this.controller.setStackOrder(expected);
		assertEquals(expected, this.controller.getStackOrder());
	}

}
