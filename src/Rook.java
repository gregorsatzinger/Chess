public class Rook extends Piece {

    public Rook(boolean isWhite, boolean isSelected) {
        super(isWhite, isSelected);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (MoveRules.canRookMove(board, start, end)){
            return true;
        }
        System.err.println("Illegal rook move");
        return false;
    }

    @Override
    public String toString() {
        return "R";
    }

}
