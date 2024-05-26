package com.example.its.swingUI;

import org.springframework.stereotype.Component;

import javax.swing.JPanel;


public interface BaseController {
    void popStack();
    void setPanel(JPanel targetPanel);
    void run();
}
