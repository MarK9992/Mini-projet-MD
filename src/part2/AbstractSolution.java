package part2;

import java.awt.*; // for Graphics, Frame
import java.awt.event.WindowAdapter; // to close
import java.awt.event.WindowEvent; // to close

public abstract class AbstractSolution extends Frame {
    // TODO deal with the serializing problems
    // TODO final parameters of functions
    // TODO private fields
    // TODO java documentation comments

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
        int frameHeight = getSize().height;
        int frameWidth = getSize().width;
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.clearRect(0, 0, frameWidth, frameHeight);
        switch (type) {
        case FkSolution:
            drawSolution1(g2d);
            break;
        case F2kSolution:
            drawSolution2(g2d, frameWidth, frameHeight);
            break;
        case F3kSolution:
            drawSolution3(g2d, frameWidth, frameHeight);
            break;
        case F4kSolution:
            drawSolution4(g2d, frameWidth, frameHeight);
            break;
        default:
            System.err
                    .println("unknown SolutionType\tpart2.AbstractSolution.paint()");
        }
    }

    /**
     * drawSolutionk call for FkSolution instances.
     * 
     * @param g2d
     *            the graphic object to draw into
     */
    private void drawSolution1(Graphics2D g2d) {
        if (type == SolutionType.FkSolution) {
            g2d.setColor(Color.magenta);
            drawSolutionk(g2d, 1, getInsets().top + 1, initialLength, depth);
        } else
            System.err
                    .println("Invalid use of part2.AbstractSolution.drawSolution1(), SolutionType different of FkSolution.");
    }

    /**
     * drawSolutionk call for F2kSolution instances.
     * 
     * @param g2d
     *            the graphic object to draw into
     * @param frameWidth
     *            the width of the frame
     * @param frameHeight
     *            the height of the frame
     */
    private void drawSolution2(Graphics2D g2d, int frameWidth, int frameHeight) {
        if (type == SolutionType.F2kSolution) {
            g2d.setColor(Color.green);
            drawSolutionk(g2d, frameWidth / 2 - initialLength / 2, frameHeight
                    / 2 - initialLength / 2, initialLength, depth,
                    Position.CENTER.getValue());
        } else
            System.err
                    .println("Invalid use of part2.AbstractSolution.drawSolution2(), SolutionType different of F2kSolution.");
    }

    /**
     * drawSolutionk call for F3kSolution instances.
     * 
     * @param g2d
     *            the graphic object to draw into
     * @param frameWidth
     *            the width of the frame
     * @param frameHeight
     *            the height of the frame
     */
    private void drawSolution3(Graphics2D g2d, int frameWidth, int frameHeight) {
        if (type == SolutionType.F3kSolution) {
            g2d.setColor(Color.black);
            drawSolutionk(g2d, frameWidth / 2 - initialLength / 2, frameHeight
                    / 2 - initialLength / 2, initialLength, depth,
                    Position.CENTER.getValue());
        } else
            System.err
                    .println("Invalid use of part2.AbstractSolution.drawSolution3(), SolutionType different of F3kSolution.");
    }

    /**
     * drawSolutionk call for F4kSolution instances.
     * 
     * @param g2d
     *            the graphic object to draw into
     * @param frameWidth
     *            the width of the frame
     * @param frameHeight
     *            the height of the frame
     */
    private void drawSolution4(Graphics2D g2d, int frameWidth, int frameHeight) {
        if (type == SolutionType.F4kSolution) {
            g2d.setColor(Color.black);
            g2d.fillRect(0, 0, frameWidth, frameHeight);
            g2d.setColor(Color.white);
            g2d.translate(frameWidth / 2, frameHeight / 2);
            drawSolutionk(g2d, -initialLength / 2, -initialLength / 2,
                    initialLength, depth, 1);
        } else
            System.err
                    .println("Invalid use of part2.AbstractSolution.drawSolution4(), SolutionType different of F4kSolution.");
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
    public abstract void drawSolutionk(Graphics2D drawingArea, int... args);

    /**
     * Returns a string representation of this solution and its values.
     */
    public String toString() {
        return type + " " + depth + " " + initialLength + " "
                + super.toString();
    }
}
