package sweeper;

public class PlayField {
    public Cell[][] playField;

    public PlayField(int cols, int rows){
        playField = new Cell[cols][rows];
        int count = 0;
        for (int x=0; x< cols; x++) {
            for (int y=0; y< rows; y++) {
                playField[x][y] = new Cell(count, x,y,"num7");
                count++;
            }
        }

    }

    public Cell[][] getPlayField() {
        return playField;
    }

}
