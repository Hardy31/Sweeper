package Lesson12_Refactoring;

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

         //выведем бомбы  на игровое поле.
        for (int x = 0; x< GameField.COLS ; x++) {
            for (int y = 0; y< GameField.ROWS; y++) {

//                //прорисовываем ячейки с бомбами
//                if (GameField.playField[x][y].isStatusBomb() ){
//                    g.drawImage(getImage("bombed"), x*50,y*50, null);
//                }
                //открываем нажатые ячейки
                if (!GameField.playField[x][y].isStatusClosed() ){
                    //

                    g.drawImage(getImage(GameField.playField[x][y].getCellImage()), x*50,y*50, null);

                }
                //Взрываем нажатые бомбы
                if (!GameField.playField[x][y].isStatusClosed() && GameField.playField[x][y].isStatusBomb()){
                    g.drawImage(getImage("bombed"), x*50,y*50, null);
                }

                //правая кнопка на пустом- флаг
                if (GameField.playField[x][y].isStatusClosed() && (GameField.playField[x][y].getCellImage()).equals("flaged")){
                    g.drawImage(getImage("flaged"), x*50,y*50, null);
                }
//                //правая кнопка на флаге - пусто
//                if (GameField.playField[x][y].isStatusClosed() && (GameField.playField[x][y].getCellImage()).equals("closed")){
//                    g.drawImage(getImage("closed"), x*50,y*50, null);
//                }

            }
        }

//        g.drawImage(getImage("flaged"),((int)xCord/50)*50,(((int)yCord-30)/50)*50, null);
    }
    private Image getImage(){
        ImageIcon icon = new ImageIcon("res/images/flaged.png");
        return icon.getImage();
    }

    static  private Image getImage(String imagName){
        ImageIcon icon = new ImageIcon("res/images/"+imagName+".png");
        return icon.getImage();
    }

    private int bombNearbu(int x, int y){
        return GameField.playField[x][y].getBombsNearby();

    }
}
