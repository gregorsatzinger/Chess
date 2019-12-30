import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Piece {
    private boolean isWhite;
    private boolean isAlive;
    private ImageIcon icon;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File( isWhite ? "res/w"+this.getClass().getSimpleName()+".png" : "res/b"+this.getClass().getSimpleName()+".png"));
            icon = new ImageIcon(bi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isWhite() {
        return isWhite;
    }


    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public ImageIcon getImageIcon() {
        return this.icon;
    }

    public abstract boolean canMove(Board board, Square start, Square end);

}
