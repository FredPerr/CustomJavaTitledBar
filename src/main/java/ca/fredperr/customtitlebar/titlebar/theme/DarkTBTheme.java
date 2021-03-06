package ca.fredperr.customtitlebar.titlebar.theme;

import java.awt.*;

public class DarkTBTheme implements TBTheme{
    @Override
    public Color getFrameBackground() {
        return new Color(62, 62, 62);
    }

    @Override
    public Color getFrameBorder() {
        return new Color(62, 62, 62);
    }

    @Override
    public Color getTitleBarColorBackground() {
        return new Color(62, 62, 62);
    }

    @Override
    public Color getTitleBarBorder() {
        return new Color(67, 67, 67);
    }

    @Override
    public Color getCloseButtonHoverBackground() {
        return new Color(173, 54, 54);
    }

    @Override
    public Color getControlButtonHoverBackground() {
        return new Color(90, 90, 90);
    }

    @Override
    public Color getControlButtonBackground() {
        return new Color(62, 62, 62);
    }
}
