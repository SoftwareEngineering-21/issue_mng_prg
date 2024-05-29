package com.example.its.swingUI;

import org.springframework.beans.factory.annotation.Autowired;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@org.springframework.stereotype.Component
public class BaseFrame extends JFrame {
	private final BaseFrameController controller;

    private final JPanel mainPanel;

	class BackButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.popStack();
		} 
	}

	class LogOutButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.logout();
		}
	}

	class UserInfoAction extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
		}
	}

	@Autowired
    BaseFrame(BaseFrameController controller){
		this.controller = controller;

        this.setLayout(new BorderLayout(0,5));
		this.setBounds(100, 100, 1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel UserInfoPanel = new JPanel();
		this.getContentPane().add(UserInfoPanel, BorderLayout.NORTH);
		UserInfoPanel.setLayout(new BoxLayout(UserInfoPanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		UserInfoPanel.add(horizontalStrut);

		JButton BackButton = new JButton("<-");
		BackButton.addActionListener(new BackButtonAction());
		UserInfoPanel.add(BackButton);

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
		btnNewButton.addActionListener(new LogOutButtonAction());
		panel.add(btnNewButton);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_6);

        mainPanel = new JPanel();
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
    }

    public void setPanel(JPanel targetPanel){
        if(targetPanel == null){
            return;
        }
        
        mainPanel.removeAll();
        mainPanel.add(targetPanel);

        this.revalidate();
        this.repaint();
    }

	public boolean isEmptyMainPanel(){
		return mainPanel.getComponentCount() != 1;
	}

	public boolean isFull(){
		return mainPanel.getComponentCount() > 0;
	}

	public JPanel getMainPanel(){
		if(mainPanel.getComponentCount() != 1){
			return null;
		}

		return (JPanel)mainPanel.getComponent(0);
	}
}
