package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import contract.IOrderPerformer;
import contract.IBoulderDashController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;
import entity.IElement;
import entity.Permeability;
import entity.mobile.MobileElementsFactory;
import entity.motionless.MotionlessElementsFactory;

/**
 * this class manage the controller's use.it manages the model and the view , it implements the IBoulderDashController and IOrderPerformer 
 * @author GROUP 09
 *  
 */

public final class Controller implements IBoulderDashController, IOrderPerformer {

    /**
     * The speed
     */
    private static final int speed = 200;

    /**
     * The view
     */
    private IView view;

    /**
     * The model
     */
    private IModel model;

    /**
     * stakckOrder
     */
    private UserOrder stackOrder;

    /**
     * The diamonds counter
     */
    private final int diamondGoal = 12;

    /**
     * The diamonds counter
     */
    private boolean hasWon = false;

    /**
     * The random
     */
    private final Random rand = new Random();

    /**
     * The diretion for Red Monsters
     */
    private int rdirection;

    /**
     * The diretion for Green Monsters
     */
    private int gDirection;

    private boolean canChange = true;


    /**
     * the Controller's Contrustor
     * to instantiate the controller's class . it sets the view and the model retrieved in parameter 
     * 
     * @param view
     * @param model
     */
    public Controller(final IView view, final IModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
    }

    /**
     * Play method
     * it manages the different methods when the player is still alive . the Game speed , the player method, the update on map and the update view 
     */
    @Override
    public final void run() {
        while (this.getModel().getMyPlayer().isAlive() == true && hasWon == false) {

            // --- Game Speed ---
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // --- Player ---
            this.movePlayer();
            this.killPlayer();
            this.winPlayer();

            gDirection = gDirection + 1;
            rdirection = rand.nextInt(4);

            // --- Update Mobile Entities on Map
            for (int y = this.getModel().getMap().getHeight() - 1; y > 0; y--) {
                for (int x = this.getModel().getMap().getWidth() - 1; x > 0; x--) {

                    for (int g = 0; g < this.getModel().getMap().getHasChanged().size(); g = g + 2) {
                        if (this.getModel().getMap().getHasChanged().get(g) == x || this.getModel().getMap().getHasChanged().get(g + 1) == y) {
                            this.canChange = false;
                        }
                    }

                    if (canChange) {
                        // --- Boulders ---
                        this.gravityBoulder(x, y);

                        // --- Diamonds ---
                        this.gravityDiamond(x, y);

                        // --- Monsters ---
                        this.killMonster(x, y);
                        this.moveGMonster(x, y);
                    }
                    this.canChange = true;
                }
            }

            // --- Update View ---
            this.getModel().getMap().getHasChanged().clear();
            this.canChange = true;
            this.getView().followMyPlayer();
            this.getView().updateView();
            this.getView().getBoardFrame().setTitle("BoulderDash - Diamond Counter: " + this.getModel().getMyPlayer().getDiamonds());
        }
    }


    /**
     * movePlayer method
     * execute the move player according to the getStackOrder
     * @see Controller#getStackOrder()
     */
    public void movePlayer() {
        switch (this.getStackOrder()) {
            case UP:
                this.getModel().getMyPlayer().moveUp();

                break;
            case DOWN:
                this.getModel().getMyPlayer().moveDown();

                break;
            case RIGHT:
                this.getModel().getMyPlayer().moveRight();

                break;
            case LEFT:
                this.getModel().getMyPlayer().moveLeft();

                break;
            case NOP:
            default:
                this.getModel().getMyPlayer().doNothing();
                break;
        }
        this.clearStackOrder();
    }

    /**
     * killPlayer method
     * check if the condition of the players position and permeability is  the  one correct to kill the player and  then display a message according to the condition
     */
    public void killPlayer() {
        if ((this.getModel().getMap().getOnTheMapXY((this.getModel().getMyPlayer().getX()), ((this.getModel().getMyPlayer().getY()))).getPermeability() == Permeability.KILLABLE)) {
            this.getModel().getMyPlayer().die();
            this.getView().displayMessage("Game Over! Do you want to retry?");
        }
    }
    /**
     * winPlayer method
     * check if the condition of the players position and permeability is  the  one correct and  then display a message according to the condition
     */
    public void winPlayer() {
        if ((this.getModel().getMap().getOnTheMapXY((this.getModel().getMyPlayer().getX()), ((this.getModel().getMyPlayer().getY()))).getPermeability() == Permeability.EXIT) && this.getModel().getMyPlayer().getDiamonds() >= diamondGoal) {
            this.hasWon = true;
            this.getModel().getMyPlayer().win();
            this.getView().displayMessage("You won, Congratulations! Do you to replay?");
        }
    }


