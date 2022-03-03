package Lesson02_JComponent;

import javax.swing.*;
import java.awt.*;

public class My_JFrame {
    private static final int IMAGE_SIZE = 50;
    private static final int COLS = 10;
    private static final int ROWS = 10;


    public static void main(String[] args) {
        //создание обьекта класса JFrame бидлиотеки SWING.
        JFrame myFrame = new JFrame();
        //при нажатиии кнопки закрыть  останавливается выполнение.
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Красивая Иконка - из файла res/images/icon.png
        myFrame.setIconImage(new ImageIcon("res/images/icon.png").getImage());
        //добавляем название в Тайтл
        myFrame.setTitle("Java Sweeper Hardy");
        //Делаем видимым
        myFrame.setVisible(true);
        //Присваиваем размерв
        myFrame.setSize(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE + 30);
        //помещаем в центр рабочего стола
        myFrame.setLocationRelativeTo(null);


        //добавляем во Фрейм  кастомный компонент
        myFrame.add(new My_JFrame.MyComponent());
        myFrame.pack();


    }
    static class MyComponent extends JComponent{

        //Метод paintComponent запускается автомотически
        @Override
        protected void paintComponent(Graphics g) {
            ImageIcon icon = new ImageIcon("res/images/bomb.png");
            Image cellImage = icon.getImage();
            g.drawImage(cellImage, 0, 50, this);
            g.drawImage(getIcon(),0,0, this);
        }
        private Image getIcon(){
            ImageIcon icon = new ImageIcon("res/images/flaged.png");
            return icon.getImage();
        }
    }

}
