package com.example.its.swingUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import javax.swing.JPanel;

@Component
public class BaseFrameController {
    protected BaseController controller;

    private BaseFrame frame;
    private ArrayList<JPanel> stack = new ArrayList<>();

    @Autowired
    public BaseFrameController(BaseController controller){
        this.controller = controller;
        System.setProperty("java.awt.headless", "false");

        this.frame = new BaseFrame(this);
    }

    public boolean logout(){
        boolean result = controller.logout();
        if(result){
            this.frame.dispose();
            controller.run();
        }
        return result;
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

        if(frame.isFull()){
            stack.add(frame.getMainPanel());
        }

        frame.setPanel(targetPanel);
        
        frame.revalidate();
        frame.repaint();
    }

    public void popStack(){
        int i = stack.size();
        if(i < 1){
            return;
        }

        frame.setPanel(stack.get(i - 1));
        
        frame.revalidate();
        frame.repaint();

        this.stack.remove(i - 1);
    }

    public boolean isEmptyMainPanel(){
        return frame.isEmptyMainPanel();
    }
}
