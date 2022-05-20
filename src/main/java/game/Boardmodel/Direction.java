package game.Boardmodel;

/**
 * The movement direction.
 */
public interface Direction {

    /**
     * The row change
     * @return int
     */
    int getRowChange();

    /**
     * The collum change
     * @return int
     */
    int getColChange();

}
