package system.software;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import system.company.Company;

public class CompanyGUICustomer extends JFrame {
	private Company co;
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu edit;
	private JMenu plans;
	private JMenu print;

	private JMenuItem exit;
	private JMenuItem editInformation;
	private JMenuItem viewAvailablePlans;
	private JMenuItem printInvoice;
	private JMenuItem printQuote;
	private JMenuItem signOut;
	private JMenuItem save;
	private JMenuItem load;
	
	public CompanyGUICustomer(String string, Company co1) {
		super(string);
		
		co = new Company();
		
		/*for (int i = 0; i < co1.equipmentList.size(); i++) {
			co.equipmentList.add(co1.equipmentList.get(i));
		}
		
		for (int i = 0; i < co1.people.size(); i++) {
			co.people.add(co1.people.get(i));
		}
		*/
		setSize(600, 600);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JLabel ("<HTML><center>Welcome to " + string + ". " + "<BR>Choose an action from the above menus.</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();
		setVisible(true);
	}
	
	public void buildGUI() {
		menuBar = new JMenuBar();
		file = new JMenu("File");
		save = new JMenuItem("Save");
		load = new JMenuItem("Load");
		exit = new JMenuItem("Exit");
		signOut = new JMenuItem("Sign Out");
		save.addActionListener(new MenuListener());
		load.addActionListener(new MenuListener());
		exit.addActionListener(new MenuListener());
		signOut.addActionListener(new MenuListener());
		file.add(save);
		file.add(load);
		file.add(exit);
		file.add(signOut);
		edit = new JMenu("Edit");
		editInformation = new JMenuItem("Edit Information");
		editInformation.addActionListener(new MenuListener());
		edit.add(editInformation);
		plans = new JMenu("Plans");
		viewAvailablePlans = new JMenuItem("View Available Plans");
		viewAvailablePlans.addActionListener(new MenuListener());
		plans.add(viewAvailablePlans);
		print = new JMenu("Print");
		printInvoice = new JMenuItem("Print Invoice");
		printQuote = new JMenuItem("Print Quote");
		printInvoice.addActionListener(new MenuListener());
		printQuote.addActionListener(new MenuListener());
		print.add(printInvoice);
		print.add(printQuote);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(plans);
		menuBar.add(print);
		setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if (source.equals(save)) {
				
			}
			else if (source.equals(load)) {
				
			}
			else if (source.equals(exit)) {
				
			}
			else if (source.equals(signOut)) {
				
			}
			else if (source.equals(editInformation)) {
				
			}
			else if (source.equals(viewAvailablePlans)) {
				
			}
			else if (source.equals(printInvoice)) {
				
			}
			else if (source.equals(printQuote)) {
				
			}
		}
	}
}