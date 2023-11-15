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

    private static String[] filenames = new String[] {"C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\JPU-BlankProject/map4.txt", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/background.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/boulder.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/diamond.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/door.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/greenMonster.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/ground.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/pDead.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/pDown.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/pLeft.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/pNope.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/pRight.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/pUp.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/pWin.png", "C:\\Users\\Aurel\\Dropbox\\PC\\Desktop\\sprites/wall.png"};

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
