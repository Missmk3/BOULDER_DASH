package entity.mobile;

import entity.Permeability;
import entity.Sprite;

/**
 *
 * Boulder Class
 * @author GROUP 09
 *
 */
public class Boulder extends Mobile{
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('O', "boulder.png");

    /**
     * Instantiates a new obstacle.
     * @param SPRITE
     * @param Permeability.BOULDER
     */
    public Boulder() {
        super(SPRITE, Permeability.BOULDER);
    }


    /**
     *Move to th rigth
     */
    @Override
    public void moveRight() {
        super.moveRight();
    }


    /**
     *executed action when we win
     */
    @Override
    public void win() {
        // TODO Auto-generated method stub
        return;
    }


    /**
     *Move to the left
     */
    @Override
    public void moveLeft() {
        super.moveLeft();
    }


    /**
     *move Down
     */
    @Override
    public void moveDown() {
        super.moveDown();
    }


    /**
     *Gets the diamonds
     */
    @Override
    public int getDiamonds() {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     *recovers the diamonds
     */
    @Override
    public void grabDiamond() {
        return;
    }

}
