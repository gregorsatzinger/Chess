public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        Square[][] b = board.getBoard();

        //check if move is in correct L shape: If +1 in one direction -> +2 in other direction
        if ((((end.getX() == start.getX() + 1) || (end.getX() == start.getX() - 1)) &&
                ((end.getY() == start.getY() + 2) || (end.getY() == start.getY() - 2))) ||
                (((end.getX() == start.getX() + 2) || (end.getX() == start.getX() - 2)) &&
                        ((end.getY() == start.getY() + 1) || (end.getY() == start.getY() - 1)))) {

            // check if end square isnt occupied by own piece
            if (b[end.getX()][end.getY()].getPiece() == null || (b[start.getX()][start.getY()].getPiece().isWhite() != b[end.getX()][end.getY()].getPiece().isWhite())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "N";
    }

}
