package system.people;

import java.util.ArrayList;

import system.forms.*;

public class OfficeWorker {

		ArrayList<Report> reports;
		private ArrayList<Form> forms;
		
		
		public OfficeWorker() {
			reports = new ArrayList<Report>();
			forms = new ArrayList<Form>();
		}
		
		public ArrayList<Report> getRep(){
			return reports;
		}
		public ArrayList<Form> getForm(){
			return forms;
		}
		public void setRep(ArrayList<Report> r) {
			reports = r;
		}
		public void setForm(ArrayList<Form> f) {
			forms = f;
		}
		
		public void addRep(Report p) {
			reports.add(p);
		}
		public void addForm(Form o) {
			forms.add(o);
		}
	
		public void rmvRep(Report p) {
			reports.remove(p);
		}
		public void rmvForm(Form o) {
			forms.remove(o);
		}
		
		public Report findReport(int n) {
			return reports.get(n);
		}
		
}
