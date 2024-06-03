package com.example.its.swingUI.Issue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.example.its.dataClass.Comment;
import com.example.its.dataClass.Issue;
import com.example.its.swingUI.Issue.Controller.IssueSceneController;

public class IssueScenePanel extends JPanel {
	private final IssueSceneController controller;

	private JLabel IssueName;

	private JLabel reporterLable;
	private JLabel typeInfoLable;
	private JLabel priorityLable;
	private JLabel FixerLable;

	private JComboBox statusComboBox;
	private JComboBox assigneeComboBox;

	private JTextArea IssueDescription;

	private JTextArea WriteCommentArea;
	private JPanel CommentListPanel;

	class ModifiyButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!controller.modifyIssue((String)assigneeComboBox.getSelectedItem(), (String)statusComboBox.getSelectedItem(), WriteCommentArea.getText())){
				JOptionPane.showMessageDialog(null, "Can't modify issue");
			}
		}
	}

	class PostButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!controller.addComment(WriteCommentArea.getText())){
				JOptionPane.showMessageDialog(null, "Can not add comment");
			}
		}
	}

    public IssueScenePanel(IssueSceneController controller){
		this.controller = controller;

		setLayout(new BorderLayout(0, 5));
		
		JPanel ModifyIssueButtonButtonPanel = new JPanel();
		ModifyIssueButtonButtonPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(ModifyIssueButtonButtonPanel, BorderLayout.NORTH);
		ModifyIssueButtonButtonPanel.setLayout(new BoxLayout(ModifyIssueButtonButtonPanel, BoxLayout.Y_AXIS));
		
		JPanel ModifiyButtonPanel = new JPanel();
		ModifyIssueButtonButtonPanel.add(ModifiyButtonPanel);
		ModifiyButtonPanel.setLayout(new BoxLayout(ModifiyButtonPanel, BoxLayout.X_AXIS));

		Component horizontalStrut__ = Box.createHorizontalStrut(20);
		ModifyIssueButtonButtonPanel.add(horizontalStrut__);

		reporterLable = new JLabel("Reporter : ");
		ModifiyButtonPanel.add(reporterLable);

		Component horizontalStrut17 = Box.createHorizontalStrut(20);
		ModifyIssueButtonButtonPanel.add(horizontalStrut17);

		priorityLable = new JLabel("priority : ");
		ModifiyButtonPanel.add(priorityLable);

		Component horizontalStrut14 = Box.createHorizontalStrut(20);
		ModifyIssueButtonButtonPanel.add(horizontalStrut14);

		typeInfoLable = new JLabel("Type : ");
		ModifiyButtonPanel.add(typeInfoLable);

		FixerLable = new JLabel("Fixer : ");
		ModifiyButtonPanel.add(FixerLable);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		ModifiyButtonPanel.add(horizontalGlue_1);
		
		JButton ModifyButton = new JButton("Modify");
		ModifyButton.addActionListener(new ModifiyButtonAction());
		ModifiyButtonPanel.add(ModifyButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		ModifiyButtonPanel.add(horizontalStrut);

		JPanel ModifyComboBoxPanel = new JPanel();
		ModifiyButtonPanel.add(ModifyComboBoxPanel);

		String[] status = new String[]{"NEW", "ASSIGNED", "FIXED", "RESOLVED", "REOPENED", "CLOSED"};
		statusComboBox = new JComboBox(status);
		ModifyComboBoxPanel.add(statusComboBox);

		assigneeComboBox = new JComboBox();
		ModifyComboBoxPanel.add(assigneeComboBox);
		
		JPanel IssueDescriptionPanel = new JPanel();
		IssueDescriptionPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ModifyIssueButtonButtonPanel.add(IssueDescriptionPanel);
		IssueDescriptionPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel IssueNamePanel = new JPanel();
		IssueDescriptionPanel.add(IssueNamePanel, BorderLayout.NORTH);
		IssueNamePanel.setLayout(new BoxLayout(IssueNamePanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		IssueNamePanel.add(horizontalStrut_1);
		
		IssueName = new JLabel();
		IssueNamePanel.add(IssueName);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		IssueNamePanel.add(horizontalGlue_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		IssueDescriptionPanel.add(scrollPane_1, BorderLayout.SOUTH);
		
		IssueDescription = new JTextArea();
		IssueDescription.setEditable(false);
		IssueDescription.setRows(5);
		IssueDescription.setLineWrap(true);
		scrollPane_1.setViewportView(IssueDescription);
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		CommentListPanel = new JPanel();
		scrollPane.setViewportView(CommentListPanel);
		
		JPanel WriteCommentPanel = new JPanel();
		WriteCommentPanel.setLayout(new BorderLayout(0, 0));
		add(WriteCommentPanel, BorderLayout.SOUTH);

		JPanel commentInputPanel = new JPanel();
		commentInputPanel.setLayout(new BoxLayout(commentInputPanel, BoxLayout.X_AXIS));
		WriteCommentPanel.add(commentInputPanel, BorderLayout.NORTH);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		commentInputPanel.add(horizontalStrut_5);
		
		JLabel commentInputLabel = new JLabel("Comment Input");
		commentInputPanel.add(commentInputLabel);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		commentInputPanel.add(horizontalGlue_3);

		JScrollPane scrollPane_3 = new JScrollPane();
		WriteCommentPanel.add(scrollPane_3, BorderLayout.CENTER);
		
		WriteCommentArea = new JTextArea();
		WriteCommentArea.setRows(5);
		WriteCommentArea.setLineWrap(true);
		scrollPane_3.setViewportView(WriteCommentArea);
		
		JPanel PostButtonPanel = new JPanel();
		WriteCommentPanel.add(PostButtonPanel, BorderLayout.SOUTH);
		PostButtonPanel.setLayout(new BoxLayout(PostButtonPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		PostButtonPanel.add(horizontalGlue_5);
		
		JButton PostButton = new JButton("Post");
		PostButton.addActionListener(new PostButtonAction());
		PostButtonPanel.add(PostButton);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		PostButtonPanel.add(horizontalStrut_7);
	}

	public void makeCommentList() {
		CommentListPanel.removeAll();

		Comment[] comments = this.controller.getCommentList();
		int length = 0;
		if(comments != null) {
			length = comments.length;
		}

		int size = length > 5 ? length : 5;

		GridBagLayout gbl_CommentListPanel = new GridBagLayout();
		gbl_CommentListPanel.columnWidths = new int[]{0, 0};
		gbl_CommentListPanel.rowHeights = new int[size + 1];
		gbl_CommentListPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_CommentListPanel.rowWeights = new double[size + 1];
		CommentListPanel.setLayout(gbl_CommentListPanel);
		
		CommentPanel[] commentPanel = new CommentPanel[size];
		for(int i = 0; i < size; i++) {
			gbl_CommentListPanel.rowHeights[i] = 50;

			if(i < length) {
				commentPanel[i] = new CommentPanel(CommentListPanel, comments[i].getAuthor().getID(), comments[i].getText(), i);
			}
		}

		gbl_CommentListPanel.rowHeights[size] = 0;
		gbl_CommentListPanel.rowWeights[size] = Double.MIN_VALUE;

		revalidate();
		repaint();
	}

	public void setIssueInfo(Issue issue){
		reporterLable.setText("Reporter : " + issue.getReporter().getID());
		typeInfoLable.setText(", Type : " + issue.getType().toString());
		priorityLable.setText(", Priority : " + issue.getPriority().toString());
		FixerLable.setText(", Fixer : " + (issue.getFixer() == null ? "" : issue.getFixer().getID()));

		IssueName.setText(issue.getTitle());
		IssueDescription.setText(issue.getDescription());

		if(issue.getStatus() != null) {
			statusComboBox.setSelectedItem(issue.getStatus().toString());
		}

		assigneeComboBox.removeAllItems();
		for(String name : this.controller.getDeveloperList()){
			assigneeComboBox.addItem(name);
		}
		if(issue.getAssignee() != null) {
			assigneeComboBox.setSelectedItem(issue.getAssignee().toString());
		}

		revalidate();
		repaint();
	}
	
	class CommentPanel extends JPanel {
		CommentPanel(JPanel GbcPanel, String writerName, String commentText, int index){
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

			GridBagConstraints gbc_CommentPanel = new GridBagConstraints();
			gbc_CommentPanel.insets = new Insets(0, 0, 5, 0);
			gbc_CommentPanel.fill = GridBagConstraints.BOTH;
			gbc_CommentPanel.gridx = 0;
			gbc_CommentPanel.gridy = index;
			GbcPanel.add(this, gbc_CommentPanel);
		}
	}
}