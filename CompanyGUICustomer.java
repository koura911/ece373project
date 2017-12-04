package system.software;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import system.company.Company;
import system.forms.Invoice;
import system.people.Customer;

/*
 * I need some clarification on why customer needs print quote when they already have a plan
 * Do we want print invoice to also print to a window? Or is the pdf generation enough?
 * Is total amount due necessary for the invoice? We'd have to add functionalities for the customer class for it to keep track of the total due for the contract and when they pay to deduct the paid balances.
 */
public class CompanyGUICustomer extends JFrame {
	private Company co;
	private final JPopupMenu popupfile;
	private final JPopupMenu popupedit;
	private final JPopupMenu popupplans;
	private final JPopupMenu popupprint;
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
	//private JMenuItem save;
	//private JMenuItem load;
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
		Company.saveData(co);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setLayout(new BorderLayout());
		setIconImage(img.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		menuBar = new VerticalMenuBar();
		file = new JMenu("File");
		popupfile = new JPopupMenu();
		//save = new JMenuItem("Save");
		//load = new JMenuItem("Load");
		exit = new JMenuItem("Exit");
		signOut = new JMenuItem("Sign Out");
		file.setFont(new Font("Dialog", Font.PLAIN, 14));
		//save.setFont(new Font("Dialog", Font.PLAIN, 14));
		//load.setFont(new Font("Dialog", Font.PLAIN, 14));
		exit.setFont(new Font("Dialog", Font.PLAIN, 14));
		signOut.setFont(new Font("Dialog", Font.PLAIN, 14));
		//save.addActionListener(new MenuListener());
		//load.addActionListener(new MenuListener());
		exit.addActionListener(new MenuListener());
		signOut.addActionListener(new MenuListener());
		file.addActionListener(new MenuListener());
		//popupfile.add(save);
		//popupfile.add(load);
		popupfile.add(signOut);
		popupfile.add(exit);
		file.add(popupfile);
		popupedit = new JPopupMenu();
		popupplans = new JPopupMenu();
		popupprint = new JPopupMenu();
		file.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (popupfile.isVisible()) {
					popupfile.setVisible(false);
				}
				else {
					popupfile.show(file, 47, 0);
					popupedit.setVisible(false);
					popupprint.setVisible(false);
					popupplans.setVisible(false);
				}
			}
		});
		
		edit = new JMenu("Edit");
		edit.setFont(new Font("Dialog", Font.PLAIN, 14));
		editInformation = new JMenuItem("Edit Information");
		editInformation.setFont(new Font("Dialog", Font.PLAIN, 14));
		editInformation.addActionListener(new MenuListener());
		popupedit.add(editInformation);
		edit.add(popupedit);
		edit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (popupedit.isVisible()) {
					popupedit.setVisible(false);
				}
				else {
					popupedit.show(edit, 47, 0);
					popupfile.setVisible(false);
					popupprint.setVisible(false);
					popupplans.setVisible(false);
				}
			}
		});
		plans = new JMenu("Plans");
		plans.setFont(new Font("Dialog", Font.PLAIN, 14));
		viewAvailablePlans = new JMenuItem("View Available Plans");
		viewAvailablePlans.setFont(new Font("Dialog", Font.PLAIN, 14));
		viewAvailablePlans.addActionListener(new MenuListener());
		popupplans.add(viewAvailablePlans);
		plans.add(popupplans);
		plans.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (popupplans.isVisible()) {
					popupplans.setVisible(false);
				}
				else {
					popupplans.show(plans, 47, 0);
					popupfile.setVisible(false);
					popupedit.setVisible(false);
					popupprint.setVisible(false);
				}
			}
		});
		
		print = new JMenu("Print");
		print.setFont(new Font("Dialog", Font.PLAIN, 14));
		printInvoice = new JMenuItem("Print Invoice");
		printInvoice.setFont(new Font("Dialog", Font.PLAIN, 14));
		printQuote = new JMenuItem("Print Quote");
		printQuote.setFont(new Font("Dialog", Font.PLAIN, 14));
		printInvoice.addActionListener(new MenuListener());
		printQuote.addActionListener(new MenuListener());
		popupprint.add(printInvoice);
		popupprint.add(printQuote);
		print.add(popupprint);
		
		print.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (popupprint.isVisible()) {
					popupprint.setVisible(false);
				}
				else {
					popupprint.show(print, 47, 0);
					popupfile.setVisible(false);
					popupedit.setVisible(false);
					popupplans.setVisible(false);
				}
			}
		});
		menuBar.setFont(new Font("Dialog", Font.PLAIN, 16));
		menuBar.add(file, 0,0 );
		menuBar.add(edit, 0,1 );
		menuBar.add(plans, 0,2 );
		menuBar.add(print, 0,3 );
		JPanel Northpanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		Northpanel.add(menuBar, c);
		Color ccc1 = new Color(238, 238,238);

		Northpanel.setBackground(ccc1);
		Northpanel.setVisible(true);
		add(Northpanel, BorderLayout.NORTH);
		setBackground(new Color(246, 243, 243));
		JPanel nestedCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nestedCenter.setBackground(ccc1);
		JTextArea textArea = new JTextArea("Welcome to " + string + ". Select an action from the menu bar.\n\n\n\nCustomer name:  " + user.getName() + "\n\nCurrent Plan:\n\tSpeed up:\t" + user.getUp() + " Mbps\n\tSpeed down:\t" + user.getDown() + " Mbps\n\nPrice:\t" + "$" + user.getPrice() +" per month\n\nEquipment:\n");
		JScrollPane scrollPaneEquipment = new JScrollPane(textArea);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 16));

		for (int i = 0; i < user.getEquip().size(); i++) {
			textArea.append("\tName:\t   " + user.getEquip().get(i).getName() + "\n\tBrand:\t   " + user.getEquip().get(i).getBrand() + "\n\tModel:\t   " + user.getEquip().get(i).getModel() + "\n\tSerial Number:  " + user.getEquip().get(i).getSerialNumber() + "\n\n");
		}
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		scrollPaneEquipment.setBorder(null);
		textArea.setBackground(ccc1);
		scrollPaneEquipment.setPreferredSize(new Dimension(600, 800));
		scrollPaneEquipment.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneEquipment.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		scrollPaneEquipment.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		nestedCenter.add(scrollPaneEquipment);
		panel.add(nestedCenter, BorderLayout.CENTER);
		ImageIcon cologo = new ImageIcon("C:/Users/Oura9_000/Desktop/ECE_373_Project_Git/ece373project/companylogo.png");
		JLabel logoholder = new JLabel(cologo);
		logoholder.setBackground(new Color(247, 247, 243));
		add(panel, BorderLayout.CENTER);
		add(logoholder, BorderLayout.SOUTH);
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
			
			/*if (source.equals(save)) {
				popupfile.setVisible(false);
				handleSave(co);
			}
			else if (source.equals(load)) {
				popupfile.setVisible(false);
				handleLoad();
			}*/
			if (source.equals(exit)) {
				popupfile.setVisible(false);
				Company.saveData(co);
				co = handleLoad();
				System.exit(0);
			}
			else if (source.equals(signOut)) {
				popupfile.setVisible(false);
				Company.saveData(co);
				co = handleLoad();
				handleSignOut();
			}
			else if (source.equals(editInformation)) {
				popupedit.setVisible(false);
				handleEditInformation();
			}
			else if (source.equals(viewAvailablePlans)) {
				popupplans.setVisible(false);
				handleViewAvailablePlans();
			}
			else if (source.equals(printInvoice)) {
				popupprint.setVisible(false);
				handlePrintInvoice();
			}
			else if (source.equals(printQuote)) {
				popupprint.setVisible(false);
				handlePrintQuote();
			}
		}
	
		private void handleEditInformation() {
			
		}
		
		private void handleViewAvailablePlans() {
			//use checkSpeedUp checkSpeedDown and use that show available plans
			//+$10 per 5mbps increase in plans
		}
		
		private void handlePrintInvoice() {
			JFrame invoice = new JFrame();
			Invoice i1 = new Invoice();
			i1.setPerson(user);
			i1.setDueDate(user.getDueDate());
			i1.setMinDue(user.getPrice());
			i1.setTotalDue(user.getAmyDue());
			i1.generateInvoice();
			invoice.setVisible(true);
			invoice.setSize(600, 600);
			invoice.setTitle(i1.getPerson().getName() + "'s Invoice");
			invoice.setLayout(new FlowLayout(FlowLayout.CENTER));
			invoice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			JTextArea invoiceinfo = new JTextArea("Customer name: " + i1.getPerson().getName() + "\n\n" + "Amount due this cycle: $" + i1.getMinDue() + "\n\nTotal amount due for contract: $" + i1.getTotalDue() + "\n\nPayment due by: " + i1.getDueDate().getDate());
			invoiceinfo.setLineWrap(true);
			JScrollPane invoicepane = new JScrollPane(invoiceinfo);
			invoicepane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			invoicepane.setPreferredSize(new Dimension(600, 600));
			invoice.add(invoicepane);
			invoice.pack();
		}
		
		private void handlePrintQuote() {
			
		}
		
		/*private void handleSave(Company co1) {
			Company.saveData(co1);
		}
		
		private Company handleLoad() {
			co = new Company();
			co = Company.loadData();
			
			return co;
		}*/
		
		private void handleSignOut() {
			dispose();
			Company.saveData(co);
			co = new Company();
			co = Company.loadData();
			LoginGUI return1 = new LoginGUI("The University of Arizona", co);
		}
	}
}