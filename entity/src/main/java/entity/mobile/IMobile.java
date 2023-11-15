package entity.mobile;

import java.awt.Point;

import fr.exia.showboard.*;


import entity.IElement;

/**
 * IMobile Interface .
 * Contents the method for the mobile element
 * @author GROUP 09
 */
public interface IMobile extends IPawn, IElement{
    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
    void doNothing();
    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();


    /**
     *Gets the position
     */
    @Override
    Point getPosition();

    /**
     * Die
     */
    public void die();

    /**
     * Win
     */
    public void win();

    /**
     * Gets diamonds
     * @return int
     *
     */
    public int getDiamonds();

    /**
     * Gets diamond
     * @return int
     *
     */
    public void grabDiamond();

}
