package com.mycompany.chatapp.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mycompany.chatapp.network.Client;
import com.mycompany.chatapp.utils.UserInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

public class ClientChatScreen extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    private Client client;
    
    
    public static void main(String[] args) {
		try {
			ClientChatScreen frame=new ClientChatScreen();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    private void sendIt() {
        String message = textField.getText();
        try {
			client.sendMessage(UserInfo.USER_NAME+" - "+ message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//       
//        }
    }

    public ClientChatScreen() throws UnknownHostException, IOException {
    	textArea= new JTextArea();
    	  textField=new JTextField();
    	client=new Client(textArea);
       
    	// Frame settings
        
    	setTitle("Chit Chat");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 799, 425);

        // Panel setup
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Text Area inside ScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 6, 768, 313);
        contentPane.add(scrollPane);

//        textArea = new JTextArea();
        textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
//        textField.setBounds(10, 24, 713, 280);
        scrollPane.setViewportView(textArea);

        // Input field
        textField = new JTextField();
        textField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        textField.setBounds(20, 339, 602, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        // Send Button
        JButton sendIt = new JButton("Send Message");
        sendIt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendIt();
            }
        });

        // Connect to the server after initializing textArea
       
        sendIt.setBounds(627,352,132,29);
        contentPane.add(sendIt);
        setVisible(true);
    }
   
    

} 
