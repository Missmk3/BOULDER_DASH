package contract;

import fr.exia.showboard.BoardFrame;

/**
 * The Interface IView.
 *the interface manage the methods of the view's class
 * @author GROUP 09
 * @see IView#displayMessage(String)
 */
public interface IView {

	/**

	 *this method manage the method used to display message on the game's windows
	 *
	 *@param message
	 * @see View#displayMessage(String)
	 */
	void displayMessage(final String message);

	/**

	 *this method manage the method used to display the player on the game's windows
	 *
	 * @see View#followMyPlayer()
	 */

	void followMyPlayer();
	/**

	 *this method manage the method used to update the game's view after any change
	 *
	 * @see View#updateView()
	 */

	void updateView();

	/**

	 *this method gets the order BooradFrame
	 *@returns BoardFrame
	 * @see View#getBoardFrame()	 */

	BoardFrame getBoardFrame();
}