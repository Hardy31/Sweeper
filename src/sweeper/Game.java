package sweeper;


import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Game {

    private static final int IMAGE_SIZE = 50;
    private static final int COLS = 10;
    private static final int ROWS = 10;
    private static final int BOMB = 80;


    private static Cell[][] playField = new PlayField(COLS,ROWS).getPlayField();

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setIconImage(new ImageIcon("res/images/icon.png").getImage());
        myFrame.setTitle("Java Sweeper Hardy");
//        setLocationRelativeTo(null);
        myFrame.setVisible(true);
//        setResizable(false);
        myFrame.setSize(COLS*IMAGE_SIZE,ROWS*IMAGE_SIZE+305);

//        pack();
        myFrame.setLocationRelativeTo(null);


        generatBomb(BOMB);
        myFrame.add(new MyComponent());


    }
    static class MyComponent extends JComponent{
        @Override
        protected void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;

            for (int x=0; x< COLS; x++) {
                for (int y=0; y< ROWS; y++) {




                    if (playField[x][y].isStatusBomb()){
                        g.drawImage(
                                getImage(playField[x][y].getCellImage()),
                                playField[x][y].getNumberX()*IMAGE_SIZE,
                                playField[x][y].getNumberY()*IMAGE_SIZE,
                                this);
                    }




                }
            }
            g.drawImage(getImage("num1"),0,50,this);

        }
    }







    public int getIMAGE_SIZE() {
        return IMAGE_SIZE;
    }

    public int getCOLS() {
        return COLS;
    }

    public int getROWS() {
        return ROWS;
    }


    public void drowPlayField(Graphics g, ImageObserver th){
//        Cell[][] pp = new PlayField(COLS,ROWS).getPlayField();


        //гененрируем бомбы на поле.
        generatBomb(BOMB);


        //Отрисовываем  игровое поле
        for (int x=0; x< COLS; x++) {
            for (int y=0; y< ROWS; y++) {




                if (playField[x][y].isStatusBomb()){
                    g.drawImage(
                            getImage(playField[x][y].getCellImage()),
                            playField[x][y].getNumberX()*IMAGE_SIZE,
                            playField[x][y].getNumberY()*IMAGE_SIZE,
                            th);
                }




            }
        }


    }
    static  private Image getImage(String imagName){
        ImageIcon icon = new ImageIcon("res/images/"+imagName+".png");
        return icon.getImage();
    }

    static private void generatBomb(int BOMB){
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
