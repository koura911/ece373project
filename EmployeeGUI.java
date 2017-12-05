package system.software;
import system.company.*;
import system.forms.Inventory;
import system.forms.Roster;
import system.people.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import company.people.Customer;
import company.people.Person;





public class EmployeeGUI extends JFrame {
	
	private Company comp;
	private JMenuBar menubar;
	private JMenu file;
	private JMenu admin;
	private JMenu tech;
	private JMenu office;
	
	//file menu
	private JMenuItem save;
	private JMenuItem load;
	
	//admin menu
	private JMenuItem addUser;
	private JMenuItem editUser;
	private JMenuItem rmvUser;
	private JMenuItem addEquip; //same on tech menu
	private JMenuItem editEquip; //same on tech menu
	private JMenuItem rmvEquip;
	
	//tech menu
	private JMenuItem addCust; // same on office menu
	
	//office menu
	private JMenuItem reports;
	private JMenuItem forms;
	
	public EmployeeGUI(String EmployeeGui, Company c1) {
		
		super(EmployeeGui);
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildBaseGUI();	
		setVisible(true);
	}
	
	public void buildBaseGUI() {
		menubar = new JMenuBar();

		
		//File Menu
     	
		file = new JMenu("File");
		
		save = new JMenuItem("Save");
		load = new JMenuItem("Load");
		
		save.addActionListener(new MenuListener());
		load.addActionListener(new MenuListener());
		
		file.add(save);
		file.add(load);
		
		menubar.add(file);
		
	}
	
