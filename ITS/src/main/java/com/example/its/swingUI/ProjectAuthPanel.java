package com.example.its.swingUI;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.example.its.dataClass.User;

public class ProjectAuthPanel extends JPanel {
	private final ProjAuthSceneController controller;

	private JTextField TesterTextField;
	private JTextField PlayerTextField;
	private JTextField DeveloperTextFeild;

    private JPanel TesterInfoListPanel; 
    private JPanel PlayerInfoListPanel;
    private JPanel DeveloperInfoListPanel;

    ProjectAuthPanel(ProjAuthSceneController controller){
		this.controller = controller;

        JPanel ProjectNamePanel = new JPanel();
		add(ProjectNamePanel, BorderLayout.NORTH);
		ProjectNamePanel.setLayout(new BoxLayout(ProjectNamePanel, BoxLayout.X_AXIS));
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 40));
		ProjectNamePanel.add(rigidArea);
		
		JLabel ProjectNameLabel = new JLabel("Project Name");
		ProjectNamePanel.add(ProjectNameLabel);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		ProjectNamePanel.add(horizontalGlue);
		
		JButton BackButton = new JButton("Back");
		ProjectNamePanel.add(BackButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		ProjectNamePanel.add(horizontalStrut);
		
		JButton PostButton = new JButton("Post");
		ProjectNamePanel.add(PostButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		ProjectNamePanel.add(horizontalStrut_1);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel AuthorityPanel = new JPanel();
		scrollPane.setViewportView(AuthorityPanel);
		AuthorityPanel.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel TestPanel = new JPanel();
		AuthorityPanel.add(TestPanel);
		TestPanel.setLayout(new BoxLayout(TestPanel, BoxLayout.Y_AXIS));
		
		JPanel Test = new JPanel();
		Test.setBorder(new LineBorder(new Color(0, 0, 0)));
		TestPanel.add(Test);
		Test.setLayout(new BoxLayout(Test, BoxLayout.X_AXIS));
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		Test.add(horizontalStrut_2);
		
		JLabel TesterLabel = new JLabel("Tester");
		Test.add(TesterLabel);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		Test.add(horizontalStrut_10);
		
		TesterTextField = new JTextField();
		TesterTextField.setColumns(1);
		Test.add(TesterTextField);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		Test.add(horizontalStrut_3);
		
		JButton TesterAddButton = new JButton("Add");
		Test.add(TesterAddButton);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		Test.add(horizontalStrut_4);
		
		TesterInfoListPanel = new JPanel();
		TesterInfoListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		TestPanel.add(TesterInfoListPanel);
		
		JPanel PlayerPanel = new JPanel();
		AuthorityPanel.add(PlayerPanel);
		PlayerPanel.setLayout(new BoxLayout(PlayerPanel, BoxLayout.Y_AXIS));
		
		JPanel Player = new JPanel();
		Player.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlayerPanel.add(Player);
		Player.setLayout(new BoxLayout(Player, BoxLayout.X_AXIS));
		
		Component horizontalStrut_2_1 = Box.createHorizontalStrut(20);
		Player.add(horizontalStrut_2_1);
		
		JLabel PlayerLabel = new JLabel("Player");
		Player.add(PlayerLabel);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		Player.add(horizontalStrut_9);
		
		PlayerTextField = new JTextField();
		PlayerTextField.setColumns(1);
		Player.add(PlayerTextField);
		
		Component horizontalStrut_3_1 = Box.createHorizontalStrut(20);
		Player.add(horizontalStrut_3_1);
		
		JButton PlayerAddButton_1 = new JButton("Add");
		Player.add(PlayerAddButton_1);
		
		Component horizontalStrut_4_1 = Box.createHorizontalStrut(20);
		Player.add(horizontalStrut_4_1);
		
		PlayerInfoListPanel = new JPanel();
		PlayerInfoListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlayerPanel.add(PlayerInfoListPanel);
		GridBagLayout gbl_PlayerInfoListPanel = new GridBagLayout();
		gbl_PlayerInfoListPanel.columnWidths = new int[] {0};
		gbl_PlayerInfoListPanel.rowHeights = new int[] {30, 30};
		gbl_PlayerInfoListPanel.columnWeights = new double[]{1.0};
		gbl_PlayerInfoListPanel.rowWeights = new double[]{0.0, 1.0};
		PlayerInfoListPanel.setLayout(gbl_PlayerInfoListPanel);
		
		JPanel DeveloperPanel = new JPanel();
		AuthorityPanel.add(DeveloperPanel);
		DeveloperPanel.setLayout(new BoxLayout(DeveloperPanel, BoxLayout.Y_AXIS));
		
		JPanel Developer = new JPanel();
		Developer.setBorder(new LineBorder(new Color(0, 0, 0)));
		DeveloperPanel.add(Developer);
		Developer.setLayout(new BoxLayout(Developer, BoxLayout.X_AXIS));
		
		Component horizontalStrut_2_1_1 = Box.createHorizontalStrut(20);
		Developer.add(horizontalStrut_2_1_1);
		
		JLabel DeveloperLabel = new JLabel("Developer");
		Developer.add(DeveloperLabel);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		Developer.add(horizontalStrut_8);
		
		DeveloperTextFeild = new JTextField();
		Developer.add(DeveloperTextFeild);
		DeveloperTextFeild.setColumns(1);
		
		Component horizontalStrut_3_1_1 = Box.createHorizontalStrut(20);
		Developer.add(horizontalStrut_3_1_1);
		
		JButton DeveloperAddButton = new JButton("Add");
		Developer.add(DeveloperAddButton);
		
		Component horizontalStrut_4_1_1 = Box.createHorizontalStrut(20);
		Developer.add(horizontalStrut_4_1_1);
		
		DeveloperInfoListPanel = new JPanel();
		DeveloperInfoListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		DeveloperPanel.add(DeveloperInfoListPanel);
		GridBagLayout gbl_DeveloperInfoListPanel = new GridBagLayout();
		gbl_DeveloperInfoListPanel.columnWidths = new int[] {0};
		gbl_DeveloperInfoListPanel.rowHeights = new int[] {30, 30};
		gbl_DeveloperInfoListPanel.columnWeights = new double[]{1.0};
		gbl_DeveloperInfoListPanel.rowWeights = new double[]{0.0, 1.0};
		DeveloperInfoListPanel.setLayout(gbl_DeveloperInfoListPanel);

        setList();
    }

    void setList(){
		TesterInfoListPanel.removeAll();
		PlayerInfoListPanel.removeAll();
		DeveloperInfoListPanel.removeAll();

		User testers[] = controller.getTesterList();
		GridBagLayout gbl_TesterInfoListPanel = new GridBagLayout();
		gbl_TesterInfoListPanel.columnWidths = new int[] {0};
		gbl_TesterInfoListPanel.rowHeights = new int[testers.length];
		gbl_TesterInfoListPanel.columnWeights = new double[]{1.0};
		gbl_TesterInfoListPanel.rowWeights = new double[]{1.0, 1.0};

		for(int i = 0; i < testers.length; i++){
			gbl_TesterInfoListPanel.rowHeights[i] = 30;
			new TesterInfoPanel(TesterInfoListPanel, "Tester Name", i);
		}
		TesterInfoListPanel.setLayout(gbl_TesterInfoListPanel);



        revalidate();
        repaint();
    }

    class TesterInfoPanel extends JPanel{
        TesterInfoPanel(JPanel ListPanel, String name, int index){
            setBorder(new LineBorder(new Color(0, 0, 0)));
            GridBagConstraints gbc_TesterInfoPanel = new GridBagConstraints();
            gbc_TesterInfoPanel.insets = new Insets(5, 0, 0, 0);
            gbc_TesterInfoPanel.fill = GridBagConstraints.BOTH;
            gbc_TesterInfoPanel.gridx = 0;
            gbc_TesterInfoPanel.gridy = index;
            ListPanel.add(this, gbc_TesterInfoPanel);
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

            Component horizontalStrut_5 = Box.createHorizontalStrut(20);
            add(horizontalStrut_5);
            
            JLabel TesterNameLabel = new JLabel(name);
            add(TesterNameLabel);
            
            Component horizontalGlue_2 = Box.createHorizontalGlue();
            add(horizontalGlue_2);
            
            JButton DeleteButton = new JButton("X");
            DeleteButton.addActionListener(new DeleteTesterAction());
            add(DeleteButton);
            
            Component horizontalStrut_7 = Box.createHorizontalStrut(20);
            add(horizontalStrut_7);
        }

        class DeleteTesterAction implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
    }

    class PlayerInfoPanel extends JPanel{
        PlayerInfoPanel(JPanel ListPanel, String name, int index){
            setBorder(new LineBorder(new Color(0, 0, 0)));
            GridBagConstraints gbc_PlayerInfoPanel = new GridBagConstraints();
            gbc_PlayerInfoPanel.insets = new Insets(5, 0, 0, 0);
            gbc_PlayerInfoPanel.fill = GridBagConstraints.BOTH;
            gbc_PlayerInfoPanel.gridx = 0;
            gbc_PlayerInfoPanel.gridy = index;
            ListPanel.add(this, gbc_PlayerInfoPanel);
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            
            Component horizontalStrut_5_1 = Box.createHorizontalStrut(20);
            add(horizontalStrut_5_1);
            
            JLabel PlayerNameLabel = new JLabel(name);
            add(PlayerNameLabel);
            
            Component horizontalGlue_2_1 = Box.createHorizontalGlue();
            add(horizontalGlue_2_1);
            
            JButton PlayerDeleteButton = new JButton("X");
            PlayerDeleteButton.addActionListener(new DeletePlayerAction());
            add(PlayerDeleteButton);
            
            Component horizontalStrut_6 = Box.createHorizontalStrut(20);
            add(horizontalStrut_6);
        }

        class DeletePlayerAction implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
    }

    class DeveloperInfoPanel extends JPanel{
        DeveloperInfoPanel(JPanel ListPanel, String name, int index){
            setBorder(new LineBorder(new Color(0, 0, 0)));
            GridBagConstraints gbc_DeveloperInfoPanel = new GridBagConstraints();
            gbc_DeveloperInfoPanel.fill = GridBagConstraints.BOTH;
            gbc_DeveloperInfoPanel.insets = new Insets(5, 0, 0, 0);
            gbc_DeveloperInfoPanel.gridx = 0;
            gbc_DeveloperInfoPanel.gridy = index;
            ListPanel.add(this, gbc_DeveloperInfoPanel);
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            
            Component horizontalStrut_5_1_1 = Box.createHorizontalStrut(20);
            add(horizontalStrut_5_1_1);
            
            JLabel DeveloperNameLabel = new JLabel(name);
            add(DeveloperNameLabel);
            
            Component horizontalGlue_2_1_1 = Box.createHorizontalGlue();
            add(horizontalGlue_2_1_1);
            
            JButton DeveloperDeleteButton = new JButton("X");
            DeveloperDeleteButton.addActionListener(new DeleteDeveloperAction());
            add(DeveloperDeleteButton);
            
            Component horizontalStrut_6_1 = Box.createHorizontalStrut(20);
            add(horizontalStrut_6_1);
        }

        class DeleteDeveloperAction implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {

            }
            
        }
    }
}
