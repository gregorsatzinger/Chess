public class Square {
    private int x;
    private int y;
    private Piece piece;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty(){
        return piece == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return " ";
        } else {
            return piece.toString();
        }
    }
}
