package contract;

import entity.IMap;
import entity.mobile.IMobile;


/**
 * This method contents the main method of the Model .
 * the classes which will implement this interface, will use them to carry out their main operation
 *
 * @author GROUP 09
 *
 * @see IModel#getMap()
 */
public interface IModel {

	/**
	 * this method recovers the map for the model's classes .
	 * @return the map
	 * @see IModel#getMyPlayer()
	 */
	IMap getMap();


	/**
	 *this method allows you to retrieve the desired player for the classes of the IModel interface .
	 *@return the player's param
	 */
	IMobile getMyPlayer();
}
