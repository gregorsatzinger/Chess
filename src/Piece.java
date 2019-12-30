public abstract class Piece {
    private boolean isWhite;
    private boolean isAlive;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }


    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public abstract boolean canMove(Board board, Square start, Square end);

}
