import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Piece {
    private boolean isWhite;
    private boolean isSelected;
    private boolean hasMoved;
    private ImageIcon icon;

    public Piece(boolean isWhite, boolean isSelected) {
        this.isWhite = isWhite;
        this.isSelected = isSelected;
        this.hasMoved = false;
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File( isWhite ? "res/w"+this.getClass().getSimpleName()+".png" : "res/b"+this.getClass().getSimpleName()+".png"));
            icon = new ImageIcon(bi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public ImageIcon getImageIcon() {
        return this.icon;
    }

    public abstract boolean canMove(Board board, Square start, Square end);

}
