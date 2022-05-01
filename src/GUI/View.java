package GUI;

import javax.swing.*;

public class View extends JFrame {
    private JTable playersTable;
    private JScrollPane scrollPane;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public View(){
        super("Bookmaker's assistant");
        setSize(800,400);
        setVisible(true);
    }
}
