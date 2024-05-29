package com.example.its.swingUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MakeIssueFrame extends JFrame {
    MakeIssueController controller;

	private JTextField issueTitleField;
    private JTextArea issueDescArea;
    private JComboBox priorityComboBox;

    class BackButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.dispose();
        }
    }

    class PostButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(controller.MakeIssue(issueTitleField.getText(), issueDescArea.getText(), priorityComboBox.getSelectedIndex())) {
                issueTitleField.setText("");
                issueDescArea.setText("");
                dispose();
            }
        }        
    }
    
    MakeIssueFrame(MakeIssueController controller){
        this.controller = controller;
		BorderLayout borderLayout = (BorderLayout) this.getContentPane().getLayout();
		borderLayout.setVgap(5);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel NorthPanel = new JPanel();
		getContentPane().add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new BoxLayout(NorthPanel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		NorthPanel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut);
		
		JButton BackButton = new JButton("Back");
        BackButton.addActionListener(new BackButtonAction());
		panel_2.add(BackButton);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_2.add(horizontalGlue);
		
		JButton PostButton = new JButton("Post");
        PostButton.addActionListener(new PostButtonAction());
		panel_2.add(PostButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_1);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		NorthPanel.add(verticalStrut);
		
		JPanel panel_3 = new JPanel();
		NorthPanel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_2);
		
		JLabel IssueNameLabel = new JLabel("IssueName");
		panel_4.add(IssueNameLabel);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_4.add(horizontalGlue_1);
		
		issueTitleField = new JTextField();
		panel_3.add(issueTitleField);
		issueTitleField.setColumns(10);
		
		JPanel CenterPanel = new JPanel();
		getContentPane().add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		CenterPanel.add(scrollPane);
		
		JPanel descPanel = new JPanel();
		scrollPane.setViewportView(descPanel);
		descPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel descTextPanel = new JPanel();
		descPanel.add(descTextPanel, BorderLayout.NORTH);
		descTextPanel.setLayout(new BoxLayout(descTextPanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		descTextPanel.add(horizontalStrut_9);
		
		JLabel IssueDescLabel = new JLabel("Issue Description");
		descTextPanel.add(IssueDescLabel);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		descTextPanel.add(horizontalGlue_2);
		
		issueDescArea = new JTextArea();
		descPanel.add(issueDescArea);
		
		JPanel panel = new JPanel();
		CenterPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_6);
		
		JLabel PriorityLabel = new JLabel("Priority");
		panel.add(PriorityLabel);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_7);
		
        String[] priority = new String[]{ "Major", "Minor", "Blocker", "Critical", "Trivial" };
		priorityComboBox = new JComboBox(priority);
		panel.add(priorityComboBox);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_8);
    }
}
