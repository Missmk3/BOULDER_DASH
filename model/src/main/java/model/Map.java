package model;

import java.io.BufferedReader;
import java.io.File;

import entity.IElement;
import entity.IMap;
import entity.mobile.MobileElementsFactory;
import entity.motionless.MotionlessElementsFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;

/**
 * <h1>The Map Class.</h1>
 *
 * @author GROUP09
 *
 */

public class Map extends Observable implements IMap {
    /** The width. */
    private int width;

    /** The height. */
    private int height;

    /** The on the map. */
    private IElement[][] onTheMap;

    private boolean isCorrect = true;

    private List<Integer> hasChanged = new ArrayList<Integer>();

    private static String[] filenames = new String[] {"D:\\BoulderDash_code/map1.txt", "D:\\BoulderDash_code\\sprites/background.png", "D:\\BoulderDash_code\\sprites/boulder.png", "D:\\BoulderDash_code\\sprites/diamond.png", "D:\\BoulderDash_code\\sprites/door.png", "D:\\BoulderDash_code\\sprites/greenMonster.png", "D:\\BoulderDash_code\\sprites/ground.png", "D:\\BoulderDash_code\\sprites/pDead.png", "D:\\BoulderDash_code\\sprites/pDown.png", "D:\\BoulderDash_code\\sprites/pLeft.png", "D:\\BoulderDash_code\\sprites/pNope.png", "D:\\BoulderDash_code\\sprites/pRight.png", "D:\\BoulderDash_code\\sprites/pUp.png", "D:\\BoulderDash_code\\sprites/pWin.png", "D:\\BoulderDash_code\\sprites/wall.png"};

    /**
     * Instantiates a new map with the content of the file fileName.
     *
     * @param fileName the file name where the map is
     * @throws IOException Signals that an I/O exception has occurred.
     */
    Map(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
        this.checkFiles();
    }

    /**
     * Loads file.
     *
     * @param fileName the file name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;

        try {
            line = buffer.readLine();
            this.setWidth(Integer.parseInt(line));
            line = buffer.readLine();
            this.setHeight(Integer.parseInt(line));
        } catch (Exception | Error e) {
            isCorrect = false;
        }

        if (isCorrect) {
            this.onTheMap = new IElement[this.getWidth()][this.getHeight()];

            int y = 0;
            line = buffer.readLine();
            while (line != null) {
                if (line.toCharArray().length == this.width) {
                    for (int x = 0; x < line.toCharArray().length; x++) {
                        if (line.toCharArray()[x] == 'R' || line.toCharArray()[x] == 'O' || line.toCharArray()[x] == 'G' || line.toCharArray()[x] == '*') {
                            this.setOnTheMapXY(MobileElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
                        } else {
                            this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
                        }
                    }
                } else {
                    this.isCorrect = false;
                }
                line = buffer.readLine();
                y++;
            }
            buffer.close();

            if (y != this.height) {
                this.isCorrect = false;
            }
        }
    }

    static void checkFiles() {
        File file;
        for (String filename : filenames) {
            file = new File(filename);
            if (!file.exists()){
                JOptionPane.showMessageDialog(null, "File \"" + filename + "\" is missing.\nPlease put the file back in its place and then restart.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                return;
            }
        }
    }
    /*
     * Gets element on the map
     *
     */
    @Override
    public final IElement getOnTheMapXY(final int x, final int y) {
        return this.onTheMap[x][y];
    }

    /**
     * Sets the on the map XY.
     *
     * @param element the element
     * @param x       the x
     * @param y       the y
     */
    public void setOnTheMapXY(IElement element, int x, int y) {
        this.onTheMap[x][y] = element;
        this.hasChanged.add(x);
        this.hasChanged.add(y);

    }

    /*
     * Sets the mobile has changed
     *
     */
    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * Gets the width
     *
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /*
     * Gets the height
     *
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /*
     * Gets the observable
     *
     */
    @Override
    public Observable getObservable() {
        return this;
    }

    public boolean isCorrect() {
        return isCorrect;
    }


    public List<Integer> getHasChanged() {
        return hasChanged;
    }


}
