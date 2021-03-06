package ca.fredperr.customtitlebar;

import ca.fredperr.customtitlebar.titlebar.TBJFrame;
import ca.fredperr.customtitlebar.titlebar.theme.DarkTBTheme;
import ca.fredperr.customtitlebar.win.WindowFrameType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class TBDemo {

    public TBDemo() throws IOException {
        TBJFrame frame = new TBJFrame("test", WindowFrameType.NORMAL, new DarkTBTheme());
        InputStream fis = getClass().getResourceAsStream("/test.png");
        frame.iconPanel.setIcon(ImageIO.read(fis));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        try {
            new TBDemo();
        } catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