	public void buildAdminGUI() {
		//admin
		admin = new JMenu("Admin");
		addUser = new JMenuItem("Add User");
		editUser = new JMenuItem("Edit User");
		rmvUser = new JMenuItem("Remove User");
		rmvEquip = new JMenuItem("Remove Equipment");
		
		addUser.addActionListener(new MenuListener());
		editUser.addActionListener(new MenuListener());
		rmvUser.addActionListener(new MenuListener());
		rmvEquip.addActionListener(new MenuListener());
		
		admin.add(addUser);
		admin.add(editUser);
		admin.add(rmvUser);
		admin.add(rmvEquip);
		//tech
		tech = new JMenu("Tech");
		addEquip = new JMenuItem("Add Equipment");
		editEquip = new JMenuItem("Edit Equipment");
		
		addEquip.addActionListener(new MenuListener());
		editEquip.addActionListener(new MenuListener());
		
		tech.add(addEquip);
		tech.add(editEquip);
		
		//office
		office = new JMenu("Office Worker");
		addCust = new JMenuItem("Add Customer");
		reports = new JMenuItem("Reports");
		forms = new JMenuItem("Forms");
		
		addCust.addActionListener(new MenuListener());
		reports.addActionListener(new MenuListener());
		forms.addActionListener(new MenuListener());
		
		menubar.add(admin);
		menubar.add(tech);
		menubar.add(office);
	}
	public void buildTechGUI() {
		//tech
		tech = new JMenu("Tech");
		addEquip = new JMenuItem("Add Equipment");
		editEquip = new JMenuItem("Edit Equipment");
		
		addEquip.addActionListener(new MenuListener());
		editEquip.addActionListener(new MenuListener());
		
		tech.add(addEquip);
		tech.add(editEquip);
		
		//office for add cust
		office = new JMenu("Office Worker");
		addCust = new JMenuItem("Add Customer");
		
		addCust.addActionListener(new MenuListener());
		
		office.add(addCust);
		
		menubar.add(tech);
		menubar.add(office);
		
		
	}
	public void buildOfficeGUI() {
		//office
		office = new JMenu("Office Worker");
		addCust = new JMenuItem("Add Customer");
		reports = new JMenuItem("Reports");
		forms = new JMenuItem("Forms");
		
		addCust.addActionListener(new MenuListener());
		reports.addActionListener(new MenuListener());
		forms.addActionListener(new MenuListener());
		
		menubar.add(office);
		
	}
	
	
	
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			JMenuItem source = (JMenuItem)(e.getSource());
			
		
			if(source.equals(save)) {
				handleSave();
			}
			else if(source.equals(load)) {
				handleLoad();
			}
			else if(source.equals(addUser)) {
				handleAddUser();
			}
			else if (source.equals(reports)) {
				handlePrintReport();
			}
		}
	}
	public void handleLoad() {
		comp = Company.loadData();
		
	}

	public void handleSave() {
		if(comp != null)
			Company.saveData(comp);
		else
			JOptionPane.showMessageDialog(null,"No Company","Error",JOptionPane.PLAIN_MESSAGE);
		
	}
	
	public void handlePrintReport() {
		Roster ro1 = new Roster();
		ro1.setEquipment(comp.equipmentList);
		ro1.setPeople(comp.people);
		Inventory i1 = new Inventory();
		i1.setEquipment(comp.equipmentList);
		String reportNum = JOptionPane.showInputDialog(null, "Enter report number: ");
		int rnum = Integer.parseInt(reportNum);
		ro1.setNumber(rnum);
		i1.setNumber(rnum);
		JTextArea rostertext = new JTextArea();
		String rosterstring = "";
		rostertext.setLineWrap(true);
		
		for (int i = 0; i < ro1.getPeople().size(); i++) {
			rosterstring = rosterstring + ro1.getPeople().get(i).getName() + "\n";
		}
		
		rostertext.setText(rosterstring);
		JTextArea inventorytext = new JTextArea();
		inventorytext.setLineWrap(true);
		String inventorystring = "";
		
		for (int i = 0; i < i1.getEquipment().size(); i++) {
			inventorystring = inventorystring + "Name: " + i1.getEquipment().get(i).getName() + "\nBrand: " + i1.getEquipment().get(i).getBrand() + "\nModel: " + i1.getEquipment().get(i).getModel() + "\nIDNum: " + i1.getEquipment().get(i).getIdNum() + "\nSerial Number: " + i1.getEquipment().get(i).getSerialNumber() + "\nDate Installed: " + i1.getEquipment().get(i).getDateInstalled().getDate() + "\nLocation: " + i1.getEquipment().get(i).getLocation().getAddress() + " " + i1.getEquipment().get(i).getLocation().getGpsLat() + " " + i1.getEquipment().get(i).getLocation().getGpsLon() + "\n";
		}
		
		inventorytext.setText(inventorystring);
		
		JFrame reportro = new JFrame();
		reportro.setVisible(true);
		reportro.setTitle("Roster Report");
		reportro.setLayout(new FlowLayout(FlowLayout.CENTER));
		reportro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JScrollPane rosterpane = new JScrollPane(rostertext);
		rosterpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		rosterpane.setPreferredSize(new Dimension(600, 600));
		reportro.add(rosterpane);
		reportro.pack();
		JFrame reporti = new JFrame();
		reporti.setVisible(true);
		reporti.setTitle("Inventory Report");
		reporti.setLayout(new FlowLayout(FlowLayout.CENTER));
		reporti.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JScrollPane inventorypane = new JScrollPane(inventorytext);
		inventorypane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		inventorypane.setPreferredSize(new Dimension(600, 600));
		reporti.add(inventorypane);
		reporti.pack();
		
	}
	
	public Person addNewUser() {
		JPanel newUser = new JPanel();
		addCust.add(new JLabel("Enter the User's Information"));
		
		JTextField newName = new JTextField(5);
		JPasswordField newPswd1 = new JPasswordField(5);
		JPasswordField newPswd2 = new JPasswordField(5);
		
		newUser.add(new JLabel("Name:"));
		newUser.add(newName);
		newUser.add(new JLabel("Password:"));
		newUser.add(newPswd1);
		newUser.add(new JLabel("Confirm Password:"));
		newUser.add(newPswd2);
		
		int result = JOptionPane.showConfirmDialog(null,newUser,"Add New User", JOptionPane.OK_CANCEL_OPTION);
		
		if(result == JOptionPane.OK_OPTION) {
			if(newPswd1.getPassword().toString().equals(newPswd2.getPassword().toString())) {
				Person p = new Person();
				p.setName(newName.getText());
				p.setPswd(newPswd1.getPassword().toString());
				p.setUserID(comp.people.size()+1);
				return p;
			}
			else {
				JOptionPane.showMessageDialog(null, "Entered passwords do not match, please try again", "Password Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public Customer addCustomer() {
		Customer c1 = new Customer();
		JPanel addCust = new JPanel();
		addCust.add(new JLabel("Enter the Customer's Information"));
		
		JTextField xcor = new JTextField(5);
		JTextField ycor = new JTextField(5);
		JTextField sUp = new JTextField(5);
		JTextField sDo = new JTextField(5);
		JTextField price = new JTextField(5);
		JTextField Address = new JTextField(5);
		
		addCust.add(new JLabel("Latitude:"));
		addCust.add(xcor);
		addCust.add(new JLabel("Longitude"));
		addCust.add(ycor);
		addCust.add(new JLabel("Upload Speed"));
		addCust.add(sUp);
		addCust.add(new JLabel("Download Speed"));
		addCust.add(sDo);
		addCust.add(new JLabel("Price"));
		addCust.add(price);
		addCust.add(new JLabel("Address:"));
		addCust.add(Address);
		
		c1.setAddress(Address.getText());
		c1.setPrice(Double.parseDouble(price.getText()));
		c1.setDown(Integer.parseInt(sDo.getText()));
		c1.setUp(Integer.parseInt(sUp.getText()));
		c1.getLoc().setGpsLon(Double.parseDouble(ycor.getText()));
		c1.getLoc().setGpsLat(Double.parseDouble(xcor.getText()));
			
	}
	
	public void handleAddUser() {
		JPanel addUser = new JPanel();
		addUser.add(new JLabel("Select the Type of User"));
		JRadioButton ad = new JRadioButton("Admin");
		JRadioButton te = new JRadioButton("Tech");
		JRadioButton of = new JRadioButton("Office");
		JRadioButton cu = new JRadioButton("Customer");
		ButtonGroup usertypes = new ButtonGroup();
		usertypes.add(cu);
		usertypes.add(of);
		usertypes.add(te);
		usertypes.add(ad);
		
		addUser.add(cu);
		addUser.add(of);
		addUser.add(te);
		addUser.add(ad);
		
		if(cu.isSelected()) {
			Person p = addNewUser();
			Customer c = addCustomer();
			c.setName(p.getName());
			c.setPswd(p.getPswd());
		}
		else if(of.isSelected()) {
			Person p = addNewUser();
			OfficeWorker of1 = new OfficeWorker();
			of1.setName(p.getName());
			of1.setPswd(p.getPswd());
		}
		else if(te.isSelected()) {
			Person p = addNewUser();
			Tech te1 = new Tech();
			te1.setName(p.getName());
			te1.setPswd(p.getPswd());
			
		}
		else if(ad.isSelected()) {
			Person p = addNewUser();
			Admin ad1 = new Admin();
			ad1.setName(p.getName());
			ad1.setPswd(p.getPswd());
		}
		
	}

}

