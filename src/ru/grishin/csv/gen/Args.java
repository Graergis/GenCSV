package ru.grishin.csv.gen;

public class Args {
    private final int col;
    private final int row;
    private final int len;
    private final String out;

    public Args(int col, int row, int len, String out) {
        this.col = col;
        this.row = row;
        this.len = len;
        this.out = out;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getLen() {
        return len;
    }

    public String getOut() {
        return out;
    }
}
