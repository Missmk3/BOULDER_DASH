package entity;

import java.awt.Image;

/**
 * it gathers the methods to be applied to all the elements of the game
 * the Element Class .
 *
 * @author GROUP 09
 */
public abstract class Element {
    /**
     * The sprite.
     */
    private Sprite sprite;

    /**
     * The permeability.
     */
    private Permeability permeability;

    private Boolean hasChanged = false;

    /**
     * the Element Constructor
     * to instantiate a new Element
     *
     * @param sprite
     * @param permeability
     */
    public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }
    /**
     * Gets the sprite
     * @return this.sprite
     */
    public final Sprite getSprite() {
        return this.sprite;
    }

    /**
     * Sets a new sprite.
     *
     * @param sprite the new sprite
     */

    protected final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }

    /*
     * Gets Elements Permeability
     * @see fr.exia.insanevehicles.model.element.IElement#getPermeability()
     *
     * @return this.permeability
     */
    public final Permeability getPermeability() {
        return this.permeability;
    }

    /**
     * Sets a new permeability.
     *
     * @param permeability the new permeability
     */
    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }

    /*
     * Gets the Image by the sprite
     * @return this.getSprite().getImage()
     *
     */
    public final Image getImage() {
        return this.getSprite().getImage();
    }

    /**
     * Gets the change on the Element
     *
     * @return hasChanged
     */
    public Boolean getHasChanged() {
        return hasChanged;
    }


    /**
     * Sets a new value changes param
     *
     * @rparam  this.hasChanged
     */
    public void setHasChanged(Boolean hasChanged) {
        this.hasChanged = hasChanged;
    }


}
