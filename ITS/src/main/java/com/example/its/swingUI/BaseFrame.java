package com.example.its.swingUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaseFrame extends JFrame {
    private ArrayList<JPanel> stack = new ArrayList<>();

    BaseFrame(){
        BorderLayout borderLayout = (BorderLayout) this.getContentPane().getLayout();
		borderLayout.setVgap(5);
		setBounds(100, 100, 1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel UserInfoPanel = new JPanel();
		getContentPane().add(UserInfoPanel, BorderLayout.NORTH);
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
    }

    public void setPanel(JPanel targetPanel){
        if(targetPanel == null){
            return;
        }
        
        if(this.getContentPane().getComponentCount() != 1){
            this.getContentPane().removeAll();
        }
        else{
            stack.add((JPanel)this.getContentPane().getComponent(0));
        }

        this.getContentPane().add(targetPanel);
    }

    public void popStack(){
        int i = stack.size();

        this.getContentPane().removeAll();
        this.getContentPane().add(stack.get(i));
        this.stack.remove(i);
    }
}
