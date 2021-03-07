package ca.fredperr.customtitlebar.titlebar.controls;

import ca.fredperr.customtitlebar.titlebar.TBJFrame;
import ca.fredperr.customtitlebar.titlebar.win.CustomDecorationParameters;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class TBCloseButton extends TBControlButton {

    private boolean hover = false;

    public TBCloseButton(TBJFrame frame) {
        super(frame);
        setPreferredSize(new Dimension(50, CustomDecorationParameters.getTitleBarHeight()));
    }

    @Override
    public void draw(Graphics2D g, Point p1, Point p2) {
        if (hover)
            g.setColor(Color.WHITE);
        else g.setColor(Color.GRAY);

        g.setStroke(new BasicStroke(1.1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.draw(new Line2D.Float(p1.x, p1.y, p2.x, p2.y));
        g.draw(new Line2D.Float(p1.x , p2.y , p2.x , p1.y));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.exit(0);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(frame.getTheme().getCloseButtonHoverBackground());
    }

    @Override
    public void mouseReleased(MouseEvent e) { setBackground(frame.getTheme().getCloseButtonHoverBackground());}

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(frame.getTheme().getCloseButtonHoverBackground());
        hover = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(frame.getTheme().getControlButtonBackground());
        hover = false;
    }
}
