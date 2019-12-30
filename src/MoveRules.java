public class MoveRules {

    public static boolean canPawnMove(Board board, Square start, Square end) {
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
        return false;
    }

    public static boolean canKnightMove(Board board, Square start, Square end) {
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

    public static boolean canBishopMove(Board board, Square start, Square end) {
        Square[][] b = board.getBoard();
        //check if move is diagonal
        if ((end.getX() - start.getX()) == ((end.getY() - start.getY())) || (end.getX() - start.getX()) == -1*((end.getY() - start.getY()))) {
            //check if end square isnt occupied by own piece
            if (b[end.getX()][end.getY()].getPiece() == null || (b[start.getX()][start.getY()].getPiece().isWhite() != b[end.getX()][end.getY()].getPiece().isWhite())) {
                int diffX = end.getX() - start.getX();
                int diffY = end.getY() - start.getY();
                int i = 1;
                // Check if there is another piece between start and end position
                if (diffX > 0 && diffY > 0) { //move up right
                    while (b[start.getX()+i][start.getY()+i].getPiece() == null && i<diffX) {
                        i++;
                    }
                    if(i==diffX){
                        return true;
                    }
                } else if (diffX > 0 && diffY < 0) { //move down right
                    while (b[start.getX()+i][start.getY()-i].getPiece() == null && i<diffX) {
                        i++;
                    }
                    if(i==diffX){
                        return true;
                    }
                } else if (diffX < 0 && diffY > 0) { //move up left
                    while (b[start.getX()-i][start.getY()+i].getPiece() == null && i<diffY) {
                        i++;
                    }
                    if(i==diffY){
                        return true;
                    }
                } else if (diffX < 0 && diffY < 0) { //move down left
                    while (b[start.getX()-i][start.getY()-i].getPiece() == null && i<Math.abs(diffX)) {
                        i++;
                    }
                    if(i == Math.abs(diffX)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean canRookMove(Board board, Square start, Square end) {
        Square[][] b = board.getBoard();
        //check if move is in a straight line
        if ((end.getX() == start.getX()) || (end.getY() == start.getY())) {
            //check if end square isnt occupied by own piece
            if (b[end.getX()][end.getY()].getPiece() == null || (b[start.getX()][start.getY()].getPiece().isWhite() != b[end.getX()][end.getY()].getPiece().isWhite())) {
                int diffX = end.getX() - start.getX();
                int diffY = end.getY() - start.getY();
                int i = 1;
                // Check if there is another piece between start and end position
                if (diffX > 0 && diffY == 0) { //move right
                    while (b[start.getX()+i][start.getY()].getPiece() == null && i<Math.abs(diffX)) {
                        i++;
                    }
                    if(i==Math.abs(diffX)){
                        return true;
                    }
                } else if (diffX < 0 && diffY == 0) { //move left
                    while (b[start.getX()-i][start.getY()].getPiece() == null && i<Math.abs(diffX)) {
                        i++;
                    }
                    if(i==Math.abs(diffX)){
                        return true;
                    }
                } else if (diffX == 0 && diffY > 0) { //move up
                    while (b[start.getX()][start.getY()+i].getPiece() == null && i<Math.abs(diffY)) {
                        i++;
                    }
                    if(i==Math.abs(diffY)){
                        return true;
                    }
                } else if (diffX == 0 && diffY < 0) { //move down
                    while (b[start.getX()][start.getY()-i].getPiece() == null && i<Math.abs(diffY)) {
                        i++;
                    }
                    if(i == Math.abs(diffY)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean canKingMove(Board board, Square start, Square end) {
        Square[][] b = board.getBoard();

        int diffX = Math.abs(end.getX() - start.getX());
        int diffY = Math.abs(end.getY() - start.getY());
        if(diffX <= 1 && diffY <= 1) {
            if (b[end.getX()][end.getY()].getPiece() == null || (b[start.getX()][start.getY()].getPiece().isWhite() != b[end.getX()][end.getY()].getPiece().isWhite())) {
                return true;
            }
        }
        return false;
    }

    public static boolean canQueenMove(Board board, Square start, Square end) {
        if (MoveRules.canBishopMove(board, start, end) || MoveRules.canRookMove(board, start, end)) {
            return true;
        }
        return false;
    }
}
