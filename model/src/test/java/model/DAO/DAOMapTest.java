package model.DAO;

import org.junit.Test;

/**
 * @author GROUP 09
 *
 */
public class DAOMapTest {


	DAOMap dao ;
	private String mapFile = "C:\\Users\\Rayan\\Desktop\\JPU-BlankProject\\map1.txt";

	/**
	 * Test for level 0
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testApplyToMap() throws Exception {
		this.dao.loadlevel(mapFile, "0");
	}

}
