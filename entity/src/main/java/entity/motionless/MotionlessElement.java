package entity.motionless;

import entity.Element;
import entity.IElement;
import entity.Permeability;
import entity.Sprite;

/**
 * @author GROUP 09
 *
 */
public class MotionlessElement extends Element implements IElement {
    /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    MotionlessElement(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }

}
