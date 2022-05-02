package GUI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class View extends JFrame {
    private JTable playersTable;
    private JScrollPane scrollPane;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel background;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public View(){
        super("Bookmaker's assistant");
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        setIconImage(new ImageIcon(classloader.getResource("Icon.png")).getImage());
        background = new JLabel(new ImageIcon(classloader.getResource("Background.jpg")));
        add(background);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
}
