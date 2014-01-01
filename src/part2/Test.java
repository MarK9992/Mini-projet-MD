package part2;

import java.util.Scanner;

/**
 * Part 2 test class, allows to test each solution at recursion depths of
 * maximum 30. Recursion depth is limited in order to prevent stack overflows.
 * Usually a recursion of more than 10 is useless, it's allowed to 15 to show
 * that the program can make the computation.
 * 
 * @author Marc Karassev
 * 
 */
public class Test {

    /**
     * Test potential static problems, try to run different instances and see if
     * you can modify them all with on input.
     */
    private static AbstractSolution s;
    private static Scanner sc = new Scanner(System.in);
    private static int solution, depth;
    private static final int MAXDEPTH = 15, MINDEPTH = 0, MAXSOLUTION = 4,
            MINSOLUTION = 1;

    /**
     * Asks the user to choose a solution.
     */
    public static void selectSolution() {
        do {
            System.out.println("Please choose the solution type:");
            for(int i = MINSOLUTION; i <= MAXSOLUTION; i++) {
                System.out.println("F" + i + "kSolution -> " + i);
            }
            solution = sc.nextInt();
        } while (solution > MAXSOLUTION || solution < MINSOLUTION);
    }

    /**
     * Asks the user to choose a depth.
     */
    public static void selectDepth() {
        do {
            System.out.printf("Please choose the recursion depth (max "
                    + MAXDEPTH + "): ");
            depth = sc.nextInt();
        } while (depth < MINDEPTH || depth > MAXDEPTH);
    }

    /**
     * Creates the solution.
     */
    public static void createSolution() {
        try {
            switch (solution) {
            case 1:
                s = new FkSolution(depth);
                break;
            case 2:
                s = new F2kSolution(depth);
                break;
            case 3:
                s = new F3kSolution(depth);
                break;
            case 4:
                s = new F4kSolution(depth);
            }
        } catch (NullPointerException e) {
            System.err
                    .println("Invalid use of Test.createSolution, solution or depth or both is/are unselected.");
            e.printStackTrace();
        }
    }

    /**
     * Main program.
     * 
     * @param args
     */
    public static void main(String[] args) {
        selectSolution();
        selectDepth();
        createSolution();
    }

}
