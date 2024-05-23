package com.example.its.swingUI;

import com.example.its.dataClass.Project;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScenePanel extends JPanel {
	private final MainController controller;

	private JPanel ProjectListPanel;
	private GridBagLayout gbl_ProjectListPanel;

	class NewProjectButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Open MakeProjectFrame");
			controller.openMakeProj();
		}
	}

    MainScenePanel(MainController controller){
		this.controller = controller;

        setLayout(new BorderLayout(0, 5));
		
		JPanel NewProjectButtonPanel = new JPanel();
		add(NewProjectButtonPanel, BorderLayout.NORTH);
		NewProjectButtonPanel.setLayout(new BoxLayout(NewProjectButtonPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		NewProjectButtonPanel.add(horizontalGlue_1);
		
		JButton NewProjectButton = new JButton("New");
		NewProjectButton.addActionListener(new NewProjectButtonAction());
		NewProjectButtonPanel.add(NewProjectButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		NewProjectButtonPanel.add(horizontalStrut);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		ProjectListPanel = new JPanel();
		ProjectListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gbl_ProjectListPanel = new GridBagLayout();
		gbl_ProjectListPanel.columnWidths = new int[] { 420, 0 };
		gbl_ProjectListPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		ProjectListPanel.setLayout(gbl_ProjectListPanel);
		scrollPane.setViewportView(ProjectListPanel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.SOUTH);

		makeProjectList();
	}

	public void makeProjectList(){
		ProjectListPanel.removeAll();

		Project[] projectList = controller.getProjectList();
		if(projectList == null){
			return;
		}
		
		int size = projectList.length;
		System.out.println(projectList.length);
		gbl_ProjectListPanel.rowHeights = new int[size + 1];
		gbl_ProjectListPanel.rowWeights = new double[size + 1];


		ProjectPanel projectPanel[] = new ProjectPanel[size];
		for(int i = 0; i < size; i++) {
			gbl_ProjectListPanel.rowHeights[i] = 100;
			gbl_ProjectListPanel.rowWeights[i] = 0;

			projectPanel[i] = new ProjectPanel(ProjectListPanel, i, projectList[i].getTitle());
		}
		System.out.println(projectPanel.length);
		gbl_ProjectListPanel.rowHeights[size] = 0;
		gbl_ProjectListPanel.rowWeights[size] = Double.MIN_VALUE;
		
		revalidate();
		repaint();
	}
	
	class ProjectPanel extends JPanel {
		int index;

		ProjectPanel(JPanel GbcPanel,int index, String title){
			this(GbcPanel, index, title, "New");
		}

		ProjectPanel(JPanel GbcPanel, int index, String title, String Authority){
			this.index = index;

			setBorder(new LineBorder(new Color(0, 0, 0)));
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			add(horizontalStrut_1);
			
			JLabel ProjectName = new JLabel(title);
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
			
			JLabel AuthorityName = new JLabel(Authority);
			AuthorityPanel.add(AuthorityName);
			
			Component horizontalStrut_7 = Box.createHorizontalStrut(20);
			AuthorityPanel.add(horizontalStrut_7);
			
			Component verticalGlue = Box.createVerticalGlue();
			AthorityAreaPanel.add(verticalGlue);
			
			Component horizontalGlue_2 = Box.createHorizontalGlue();
			add(horizontalGlue_2);

			addMouseListener(new ProjectPanelAction());
			
			GridBagConstraints gbc_ProjectPanel = new GridBagConstraints();
			gbc_ProjectPanel.fill = GridBagConstraints.BOTH;
			gbc_ProjectPanel.weightx = 1;
			gbc_ProjectPanel.insets = new Insets(0, 0, 5, 0);
			gbc_ProjectPanel.gridx = 0;
			gbc_ProjectPanel.gridy = index;
			GbcPanel.add(this, gbc_ProjectPanel);
		}
		
		class ProjectPanelAction extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("Open ProjectInfo : " + index);
				controller.openProject(index);
			}
		}
	}
}