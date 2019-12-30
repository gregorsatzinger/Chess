import javax.swing.*;
import java.awt.*;

public class ChessboardGfx extends JPanel {
    private final int FIELD_SIZE = 100;
    public ChessboardGfx() {
        super(new GridLayout(8,8));
        this.setPreferredSize(new Dimension(8*FIELD_SIZE,8*FIELD_SIZE));
    }
    public void render(Board b) {
        this.removeAll();
        Square[][] board = b.getBoard();
        String label;
        int i = 0;
        int j = 0;

        //Render every square of the board
        for (int n = 0; n < 64; n++) {
            JLabel sq = new JLabel("",SwingConstants.CENTER);
            sq.setOpaque(true);
            sq.setFont(new Font("Sans",Font.BOLD,FIELD_SIZE/2));
            sq.setText(board[7-i][7-j].toString());

            //set every piece to the correct color
            if (board[7-i][7-j].getPiece() != null && board[7-i][7-j].getPiece().isWhite()) {
                sq.setForeground(Color.WHITE);
            }else {
                sq.setForeground(Color.BLACK);
            }


            // Logic to color the board in right colors
            if ((n / 8 + n % 8) % 2 == 0) {
                sq.setBackground(new Color(240, 218, 181));
            }else {
                sq.setBackground(new Color(185, 134, 99));
            }
            this.add(sq);
            i++;
            if(i == 8){
                j++;
                i = 0;
            }
        }
    }
}
