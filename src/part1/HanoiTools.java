package part1;

/**
 * This Class contains several tools that can be used with HanoiGame.
 * 
 * @author Tom Veniat
 *
 */
public abstract class HanoiTools {

	/**
	 * Recursive function that repeat times(the argument) times the String s .
	 * @param s
	 * @param times
	 * @return
	 */
	public static String repeat(String s, int times) {
		StringBuilder stringBuilder = new StringBuilder(s.length() * times);
		if (times != 0)
			repeat(stringBuilder, s, times);
		return stringBuilder.toString();
	}

	private static void repeat(StringBuilder stringBuilder, String s, int times) {
		if (times == 1)
			stringBuilder.append(s);
		else if (times % 2 == 0)
			repeat(stringBuilder, s + s, times / 2);
		else if (times % 2 == 1)
			repeat(stringBuilder.append(s), s + s, times / 2);
	}

	/**
	 * Method that move a Disk From the Pile origin to the Pile destination if it's possible.
	 * It also increment the number of movements of the Disk and of the HanoiGame
	 * @param game
	 * @param origin
	 * @param destination
	 */
	public static void moveDisk(HanoiGame game, int origin, int destination) {
		try {
			Disk temp = game.getCurrentSituation().get(origin).pop();
			temp.incNbMoves();
			game.getCurrentSituation().get(destination).push(temp);
			game.incMoves();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * method which makes the only possible move between pileA and pileB, and does nothing if both Pile are empty
	 * @param game
	 * @param pileA
	 * @param pileB
	 */
	public static void makeAMove(HanoiGame game, int pileA, int pileB) {
		int sizeTopPileA = game.getCurrentSituation().get(pileA).seeLast()
				.getSize();
		int sizeTopPileB = game.getCurrentSituation().get(pileB).seeLast()
				.getSize();
		if (sizeTopPileA != 0
				&& (sizeTopPileB == 0 || sizeTopPileA < sizeTopPileB)) {
			moveDisk(game, pileA, pileB);
			System.out.println("on bouge de " + pileA + " vers " + pileB);
		} else if (sizeTopPileB != 0) {
			moveDisk(game, pileB, pileA);
			System.out.println("on bouge de " + pileB + " vers " + pileA);
		}
	}

	/**
	 * method which print the current state of the HanoiGame game.
	 * 
	 * @param game
	 */
	public static void printGame(HanoiGame game) {
		for (int i = game.getNumberOfDisk(); i > 0; i--) {
			System.out.println(getGameLine(game, i - 1));
		}
		if (game.getNumberOfDisk() > 0)
			System.out.println(HanoiTools.repeat("#",
					((game.getNumberOfDisk() * 2) - 1) * 3 + 2));
	}

	public static void printEndGame(HanoiGame game) {
		for (int i = game.getCurrentSituation().get(2).getSize(); i > 0; i--) {
			Disk currentDisk=game.getCurrentSituation().get(2).see(i - 1);
			System.out.println(currentDisk
					+ " : "
					+ currentDisk.getNbMoves()
					+ " Moves.");
		}
	}

	/**
	 * Prints the line n°i of the HanoiGame game.
	 * @param game
	 * @param i
	 * @return
	 */
	private static String getGameLine(HanoiGame game, int i) {
		Disk currentDisk;
		StringBuilder stringBuilder = new StringBuilder();
		for (int j = 0; j < game.getCurrentSituation().size(); j++) {
			currentDisk = game.getCurrentSituation().get(j).see(i);
			stringBuilder.append(HanoiTools.repeat(" ", game.getNumberOfDisk()
					- (currentDisk == null ? 1 : currentDisk.getSize())));
			stringBuilder.append(currentDisk == null ? "|" : currentDisk
					.toString());
			stringBuilder.append(HanoiTools.repeat(" ", game.getNumberOfDisk()
					- (currentDisk == null ? 1 : currentDisk.getSize())));
			stringBuilder.append(" ");
		}
		return stringBuilder.toString();
	}

	/**
	 * Optimal solution of an HanoiGame.
	 * Use an auxiliary recursive function.
	 * 
	 * @param game
	 */
	public static void solveHanoiRecOpt(HanoiGame game) {
		HanoiTools.solveHanoiRecAux(game, game.getNumberOfDisk(), 0, 1, 2);
		System.out.println(minNbMoves(game.getNumberOfDisk()));
	}
	
	/**
	 * Optimal solution of an HanoiGame if we add the Circular rule.
	 * Use two auxiliary recursive function.
	 * 
	 * @param game
	 */
	public static void solveHanoiRecCir(HanoiGame game) {
		HanoiTools.solveHanoiRecAuxCir(game, game.getNumberOfDisk(), 0, 1, 2);
		System.out.println(minNbMovesCir(game.getNumberOfDisk()));
	}

	

	/**
	 * Solve the HanoiTower game with recursive calls,
	 * It is the optimal Solution.
	 * 
	 * @param g
	 * @param numberOfDisk
	 * @param i
	 * @param j
	 * @param k
	 */
	public static void solveHanoiRecAux(HanoiGame g, int numberOfDisk, int i,
			int j, int k) {
		if (numberOfDisk < 1) {
			System.out.println(g.getNbMoves());
		} else {
			solveHanoiRecAux(g, numberOfDisk - 1, i, k, j);
			moveDisk(g, i, k);
			printGame(g);
			solveHanoiRecAux(g, numberOfDisk - 1, j, i, k);
		}
	}

	/**
	 * Solve an HanoiGame with the circular rule.
	 * 
	 * 
	 * @param g
	 * @param numberOfDisk
	 * @param i
	 * @param j
	 * @param k
	 */
	public static void solveHanoiRecAuxCir(HanoiGame g, int numberOfDisk,
			int i, int j, int k) {
		if (numberOfDisk < 1) {
			System.out.println(g.getNbMoves());
		} else {
			solveHanoiRecAuxCir(g, numberOfDisk - 1, i, j, k);
			
			moveDisk(g, i, j);
			printGame(g);

			solveHanoiRecAux2Cir(g, numberOfDisk - 1, k, j, i);

			moveDisk(g, j, k);
			printGame(g);

			solveHanoiRecAuxCir(g, numberOfDisk - 1, i, j, k);
		}

	}

	private static void solveHanoiRecAux2Cir(HanoiGame g, int numberOfDisk,
			int i, int j, int k) {
		if (numberOfDisk < 1) {
			System.out.println(g.getNbMoves());
		} else {
			solveHanoiRecAuxCir(g, numberOfDisk - 1, i, k, j);
			moveDisk(g, i, k);
			printGame(g);
			solveHanoiRecAuxCir(g, numberOfDisk - 1, j, i, k);
		}
	}
	
	/**
	 * Solve the HanoiTower game with an iterative method,
	 * It is the optimal Solution.
	 * @param g
	 */
	public static void solveHanoiIt(HanoiGame g) {
		int step = 0;
		int pas = ((g.getNumberOfDisk() % 2) == 0) ? 1 : -1;
		int minNbMoves = HanoiTools.minNbMoves(g.getNumberOfDisk());
		moveDisk(g, 0, myMod3(step + pas));
		printGame(g);
		for (int i = 1; i < minNbMoves; i += 2) {
			makeAMove(g, step, myMod3(step + 2 * pas));
			printGame(g);
			step = myMod3(step + pas);
			moveDisk(g, step, myMod3(step + pas));
			printGame(g);
		}
		System.out.println(g.getNbMoves());
		System.out.println(minNbMoves);
	}

	public static int myMod3(int i) {
		int mod3 = i % 3;
		return (mod3 < 0) ? mod3 + 3 : mod3;
	}

	/**
	 * function that return the minimal number of moves needed to solve an HanoiGame.
	 * 
	 * @param numberOfDisk
	 * @return
	 */
	public static int minNbMoves(int numberOfDisk) {
		if (numberOfDisk < 1)
			return 0;
		else
			return 1 + 2 * minNbMoves(numberOfDisk - 1);
	}

	/**
	 * function that return the minimal number of moves needed to solve an HanoiGame with the circular rule.
	 * 
	 * @param numberOfDisk
	 * @return
	 */
	public static int minNbMovesCir(int numberOfDisk) {
		if (numberOfDisk < 1)
			return 0;
		else if (numberOfDisk ==1)
			return 2;
		else
			return 3 + 2 * minNbMovesCir(numberOfDisk - 1)+2*minNbMovesCir(numberOfDisk-2);
	}

}
