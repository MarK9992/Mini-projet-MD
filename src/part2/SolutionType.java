package part2;

/**
 * Enumeration of SolutionTypes : FkSolution, F2kSolution
 * 
 * @author Marc Karassev
 * 
 */
public enum SolutionType {
    FkSolution("Fk"), F2kSolution("F2k");

    private String name;

    /**
     * Constructs a new SolutionType with the specified name.
     * 
     * @param n
     *            the name of the SolutionType.
     */
    private SolutionType(String n) {
        name = n;
    }

    /**
     * Returns the name of the SolutionType.
     */
    public String toString() {
        return name;
    }
}
