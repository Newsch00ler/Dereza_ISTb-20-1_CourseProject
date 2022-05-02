package GUI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class View extends JFrame {
    private JTable playersTable;
    private JScrollPane scrollPane;

    private JMenuBar menuBar;
    private JPanel panelTop;
    private JPanel panelCenter;
    private JPanel panelBottom;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel labelInfo;
    private JLabel background;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public View(){
        super("Bookmaker's assistant");
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        setIconImage(new ImageIcon(Objects.requireNonNull(classloader.getResource("Icon.png"))).getImage());
        /*background = new JLabel(new ImageIcon(Objects.requireNonNull(classloader.getResource("Background.jpg"))));
        add(background);*/

        playersTable = new JTable();
        scrollPane = new JScrollPane(playersTable);

        panelTop = new JPanel();
        /*panelTop.setPreferredSize(new Dimension(1500, 300));
        panelTop.setMaximumSize(new Dimension(1500, 300));*/
        add(panelTop, BorderLayout.NORTH);

        panelCenter = new JPanel();
        /*panelCenter.setPreferredSize(new Dimension(1500, 300));
        panelCenter.setMaximumSize(new Dimension(1500, 300));*/
        panelCenter.add(scrollPane);
        add(panelCenter, BorderLayout.CENTER);

        panelBottom = new JPanel(new GridLayout(2, 5, 5, 5));
        
        labelInfo = new JLabel("Mins: Minutes played");
        labelInfo.setFont(new Font("Text", Font.PLAIN, 20));
        panelBottom.add(labelInfo);
       /* panelBottom.setPreferredSize(new Dimension(1500, 300));
        panelBottom.setMaximumSize(new Dimension(1500, 300));*/
        add(panelBottom, BorderLayout.SOUTH);


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
