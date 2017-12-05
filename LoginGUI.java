package system.software;
import system.company.*;
import system.people.*;
import system.software.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class LoginGUI extends JFrame {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JFrame login_Window;

	private JLabel usernameLabel;
	private JLabel PasswordLabel;
	
	private Person user;
	private Company comp = new Company();
	
	
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
	
	
	
	LoginGUI(String windowTitle, Company c) {
		
	/*setSize(600, 600);
	setLayout(new FlowLayout(FlowLayout.CENTER));
	add(new JLabel ("<HTML><center>Welcome to WISP " + windowTitle + ". " + "<BR>Please Login in</center></HTML>"));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	*/
	buildGUI();
	//setVisible(true);
	int i;
	for(i =0; i< c.people.size(); i++) {
		comp.addPeople(c.people.get(i));
	}
	for(i =0; i < c.equipmentList.size(); i++) {
		comp.addEquipment(c.equipmentList.get(i));
	}
	
	}
	
	
	
	public void buildGUI() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		//frame.setVisible(true);
		
		//frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(39, 89, 72, 16);
		
		frame.add(usernameLabel);
		//frame.setVisible(true);
		usernameLabel.setVisible(true);
		
		
		
		PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(39, 133, 72, 16);
		frame.add(PasswordLabel);
		PasswordLabel.setVisible(true);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setBounds(191, 20, 61, 16);
		//frame.getContentPane().add(loginLabel);
		frame.add(loginLabel);
		loginLabel.setVisible(true);
		
		
		usernameField = new JTextField();
		usernameField.setBounds(160, 84, 130, 26);
		frame.add(usernameField);
		usernameField.setColumns(10);
		usernameField.setBackground(Color.LIGHT_GRAY);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 128, 131, 26);
		frame.add(passwordField);
		passwordField.setColumns(10);
		passwordField.setBackground(Color.LIGHT_GRAY);
		
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 user = new Person();
				
				user.setUserID(Integer.parseInt(usernameField.getText()));
				String password = passwordField.getText();
				
				int i;
				boolean activeUser = false;
				for(i=0; i< comp.people.size(); i++) {
					if(comp.people.get(i).getUserID() == user.getUserID()) {
						activeUser = true;
						user = (Person)comp.people.get(i);
						
					}
						
					}
				
				if(activeUser == false) {
					JOptionPane.showMessageDialog(null, "This username is not associated with an account", "Error user does not exist",JOptionPane.PLAIN_MESSAGE);
				}
				
				if(activeUser == true) {
					if(user.checkPswd(password) == true) {
						//If the password is correct
						if(user instanceof Customer) {
							//CompanyGUICustomer(String string, Company co1, Customer comp)
							CompanyGUICustomer return0 = new CompanyGUICustomer("Customer",comp,(Customer)user);
						}
						/*else if(user instanceof Employee) {
							buildBaseGUI();
							}*/
						else if(user instanceof Admin) {
							buildBaseGUI();
							buildAdminGUI();
						}else if(user instanceof OfficeWorker) {
							buildBaseGUI();
							buildOfficeGUI();
						}else if(user instanceof Tech) {
							buildBaseGUI();
							buildTechGUI();
						}
					}else {
						//if the password is wrong
						JOptionPane.showMessageDialog(null, 
								"Password was incorecct", 
								"Please try again", 
								JOptionPane.PLAIN_MESSAGE);
						LoginGUI return6 = new LoginGUI("Login", comp);
					}
					
					
				}
			}
		});
		loginButton.setBounds(65, 205, 117, 29);
		frame.add(loginButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login_Window = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(login_Window, "Confirm if you want to exit", "Login",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		exitButton.setBounds(267, 205, 117, 29);
		frame.add(exitButton);
	
		frame.setVisible(true);
		
		
	}
	
	public void buildBaseGUI() {
		frame = new JFrame();
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
		frame.add(menubar);
		
		
	}
	
	public void buildAdminGUI() {
		frame = new JFrame();
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
		
		office.add(addCust);
		office.add(forms);
		office.add(reports);
		
		menubar.add(admin);
		menubar.add(tech);
		menubar.add(office);
		frame.setJMenuBar(menubar);
		
		frame.setVisible(true);

	}
	
	public void buildTechGUI() {
		frame = new JFrame();

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
		
		frame.add(menubar);
		frame.setVisible(true);

		
	}
	
	public void buildOfficeGUI() {
		frame = new JFrame();
		
		//office
		office = new JMenu("Office Worker");
		addCust = new JMenuItem("Add Customer");
		reports = new JMenuItem("Reports");
		forms = new JMenuItem("Forms");
		
		addCust.addActionListener(new MenuListener());
		reports.addActionListener(new MenuListener());
		forms.addActionListener(new MenuListener());
		
		menubar.add(office);
		
		frame.add(menubar);
		frame.setVisible(true);

		
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
		newUser.setVisible(true);
		int result = JOptionPane.showConfirmDialog(null,newUser,"Add New User", JOptionPane.OK_CANCEL_OPTION);
		
		Person p = new Person();
		
		if(result == JOptionPane.OK_OPTION) {
			if(newPswd1.getPassword().toString().equals(newPswd2.getPassword().toString())) {
				p.setName(newName.getText());
				p.setPswd(newPswd1.getPassword().toString());
				p.setUserID(comp.people.size()+1);
				return p;
			}
			else {
				JOptionPane.showMessageDialog(null, "Entered passwords do not match, please try again", "Password Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
		return null;
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
		
		return c1;
			
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
			OfficeWorker off = new OfficeWorker();
			off.setName(p.getName());
			off.setPswd(p.getPswd());
		}
		else if(te.isSelected()) {
			Person p = addNewUser();
			Tech tec = new Tech();
			tec.setName(p.getName());
			tec.setPswd(p.getPswd());
			
		}
		else if(ad.isSelected()) {
			Person p = addNewUser();
			Admin adi = new Admin();
			adi.setName(p.getName());
			adi.setPswd(p.getPswd());
		}
		
	}
	
	
	
}
