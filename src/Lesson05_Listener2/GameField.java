package Lesson05_Listener2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JFrame {
    public GameField() throws HeadlessException {
        super("Игровое Поле");
        super.setBounds(250,250,500,530);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyComponent myComponent = new MyComponent();

        super.add(myComponent);
//
        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                myComponent.xCord = mouseEvent.getX();
                myComponent.yCord = mouseEvent.getY();
//                if(myComponent.xCord>0 && myComponent.xCord<100 && myComponent.yCord>0 && myComponent.yCord<130){
//                    myComponent.count ++;
//                    System.out.println("Count - "+ myComponent.count+ ", x - " + myComponent.xCord + ", y - " + myComponent.yCord);
//                    GameField.super.setVisible(false);
//                    GameField.super.setVisible(true);
//                }
                if(myComponent.xCord>0 && myComponent.xCord<500 && myComponent.yCord>0 && myComponent.yCord<530){
                    myComponent.count ++;
                    System.out.println("Count - "+ myComponent.count+ ", x - " + myComponent.xCord + ", y - " + myComponent.yCord);
                    GameField.super.setVisible(false);
                    GameField.super.setVisible(true);
                }

            }
        });



    }
}