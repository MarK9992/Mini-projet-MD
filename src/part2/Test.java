package part2;

import java.util.Scanner;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AbstractSolution s;
        Scanner sc = new Scanner(System.in);
        int choice;
        
        System.out.printf("Please choose the recursion depth: ");
        choice = sc.nextInt();
        s = new FkSolution(choice);
    }

}
