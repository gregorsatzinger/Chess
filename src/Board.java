public class Board {
    private Square[][] box;
    private boolean isWhitesTurn;
    public Board() {
        box = new Square[8][8];
        isWhitesTurn = true;
        initSquare();
        loadStartPosition();
    }

    public Square[][] getBoard(){
        return this.box;
    }

    public void movePiece(int x1, int y1, int x2, int y2) {
        if (box[x1][y1].getPiece()!=null &&
                box[x1][y1].getPiece().isWhite() == isWhitesTurn &&
                box[x1][y1].getPiece().canMove(this, new Square(x1,y1), new Square(x2,y2))){
            box[x2][y2].setPiece(box[x1][y1].getPiece());
            box[x1][y1].setPiece(null);
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
        /**
         * Init White
         */
        box[0][0].setPiece(new Rook(true));
        box[1][0].setPiece(new Knight(true));
        box[2][0].setPiece(new Bishop(true));
        box[3][0].setPiece(new King(true));
        box[4][0].setPiece(new Queen(true));
        box[5][0].setPiece(new Bishop(true));
        box[6][0].setPiece(new Knight(true));
        box[7][0].setPiece(new Rook(true));
        box[0][1].setPiece(new Pawn(true));
        box[1][1].setPiece(new Pawn(true));
        box[2][1].setPiece(new Pawn(true));
        box[3][1].setPiece(new Pawn(true));
        box[4][1].setPiece(new Pawn(true));
        box[5][1].setPiece(new Pawn(true));
        box[6][1].setPiece(new Pawn(true));
        box[7][1].setPiece(new Pawn(true));

        /***
         * Init black
         */
        box[0][7].setPiece(new Rook(false));
        box[1][7].setPiece(new Knight(false));
        box[2][7].setPiece(new Bishop(false));
        box[3][7].setPiece(new King(false));
        box[4][7].setPiece(new Queen(false));
        box[5][7].setPiece(new Bishop(false));
        box[6][7].setPiece(new Knight(false));
        box[7][7].setPiece(new Rook(false));
        box[0][6].setPiece(new Pawn(false));
        box[1][6].setPiece(new Pawn(false));
        box[2][6].setPiece(new Pawn(false));
        box[3][6].setPiece(new Pawn(false));
        box[4][6].setPiece(new Pawn(false));
        box[5][6].setPiece(new Pawn(false));
        box[6][6].setPiece(new Pawn(false));
        box[7][6].setPiece(new Pawn(false));
    }
}
