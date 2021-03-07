package ca.fredperr.customtitlebar.titlebar.controls;

import ca.fredperr.customtitlebar.titlebar.TBJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class TBControlButton extends JButton implements MouseListener {

    protected TBJFrame frame;

    protected TBControlButton(TBJFrame frame){
        this.frame = frame;
        setBackground(frame.getTheme().getControlButtonBackground());
        setOpaque(false);
        addMouseListener(this);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
    }

    /**
     * @param p1 The starting point of the rectangle drawable area (North-West).
     * @param p2 The ending point of the rectangle drawable area (South-Est).
     */
    public abstract void draw(Graphics2D g, Point p1, Point p2);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.GRAY);

        Point p1 = new Point(width / 2 - 5, height / 2 - 5);
        Point p2 = new Point(width / 2 + 5, height / 2 + 5);

        draw(g2d, p1, p2);
        g2d.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(frame.getTheme().getControlButtonHoverBackground());
    }

    @Override
    public void mouseReleased(MouseEvent e) { setBackground(frame.getTheme().getControlButtonHoverBackground());}

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(frame.getTheme().getControlButtonHoverBackground());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(frame.getTheme().getControlButtonBackground());
    }
}
