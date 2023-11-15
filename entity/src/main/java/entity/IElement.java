package entity;

import fr.exia.showboard.ISquare;

/**
 * the IElement Interface
 * @author GROUP 09
 *
 */
public interface IElement extends ISquare {
    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();


    /**
     * Gets the change.
     *
     * @return this.hasChanged
     */
    Boolean getHasChanged();

    /**
     * Sets a new value for the change .
     *
     * @param hasChanged
     */
    void setHasChanged(Boolean hasChanged);

}
