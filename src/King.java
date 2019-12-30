public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        Square[][] b = board.getBoard();

        int diffX = Math.abs(end.getX() - start.getX());
        int diffY = Math.abs(end.getY() - start.getY());
        if(diffX <= 1 && diffY <= 1) {
            if (b[end.getX()][end.getY()].getPiece() == null || (b[start.getX()][start.getY()].getPiece().isWhite() != b[end.getX()][end.getY()].getPiece().isWhite())) {
                return true;
            }
        }
        System.err.println("Illegal king move");
        return false;
    }

    @Override
    public String toString() {
        return "K";
    }
}
