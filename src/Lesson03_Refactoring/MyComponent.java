package Lesson03_Refactoring;

import javax.swing.*;
import java.awt.*;

public class MyComponent extends JComponent {
    //Метод paintComponent запускается автомотически
    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon icon = new ImageIcon("res/images/bomb.png");
        Image cellImage = icon.getImage();
        g.drawImage(cellImage, 0, 50, this);
        g.drawImage(getImage(),0,0, this);
        g.drawImage(getImage(""),0,300, null);
    }
    private Image getImage(){
        ImageIcon icon = new ImageIcon("res/images/flaged.png");
        return icon.getImage();
    }
    static  private Image getImage(String imagName){
        ImageIcon icon = new ImageIcon("res/images/"+imagName+".png");
        return icon.getImage();
    }
}
