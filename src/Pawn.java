public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        // TODO: If pawn is at start position it can move two squares up or down
        Square[][] b = board.getBoard();
        if (b[start.getX()][start.getY()].getPiece().isWhite()) {
            // White pawn can move up
            if (end.getX() == start.getX() && end.getY() == start.getY()+1) {
                if (b[end.getX()][end.getY()].getPiece() == null) {
                    return true;
                }
            }
            //White pawn can take piece
            if ((end.getX() == start.getX()+1 && end.getY() == start.getY()+1) || (end.getX() == start.getX()-1 && end.getY() == start.getY()+1)) {
                if(b[end.getX()][end.getY()].getPiece() != null) {
                    return true;
                }
            }

        }else {
            //Black pawn can move down
            if (end.getX() == start.getX() && end.getY() == start.getY()-1) {
                if (b[end.getX()][end.getY()].getPiece() == null) {
                    return true;
                }
            }
            //Black pawn can take piece
            if ((end.getX() == start.getX()+1 && end.getY() == start.getY()-1) || (end.getX() == start.getX()-1 && end.getY() == start.getY()-1)) {
                if(b[end.getX()][end.getY()].getPiece() != null) {
                    return true;
                }
            }
        }
        System.err.println("Illeagal pawn move");
        return false;
    }

    @Override
    public String toString() {
        return "P";
    }

}
