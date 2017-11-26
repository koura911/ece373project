package people;

import java.util.ArrayList;

import sun.misc.FormattedFloatingDecimal.Form;

public class OfficeWorker {

		ArrayListrrayList<Report> reports;
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
			reprots.remove(p);
		}
		public void rmvForm(Form o) {
			forms.remove(o);
		}
		
		public Report findReport(int n) {
			return report.get(n);
		}
		
}
