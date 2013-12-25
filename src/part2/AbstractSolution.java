package part2;

import java.awt.*; // for Graphics, Frame
import java.awt.event.WindowAdapter; // to close
import java.awt.event.WindowEvent; // to close

public abstract class AbstractSolution extends Frame {
    // TODO deal with the serializing problems
    // TODO final parameters of functions
    // TODO private fields

    // Fields

    protected static final int WIDTH = 600; // initial frame dimensions
    protected static final int HEIGHT = 600;
    protected int depth; // recursion depth
    protected int initialLength;
    protected SolutionType type;

    // Constructors

    public AbstractSolution() {
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.depth = 0;
        initialLength = 0;
        this.type = SolutionType.FkSolution;
        addWindowListener(new WindowHandler()); // to close
        setTitle("Dessins recursifs au niveau : " + depth);
    }

    public AbstractSolution(int depth, int length, SolutionType type) {
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.depth = depth;
        initialLength = length;
        this.type = type;
        addWindowListener(new WindowHandler()); // to close
        setTitle("Dessins recursifs au niveau : " + depth);
    }

    private class WindowHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    // TODO repaint ? listener on resize
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int frameHeight = getSize().height; // frame dimensions with borders
        int frameWidth = getSize().width;

        // g2d.translate(frameWidth/2,frameHeight/2); //to move the origin if
        // necessary

        // drawSolutionk call
        switch (type) {
        case FkSolution:
            g2d.setColor(Color.magenta);
            drawSolutionk(g2d, 1, getInsets().top + 1, initialLength, depth);
            break;
        case F2kSolution:
            g2d.setColor(Color.black);
            drawSolutionk(g2d, frameWidth / 2 - initialLength / 2, frameHeight
                    / 2 - initialLength / 2, initialLength, depth,
                    Position.CENTER.getValue());
            break;
        default:
            System.err
                    .println("unknown SolutionType\tAbstractSolution.paint()");
        }
    }

    /**
     * Produces a recursive drawing.
     * 
     * @param drawingArea
     *            the graphic object in which we draw
     * @param args
     *            the coordinates, length and others if necessary, and recursion
     *            depth
     */
    public abstract void drawSolutionk(Graphics drawingArea, int... args);

    /**
     * Returns a string representation of this solution and its values.
     */
    public String toString() {
        return type + " " + depth + " " + initialLength + " "
                + super.toString();
    }
}
