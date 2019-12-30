import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Chess {
    public static void main(String[] args) {
        ChessboardGfx cb = new ChessboardGfx();
        JLabel info = new JLabel("Click on the square to move a piece.");

        Board board = new Board();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(cb);
        frame.pack();
        frame.setVisible(true);
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
                    x1 = 7-e.getX()/100;
                    y1 = 7-e.getY()/100;
                    info.setText("Select destination");

                } else{
                    x2 = 7-e.getX()/100;
                    y2 = 7-e.getY()/100;
                    board.movePiece(x1, y1, x2, y2);
                    cb.render(board);
                    info.setText("Select piece");
                    cb.revalidate();
                }
            }
        });
    }
}
