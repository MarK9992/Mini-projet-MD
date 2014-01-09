package part1;

import java.util.Scanner;

public class Main {
	
	public Main(){
		int nbOfDisk;
		do {
			nbOfDisk=getValidUserNbDisk();
			new HanoiGame(nbOfDisk,getVersion());
		} while (nbOfDisk != 0);
	}
	
	
	
	private int getValidUserNbDisk() {
		System.out.println("How many disk do you want ? (0 to quit)");
		int number = getUserInteger();
		while (number < 0) {
			System.out.println("How many disk do you want ? (0 to quit)");
			number = getUserInteger();
		}
		return number;

	}
	
	
	private int getVersion() {
		System.out.println("Which version do you want to use?\n	1-Recursive optimal\n	2-Iterative optimal\n	3-Recursive circular");
		return getUserInteger();
	}
	
	private int getUserInteger() {
		Scanner sc = new Scanner(System.in);
		int number;
		try {
			number = sc.nextInt();
		} catch (Exception e) {
			number = -1;
		}
		return number;
	}
	
	public static void main(String[] args){
		new Main();
		
	}

}
