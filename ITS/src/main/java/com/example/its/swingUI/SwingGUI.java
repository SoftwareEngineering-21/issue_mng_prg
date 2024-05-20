package com.example.its.swingUI;

import com.example.its.dataClass.Project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingGUI {
    ProjectController controller;

    JFrame window;
    JFrame additionalFrame;
    JPanel outputPanel;

    MainScenePanel mainScene;
    ProjectScenePanel projectScene;
    IssueScenePanel issueScene;

    enum PanelIndex { PROJECTSCENE, MAINSCENE, ISSUESCENE };

    public SwingGUI(ProjectController controller){
        this.controller = controller;

        this.mainScene = new MainScenePanel(this);
        this.projectScene = new ProjectScenePanel();
        this.issueScene = new IssueScenePanel();

        this.outputPanel = mainScene;
        MakeJFrame();
    }

    void MakeJFrame(){
        window = new JFrame("Issue Manager");
		BorderLayout borderLayout = (BorderLayout) window.getContentPane().getLayout();
		borderLayout.setVgap(5);
		window.setBounds(100, 100, 1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel UserInfoPanel = new JPanel();
		window.getContentPane().add(UserInfoPanel, BorderLayout.NORTH);
		UserInfoPanel.setLayout(new BoxLayout(UserInfoPanel, BoxLayout.X_AXIS));
		
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
		panel.add(btnNewButton);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_6);

        window.getContentPane().add(outputPanel, BorderLayout.CENTER);
    }

    public void setVisible(boolean value){
        window.setVisible(value);
    }

    public void change(PanelIndex targetPanel){
        window.getContentPane().remove(outputPanel);
        switch (targetPanel) {
            case PanelIndex.PROJECTSCENE:
                outputPanel = this.mainScene;
                break;
            case PanelIndex.MAINSCENE:
                outputPanel = this.projectScene;
                break;
            case PanelIndex.ISSUESCENE:
                outputPanel = this.issueScene;
                break;
            default:
                break;
        }
        
        window.getContentPane().add(outputPanel);
        window.repaint();
    }

    public void repaint(){
        System.out.println("call");
        mainScene.makeProjectList();
        mainScene.repaint();
    }

    ArrayList<Project> getProjectList(){
        return controller.getProjectList();
    }

    void callMakeProjecFrame(){
        if(additionalFrame != null){
            additionalFrame.dispose();
        }
        additionalFrame = new MakeProjectFrame(this);
        additionalFrame.setVisible(true);
    }

    void makeNewProject(String title, String decs){
        controller.makeNewProject(title, decs);
    }
}
