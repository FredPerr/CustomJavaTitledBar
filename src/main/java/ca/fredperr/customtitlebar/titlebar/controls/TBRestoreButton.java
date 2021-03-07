package ca.fredperr.customtitlebar.titlebar.controls;

import ca.fredperr.customtitlebar.titlebar.TBJFrame;
import ca.fredperr.customtitlebar.titlebar.win.CustomDecorationParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TBRestoreButton extends TBControlButton {

    public boolean maximize = false;

    public TBRestoreButton(TBJFrame frame) {
        super(frame);
        setPreferredSize(new Dimension(50, CustomDecorationParameters.getTitleBarHeight()));
    }

    @Override
    public void draw(Graphics2D g, Point p1, Point p2) {
        p1 = new Point(getWidth() / 2 - 5, getHeight() / 2 - 3);
        g.drawRect(p1.x, p1.y, 8, 8);
        p1 = new Point(getWidth() / 2 + 5, getHeight() / 2 - 5);
        g.drawLine(p1.x, p1.y, p1.x - 8, p1.y);
        g.drawLine(p1.x, p1.y, p1.x, p1.y + 8);
        g.drawLine(p1.x - 8, p1.y, p1.x - 8, p1.y + 2);
        g.drawLine(p1.x, p1.y + 8, p1.x - 2, p1.y + 8);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (frame.getExtendedState() == JFrame.MAXIMIZED_BOTH)
            frame.setExtendedState(JFrame.NORMAL);
        else
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
