package com.example.its.swingUI;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.val;

public class SwingController {
    JFrame window;
    JPanel outputPanel;

    public SwingController(){
        window = new JFrame("Issue Manager");
		BorderLayout borderLayout = (BorderLayout) window.getContentPane().getLayout();
		borderLayout.setVgap(5);
		window.setBounds(100, 100, 450, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel UserInfoPanel = new JPanel();
		window.getContentPane().add(UserInfoPanel, BorderLayout.NORTH);
		UserInfoPanel.setLayout(new BoxLayout(UserInfoPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		UserInfoPanel.add(horizontalGlue);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		UserInfoPanel.add(horizontalStrut_4);
		
		JPanel panel = new JPanel();
		UserInfoPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("UserName");
		panel.add(lblNewLabel);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_5);
		
		JButton btnNewButton = new JButton("LogOut");
		panel.add(btnNewButton);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_6);

        outputPanel = new MainScenePanel();
        window.getContentPane().add(outputPanel, BorderLayout.CENTER);
    }

    public void setVisible(boolean value){
        window.setVisible(value);
    }

    public void change(){
        window.getContentPane().remove(outputPanel);
        outputPanel = new ProjectScenePanel();

        window.getContentPane().add(outputPanel);
        window.repaint();
    }
}
