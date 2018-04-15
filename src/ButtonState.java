import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;

/*
 ButtonState class contains all possible button states.
 If a button shows a mine, use danger icon.
 If there's no mine surrounding, use safe icon.
 Otherwise, show the number of the number of adjacent mines surrounding a certain tile.
 */
public class ButtonState extends JButton{
    // Buttons should get images set up
    // D means danger, S means safe, the number Icons(ONE, TWO, ..., EIGHT) stands for the number of adjacent mines.
    ImageIcon D, S, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT;
    
    public ButtonState() {
        // Icon website: https://www.flaticon.com/search?word=number
        D = scaleImage(new ImageIcon("DangerIcon1.png"));
        S = scaleImage(new ImageIcon("SafeIcon.png"));
        ONE = scaleImage(new ImageIcon("1.png"));
        TWO = scaleImage(new ImageIcon("2.png"));
        THREE = scaleImage(new ImageIcon("3.png"));
        FOUR = scaleImage(new ImageIcon("4.png"));
        FIVE = scaleImage(new ImageIcon("5.png"));
        SIX = scaleImage(new ImageIcon("6.png"));
        SEVEN = scaleImage(new ImageIcon("7.png"));
        EIGHT = scaleImage(new ImageIcon("8.png"));
    }
    
    // Scale images to fit cubes
    // How to scale images: https://stackoverflow.com/questions/13810213/java-stretch-icon-to-fit-button
    public ImageIcon scaleImage(ImageIcon imgIcon) {
        int iconSize = (int) (Minesweeper.FRAME_SIZE/(1.2 * Minesweeper.buttonNumRow));
        Image newImage = imgIcon.getImage().getScaledInstance(iconSize, iconSize, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
}



