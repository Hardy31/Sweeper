package Lesson03_Refactoring;

import javax.swing.*;
import java.awt.*;

public class GameField extends JFrame {
    public GameField() throws HeadlessException {
        super("Игровое Поле");
        super.setBounds(250,250,500,530);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyComponent myComponent = new MyComponent();
        super.add(myComponent);


    }
}
