public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (MoveRules.canBishopMove(board, start, end)) {
            return true;
        }
        System.err.println("Illegal bishop move");
        return false;
    }

    @Override
    public String toString() {
        return "B";
    }


}
