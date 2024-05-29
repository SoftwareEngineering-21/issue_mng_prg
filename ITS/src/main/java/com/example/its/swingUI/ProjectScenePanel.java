package com.example.its.swingUI;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Component;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;

public class ProjectScenePanel extends JPanel {
	ProjectSceneController controller;

	JLabel projecNameLabel;
	JTextArea projectDescArea;

	JPanel IssueListPanel;

	class NewIssueButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.runMakeIssue();
		}
	}

	class StatisticButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	class settingButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.runProjAuthPanel();
		}
		
	}
	
    ProjectScenePanel(ProjectSceneController controller) {
		this.controller = controller;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel ProjectPanel = new JPanel();
		ProjectPanel.setLayout(new BorderLayout());
		add(ProjectPanel);
		
		JPanel ProjectNamePanel = new JPanel();
		ProjectNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ProjectNamePanel.setLayout(new BoxLayout(ProjectNamePanel, BoxLayout.X_AXIS));
		ProjectPanel.add(ProjectNamePanel, BorderLayout.NORTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		ProjectNamePanel.add(horizontalStrut);
		
		projecNameLabel = new JLabel("Project Name");
		ProjectNamePanel.add(projecNameLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(40);
		ProjectNamePanel.add(verticalStrut_1);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		ProjectNamePanel.add(horizontalGlue_1);

		ScrollPane scrollPane = new ScrollPane();
		ProjectPanel.add(scrollPane, BorderLayout.CENTER);

		projectDescArea = new JTextArea();
		projectDescArea.setToolTipText("Desc");
		projectDescArea.setLineWrap(true);
		projectDescArea.setEditable(false);;
		scrollPane.add(projectDescArea);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		add(buttonPanel);

		JButton statisticButton = new JButton("Statistc");
		statisticButton.addActionListener(new StatisticButtonAction());
		buttonPanel.add(statisticButton);

		JButton settingButton = new JButton("Setting");
		settingButton.addActionListener(new settingButtonAction());
		buttonPanel.add(settingButton);

		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut);
		
		//이슈 목록
		JPanel basePanel = new JPanel();
		basePanel.setBackground(new Color(240, 240, 240));
		add(basePanel);
		basePanel.setLayout(new BorderLayout(0, 5));

		JPanel IssueLIistTextPanel = new JPanel();
		IssueLIistTextPanel.setBackground(new Color(240, 240, 240));
		IssueLIistTextPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		basePanel.add(IssueLIistTextPanel, BorderLayout.NORTH);
		IssueLIistTextPanel.setLayout(new BoxLayout(IssueLIistTextPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		IssueLIistTextPanel.add(horizontalGlue_3);
		
		JLabel IssueListTextLable = new JLabel("IssueList");
		IssueListTextLable.setAlignmentX(Component.CENTER_ALIGNMENT);
		IssueLIistTextPanel.add(IssueListTextLable);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		IssueLIistTextPanel.add(horizontalGlue_2);
		
		JButton NewIssueButton = new JButton("New");
		NewIssueButton.addActionListener(new NewIssueButtonAction());
		IssueLIistTextPanel.add(NewIssueButton);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		IssueLIistTextPanel.add(horizontalStrut_3);
		
		// 이슈 목록 형성
		JScrollPane scrollPane1 = new JScrollPane();
		basePanel.add(scrollPane1);
		
		IssueListPanel = new JPanel();
		IssueListPanel.setBackground(new Color(240, 240, 240));
		IssueListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane1.setViewportView(IssueListPanel);

		GridBagLayout gbl_IssueListPanel = new GridBagLayout();
		gbl_IssueListPanel.columnWidths = new int[] {0};
		gbl_IssueListPanel.rowHeights = new int[] { 32, 32, 32, 32, 32, 32, 32, 32 };
		gbl_IssueListPanel.columnWeights = new double[]{1.0};
		gbl_IssueListPanel.rowWeights = new double[]{0.0};
		IssueListPanel.setLayout(gbl_IssueListPanel);
	}

	void setProjInfo(Project project) {
		projecNameLabel.setText(project.getTitle());
		projectDescArea.setText(project.getDescription());
	}

	void makeIssueList(){
		IssueListPanel.removeAll();

		Issue[] issueList = controller.getIssueList();
		int length = 0;

		if(issueList != null) {
			length = issueList.length;
		}

		int size = length > 8 ? length : 8;
		GridBagLayout gbl_IssueListPanel = new GridBagLayout();
		gbl_IssueListPanel.columnWidths = new int[] {0};
		gbl_IssueListPanel.rowHeights = new int[size];
		gbl_IssueListPanel.columnWeights = new double[]{1.0};
		gbl_IssueListPanel.rowWeights = new double[]{0.0};
		IssueListPanel.setLayout(gbl_IssueListPanel);
		
		IssuePanel IssuePanel[] = new IssuePanel[size];
		for(int i = 0; i < size; i++) {
			gbl_IssueListPanel.rowHeights[i] = 32;
			if(i < length) {
				String result;
				switch(issueList[i].getStatus()){
					default : 
						result = "New";
						break;
				}
				IssuePanel[i] = new IssuePanel(IssueListPanel, i, issueList[i].getTitle(), result);
			}
		}

		revalidate();
		repaint();
	}
	
	class IssuePanel extends JPanel{
		int index;

		IssuePanel(JPanel GbcPanel, int index){
			this(GbcPanel, index, "IssueName", "New");
		}
		
		IssuePanel(JPanel GbcPanel, int index, String name, String state){
			this.index = index;

			addMouseListener(new OpenIssueAction());

			setBorder(new LineBorder(new Color(0, 0, 0)));
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			
			Component horizontalStrut_2 = Box.createHorizontalStrut(20);
			add(horizontalStrut_2);
			
			JLabel IssueName = new JLabel(name);
			add(IssueName);
			
			Component horizontalGlue_1 = Box.createHorizontalGlue();
			add(horizontalGlue_1);
			
			JLabel IssueStateText = new JLabel(state);
			IssueStateText.setForeground(new Color(0, 0, 255));
			add(IssueStateText);
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			add(horizontalStrut_1);

			GridBagConstraints gbc_IssuePanel = new GridBagConstraints();
			gbc_IssuePanel.fill = GridBagConstraints.BOTH;
			gbc_IssuePanel.insets = new Insets(0, 0, 5, 0);
			gbc_IssuePanel.gridx = 0;
			gbc_IssuePanel.gridy = index;
			GbcPanel.add(this, gbc_IssuePanel);
		}

		class OpenIssueAction extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("Open ProjectInfo : " + index);
				controller.runIssueScene(index);
			}
		} 
	}
}