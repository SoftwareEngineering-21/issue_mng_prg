package com.example.its.swingUI;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import javax.swing.JPanel;

@Component
public class TestBaseCon implements BaseController {
    private BaseFrame frame;
    
    private ArrayList<JPanel> stack = new ArrayList<>();

    public TestBaseCon(){
        frame = new BaseFrame();

    }

    @Override
    public void run(){
        frame.setVisible(true);
    }
    
    @Override
    public void setPanel(JPanel targetPanel){
        if(targetPanel == null){
            return;
        }
        
        stack.add((JPanel)frame.getContentPane().getComponent(0));

        frame.setPanel(targetPanel);
        
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void popStack(){
        int i = stack.size() - 1;
        if(i < 0){
            return;
        }

        frame.getContentPane().removeAll();
        frame.getContentPane().add(stack.get(i));
        this.stack.remove(i);
    }
}
