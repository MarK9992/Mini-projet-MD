package part1;


/**
 * 
 * This Class represents an element on a Tower of Hanoi.
 * 
 * @author Tom Veniat
 *
 */
public class Disk {
	private int size; // the size of the disk
	private int nbMoves; // the number of movements this disk already done in the current game.
	
	public Disk(int i) {
		this.size=i;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString(){
		return HanoiTools.repeat("-", 2*size-1);
	}
	
	public void incNbMoves(){
		setNbMoves(getNbMoves() + 1);
	}

	public int getNbMoves() {
		return nbMoves;
	}

	public void setNbMoves(int nbMoves) {
		this.nbMoves = nbMoves;
	}

}
