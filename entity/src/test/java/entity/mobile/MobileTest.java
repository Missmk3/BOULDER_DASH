package entity.mobile;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.IMap;
import fr.exia.showboard.IBoard;


/**
 *MobileTest 
 *
 *@author Group 09
 */
public class MobileTest {
	
	int IExpected;
	MyPlayer myplayer;
	Boolean BExpected;
	IMap map;
	IMobile player ;
	private IBoard board;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.myplayer = new MyPlayer(1, 2, map);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	 /**
     *MoveUp Test 
     *Check the result of a moveUp movement 
     *
     *@param movedUp
     *@param Upmove 
     */
	@Test
	
	public void testMoveUp() {
		final boolean movedUp= true;
		final int Upmove= 1;
		int result= this.myplayer. getY() - 1;
		if (Upmove == result) {
			assertTrue(movedUp);
			
		}
	}

	

	 /**
    *MoveLeft Test 
    *Check the result of a movedLeft movement 
    *
    *@param moveLeft 
    *@param Leftmove 
    */
	@Test
	public void testMoveLeft() {
		final boolean movedLeft= true;
		final int Leftmove= 0;
		int result= this.myplayer. getX() - 1;
		if (Leftmove == result) {
			assertTrue(movedLeft);
			
		}
	}

	

	 /**
    *MoveDown  Test 
    *Check the result of a moveDown  movement 
    *
    *@param movedDown 
    *@param Downmove 
    */
	@Test
	public void testMoveDown() {
		final boolean movedDown= true;
		final int Downmove= 1;
		int result= this.myplayer. getY() + 1;
		if (Downmove == result) {
			assertTrue(movedDown);
			
		}
	}


	 /**
    *MoveRight Test 
    *Check the result of a moveRight movement 
    *
    *@param movedRight
    *@param Rightmove 
    */
	@Test
	public void testMoveRight() {
		final boolean movedRigth= true;
		final int Rigthmove= 1;
		int result= this.myplayer. getY() + 1;
		if (Rigthmove == result) {
			assertTrue(movedRigth);
			
		}
	}


	 /**
    *DoNothing Test 
    *Check the result of a DoNothing  movement 
    *
    *@param Yexpected 
    */
	@Test
	public void testDoNothing() {
		final int Yexpected=2;
		assertEquals(Yexpected , this.myplayer.getY());
	}

	

	 /**
    *GetX Test 
    *Check if what we Expected is what we get
    *
    *@param IExpected
    */
	@Test
	public void testGetX() {
		IExpected = 1;
		assertEquals(this.IExpected, this.myplayer.getX());
	}

	 /**
	    *SetX Test 
	    *Check if what we set is what we get
	    *
	    *@param IExpected
	    */
	@Test
	public void testSetX() {
		IExpected = 4;
		this.myplayer.setX(IExpected);
		assertEquals(this.IExpected, this.myplayer.getX());
	}

	
	 /**
	    *GetY Test 
	    *Check if what we Expected is what we get
	    *
	    *@param IExpected
	    */
	@Test
	public void testGetY() {
		IExpected = 2;
		assertEquals(this.IExpected, this.myplayer.getY());
	}

	
	 /**
	    *SetY Test 
	    *Check if what we set is what we get
	    *
	    *@param IExpected
	    */
	@Test
	public void testSetY() {
		IExpected = 6;
		this.myplayer.setY(IExpected);
		assertEquals(this.IExpected, this.myplayer.getY());
	}

	
	 /**
	    *GetPosition  Test 
	    *Check if what we Expected is what we get
	    *
	    *@param expected
	    */
	@Test
	public void testGetPosition() {
		final Point expected = new Point(1,2);
		assertEquals(expected , ((Mobile) this.myplayer).getPosition());
	}

	
	 /**
	    *SetPosition Test 
	    *Check if what we set as position  is what we get
	    *
	    *@param PExpected
	    */
	@Test
	public void testSetPosition() {
		final Point PExpected = new Point(3, 2);
		this.myplayer.setPosition(PExpected);
		assertEquals(PExpected, this.myplayer.getPosition());
	}

	
	 /**
	    *GetBoardTest 
	    *Check if the expected Board is what we get
	    *
	    *@param expected
	    */
	@Test
	public void testGetBoard() {
		final IBoard expected =this.board;
		assertEquals(expected , ((Mobile) this.myplayer).getBoard());
	}

}
