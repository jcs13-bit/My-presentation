package myPresentation;

import javax.swing.*;
import java.awt.*;

public class Title  extends JLabel {
    public Title(String title, Color bacgroundColor){
        this.setText(title);
        this.setBackground(bacgroundColor);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24 ));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
