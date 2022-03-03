package Lesson03_Refactoring;

public class Main {
    public static void main(String[] args) throws Exception{
        GameField gameField = new GameField();
        gameField.setVisible(true);
        Thread.sleep(5000);
        gameField.setVisible(false);
        Thread.sleep(5000);
        gameField.setVisible(true);
    }
}
