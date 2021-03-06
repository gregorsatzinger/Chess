import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Chess {
    private Chess(){
        ChessboardPanel cb = new ChessboardPanel();
        JLabel info = new JLabel("Click on the square to move a piece.");

        Board board = new Board();

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(cb);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("Chess");
        frame.add(info, BorderLayout.SOUTH);


        cb.render(board);
        cb.validate();

        cb.addMouseListener(new MouseAdapter() {
            int x1, y1, x2, y2;
            boolean firstSquare = false;
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                firstSquare = !firstSquare;

                if (firstSquare){
                    x1 = e.getX()/cb.FIELD_SIZE;
                    y1 = 7-e.getY()/cb.FIELD_SIZE;
                    if (board.getBoard()[x1][y1].getPiece() != null){
                        board.getBoard()[x1][y1].getPiece().setSelected(true);
                    }
                    cb.render(board);
                    info.setText("Select destination");
                    cb.revalidate();

                } else{
                    x2 = e.getX()/cb.FIELD_SIZE;
                    y2 = 7-e.getY()/cb.FIELD_SIZE;
                    if (board.getBoard()[x1][y1].getPiece() != null){
                        board.getBoard()[x1][y1].getPiece().setSelected(false);
                    }
                    board.movePiece(x1, y1, x2, y2);
                    cb.render(board);
                    info.setText("Select piece");
                    cb.revalidate();
                }
            }
        });
    }
    public static void main(String[] args) {
        new Chess();
    }
}
