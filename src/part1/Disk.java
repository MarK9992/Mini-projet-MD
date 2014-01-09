package part1;

public class Disk {
	private int size;
	private int nbMoves;
	
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
