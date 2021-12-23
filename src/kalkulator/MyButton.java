package kalkulator;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    MyButton(int x, int y, int width,int height,String text){
        setBounds(x,y,width,height);
        setText(text);
        setFont(new Font("Serif", Font.BOLD, 26));
        setVisible(true);
    }
}
