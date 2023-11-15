package entity;

import java.util.List;
import java.util.Observable;

/**
 * the IMap Interface
 * @author GROUP 09
 */

/**
 * Gets the width.
 *
 * @return the width
 */
public interface IMap {
    int getWidth();

            /**
             * Gets the height.
             *
             * @return the height
             */
            int getHeight();

            /**
             * Gets on the map XY.
             *
             * @param x
             *            the x
             * @param y
             *            the y
             * @return the on the road XY
             */
            IElement getOnTheMapXY(int x, int y);

            /**
             * Sets on the Map XY
             * @param element
             * @param x
             * @param y
             */
            void setOnTheMapXY(IElement element, final int x, final int y);

        /**
         * Sets the mobile has changed.
         */
        void setMobileHasChanged();

        /**
         * Gets the observable.
         *
         * @return the observable
         */
        Observable getObservable();

        /**
         * check the status of the maps element
         *
         * @return boolean
         */
        boolean isCorrect();
        /**
         * Gets changes in a integer list
         *
         */

        List<Integer> getHasChanged();


        }
