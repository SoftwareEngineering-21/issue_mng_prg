package com.example.its.swingUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import lombok.RequiredArgsConstructor;

public class MakeProjectFrame extends JFrame {
	private final MakeProjectController controller;

    private JTextField titleText;
    private JTextArea decsText;

	class PostButtonAction implements ActionListener{
		JFrame frame;

		PostButtonAction(JFrame frame){
			this.frame = frame;
		}

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Post to Server");
			if(titleText.getText().length() <= 100){
				controller.makeNewProject(titleText.getText(), decsText.getText());
				frame.dispose();
			}
			else{
				
			}
        }
    }

    MakeProjectFrame(MakeProjectController controller){
		this.controller = controller;

		setTitle("Make Project");
		BorderLayout borderLayout = (BorderLayout) this.getContentPane().getLayout();
		borderLayout.setVgap(5);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel ButtonPanel = new JPanel();
		getContentPane().add(ButtonPanel, BorderLayout.NORTH);
		ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		ButtonPanel.add(horizontalStrut);
		
		JButton BackButton = new JButton("Back");
		ButtonPanel.add(BackButton);
        BackButton.addActionListener(new BackButtonAction(this));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		ButtonPanel.add(horizontalGlue);
		
		JButton PostButton = new JButton("Post");
		ButtonPanel.add(PostButton);
        PostButton.addActionListener(new PostButtonAction(this));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		ButtonPanel.add(horizontalStrut_1);
		
		JPanel ProjectInfoPanel = new JPanel();
		getContentPane().add(ProjectInfoPanel, BorderLayout.CENTER);
		ProjectInfoPanel.setLayout(new BorderLayout(0, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		ProjectInfoPanel.add(scrollPane, BorderLayout.CENTER);
		
		decsText = new JTextArea();
		decsText.setToolTipText("Desc");
		decsText.setLineWrap(true);
		scrollPane.setViewportView(decsText);
		
		titleText = new JTextField();
		titleText.setToolTipText("Title");
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		ProjectInfoPanel.add(titleText, BorderLayout.NORTH);
		titleText.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		getContentPane().add(verticalStrut, BorderLayout.SOUTH);
	}

	@RequiredArgsConstructor
    class BackButtonAction implements ActionListener{
		private final JFrame frame;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Back");
			frame.dispose();
        }
        
    }
}
