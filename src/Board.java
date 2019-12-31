public class Board {
    private Square[][] box;
    private boolean isWhitesTurn;
    private Piece lastMovedPiece;
    private int squaresMovedInY;
    public Board() {
        box = new Square[8][8];
        isWhitesTurn = true;
        lastMovedPiece = null;
        squaresMovedInY = 0;
        initSquare();
        loadStartPosition();
    }

    public void movePiece(int x1, int y1, int x2, int y2) {
        if (box[x1][y1].getPiece()!=null &&
                box[x1][y1].getPiece().isWhite() == isWhitesTurn &&
                box[x1][y1].getPiece().canMove(this, new Square(x1,y1), new Square(x2,y2))){
            //Take pawn en passante
            if ("P".equals(box[x1][y1].getPiece().toString()) && ((y2==y1+1 || y2==y1-1) && (x2==x1+1 || x2==x1-1)) && box[x2][y2].getPiece() == null) {
                box[x2][y1].setPiece(null);
            }
            //Move piece
            box[x2][y2].setPiece(box[x1][y1].getPiece());
            box[x1][y1].setPiece(null);
            box[x2][y2].getPiece().setHasMoved(true);
            //Move Rook too when castling
            if("K".equals(box[x2][y2].getPiece().toString())) {
                if (x2 - x1 == 2) {
                    box[x2-1][y2].setPiece(box[7][y1].getPiece());
                    box[7][y1].setPiece(null);
                    box[x2-1][y2].getPiece().setHasMoved(true);
                }
                else if (x2 - x1 == -2){
                    box[x2+1][y2].setPiece(box[0][y1].getPiece());
                    box[0][y1].setPiece(null);
                    box[x2+1][y2].getPiece().setHasMoved(true);
                }
            }
            lastMovedPiece = box[x2][y2].getPiece();
            squaresMovedInY = Math.abs(y2-y1);
            isWhitesTurn = !isWhitesTurn;
        }
    }

    private void initSquare() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                box[j][i] = new Square(j, i);
            }
        }
    }
    private void loadStartPosition() {
        /*
         * Init White
         */
        box[0][0].setPiece(new Rook(true, false));
        box[1][0].setPiece(new Knight(true, false));
        box[2][0].setPiece(new Bishop(true, false));
        box[3][0].setPiece(new Queen(true, false));
        box[4][0].setPiece(new King(true, false));
        box[5][0].setPiece(new Bishop(true, false));
        box[6][0].setPiece(new Knight(true, false));
        box[7][0].setPiece(new Rook(true, false));
        box[0][1].setPiece(new Pawn(true, false));
        box[1][1].setPiece(new Pawn(true, false));
        box[2][1].setPiece(new Pawn(true, false));
        box[3][1].setPiece(new Pawn(true, false));
        box[4][1].setPiece(new Pawn(true, false));
        box[5][1].setPiece(new Pawn(true, false));
        box[6][1].setPiece(new Pawn(true, false));
        box[7][1].setPiece(new Pawn(true, false));

        /*
         * Init black
         */
        box[0][7].setPiece(new Rook(false, false));
        box[1][7].setPiece(new Knight(false, false));
        box[2][7].setPiece(new Bishop(false, false));
        box[3][7].setPiece(new Queen(false, false));
        box[4][7].setPiece(new King(false, false));
        box[5][7].setPiece(new Bishop(false, false));
        box[6][7].setPiece(new Knight(false, false));
        box[7][7].setPiece(new Rook(false, false));
        box[0][6].setPiece(new Pawn(false, false));
        box[1][6].setPiece(new Pawn(false, false));
        box[2][6].setPiece(new Pawn(false, false));
        box[3][6].setPiece(new Pawn(false, false));
        box[4][6].setPiece(new Pawn(false, false));
        box[5][6].setPiece(new Pawn(false, false));
        box[6][6].setPiece(new Pawn(false, false));
        box[7][6].setPiece(new Pawn(false, false));
    }
    public Square[][] getBoard(){
        return this.box;
    }

    public Piece getLastMovedPiece() {
        return lastMovedPiece;
    }
    public int getSquaresMovedInY() {
        return squaresMovedInY;
    }
}
