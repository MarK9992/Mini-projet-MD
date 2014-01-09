package part1;

import java.util.*;

public class HanoiGame {
	private int numberOfDisk;
	private ArrayList<Pile> currentSituation;
	private int nbMoves;

	public HanoiGame(int nbOfDisk, int version) {
		
			this.initialize(nbOfDisk);
			this.play(version);
		
		
	}

	private void play(int version) {
		HanoiTools.printGame(this);
		switch(version){
		case 1:
			HanoiTools.solveHanoiRecOpt(this);
			break;
		case 2:
			HanoiTools.solveHanoiIt(this);
			break;
		case 3:
			HanoiTools.solveHanoiRecCir(this);
			break;
		}
		HanoiTools.printEndGame(this);
	}

	

	private void initialize(int nbOfDisk) {
		this.setNumberOfDisk(nbOfDisk);
		this.setNbMoves(0);
		this.currentSituation=new ArrayList<Pile>(3);
		this.currentSituation.add(new Pile());
		this.currentSituation.add(new Pile());
		this.currentSituation.add(new Pile());
		for (int i = getNumberOfDisk(); i>0; i--) {
			try {
				this.currentSituation.get(0).push(new Disk(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	

	

	public int getNumberOfDisk() {
		return numberOfDisk;
	}

	public void setNumberOfDisk(int numberOfDisk) {
		this.numberOfDisk = numberOfDisk;
	}

	public ArrayList<Pile> getCurrentSituation() {
		return currentSituation;
	}

	public void setCurrentSituation(ArrayList<Pile> currentSituation) {
		this.currentSituation = currentSituation;
	}

	public void incMoves() {
		setNbMoves(getNbMoves() + 1);
	}

	public int getNbMoves() {
		return nbMoves;
	}

	public void setNbMoves(int nbMoves) {
		this.nbMoves = nbMoves;
	}
}
