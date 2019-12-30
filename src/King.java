public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (MoveRules.canKingMove(board, start, end)) {
            return true;
        }
        System.err.println("Illegal knight move");
        return false;
    }

    @Override
    public String toString() {
        return "K";
    }
}
