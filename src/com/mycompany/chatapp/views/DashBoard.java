//
//
//package com.mycompany.chatapp.views;
//
//import javax.swing.*;
//import java.awt.*;
//import java.net.URL;
//
//public class DashBoard extends JFrame {
//
//    public DashBoard(String message) {
//        setTitle(message);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setBounds(100, 100, 1231, 675); // Set your preferred size
//        setLocationRelativeTo(null); // Center the window
//
//        // Load the image
//        URL imageUrl = DashBoard.class.getResource("/images/chit.jpg");
//        if (imageUrl != null) {
//            ImageIcon originalIcon = new ImageIcon(imageUrl);
//
//            // Scale the image to fit the full frame
//            Image scaledImage = originalIcon.getImage().getScaledInstance(
//                    getWidth(), getHeight(), Image.SCALE_SMOOTH
//            );
//            ImageIcon scaledIcon = new ImageIcon(scaledImage);
//
//            JLabel backgroundLabel = new JLabel(scaledIcon);
//            backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
//            backgroundLabel.setLayout(null); // Allow adding components manually
//
//            // Optional: Add title text on top
//            JLabel welcomeLabel = new JLabel(message);
//            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));
//            welcomeLabel.setForeground(Color.BLACK);
//            welcomeLabel.setBounds(450, 20, 600, 50); // Adjust position
//            backgroundLabel.add(welcomeLabel);
//
//            // Set backgroundLabel as the content pane
//            setContentPane(backgroundLabel);
//        } else {
//            System.out.println("Image not found!");
//        }
//
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new DashBoard("Welcome to the Chit Chat App"));
//    }
//}








package com.mycompany.chatapp.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;

public class DashBoard extends JFrame {

    public DashBoard(String message) {
        setTitle(message);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // ==== Create Menu ====
        JMenuBar menuBar = new JMenuBar();
        JMenu chatMenu = new JMenu("Chat");
        JMenuItem startChatItem = new JMenuItem("Start Chat");

        // Add ActionListener if you want to handle "Start Chat" click
//        startChatItem.addActionListener(e -> {
//            JOptionPane.showMessageDialog(this, "Starting Chat...");
//            // You can open a new window or panel here
//        });
        
        startChatItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ClientChatScreen();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

        chatMenu.add(startChatItem);
        menuBar.add(chatMenu);
        setJMenuBar(menuBar);

        // ==== Load Background Image ====
        URL imageUrl = DashBoard.class.getResource("/images/chit.jpg");
        if (imageUrl != null) {
            ImageIcon originalIcon = new ImageIcon(imageUrl);
            Image scaledImage = originalIcon.getImage().getScaledInstance(
                    1920, 600, Image.SCALE_SMOOTH // Or use getWidth()/getHeight() dynamically
            );
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JLabel backgroundLabel = new JLabel(scaledIcon);
            backgroundLabel.setLayout(null);

            JLabel welcomeLabel = new JLabel(message);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));
            welcomeLabel.setForeground(Color.BLACK);
            welcomeLabel.setBounds(650, 40, 600, 50);
            backgroundLabel.add(welcomeLabel);


            setContentPane(backgroundLabel);
        } else {
            System.out.println("Image not found!");
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashBoard("Welcome Ansh"));
    }
}
