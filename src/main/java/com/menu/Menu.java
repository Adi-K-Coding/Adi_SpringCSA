package com.menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Menu {
    JFrame frame = new JFrame("Math Functions");
    void setup() {
        boolean running = true;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] functionOptions = { "GCF", "Factorial", "Addition", "Multiplication", "Exit" };
        while (running) {
            int menuX = JOptionPane.showOptionDialog(frame, "Select a function to perform",
                    "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, functionOptions,
                    functionOptions[4]);
            if (menuX == 0) {
                System.out.println("GCF");
            } else if (menuX == 1) {
                System.out.println("Factorial");
                String inp = JOptionPane.showInputDialog("Enter num for factorial");
                int inp1 = Integer.parseInt(inp);
                int finalNum = 1;
                for (int i = 1; i < inp1+1; i++) {
                    finalNum = finalNum*i;
                }
                JOptionPane.showMessageDialog(null, "Factorial of " + inp1 + " is " + finalNum);
            } else if (menuX == 2) {
                System.out.println("Addition");
                String add1 = JOptionPane.showInputDialog("Enter num 1 ");
                String add2 = JOptionPane.showInputDialog("Enter num2");
                int add1int = Integer.parseInt(add1);
                int add2int = Integer.parseInt(add2);
                JOptionPane.showMessageDialog(null,
                        "Sum of " + add1int + " and " + add2int + " is " + (add1int + add2int));
            } else if (menuX == 3) {
                System.out.println("Multiplication");
                String mult1 = JOptionPane.showInputDialog("Enter num 1 ");
                String mult2 = JOptionPane.showInputDialog("Enter num2");
                int mult1int = Integer.parseInt(mult1);
                int mult2int = Integer.parseInt(mult2);
                JOptionPane.showMessageDialog(null,
                        "Sum of " + mult1int + " and " + mult2int + " is " + (mult1int * mult2int));
            } else if (menuX == 4) {
                System.out.println("Exiting Menu");
                running = false;
            }
        }
    }

    public static void main(String[] args) {
        Menu m = new Menu();
        m.setup();
    }

}
