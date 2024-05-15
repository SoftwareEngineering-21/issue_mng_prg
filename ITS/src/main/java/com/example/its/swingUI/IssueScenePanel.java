package com.example.its.swingUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class IssueScenePanel extends JPanel {
    IssueScenePanel(){
		setLayout(new BorderLayout(0, 5));
		
		JPanel ModifyIssueButtonButtonPanel = new JPanel();
		ModifyIssueButtonButtonPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(ModifyIssueButtonButtonPanel, BorderLayout.NORTH);
		ModifyIssueButtonButtonPanel.setLayout(new BoxLayout(ModifyIssueButtonButtonPanel, BoxLayout.Y_AXIS));
		
		JPanel ModifiyButtonPanel = new JPanel();
		ModifyIssueButtonButtonPanel.add(ModifiyButtonPanel);
		ModifiyButtonPanel.setLayout(new BoxLayout(ModifiyButtonPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		ModifiyButtonPanel.add(horizontalGlue_1);
		
		JButton ModifyButton = new JButton("Modify");
		ModifiyButtonPanel.add(ModifyButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		ModifiyButtonPanel.add(horizontalStrut);
		
		JPanel IssueDescriptionPanel = new JPanel();
		IssueDescriptionPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ModifyIssueButtonButtonPanel.add(IssueDescriptionPanel);
		IssueDescriptionPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel IssueNamePanel = new JPanel();
		IssueDescriptionPanel.add(IssueNamePanel, BorderLayout.NORTH);
		IssueNamePanel.setLayout(new BoxLayout(IssueNamePanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		IssueNamePanel.add(horizontalStrut_1);
		
		JLabel IssueName = new JLabel("IssueName");
		IssueNamePanel.add(IssueName);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		IssueNamePanel.add(horizontalGlue_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		IssueDescriptionPanel.add(scrollPane_1, BorderLayout.SOUTH);
		
		JTextArea IssueDescription = new JTextArea();
		IssueDescription.setEditable(false);
		IssueDescription.setRows(5);
		IssueDescription.setLineWrap(true);
		scrollPane_1.setViewportView(IssueDescription);
		
		int size = 10;
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel CommentListPanel = new JPanel();
		scrollPane.setViewportView(CommentListPanel);
		GridBagLayout gbl_CommentListPanel = new GridBagLayout();
		gbl_CommentListPanel.columnWidths = new int[]{0, 0};
		gbl_CommentListPanel.rowHeights = new int[size];
		gbl_CommentListPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_CommentListPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0};
		CommentListPanel.setLayout(gbl_CommentListPanel);
		

		CommentPanel commentPanel[] = new CommentPanel[size];
		for(int i = 0; i < size; i++) {
			commentPanel[i] = new CommentPanel("Writer" + i, "");
			commentPanel[i].addGbcPanel(CommentListPanel, i);
			gbl_CommentListPanel.rowHeights[i] = 50;
		}
		
		
		JPanel WriteCommentPanel = new JPanel();
		add(WriteCommentPanel, BorderLayout.SOUTH);
		WriteCommentPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		WriteCommentPanel.add(scrollPane_3);
		
		JTextArea WriteCommentArea = new JTextArea();
		WriteCommentArea.setRows(5);
		WriteCommentArea.setLineWrap(true);
		scrollPane_3.setViewportView(WriteCommentArea);
		
		JPanel PostButtonPanel = new JPanel();
		WriteCommentPanel.add(PostButtonPanel, BorderLayout.SOUTH);
		PostButtonPanel.setLayout(new BoxLayout(PostButtonPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		PostButtonPanel.add(horizontalGlue_5);
		
		JButton PostButton = new JButton("Post");
		PostButtonPanel.add(PostButton);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		PostButtonPanel.add(horizontalStrut_7);

	}
	
	class CommentPanel extends JPanel {
		CommentPanel(){
			this("WriterName", "");
		}
		
		CommentPanel(String writerName, String commentText){
			setBorder(new LineBorder(new Color(0, 0, 0)));
			setLayout(new BorderLayout(0, 0));
			
			JPanel WriterNamePanel = new JPanel();
			add(WriterNamePanel, BorderLayout.NORTH);
			WriterNamePanel.setLayout(new BoxLayout(WriterNamePanel, BoxLayout.X_AXIS));
			
			Component horizontalStrut_2 = Box.createHorizontalStrut(20);
			WriterNamePanel.add(horizontalStrut_2);
			
			JLabel Writer = new JLabel(writerName);
			WriterNamePanel.add(Writer);
			
			Component horizontalGlue_3 = Box.createHorizontalGlue();
			WriterNamePanel.add(horizontalGlue_3);
			
			JTextArea CommenTextArea = new JTextArea();
			CommenTextArea.setLineWrap(true);
			CommenTextArea.setText(commentText);
			CommenTextArea.setEditable(false);
			CommenTextArea.setRows(1);
			add(CommenTextArea, BorderLayout.CENTER);
		}
		
		void addGbcPanel(JPanel GbcPanel, int index) {
			GridBagConstraints gbc_CommentPanel = new GridBagConstraints();
			gbc_CommentPanel.insets = new Insets(0, 0, 5, 0);
			gbc_CommentPanel.fill = GridBagConstraints.BOTH;
			gbc_CommentPanel.gridx = 0;
			gbc_CommentPanel.gridy = index;
			GbcPanel.add(this, gbc_CommentPanel);
		}
	}
}
