package part2;

import java.awt.*; // for Graphics, Frame
import java.awt.event.WindowAdapter; // to close
import java.awt.event.WindowEvent; // to close

public abstract class AbstractSolution extends Frame {
    protected static final int WIDTH = 800; // initial frame dimensions
    protected static final int HEIGHT = 1200;
    protected int depth; // recursion depth

    public AbstractSolution(int depth) {
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.depth = depth;
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

        // call here drawSolutionk with an adequate list of arguments, for
        // instance :
        // drawSolutionk(g2d, frameWidth/20, frameHeight/20,
        // frameWidth/4, depth);
    }

    /**
     * drawSolutionk: Produce a recursive drawing Parameters: Graphics
     * drawingArea: The graphic object in which we draw int ... arg : the
     * coordinates, length and others if necessary, and recursion depth
     **/
    // public abstract void drawSolutionk(Graphics drawingArea, int ... arg) ;

}
