package TicTacToe;

public enum Marker {
    X('X'),O('O'),EMPTY(' ');

    public char ch;

    Marker(char ch){
        this.ch=ch;
    }

    public char getCh() {
        return ch;
    }

    @Override
    public String toString() {
        return String.format("%c",this.ch);
    }
}
