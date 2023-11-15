package entity.mobile;
/**
 *
 * MobileElementsFactory Class
 * @author GROUP 09
 *
 */

public class MobileElementsFactory {
    /**
     * The Green Monster
     */
    private final static MonsterG monsterG = new MonsterG();
    /**
     * The diamond
     */
    private final static Diamond diamond = new Diamond();
    /**
     * The rock
     */
    private final static Boulder boulder = new Boulder();

    /**
     * The list of mobile elements
     */
    private static Mobile[] mobileElements = { monsterG, diamond, boulder};

    /**
     * Gets char from file
     * @param fileSymbol
     * @return
     */
    public static Mobile getFromFileSymbol(final char fileSymbol) {
        for (final Mobile mobileElement : mobileElements) {
            if (mobileElement.getSprite().getConsoleImage() == fileSymbol) {
                return mobileElement;
            }
        }
        return boulder;
    }

    /**
     * creates Green Monster
     * @return Green Monster
     */
    public static Mobile createMonsterG() {
        return monsterG;
    }

    /**
     * creates diamond
     * @return
     */
    public static Mobile createDiamond() {
        return diamond;
    }

    /**
     * creates rock
     * @return
     */
    public static Mobile createRock() {
        return boulder;
    }

}
