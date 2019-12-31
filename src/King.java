public class King extends Piece {

    public King(boolean isWhite, boolean isSelected) {
        super(isWhite, isSelected);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (MoveRules.canKingMove(board, start, end)) {
            return true;
        }
        System.err.println("Illegal king move");
        return false;
    }

    @Override
    public String toString() {
        return "K";
    }
}
