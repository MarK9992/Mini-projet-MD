package hanoi;

import java.util.ArrayList;

public class Pile {
	private ArrayList<Disk> disks=new ArrayList<Disk>();
	private int size;
	
	public void push(Disk d) throws Exception{
		if((getSize()==0) || (d.getSize()<disks.get(getSize()-1).getSize())){
			disks.add(getSize(),d);
			setSize(getSize() + 1);
		}
		else throw new Exception("on ne peut ajouter un disque que sur un disque plus grand");
	}
	
	
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


	public Disk see(int i) {
		try {
			return disks.get(i);
		} catch (Exception e) {
			return null;
		}
	}
	
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
