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
        this(5, 150);
    }

    /**
     * Constructs a new instance of F2kSolution with the specified recursion
     * depth and an initial diameter of 200px.
     * 
     * @param depth
     *            the recursion depth of the recursive drawing.
     */
    public F2kSolution(int depth) {
        this(depth, 150);
    }

    /**
     * Constructs a new instance of F2kSolution with the specified recursion
     * depth and initial diameter.
     * 
     * @param depth
     *            the recursion depth of the recursive drawing.
     * @param diameter
     *            the diameter of the first circle.
     */
    public F2kSolution(int depth, int diameter) {
        super(depth, diameter, SolutionType.F2kSolution);
    }

    // Methods

    /**
     * Produces a recursive drawing of circles.
     * 
     * @param drawingArea
     *            the graphic object to draw into.
     * @param args
     *            [0] the x coordinate of the upper left corner of the circle to
     *            draw.
     * @param args
     *            [1] the y coordinate of the upper left corner of the circle to
     *            draw.
     * @param args
     *            [2] the width of the circle to draw.
     * @param args
     *            [3] the recursions remaining to do.
     * @param args
     *            [4] integer corresponding to a cardinal position (North,
     *            South, East, West or Center) of the circle to draw in relation
     *            to the circle drawn by the previous call of this function.
     */
    @Override
    public void drawSolutionk(Graphics drawingArea, int... args) {
        // TODO illegalArgs
        if (args[3] != 0) {
            drawingArea.drawOval(args[0], args[1], args[2], args[2]);
            switch (Position.getByValue(args[4])) {
            case CENTER:
                drawFromCenter(drawingArea, args[0], args[1], args[2]);
                break;
            case NORTH:
                drawFromNorth(drawingArea, args[0], args[1], args[2], args[3]);
                break;

            case SOUTH:
                drawFromSouth(drawingArea, args[0], args[1], args[2], args[3]);
                break;
            case EAST:
                drawFromEast(drawingArea, args[0], args[1], args[2], args[3]);
                break;
            case WEST:
                drawFromWest(drawingArea, args[0], args[1], args[2], args[3]);
                break;

            default:
                ;
            }
        }
    }

    /**
     * Draws the circles of the first recursion.
     * 
     * @param drawingArea
     *            the graphic object to draw into.
     * @param x
     *            the x coordinate of the upper left corner of the first circle.
     * @param y
     *            the y coordinate of the upper left corner of the first circle.
     * @param length
     *            the width of the first circle.
     */
    private void drawFromCenter(Graphics drawingArea, int x, int y, int length) {
        drawSolutionk(drawingArea, x + length / 4, y - length / 2, length / 2,
                depth - 1, Position.NORTH.getValue());
        drawSolutionk(drawingArea, x + length / 4, y + length, length / 2,
                depth - 1, Position.SOUTH.getValue());
        drawSolutionk(drawingArea, x + length, y + length / 4, length / 2,
                depth - 1, Position.EAST.getValue());
        drawSolutionk(drawingArea, x - length / 2, y + length / 4, length / 2,
                depth - 1, Position.WEST.getValue());
    }

    /**
     * Recursive calls of drawSolutionk for a circle drawn North in relation to
     * the circle drawn by the previous recursion.
     * 
     * @param drawingArea
     *            the graphic object to draw into.
     * @param x
     *            the x coordinate of the upper left corner of the first circle.
     * @param y
     *            the y coordinate of the upper left corner of the first circle.
     * @param length
     *            the width of the first circle.
     * @param depth
     *            the recursions remaining to do.
     */
    private void drawFromNorth(Graphics drawingArea, int x, int y, int length,
            int depth) {
        drawSolutionk(drawingArea, x + length / 4, y - length / 2, length / 2,
                depth - 1, Position.NORTH.getValue());
        drawSolutionk(drawingArea, x + length, y + length / 4, length / 2,
                depth - 1, Position.EAST.getValue());
        drawSolutionk(drawingArea, x - length / 2, y + length / 4, length / 2,
                depth - 1, Position.WEST.getValue());
    }

    /**
     * Recursive calls of drawSolutionk for a circle drawn South in relation to
     * the circle drawn by the previous recursion.
     * 
     * @param drawingArea
     *            the graphic object to draw into.
     * @param x
     *            the x coordinate of the upper left corner of the first circle.
     * @param y
     *            the y coordinate of the upper left corner of the first circle.
     * @param length
     *            the width of the first circle.
     * @param depth
     *            the recursions remaining to do.
     */
    private void drawFromSouth(Graphics drawingArea, int x, int y, int length,
            int depth) {
        drawSolutionk(drawingArea, x + length / 4, y + length, length / 2,
                depth - 1, Position.SOUTH.getValue());
        drawSolutionk(drawingArea, x + length, y + length / 4, length / 2,
                depth - 1, Position.EAST.getValue());
        drawSolutionk(drawingArea, x - length / 2, y + length / 4, length / 2,
                depth - 1, Position.WEST.getValue());
    }


    /**
     * Recursive calls of drawSolutionk for a circle drawn East in relation to
     * the circle drawn by the previous recursion.
     * 
     * @param drawingArea
     *            the graphic object to draw into.
     * @param x
     *            the x coordinate of the upper left corner of the first circle.
     * @param y
     *            the y coordinate of the upper left corner of the first circle.
     * @param length
     *            the width of the first circle.
     * @param depth
     *            the recursions remaining to do.
     */
    private void drawFromEast(Graphics drawingArea, int x, int y, int length,
            int depth) {
        drawSolutionk(drawingArea, x + length / 4, y - length / 2, length / 2,
                depth - 1, Position.NORTH.getValue());
        drawSolutionk(drawingArea, x + length / 4, y + length, length / 2,
                depth - 1, Position.SOUTH.getValue());
        drawSolutionk(drawingArea, x + length, y + length / 4, length / 2,
                depth - 1, Position.EAST.getValue());
    }

    /**
     * Recursive calls of drawSolutionk for a circle drawn West in relation to
     * the circle drawn by the previous recursion.
     * 
     * @param drawingArea
     *            the graphic object to draw into.
     * @param x
     *            the x coordinate of the upper left corner of the first circle.
     * @param y
     *            the y coordinate of the upper left corner of the first circle.
     * @param length
     *            the width of the first circle.
     * @param depth
     *            the recursions remaining to do.
     */
    private void drawFromWest(Graphics drawingArea, int x, int y, int length,
            int depth) {
        drawSolutionk(drawingArea, x + length / 4, y - length / 2, length / 2,
                depth - 1, Position.NORTH.getValue());
        drawSolutionk(drawingArea, x + length / 4, y + length, length / 2,
                depth - 1, Position.SOUTH.getValue());
        drawSolutionk(drawingArea, x - length / 2, y + length / 4, length / 2,
                depth - 1, Position.WEST.getValue());
    }
}
