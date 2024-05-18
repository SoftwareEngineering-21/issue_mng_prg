package com.example.its.swingUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class ProjectScenePanel extends JPanel {
    ProjectScenePanel(){
        setLayout(new BorderLayout(0, 1));
		
		//Project Name 출력 칸
		JPanel CenterPanel = new JPanel();
		add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setLayout(new BoxLayout(CenterPanel, BoxLayout.Y_AXIS));
		
		JPanel ProjectNamePanel = new JPanel();
		ProjectNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ProjectNamePanel.setLayout(new BoxLayout(ProjectNamePanel, BoxLayout.X_AXIS));
		CenterPanel.add(ProjectNamePanel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		ProjectNamePanel.add(horizontalStrut);
		
		JLabel lblNewLabel_9 = new JLabel("Project Name");
		ProjectNamePanel.add(lblNewLabel_9);
		
		Component verticalStrut_1 = Box.createVerticalStrut(40);
		ProjectNamePanel.add(verticalStrut_1);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		ProjectNamePanel.add(horizontalGlue_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		CenterPanel.add(verticalStrut);
		
		//이슈 목록
		JPanel basePanel = new JPanel();
		basePanel.setBackground(new Color(240, 240, 240));
		CenterPanel.add(basePanel);
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
		IssueLIistTextPanel.add(NewIssueButton);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		IssueLIistTextPanel.add(horizontalStrut_3);
		
		// 이슈 목록 형성
		JScrollPane scrollPane = new JScrollPane();
		basePanel.add(scrollPane);
		
		int size = 12;
		JPanel IssueListPanel = new JPanel();
		IssueListPanel.setBackground(new Color(240, 240, 240));
		IssueListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gbl_IssueListPanel = new GridBagLayout();
		gbl_IssueListPanel.columnWidths = new int[] {0};
		gbl_IssueListPanel.rowHeights = new int[size];
		gbl_IssueListPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_IssueListPanel.rowWeights = new double[]{0.0};
		IssueListPanel.setLayout(gbl_IssueListPanel);
		scrollPane.setViewportView(IssueListPanel);
		
		IssuePanel IssuePanel[] = new IssuePanel[size];
		for(int i = 0; i < size; i++) {
			gbl_IssueListPanel.rowHeights[i] = 32;
			IssuePanel[i] = new IssuePanel();
			IssuePanel[i].addGbcPanel(IssueListPanel, i);
		}
	}
	
	class IssuePanel extends JPanel{
		IssuePanel(){
			this("IssueName", "New");
		}
		
		IssuePanel(String name, String state){
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
		}
		
		public void addGbcPanel(JPanel GbcPanel, int index) {
			GridBagConstraints gbc_IssuePanel = new GridBagConstraints();
			gbc_IssuePanel.fill = GridBagConstraints.BOTH;
			gbc_IssuePanel.insets = new Insets(0, 0, 5, 0);
			gbc_IssuePanel.gridx = 0;
			gbc_IssuePanel.gridy = index;
			GbcPanel.add(this, gbc_IssuePanel);
		}
	}
}
