package part2;

/**
 * Enumeration of cardinal positions : North, South, East, West and Center.
 * 
 * @author Marc Karassev
 * 
 */
public enum Position {
    NORTH(0, "NORTH"), SOUTH(1, "SOUTH"), EAST(2, "EAST"), WEST(3, "WEST"), CENTER(
            4, "CENTER");

    private final int VALUE;
    private final String POSITION;

    /**
     * Constructs a position with the integer value V and string name P.
     * 
     * @param V
     *            the integer value of the new position instance.
     * @param P
     *            the string name of this position.
     */
    private Position(int v, String p) {
        VALUE = v;
        POSITION = p;
    }

    /**
     * Returns the integer value for this position instance.
     * 
     * @return the integer value of the position.
     */
    public int getValue() {
        return VALUE;
    }

    /**
     * Returns the position matching the specified value;
     * 
     * @param value
     *            the integer value to match with a position.
     * @return the position matched with the integer value.
     */
    public static final Position getByValue(int v) {
        switch (v) {
        case 0:
            return NORTH;
        case 1:
            return SOUTH;
        case 2:
            return EAST;
        case 3:
            return WEST;
        case 4:
            return CENTER;
        default:
            throw new IllegalArgumentException("No position with value " + v
                    + "exists.");
        }
    }

    /**
     * Returns the string name of this position.
     */
    public final String toString() {
        return POSITION;
    }
}
