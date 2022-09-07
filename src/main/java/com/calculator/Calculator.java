package com.calculator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton addButton = new JButton("Addition");
    JButton subtractButton = new JButton("Subtraction");
    JButton multiplyButton = new JButton("Multiplication");
    JButton divideButton = new JButton("Division");
    JTextField field1String = new JTextField(20);
    JTextField field2String = new JTextField(20);
    JLabel label = new JLabel();
    
    void setup(){
        frame.add(panel);
        panel.add(field1String);
        panel.add(field2String);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        frame.pack();
    }  

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setup();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int field1 = Integer.parseInt(field1String.getText());
        int field2 = Integer.parseInt(field2String.getText());
        if(e.getSource()==addButton){
            String addF = String.valueOf((field1)+(field2));
            label.setText(addF);
        }else if(e.getSource()==subtractButton){
            String subF = String.valueOf((field1)-(field2));
            label.setText(subF);
        }else if(e.getSource()==multiplyButton){
            String mulF = String.valueOf((field1)*(field2));
            label.setText(mulF);
        }else if(e.getSource()==divideButton){
            String divF = String.valueOf((field1)/(field2));
            label.setText(divF);
        }
        
    }
}

