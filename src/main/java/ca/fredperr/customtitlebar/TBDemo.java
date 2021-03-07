package ca.fredperr.customtitlebar;

import ca.fredperr.customtitlebar.titlebar.TBJFrame;
import ca.fredperr.customtitlebar.titlebar.theme.DarkTBTheme;
import ca.fredperr.customtitlebar.titlebar.win.CustomDecorationParameters;
import ca.fredperr.customtitlebar.titlebar.win.WindowFrameType;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;

public class TBDemo {

    public TBDemo() throws IOException {
        TBJFrame frame = new TBJFrame("TBDemo", WindowFrameType.NORMAL, new DarkTBTheme(), 20);
        InputStream fis = getClass().getResourceAsStream("/test.png");
        frame.setTitleBarIcon(ImageIO.read(fis));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(720, 480));
        frame.setLocationRelativeTo(null);

        // Setting UI attributes

        Font font = new Font ("SansSerif", Font.PLAIN, 14);

        UIManager.put("Menu.selectionBackground", new Color(177, 96, 96));
        UIManager.put("Menu.selectionForeground", Color.lightGray);
        UIManager.put("MenuBar.background", frame.getTheme().getFrameBackground());
        UIManager.put("Menu.background", frame.getTheme().getFrameBackground());
        UIManager.put("Menu.foreground", Color.lightGray);
        UIManager.put("Menu.border", BorderFactory.createEmptyBorder(5,2,5,2));
        UIManager.put("Menu.font", font);

        // Adding some components
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(BorderFactory.createEmptyBorder());
        menuBar.add(new JMenu("File"));
        menuBar.add(new JMenu("Edit"));
        menuBar.add(new JMenu("View"));
        menuBar.add(new JMenu("Help"));

        JLabel title = new JLabel(frame.getTitle());
        title.setFont(font);
        title.setForeground(Color.GRAY);
        title.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));

        frame.getCustomAreaPanel().add(title);
        frame.getCustomAreaPanel().add(menuBar);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TBDemo();
                } catch (IOException e){
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        });

    }
}
