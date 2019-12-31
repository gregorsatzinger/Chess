public class Pawn extends Piece {
    public Pawn(boolean isWhite, boolean isSelected) {
        super(isWhite, isSelected);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (MoveRules.canPawnMove(board, start, end)) {
            return true;
        }
        System.err.println("Illegal pawn move");
        return false;
    }

    @Override
    public String toString() {
        return "P";
    }

}
