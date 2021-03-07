package ca.fredperr.customtitlebar.titlebar;

import ca.fredperr.customtitlebar.titlebar.controls.TBCloseButton;
import ca.fredperr.customtitlebar.titlebar.controls.TBMinimizeButton;
import ca.fredperr.customtitlebar.titlebar.controls.TBRestoreButton;
import ca.fredperr.customtitlebar.titlebar.icon.TBIconPanel;
import ca.fredperr.customtitlebar.titlebar.theme.TBTheme;
import ca.fredperr.customtitlebar.titlebar.win.CustomDecorationParameters;
import ca.fredperr.customtitlebar.titlebar.win.CustomDecorationWindowProc;
import ca.fredperr.customtitlebar.titlebar.win.WindowFrameType;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TBJFrame extends JFrame {

    final CustomDecorationWindowProc windowProcEx;
    final WindowFrameType windowFrameType;
    private JPanel titleBarPane, customContentContainer, frameContentPane, iconContainer, controlContainer;
    private TBIconPanel iconPanel;
    private TBRestoreButton restoreButton;
    private TBMinimizeButton minimizeButton;
    private TBCloseButton closeButton;
    private TBTheme theme;

    public TBJFrame(String title, WindowFrameType windowFrameType, TBTheme theme, int logoSize){
        super(title);
        this.theme = theme;
        this.windowFrameType = windowFrameType;
        this.windowProcEx = new CustomDecorationWindowProc();
        setLayout(new BorderLayout());
        setBackground(theme.getFrameBackground());

        // Creating the default content pane back.
        frameContentPane = new JPanel();
        frameContentPane.setLayout(new BorderLayout());
        frameContentPane.setOpaque(false);

        // Adding the title bar to the frame.
        if (windowFrameType == WindowFrameType.NONE){
            CustomDecorationParameters.setTitleBarHeight(0);
        } else {
            titleBarPane = new JPanel();
            titleBarPane.setBackground(theme.getTitleBarColorBackground());
            titleBarPane.setBorder(BorderFactory.createMatteBorder(0,0 ,1,0, theme.getTitleBarBorder()));
            titleBarPane.setLayout(new BorderLayout());

            iconContainer = new JPanel();
            iconContainer.setOpaque(false);
            iconContainer.add(iconPanel = new TBIconPanel(null, logoSize));


            controlContainer = new JPanel();
            controlContainer.setOpaque(false);
            if(windowFrameType == WindowFrameType.NORMAL){
                controlContainer.setLayout(new GridLayout(1, 3, -1, 0));
                controlContainer.add(minimizeButton = new TBMinimizeButton(this));
                controlContainer.add(restoreButton = new TBRestoreButton(this));
                controlContainer.add(closeButton = new TBCloseButton(this));
            } else if(windowFrameType == WindowFrameType.TOOL){
                controlContainer.setLayout(new GridLayout(1, 1, -1, 0));
                controlContainer.add(new TBCloseButton(this));
            }
        }

        titleBarPane.add(controlContainer, BorderLayout.EAST);

        customContentContainer = new JPanel();
        customContentContainer.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
        customContentContainer.setOpaque(false);
        customContentContainer.add(iconContainer);

        titleBarPane.add(customContentContainer, BorderLayout.WEST);
        frameContentPane.add(titleBarPane, BorderLayout.NORTH);

        JPanel clientContentPane = new JPanel();
        clientContentPane.setLayout(new FlowLayout());
        clientContentPane.setOpaque(false);
        frameContentPane.add(clientContentPane);

        setContentPane(frameContentPane);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                TBJFrame mainFrame = (TBJFrame) e.getSource();
                if (mainFrame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    CustomDecorationParameters.setMaximizedWindowFrameThickness(7);
                    mainFrame.getRootPane().setBorder(BorderFactory.createLineBorder(theme.getFrameBorder(),
                            CustomDecorationParameters.getMaximizedWindowFrameThickness()));
                    if(restoreButton != null){
                        restoreButton.maximize = false;
                    }
                } else {
                    CustomDecorationParameters.setMaximizedWindowFrameThickness(0);
                    mainFrame.getRootPane().setBorder(BorderFactory.createLineBorder(theme.getFrameBorder(),
                            CustomDecorationParameters.getFrameBorderThickness()));
                    if(restoreButton != null && !restoreButton.maximize)
                        restoreButton.maximize = true;
                }
            }
        });
        pack();
        CustomDecorationParameters.setControlBoxWidth(controlContainer.getWidth() + 7);
    }

    public void setTitleBarIcon(Image image){
        iconPanel.setIcon(image);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        windowProcEx.init(getHwnd());
    }

    @Override
    public void pack() {
        super.pack();
        CustomDecorationParameters.setExtraLeftReservedWidth(customContentContainer.getWidth());
    }

    private WinDef.HWND getHwnd(){
        WinDef.HWND hwnd = new WinDef.HWND();
        hwnd.setPointer(Native.getComponentPointer(this));
        return hwnd;
    }

    /**
     * @return the panel containing the icon of the title bar.
     *         This panel is nested inside the iconContainer panel
     */
    public TBIconPanel getIconPanel(){
        return this.iconPanel;
    }


    /**
     * @return the area that is used to add any components such as JMenuBar or JButton for instance.
     *          This zone is located right next to the icon container.
     */
    public JPanel getCustomAreaPanel(){
        return this.customContentContainer;
    }

    /**
     * @return the JPanel containing the control button(s), which are the minimize, restore and close buttons.
     *          This component is located on the right of the title bar ny default.
     */
    public JPanel getControlContainer(){
        return this.controlContainer;
    }

    /**
     * @return the JPanel representing the title bar itself.
     *          All the other components of the bar sit on this JPanel.
     */
    public JPanel getTitleBarPane(){
        return this.titleBarPane;
    }

    /**
     * @return The theme of the title bar/frame.
     */
    public TBTheme getTheme(){
        return this.theme;
    }

    /**
     * @return the instance of the button that closes the window.
     *          This button should not be null.
     */
    public TBCloseButton getCloseButton(){
        return this.closeButton;
    }

    /**
     * @return the instance of the minimize button.
     *          This button can be null if the type of window does not support it.
     */
    public TBMinimizeButton getMinimizeButton(){
        return this.minimizeButton;
    }

    /**
     * @return the instance of the restore button.
     *          This button can be null if the type of the window does not support it.
     */
    public TBRestoreButton getRestoreButton(){
        return this.restoreButton;
    }

}
