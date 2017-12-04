package system.software;
import system.company.*;
import system.people.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
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
	private Company c;
	
	
	LoginGUI(String windowTitle) {
		
	/*setSize(600, 600);
	setLayout(new FlowLayout(FlowLayout.CENTER));
	add(new JLabel ("<HTML><center>Welcome to WISP " + windowTitle + ". " + "<BR>Please Login in</center></HTML>"));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	*/
	buildGUI();
	setVisible(true);
	
	
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
		frame.setVisible(true);
		
		
		
		PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(39, 133, 72, 16);
		frame.add(PasswordLabel);
		PasswordLabel.setVisible(true);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setBounds(191, 20, 61, 16);
		//frame.getContentPane().add(loginLabel);
		frame.add(loginLabel);
		
		
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
				
				user.setUserID(Integer.parseInt(passwordField.getText()));
				String password = passwordField.getText();
				
				int i;
				boolean activeUser = false;
				for(i=0; i< c.people.size(); i++) {
					if(c.people.get(i).equals(user)) {
						activeUser = true;
						user = c.people.get(i);
					}else {
						JOptionPane.showMessageDialog(null, 
								"This username is not associated with an account", 
								"Error user does not exsist", 
								JOptionPane.PLAIN_MESSAGE);
						activeUser = false;
					}
				}
				
				if(activeUser == true) {
					if(user.checkPswd(password) == true) {
						//If the password is correct
						if(user instanceof Customer) {
							//FILL IN Customer GUI
						}else if(user instanceof Employee) {
							//FILL IN Employee GUI
						}else if(user instanceof Admin) {
							//FILL IN Admin GUI
						}else if(user instanceof OfficeWorker) {
							//FILL IN OfficeWorker GUI
						}else if(user instanceof Tech) {
							//FILL IN  Tech GUI
						}
					}else {
						//if the password is wrong
						JOptionPane.showMessageDialog(null, 
								"Password was incorecct", 
								"Please try again", 
								JOptionPane.PLAIN_MESSAGE);
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
	

		
		
	}
	
	
	
	
	
	
	
}
