package part1;

import java.util.ArrayList;


/**
 * this class represents à Stack, with all the methods wich can be usefull for an HanoiGame.
 * 
 * 
 * @author tom
 *
 */
public class Pile {
	private ArrayList<Disk> disks=new ArrayList<Disk>();// stock of the disks
	private int size;// number of disks that the Pile contains
	
	
	/**
	 * Method that put a Disk on the top of the Pile.
	 * it throws an Exception if you try to put a larger disk on a smaller one.
	 *  
	 * @param d
	 * @throws Exception
	 */
	public void push(Disk d) throws Exception{
		if((getSize()==0) || (d.getSize()<disks.get(getSize()-1).getSize())){
			disks.add(getSize(),d);
			setSize(getSize() + 1);
		}
		else throw new Exception("on ne peut ajouter un disque que sur un disque plus grand");
	}
	
	/**
	 *  Method that remove the Disk on the top of the Pile.
	 * it throws an Exception if you try to remove a disk on an empty Pile.
	 *  
	 * @return
	 * @throws Exception
	 */
	public Disk pop() throws Exception{
		if (getSize()==0)
			throw new Exception("On ne peut pas popper une pile vide");
		
		else {
			setSize(getSize() - 1);
			Disk d=disks.get(getSize());
			disks.remove(getSize());
			return d;
		}	
	}

	/**
	 * Return a copy of the Disk at the i position or null if there is no Disk at the i position.
	 * (Used to print the Disk without popping it.)
	 * 
	 * @param i
	 * @return
	 */
	public Disk see(int i) {
		try {
			return disks.get(i);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * return a copy of the last Disk of the Pile
	 * 
	 * @return
	 */
	public Disk seeLast(){
		if (getSize()>0)
			return this.see(getSize()-1);
		else return new Disk(0);
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
}
