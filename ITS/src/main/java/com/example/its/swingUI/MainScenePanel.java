package com.example.its.swingUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JToggleButton;

public class MainScenePanel extends JPanel {
    MainScenePanel(){
        setLayout(new BorderLayout(0, 5));
		
		JPanel NewProjectButtonPanel = new JPanel();
		add(NewProjectButtonPanel, BorderLayout.NORTH);
		NewProjectButtonPanel.setLayout(new BoxLayout(NewProjectButtonPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		NewProjectButtonPanel.add(horizontalGlue_1);
		
		JButton NewProjectButton = new JButton("New");
		NewProjectButtonPanel.add(NewProjectButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		NewProjectButtonPanel.add(horizontalStrut);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		int size = 10;
		JPanel ProjectListPanel = new JPanel();
		ProjectListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(ProjectListPanel);
		GridBagLayout gbl_ProjectListPanel = new GridBagLayout();
		gbl_ProjectListPanel.columnWidths = new int[] {0};
		gbl_ProjectListPanel.rowHeights = new int[size];
		gbl_ProjectListPanel.columnWeights = new double[]{1.0};
		gbl_ProjectListPanel.rowWeights = new double[]{0.0};
		ProjectListPanel.setLayout(gbl_ProjectListPanel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.SOUTH);

		ProjectPanel projectPanel[] = new ProjectPanel[size];
		for(int i = 0; i < size; i++) {
			projectPanel[i] = new ProjectPanel();
			projectPanel[i].addGbcPanel(ProjectListPanel, i);
			gbl_ProjectListPanel.rowHeights[i] = 70;
		}
	}
	
	class ProjectPanel extends JPanel {
		ProjectPanel(){
			setBorder(new LineBorder(new Color(0, 0, 0)));
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			add(horizontalStrut_1);
			
			JLabel ProjectName = new JLabel("Project Name");
			add(ProjectName);
			
			Component horizontalStrut_2 = Box.createHorizontalStrut(20);
			add(horizontalStrut_2);
			
			JPanel AthorityAreaPanel = new JPanel();
			add(AthorityAreaPanel);
			AthorityAreaPanel.setLayout(new BoxLayout(AthorityAreaPanel, BoxLayout.Y_AXIS));
			
			Component verticalGlue_1 = Box.createVerticalGlue();
			AthorityAreaPanel.add(verticalGlue_1);
			
			JPanel AuthorityPanel = new JPanel();
			AuthorityPanel.setBackground(new Color(192, 192, 192));
			AuthorityPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			AthorityAreaPanel.add(AuthorityPanel);
			AuthorityPanel.setLayout(new BoxLayout(AuthorityPanel, BoxLayout.LINE_AXIS));
			
			Component horizontalStrut_3 = Box.createHorizontalStrut(20);
			AuthorityPanel.add(horizontalStrut_3);
			
			JLabel AuthorityName = new JLabel("Authority");
			AuthorityPanel.add(AuthorityName);
			
			Component horizontalStrut_7 = Box.createHorizontalStrut(20);
			AuthorityPanel.add(horizontalStrut_7);
			
			Component verticalGlue = Box.createVerticalGlue();
			AthorityAreaPanel.add(verticalGlue);
			
			Component horizontalGlue_2 = Box.createHorizontalGlue();
			add(horizontalGlue_2);
		}
		
		void addGbcPanel(JPanel GbcPanel, int index) {
			GridBagConstraints gbc_ProjectPanel = new GridBagConstraints();
			gbc_ProjectPanel.fill = GridBagConstraints.BOTH;
			gbc_ProjectPanel.insets = new Insets(0, 0, 5, 0);
			gbc_ProjectPanel.gridx = 0;
			gbc_ProjectPanel.gridy = index;
			GbcPanel.add(this, gbc_ProjectPanel);
		}
	}
}
