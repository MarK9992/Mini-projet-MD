package part2;

import java.awt.*; // for Graphics, Frame
import java.awt.event.WindowAdapter; // to close
import java.awt.event.WindowEvent; // to close

public abstract class AbstractSolution extends Frame {
    protected static final int WIDTH = 600; // initial frame dimensions
    protected static final int HEIGHT = 600;
    protected int depth; // recursion depth
    protected int initialLength;

    public AbstractSolution(int depth, int length) {
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.depth = depth;
        initialLength = length;
        addWindowListener(new WindowHandler()); // to close
        setTitle("Dessins recursifs au niveau : " + depth);
    }

    private class WindowHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int frameHeight = getSize().height; // frame dimensions with borders
        int frameWidth = getSize().width;
        g2d.setColor(Color.black); // the color we are going to draw with

        // g2d.translate(frameWidth/2,frameHeight/2); //to move the origin if
        // necessary

        // drawSolutionk call
        drawSolutionk(g2d, 1, getInsets().top + 1, initialLength,
                depth);
    }

    /**
     * drawSolutionk: Produces a recursive drawing Parameters: Graphics
     * drawingArea: The graphic object in which we draw int ... arg : the
     * coordinates, length and others if necessary, and recursion depth
     */
    public abstract void drawSolutionk(Graphics drawingArea, int... arg);
}
