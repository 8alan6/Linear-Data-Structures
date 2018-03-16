package maintenence;

public class Procedure {

	private int proID;
	private String name;
	private Double cost;
	static int PROCEDURE_ID = 9999;



	public Procedure(String name,Double cost ) {
		proID = PROCEDURE_ID;
		PROCEDURE_ID--;
		this.name = name;
		this.cost = cost;
	}

	public int getProID() {
		return this.proID;
	}

	public void setID(int proID) {
		this.proID = proID;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Double getCost() {
		return cost;
	}



	public void setCost(Double cost) {
		this.cost = cost;
	}



	@Override
	public String toString() {
		return "\nProcedure ID: " + proID + "\t Name: " + name + "     \t Cost: €" + cost+"";
	}

	public void Print() {
		System.out.println(toString());
	}
}
