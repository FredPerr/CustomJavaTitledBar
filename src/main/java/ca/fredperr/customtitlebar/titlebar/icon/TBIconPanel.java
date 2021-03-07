package ca.fredperr.customtitlebar.titlebar.icon;

import javax.swing.*;
import java.awt.*;

public class TBIconPanel extends JPanel {

    private Image image;
    public int size;

    public TBIconPanel(Image image, int size){
        this.size = size;
        setIcon(image);
    }

    public void setIcon(Image image){
        if (image != null){
            this.image = image.getScaledInstance(size, size, Image.SCALE_DEFAULT);
            Dimension dim = new Dimension(size, size);
            setPreferredSize(dim);
            setMinimumSize(dim);
            setMaximumSize(dim);
            setSize(dim);
            setLayout(null);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(image != null)
            g.drawImage(image, 0, 0, null);
    }
}
