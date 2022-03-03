package Lesson06_Enum;

import javax.swing.*;
import java.awt.*;

public class MyComponent extends JComponent {
     public static int xCord;
     public static int yCord;
     public static int count = 1;



    //Метод paintComponent запускается автомотически
    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon icon = new ImageIcon("res/images/bomb.png");
        Image cellImage = icon.getImage();
//        g.drawImage(getImage("flaged"),((int)xCord/50)*50,(((int)yCord-30)/50)*50, null);
        g.drawImage(getImage( Box.FLAGED),((int)xCord/50)*50,(((int)yCord-30)/50)*50, null);
    }
    private Image getImage(){
        ImageIcon icon = new ImageIcon("res/images/flaged.png");
        return icon.getImage();
    }
    static  private Image getImage(String imagName){
        ImageIcon icon = new ImageIcon("res/images/"+imagName+".png");
        return icon.getImage();
    }

    static  private Image getImage(Box imagName){
        ImageIcon icon = new ImageIcon("res/images/"+imagName.name().toLowerCase() +".png");
        return icon.getImage();
    }
}
