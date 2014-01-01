package part2;

import java.awt.Graphics2D;

/**
 * Window which draws a recursive drawing of circles. The first circle is drawn
 * at the top left corner and at each recursion, two half previous diameter
 * circles are drawn east and south of each circle drawn at the previous
 * recursion.
 * 
 * @author Marc Karassev
 * 
 */
public class F4kSolution extends AbstractSolution {

    // Constructors

    /**
     * Constructs a new instance of F4kSolution with a recursion depth of 5 and
     * an initial diameter of 50px.
     */
    public F4kSolution() {
        this(5, 50);
    }

    /**
     * Constructs a new instance of F4kSolution with the specified recursion
     * depth and an initial diameter of 50px.
     * 
     * @param depth
     *            the recursion depth of the recursive drawing
     */
    public F4kSolution(int depth) {
        this(depth, 50);
    }

    /**
     * Constructs a new instance of F4kSolution with the specified recursion
     * depth and initial diameter.
     * 
     * @param depth
     *            the recursion depth of the recursive drawing
     * @param diameter
     *            the diameter of the first circle
     */
    public F4kSolution(int depth, int diameter) {
        super(depth, diameter, SolutionType.F4kSolution);
    }

    // Methods

    /**
     * Produces a recursive drawing.
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
     * @param args
     *            [4] number of lines to draw multiplier
     */
    @Override
    public void drawSolutionk(Graphics2D drawingArea, int... args) {
        if (args.length != 5)
            throw new IllegalArgumentException(
                    "number of parameters different of 5");
        if (args[3] != 0) {
            drawingArea.drawOval(args[0], args[1], args[2], args[2]);
            for (int i = 0; i < 4 * args[4]; i++) {
                drawingArea.drawLine(-args[2] / 2, 0, -5 * args[2] / 2, 0);
                drawingArea.rotate(Math.PI / 2 / args[4]);
            }
            drawSolutionk(drawingArea, args[0] - initialLength / 10, args[1]
                    - initialLength / 10, args[2] + initialLength / 5,
                    args[3] - 1, args[4] * 2);
        }
    }
}
