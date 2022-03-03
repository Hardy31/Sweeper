package sweeper;

import java.awt.*;

public class Cell {

    private int number;
    private int numberX;
    private int numberY;
    private boolean statusClosed = true;
    private boolean statusBomb = false;
    String cellImage = "res/images/bomb.png";

    public Cell(int number, int numberX, int numberY, String cellImage) {
        this.number = number;
        this.numberX = numberX;
        this.numberY = numberY;
        this.cellImage = cellImage;
    }

    public boolean isStatusBomb() {
        return statusBomb;
    }

    public void setStatusBomb(boolean statusBomb) {
        this.statusBomb = statusBomb;
    }



    public void setNumber(int number){
        this.number = number;
    }


    public void setNumberX(int numberX) {
        this.numberX = numberX;
    }

    public void setNumberY(int numberY) {
        this.numberY = numberY;
    }

    public void setCellImage(String cellImage) {
        this.cellImage = cellImage;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberX() {
        return numberX;
    }

    public int getNumberY() {
        return numberY;
    }

    public boolean isStatusClosed() {
        return statusClosed;
    }

    public String getCellImage() {
        return cellImage;
    }


    public void setStatusClosed(boolean statusClosed) {
        this.statusClosed = statusClosed;
    }





}
