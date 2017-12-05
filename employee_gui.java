package system.software;
import system.company.*;
import system.people.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import company.people.Customer;
import company.people.Person;





public class employee_gui extends JFrame {
	
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
	
	public employee_gui(String EmployeeGui, Company c1) {
		
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
		
			
		
		/*
		 * //admin menu
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
		 * */
		
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
		addCust.add(new JLabel("Enter the Customer's Information"))
		
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
		addUser.add(of);
		addUser.add(ad);
		
		if(cu.isSelected()) {
			Person p = addNewUser();
			Customer c = addCustomer();
			c.setName(p.getName());
			c.setPswd(p.getPswd());
		}
	}

}
