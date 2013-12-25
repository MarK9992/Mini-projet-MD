package part2;

import java.awt.Graphics;

/**
 * Window which draws a recursive drawing of circles. The first circle is drawn
 * at the top left corner and at each recursion, two half previous diameter
 * circles are drawn east and south of each circle drawn at the previous
 * recursion.
 * 
 * @author Marc Karassev
 * 
 */
public class FkSolution extends AbstractSolution {

    // Constructors

    /**
     * Constructs a new instance of FkSolution with a recursion depth of 5 and
     * an initial diameter of 200px.
     */
    public FkSolution() {
        this(5, 200);
    }

    /**
     * Constructs a new instance of FkSolution with the specified recursion
     * depth and an initial diameter of 200px.
     * 
     * @param depth
     *            the recursion depth of the recursive drawing
     */
    public FkSolution(int depth) {
        this(depth, 200);
    }

    /**
     * Constructs a new instance of FkSolution with the specified recursion
     * depth and initial diameter.
     * 
     * @param depth
     *            the recursion depth of the recursive drawing
     * @param diameter
     *            the diameter of the first circle
     */
    public FkSolution(int depth, int diameter) {
        super(depth, diameter, SolutionType.FkSolution);
    }

    // Methods

    /**
     * Produces a recursive drawing of circles.
     * 
     * @param drawingArea
     *            the graphic object to draw into
     * @param args
     *            [0] the x coordinate of the upper left corner of the circle to
     *            draw
     * @param args
     *            [1] the y coordinate of the upper left corner of the circle to
     *            draw
     * @param args
     *            [2] the width of the circle to draw
     * @param args
     *            [3] the recursions remaining to do.
     */
    @Override
    public void drawSolutionk(Graphics drawingArea, int... args) {
        if (args.length != 4)
            throw new IllegalArgumentException(
                    "number of parameters different of 4");
        if (args[3] != 0) {
            drawingArea.fillOval(args[0], args[1], args[2], args[2]);
            drawSolutionk(drawingArea, args[0] + args[2],
                    args[1] + args[2] / 4, args[2] / 2, args[3] - 1);
            drawSolutionk(drawingArea, args[0] + args[2] / 4,
                    args[1] + args[2], args[2] / 2, args[3] - 1);
        }
    }
}
