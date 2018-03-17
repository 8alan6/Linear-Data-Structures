package maintenence;
import java.io.Serializable;
import java.util.ArrayList;

import people.Patient;

public class ProcedureList implements Serializable{

		private ArrayList<Procedure> procedureList;
		private Procedure procedure;
		
		public ProcedureList() {									
			procedureList = new ArrayList();
		}
		
		public ArrayList<Procedure> getList() {					//gets invoice List
			if(procedureList == null) {
				return null;
			}
			return this.procedureList;
		}
		
		public void addProcedure(Procedure procedure) {								//adds a room to the roomlist
			this.procedureList.add(procedure);
		}
		
		public void displayProcedures() {					//gets invoice List
			System.out.println("=============================\n\tPROCEDURES LIST\n");
			for(Procedure p: getList())
				System.out.println("\n\tProcedure ID: "+p.getProID()
									+"\n\tName: "+p.getName()
									+"\n\tPrice: €"+p.getCost()+"\n");
			
		}
		
		
}
