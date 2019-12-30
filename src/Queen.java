public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (MoveRules.canBishopMove(board, start, end) || MoveRules.canRookMove(board, start, end)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Q";
    }

}
