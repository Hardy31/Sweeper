package Lesson12_Refactoring;

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
                        System.out.println("нажато x -" +((int) myComponent.xCord/50)+" y -" +((int) (myComponent.yCord-30)/50) + " lm = " + GameField.playField[(int) myComponent.xCord/50][(int) (myComponent.yCord-30)/50].getCellImage());

//                        GameField.super.setVisible(false);
//                        GameField.super.setVisible(true);
                    }
                }else {
//                    if (myComponent.xCord > 0 && myComponent.xCord < 500 && myComponent.yCord > 0 && myComponent.yCord < 530){
//
//
//                        if (GameField.playField[(int) myComponent.xCord/50][(int) (myComponent.yCord-30)/50].getCellImage().equals("flaged")){
//                            GameField.playField[(int) myComponent.xCord/50][(int) (myComponent.yCord-30)/50].setCellImage("closed");
//                            System.out.println("нажато Правая2 x -" +((int) myComponent.xCord/50)+" y -" +((int) (myComponent.yCord-30)/50));
//                        } else  {
//                            GameField.playField[(int) myComponent.xCord/50][(int) (myComponent.yCord-30)/50].setCellImage("flaged");
//                            System.out.println("нажато ПраваяЯ x -" +((int) myComponent.xCord/50)+" y -" +((int) (myComponent.yCord-30)/50));
//                        }
//
//
////
////                        GameField.super.setVisible(false);
////                        GameField.super.setVisible(true);
//
//
//                    }


                }
                GameField.super.setVisible(false);
                GameField.super.setVisible(true);


            }
        });

        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent event ) {
                if (event.getButton() == MouseEvent.BUTTON3) {
                    boolean ststusOpen = !GameField.playField[(int) myComponent.xCord / 50][(int) (myComponent.yCord - 30) / 50].isStatusClosed();
                    if (myComponent.xCord > 0 && myComponent.xCord < 500 && myComponent.yCord > 0 && myComponent.yCord < 530 &&  !ststusOpen) {


                        if (GameField.playField[(int) myComponent.xCord / 50][(int) (myComponent.yCord - 30) / 50].getCellImage().equals("flaged")) {
//                            GameField.playField[(int) myComponent.xCord / 50][(int) (myComponent.yCord - 30) / 50].setCellImage("zero");
                            recoveryImage((int) myComponent.xCord / 50, (int) (myComponent.yCord - 30) / 50 );
                            System.out.println("нажато Правая2 x -" + ((int) myComponent.xCord / 50) + " y -" + ((int) (myComponent.yCord - 30) / 50));
                        } else {
                            GameField.playField[(int) myComponent.xCord / 50][(int) (myComponent.yCord - 30) / 50].setCellImage("flaged");
                            System.out.println("нажато ПраваяЯ x -" + ((int) myComponent.xCord / 50) + " y -" + ((int) (myComponent.yCord - 30) / 50));
                        }


                        GameField.super.setVisible(false);
                        GameField.super.setVisible(true);


                    }

                }
            }
        });

        genMatrix ();
        generatBomb();
        generatBombNearby();


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

    private void recoveryImage(int x, int y){
        int bombsNearby = playField[x][y].getBombsNearby();
        switch (bombsNearby){
            case 0: playField[x][y].setCellImage(Box.ZERO.toString().toLowerCase());
                break;
            case 1 : playField[x][y].setCellImage(Box.NUM1.toString().toLowerCase());
                break;
            case 2 : playField[x][y].setCellImage(Box.NUM2.toString().toLowerCase());
                break;
            case 3 : playField[x][y].setCellImage(Box.NUM3.toString().toLowerCase());
                break;
            case 4 : playField[x][y].setCellImage(Box.NUM4.toString().toLowerCase());
                break;
            case 5 : playField[x][y].setCellImage(Box.NUM5.toString().toLowerCase());
                break;
            case 6 : playField[x][y].setCellImage(Box.NUM6.toString().toLowerCase());
                break;
            case 7 : playField[x][y].setCellImage(Box.NUM7.toString().toLowerCase());
                break;
            case 8 : playField[x][y].setCellImage(Box.NUM8.toString().toLowerCase());
                break;
        }
    }

    private void generatBombNearby(){
        for (int x=0; x< COLS; x++) {
            for (int y=0; y< ROWS; y++) {
                if (!playField[x][y].isStatusBomb()){
                    int bombsNearby = 0;
                    for (int i=x-1; i<=x+1; i++) {
                        for (int j=y-1; j<= y+1; j++) {

                            if(i>=0 && i<COLS && j >=0 && j<ROWS  ){
                                if (playField[i][j].isStatusBomb()){
                                    bombsNearby = playField[x][y].getBombsNearby() + 1;
                                    playField[x][y].setBombsNearby(bombsNearby);
                                }

                            }

                        }
                    }
                    switch (bombsNearby){
                        case 0: playField[x][y].setCellImage(Box.ZERO.toString().toLowerCase());
                            break;
                        case 1 : playField[x][y].setCellImage(Box.NUM1.toString().toLowerCase());
                            break;
                        case 2 : playField[x][y].setCellImage(Box.NUM2.toString().toLowerCase());
                            break;
                        case 3 : playField[x][y].setCellImage(Box.NUM3.toString().toLowerCase());
                            break;
                        case 4 : playField[x][y].setCellImage(Box.NUM4.toString().toLowerCase());
                            break;
                        case 5 : playField[x][y].setCellImage(Box.NUM5.toString().toLowerCase());
                            break;
                        case 6 : playField[x][y].setCellImage(Box.NUM6.toString().toLowerCase());
                            break;
                        case 7 : playField[x][y].setCellImage(Box.NUM7.toString().toLowerCase());
                            break;
                        case 8 : playField[x][y].setCellImage(Box.NUM8.toString().toLowerCase());
                            break;
                    }
                }
            }
        }
    }




}