    /**
     * Boulders Gravity
     * this method manage the condition for the boulders gravity 
     * 
     * @param x
     * @param y
     * 
     */
    public void gravityBoulder(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.BOULDER && this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.WALKABLE) {
            if (x != this.getModel().getMyPlayer().getX() || y + 1 != this.getModel().getMyPlayer().getY()) {
                this.getModel().getMap().setOnTheMapXY((IElement) MotionlessElementsFactory.createBackground(), x, y);
                this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createRock(), x, y + 1);
            }
        }
    }

    /**
     * Diamonds Gravity
     * this method manage the condition for the boulders gravity 
     * @param x
     * @param y
     */
    public void gravityDiamond(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.DIAMOND && this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.WALKABLE) {
            if (x != this.getModel().getMyPlayer().getX() || y + 1 != this.getModel().getMyPlayer().getY()) {
                this.getModel().getMap().setOnTheMapXY((IElement) MotionlessElementsFactory.createBackground(), x, y);
                this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), x, y + 1);
            } else if (x == this.getModel().getMyPlayer().getX() && y + 1 == this.getModel().getMyPlayer().getY()) {
                this.getModel().getMap().setOnTheMapXY((IElement) MotionlessElementsFactory.createBackground(), x, y);
                this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), x, y + 1);
            }
        }
    }

    /**
     * killMonster method.
     * check if the condition of the element on maps permeability is  the  one correct to kill the monster and  then create a diamond 
     */
    public void killMonster(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLABLE && this.getModel().getMap().getOnTheMapXY(x, y - 1).getPermeability() == Permeability.BOULDER || this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLABLE && this.getModel().getMap().getOnTheMapXY(x, y - 1)
                .getPermeability() == Permeability.DIAMOND) {
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), x, y);

            for (int i = x - 1; i < x + 2; i++) {
                for (int j = y - 1; j < y + 2; j++) {
                    if (getModel().getMap().getOnTheMapXY(i, j).getPermeability() == Permeability.WALKABLE) {
                        this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), i, j);
                    }
                }
            }
        }
    }

    /**
     * Green Monsters Move method
     * to manage the Green Monsters moves 
     * 
     * @param x
     * @param y
     */
    public void moveGMonster(int x, int y) {
        if (gDirection <= 10) {
            MGMoveRight(x, y);
        } else if (gDirection <= 20) {
            MGMoveLeft(x, y);
        } else {
            gDirection = 0;
        }

    }

    /**
     * Green Monsters MoveRigth method
     * to manage the Green Monsters moves Rigth according to the consoleImage and element on maps permeability 
     * 
     * @param x
     * @param y
  
     */
    public void MGMoveRight(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'G' && this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.WALKABLE) {
            this.getModel().getMap().setOnTheMapXY((IElement) MotionlessElementsFactory.createBackground(), x, y);
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterG(), x + 1, y);
        }
    }

    /**
     * Green Monsters MoveLeft method
     * to manage the Green Monsters moves Left according to the consoleImage and element on maps permeability 
     * 
     * @param x
     * @param y
  
     */
    public void MGMoveLeft(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'G' && this.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.WALKABLE) {
            this.getModel().getMap().setOnTheMapXY((IElement) MotionlessElementsFactory.createBackground(), x, y);
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterG(), x - 1, y);
        }
    }

    /**
     * recovers the view for the controllers operation
     * @return this.view
     */
    private IView getView() {
        return this.view;
    }

    /**
     * set a new view for the controllers use
     * @param view
     */
    private void setView(final IView view) {
        this.view = view;
    }

    /**
     * recovers the model for the controllers use
     * @return this.model
     */
    IModel getModel() {
        return this.model;
    }

    /**
     * set a new model for the controllers use
     * @param model
     */
    private void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * gets a stack order for moves
     * @return this.stackOrder
     */
    UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * sets a new userorder for the moves
     * @param stackOrder
     */
    void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * clearStackOrder method
     *used to clear the stack order when we dont have a userorder
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    /**
     * getOrderPerformer method
     * recovers a order performer
     * @return this
     */
    @Override
    public IOrderPerformer getOrderPerformer() {
        return this;
    }

    /**
     * orderPerform method
     * sets a new userorder
     */
    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

}
