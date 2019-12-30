public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (MoveRules.canKnightMove(board, start, end)) {
            return true;
        }
        System.err.println("Illegal knight move");
        return false;
    }

    @Override
    public String toString() {
        return "N";
    }

}
