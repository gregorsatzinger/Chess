import javax.swing.*;
import java.awt.*;

public class ChessboardPanel extends JPanel {
    public final int FIELD_SIZE = 80;
    public ChessboardPanel() {
        super(new GridLayout(8,8));
        this.setPreferredSize(new Dimension(8*FIELD_SIZE,8*FIELD_SIZE));
    }
    public void render(Board b) {
        this.removeAll();
        Square[][] board = b.getBoard();
        int i = 0;
        int j = 0;

        //Render every square of the board
        for (int n = 0; n < 64; n++) {
            JLabel sq = new JLabel("",SwingConstants.CENTER);
            sq.setOpaque(true);
            sq.setIcon(board[i][7-j].getPiece() != null ? board[i][7-j].getPiece().getImageIcon() : new ImageIcon());
            this.add(sq);

            // Logic to color the board in right colors
            if ((n / 8 + n % 8) % 2 == 0) {
                sq.setBackground(new Color(240, 218, 181));
            }else {
                sq.setBackground(new Color(185, 134, 99));
            }
            //Highlight if square is selected
            if (board[i][7-j].getPiece() != null && board[i][7-j].getPiece().isSelected()){
                sq.setBackground(new Color(120, 120, 120));
            }

            i++;
            if(i == 8){
                j++;
                i = 0;
            }
        }
    }
}
