package part2;

import java.awt.Graphics;

/**
 * Window which draws a recursive drawing of circles. The first circle is drawn
 * at the center of the window and at each recursion, half previous diameter
 * circles are drawn north, south, east or west of each circle drawn at the
 * previous recursion in order to draw circles at all the four cardinal points
 * of each previous circle.
 * 
 * @author Marc Karassev
 * 
 */
public class F2kSolution extends AbstractSolution {

    // Constructors

    /**
     * Constructs a new instance of F2kSolution with a recursion depth of 5 and
     * an initial diameter of 200px.
     */
    public F2kSolution() {
        this(5, 200);
    }

    /**
     * Constructs a new instance of F2kSolution with the specified recursion
     * depth and an initial diameter of 200px.
     * 
     * @param depth
     *            the recursion depth of the recursive drawing
     */
    public F2kSolution(int depth) {
        this(depth, 200);
    }

    /**
     * Constructs a new instance of F2kSolution with the specified recursion
     * depth and initial diameter.
     * 
     * @param depth
     *            the recursion depth of the recursive drawing
     * @param diameter
     *            the diameter of the first circle
     */
    public F2kSolution(int depth, int diameter) {
        super(depth, diameter, SolutionType.F2kSolution);
    }
    
    // Methods

    @Override
    public void drawSolutionk(Graphics drawingArea, int... arg) {
        // TODO Auto-generated method stub
    }

}
