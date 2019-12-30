public class Knight extends Piece{
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        Square[][] b = board.getBoard();

        return false;
    }

    @Override
    public String toString() {
        return "N";
    }

}
