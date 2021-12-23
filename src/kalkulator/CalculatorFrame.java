package kalkulator;

import javax.swing.*;

public class CalculatorFrame extends JFrame {

    CalculatorFrame(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        int height = 600;
        int width = 450;
        setSize(width, height);
        setVisible(true);
        setLocationRelativeTo(null);

        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
    }
}
