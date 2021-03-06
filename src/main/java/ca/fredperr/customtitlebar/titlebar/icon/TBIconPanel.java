package ca.fredperr.customtitlebar.titlebar.icon;

import javax.swing.*;
import java.awt.*;

public class TBIconPanel extends JPanel {

    private Image image;
    public int length;

    public TBIconPanel(Image image, int length){
        this.length = length;
        setIcon(image);
    }

    public void setIcon(Image image){
        if (image != null){
            this.image = image.getScaledInstance(length, length, Image.SCALE_DEFAULT);
            Dimension size = new Dimension(length, length);
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(image != null)
            g.drawImage(image, 0, 0, null);
    }
}
