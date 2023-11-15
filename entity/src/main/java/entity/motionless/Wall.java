package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Wall extends MotionlessElement{
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('#', "Wall.png");

    /**
     * Instantiates a new wall.
     */
    Wall() {
        super(SPRITE, Permeability.WALL);
    }

}
