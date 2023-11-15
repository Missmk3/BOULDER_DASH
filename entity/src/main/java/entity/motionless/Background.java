package entity.motionless;

import entity.Permeability;
import entity.Sprite;

/**
 * @author GROUP 09
 *
 */
public class Background extends MotionlessElement{
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('.', "background.png");

    /**
     * Instantiates a new background.
     */
    Background() {
        super(SPRITE, Permeability.WALKABLE);
    }

}
