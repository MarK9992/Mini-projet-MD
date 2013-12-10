package part2;

import java.awt.Graphics;

public class FkSolution extends AbstractSolution {

    public FkSolution(int depth, int diameter) {
        super(depth, diameter);
    }

    @Override
    public void drawSolutionk(Graphics drawingArea, int... args) {
        drawingArea.drawOval(args[0], args[1], args[2], args[2]);
        if (args[3] != 0) {
            drawSolutionk(drawingArea, args[0] + args[2], args[1] + args[2]/4,
                    args[2] / 2, args[3] - 1);
            drawSolutionk(drawingArea, args[0] + args[2]/4, args[1] + args[2],
                    args[2] / 2, args[3] - 1);
        }
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        FkSolution fks = new FkSolution(5, 200);
    }

}
