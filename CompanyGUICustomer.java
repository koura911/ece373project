package system.software;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import system.company.Company;
import system.people.Customer;

public class CompanyGUICustomer extends JFrame {
	private Company co;
	private JPanel panel = new JPanel(new BorderLayout());
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu file;
	private JMenu edit;
	private JMenu plans;
	private JMenu print;
	private Customer user;
	private JMenuItem exit;
	private JMenuItem editInformation;
	private JMenuItem viewAvailablePlans;
	private JMenuItem printInvoice;
	private JMenuItem printQuote;
	private JMenuItem signOut;
	private JMenuItem save;
	private JMenuItem load;
	private ImageIcon img = new ImageIcon("C:/Users/Oura9_000/Desktop/ECE_373_Project_Git/ece373project/icon.jpg");
	
	public CompanyGUICustomer(String string, Company co1, Customer c1) {
		super(string);
		
		co = new Company();
		user = new Customer();
		
		for (int i = 0; i < co1.equipmentList.size(); i++) {
			co.equipmentList.add(co1.equipmentList.get(i));
		}
		for (int i = 0; i < co1.people.size(); i++) {
			co.people.add(co1.people.get(i));
		}
		user = c1;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setLayout(new BorderLayout());
		setIconImage(img.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		menuBar = new VerticalMenuBar();
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
		file.add(signOut);
		file.add(exit);
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
	
		menuBar.add(file, 0,0 );
		menuBar.add(edit, 0,1 );
		menuBar.add(plans, 0,2 );
		menuBar.add(print, 0,3 );
		//setJMenuBar(menuBar);
		add(menuBar, BorderLayout.NORTH);
		
		JPanel nestedCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel welcomeMessage = new JLabel("<html><br><br><br><br><br><br>Welcome to " + string + ".<br>Select an action from the menu bar." + "<br><br><br>Customer name: &nbsp;" + user.getName() + "<br>Current Plan:<br>" + "<font size = 20 face = Dialog> <table><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Speed up: </td><td>&nbsp;&nbsp;&nbsp;" + user.getUp() + " Mbps</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Speed down: </td><td>&nbsp;&nbsp;" + user.getDown() +" Mbps</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Price: </td><td>&nbsp;&nbsp;$" + user.getPrice() +"</td></tr></table>Equipment: <table><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Hello</td></tr></html>");
		
		welcomeMessage.setFont(new Font("Dialog", Font.PLAIN, 20));
		welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
		welcomeMessage.setVerticalAlignment(JLabel.CENTER);
		nestedCenter.add(welcomeMessage);

		panel.add(nestedCenter, BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	class VerticalMenuBar extends JMenuBar {
		private final LayoutManager grider = new GridLayout(0, 1);
		
		public VerticalMenuBar() {
			setLayout(grider);
		}
	}
	
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if (source.equals(save)) {
				
			}
			else if (source.equals(load)) {
				
			}
			else if (source.equals(exit)) {
				System.exit(0);
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
	
	/*public CompanyGUICustomer(String string, Company co1, Customer p1) {
		super(string);
		
		co = new Company();
		user = new Customer();
		
		for (int i = 0; i < co1.equipmentList.size(); i++) {
			co.equipmentList.add(co1.equipmentList.get(i));
		}
		for (int i = 0; i < co1.people.size(); i++) {
			co.people.add(co1.people.get(i));
		}
		user = p1;
		
		setSize(600, 600);
		setLayout(new BorderLayout());
		setIconImage(img.getImage());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar = new VerticalMenuBar();
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
		file.add(signOut);
		file.add(exit);
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
		menuBar.add(file, 0,0 );
		menuBar.add(edit, 0,1 );
		menuBar.add(plans, 0,2 );
		menuBar.add(print, 0,3 );
		setJMenuBar(menuBar);
		add(menuBar, BorderLayout.NORTH);
		buildGUI(string, user);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	class VerticalMenuBar extends JMenuBar {
		private final LayoutManager grider = new GridLayout(0, 1);
		
		public VerticalMenuBar() {
			setLayout(grider);
		}
	}
	
	public void buildGUI(String h, Customer p1) {
		/*menuBar = new VerticalMenuBar();
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
		file.add(signOut);
		file.add(exit);
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
		menuBar.add(file, 0,0 );
		menuBar.add(edit, 0,1 );
		menuBar.add(plans, 0,2 );
		menuBar.add(print, 0,3 );
		setJMenuBar(menuBar);
		panel.add(menuBar, BorderLayout.NORTH);
		JPanel nestedCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel welcomeMessage = new JLabel("<html><br><br><br><br><br><br>Welcome to " + h + ".<br>Select an action from the menu bar." + "<br><br><br>Customer name: &nbsp;" + p1.getName() + "<br>Current Plan:<br>" + "<font size = 20 face = Dialog> <table><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Speed up: </td><td>&nbsp;&nbsp;&nbsp;" + user.getUp() + " Mbps</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Speed down: </td><td>&nbsp;&nbsp;" + user.getDown() +" Mbps</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Price: </td><td>&nbsp;&nbsp;$" + user.getPrice() +"</td></tr></table>Equipment: <table><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Hello</td></tr></html>");
		
		welcomeMessage.setFont(new Font("Dialog", Font.PLAIN, 20));
		welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
		welcomeMessage.setVerticalAlignment(JLabel.CENTER);
		nestedCenter.add(welcomeMessage);

		panel.add(nestedCenter, BorderLayout.CENTER);
		//add(nestedCenter, FlowLayout.CENTER);
	}
	
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if (source.equals(save)) {
				
			}
			else if (source.equals(load)) {
				
			}
			else if (source.equals(exit)) {
				System.exit(0);
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
	
	}*/
}