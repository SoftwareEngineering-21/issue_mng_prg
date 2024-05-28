package com.example.its.swingUI;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import javax.swing.JPanel;

@Component
public class BaseFrameController {
    protected BaseController controller;

    private BaseFrame frame;
    private ArrayList<JPanel> stack = new ArrayList<>();

    public BaseFrameController(BaseController controller){
        this.controller = controller;

        this.frame = new BaseFrame(this);
    }

    public boolean logout(){
        return controller.logout();
    }

    public void run(){
        if(frame == null){
            this.frame = new BaseFrame(this);
        }

        frame.setVisible(true);
    }

    public void setVisible(boolean turn){
        this.frame.setVisible(turn);
    }
    
    public void setPanel(JPanel targetPanel){
        if(targetPanel == null){
            return;
        }
        
        stack.add((JPanel)frame.getContentPane().getComponent(0));

        frame.setPanel(targetPanel);
        
        frame.revalidate();
        frame.repaint();
    }

    public void popStack(){
        int i = stack.size() - 1;
        if(i < 0){
            return;
        }

        frame.getContentPane().removeAll();
        frame.getContentPane().add(stack.get(i));
        this.stack.remove(i);
    }

    public boolean isEmptyMainPanel(){
        return frame.isEmptyMainPanel();
    }
}
