package com.example.its.swingUI;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import com.example.its.dataClass.User;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Comment;
import org.springframework.stereotype.Component;


public abstract class BaseController {
    protected BaseFrameController baseFrameController;
    protected LoginFrameController loginFrameController;


    protected BaseController() {
        this.baseFrameController = new BaseFrameController(this);
        this.loginFrameController = new LoginFrameController(this);
    }

    public void run(){
        if(frame == null){
            this.frame = new BaseFrame();
        }

        frame.setVisible(true);
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
