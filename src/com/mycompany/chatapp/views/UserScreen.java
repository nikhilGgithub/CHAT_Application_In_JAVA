
package com.mycompany.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mycompany.chatapp.dao.UserDAO;
import com.mycompany.chatapp.dto.UserDTO;
import com.mycompany.chatapp.utils.UserInfo;

import javax.swing.JPasswordField;

public class UserScreen extends JFrame {
	JTextField userIdField;
    JPasswordField passwordField;
    
  
    private void doLogin() {
    	String userid=userIdField.getText();
    	char[] password=passwordField.getPassword();////it return char[]
    	  UserDAO userDAO=new UserDAO();///call userdao
    	UserDTO userDTO=new UserDTO(userid, password);
    	
    	try {
    		String message="";
    		if(userDAO.isLogin(userDTO)){
    			message="Welcome "+userid;
    			UserInfo.USER_NAME=userid;
    			JOptionPane.showMessageDialog(this, message);
    			setVisible(false);
    			dispose();
    		DashBoard dashBoard=new DashBoard(message);
    		dashBoard.setVisible(true);
    		
    	}
    		
    		else {
    			message="Invalid userid and password ";
    			JOptionPane.showMessageDialog(this,message);
    		}
    		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
private void register() {
	String userid=userIdField.getText();
	char[] password=passwordField.getPassword();////it return char[]
	UserDAO userDAO=new UserDAO();///call userdao
	UserDTO userDTO=new UserDTO(userid, password);
	
	try {
		int result=userDAO.add(userDTO);
		if(result>0) {
			JOptionPane.showMessageDialog(this, "Register Successfully...");
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Register Failed...");
		}
	} 
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	
	System.out.println("userid "+userid+"password "+password);
}

    public UserScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setTitle("LOGIN");
        setLocationRelativeTo(null); // center the window

        // Create Container
        Container container = this.getContentPane();
        container.setLayout(null);

        // Title label
        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 32));
        loginLabel.setBounds(180, 30, 200, 50);
        container.add(loginLabel);

        // User ID Label
        JLabel userIdLabel = new JLabel("Userid");
        userIdLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        userIdLabel.setBounds(80, 100, 100, 30);
        container.add(userIdLabel);

        // User ID TextField
         userIdField = new JTextField();
        userIdField.setBounds(180, 100, 220, 30);
        container.add(userIdField);

        // Password Label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setBounds(80, 150, 100, 30);
        container.add(passwordLabel);

        // Password Field
         passwordField = new JPasswordField();
        passwordField.setBounds(180, 150, 220, 30);
        container.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doLogin();
				
			}
		});
        
        loginButton.setBounds(120, 220, 100, 35);
        container.add(loginButton);

        // Register Button
        JButton registerButton = new JButton("Register");
        
        registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
				
			}
		});
        
        registerButton.setBounds(240, 220, 100, 35);
        container.add(registerButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new UserScreen();
    }
}



























