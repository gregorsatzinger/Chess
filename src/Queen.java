public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (MoveRules.canQueenMove(board, start, end)) {
            return true;
        }
        System.err.println("Illegal queen move");
        return false;
    }

    @Override
    public String toString() {
        return "Q";
    }

}
