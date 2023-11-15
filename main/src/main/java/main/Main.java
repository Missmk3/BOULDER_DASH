/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;
import contract.IBoulderDashController;
import contract.IModel;
import controller.Controller;
import model.BoulderDashModel;
import view.View;

/**
 * The Class Main.
 *
 * @author GROUP 09
 */
public abstract class Main {

    private static String[] filenames = new String[] {"D:\\BoulderDash_code/map4.txt", "D:\\BoulderDash_code\\sprites/background.png", "D:\\BoulderDash_code\\sprites/boulder.png", "D:\\BoulderDash_code\\sprites/diamond.png", "D:\\BoulderDash_code\\sprites/door.png", "D:\\BoulderDash_code\\sprites/greenMonster.png", "D:\\BoulderDash_code\\sprites/ground.png", "D:\\BoulderDash_code\\sprites/pDead.png", "D:\\BoulderDash_code\\sprites/pDown.png", "D:\\BoulderDash_code\\sprites/pLeft.png", "D:\\BoulderDash_code\\sprites/pNope.png", "D:\\BoulderDash_code\\sprites/pRight.png", "D:\\BoulderDash_code\\sprites/pUp.png", "D:\\BoulderDash_code\\sprites/pWin.png", "D:\\BoulderDash_code\\sprites/wall.png"};

    private static View view;
    private static IModel model;
    private static  IBoulderDashController controller;

    /**
     * The main method.
     *
     */
    public static void main(final String[] args) {

        model = new BoulderDashModel(filenames[0], 1, 1);



        view = new View(model.getMap(), model.getMyPlayer());
        controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPerformer());

        controller.run();


    }

}
