package Lesson09_KlickLoss;

import sweeper.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JFrame {

    static public Cell[][] playField;

    private static final int IMAGE_SIZE = 50;
    protected static final int COLS = 10;
    static final int ROWS = 10;
    private static final int BOMB = 10;

    public GameField() throws HeadlessException {
        super("Игровое Поле");
        super.setBounds(250, 250, 500, 530);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyComponent myComponent = new MyComponent();

        super.add(myComponent);

        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                myComponent.xCord = mouseEvent.getX();
                myComponent.yCord = mouseEvent.getY();
                if (mouseEvent.getButton() == MouseEvent.BUTTON1){
                    if (myComponent.xCord > 0 && myComponent.xCord < 500 && myComponent.yCord > 0 && myComponent.yCord < 530){

                        GameField.playField[(int) myComponent.xCord/50][(int) (myComponent.yCord-30)/50].setStatusClosed(false);
                        System.out.println("нажато x -" +((int) myComponent.xCord/50)+" y -" +((int) (myComponent.yCord-30)/50));

                        GameField.super.setVisible(false);
                        GameField.super.setVisible(true);
                    }
                }else {
                    if (myComponent.xCord > 0 && myComponent.xCord < 500 && myComponent.yCord > 0 && myComponent.yCord < 530){
                        GameField.playField[(int) myComponent.xCord/50][(int) (myComponent.yCord-30)/50].setCellImage("flaged");


                        GameField.super.setVisible(false);
                        GameField.super.setVisible(true);
                    }
                }


            }
        });

        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent event ) {
                if (event.getButton() == MouseEvent.BUTTON3){

                }

            }
        });

        genMatrix ();
        generatBomb();


    }

    private  static void genMatrix (){
         playField = new Cell[COLS][ROWS];
         int count = 0;
         for (int x=0; x< COLS; x++) {
             for (int y=0; y< ROWS; y++) {
                playField[x][y] = new Cell(count, x,y,"closed");
                count++;
             }
         }
        System.out.println(" Матрица Игрового поля сгененирована");
    }

     private void generatBomb(){
        int coumtBomb = 0;
        while (coumtBomb < BOMB){
            int x = random(COLS);
            int y = random(ROWS);
            if (!playField[x][y].isStatusBomb()){
                playField[x][y].setStatusBomb(true);
                System.out.println("coumtBomb - "+ coumtBomb + "; x - "+x+ "; y - " +y);
                coumtBomb++;
            }
        }
    }
    static public int random(int i){
        return  (int)(Math.random() * i);
    }



}
