
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectList implements Serializable  {
	ArrayList<Object> oList;
	private final int max_num = 15;

	public ObjectList(int max) {
		oList = new ArrayList<Object>();
	}
	
	public boolean addLect(Object o) {		//this method is used
		this.oList.add(o);
		System.out.println(o+" \n\t** Has been added **");
		return true;
}
	
	public boolean add(Object o) {			//used
		if (oList.size() < max_num) {
			this.oList.add(o);
			System.out.println(o+" \n\t** Has been added **");
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isFull() {
		if (oList.size() == max_num) {
			return true;
		}
		else { return false; }
	}

	public boolean isEmpty() {
		if (oList.size() == 0) {
			return true;
		}
		else { return false; }
	}

	public int getTotal() {
		return oList.size();
	}
	
	public boolean remove(Object o) {
		if (oList.size() == 0) {
			return false;
		} else {
			this.oList.remove(o);
			return true;
		}
	}

	
	public Object getObject(int i) {
		return this.oList.get(i);
	}

	public ArrayList<Object> getList() {
		if(oList == null) {
			return null;
		}
		return this.oList;
	}
}
