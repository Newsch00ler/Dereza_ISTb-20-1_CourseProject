package GUI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class View extends JFrame {
    private JTable playersTable;
    private JScrollPane scrollPane;

    private JMenuBar menuBar;
    private JMenu menuSport;
    private JMenuItem footballItem;
    private JMenuItem hockeyItem;
    private JMenuItem basketItem;
    private JMenu menuMode;
    private JMenuItem editModeItem;
    private JMenuItem viewModeItem;
    private JMenu menuHelp;
    private JMenuItem helpInfo;
    private JMenuItem infoAboutProg;
    private JPanel panelTop;
    private Container contCenter;
    private Container contRight;
    private Container contInput;

    private JLabel labelHeader;
    private JLabel labelFind;
    private JLabel labelName;
    private JLabel labelSurname;
    private JLabel labelRole;
    private JLabel labelNumber;
    private JLabel labelTeam;
    private JLabel labelMins;
    private JLabel labelGoals;
    private JLabel labelAssists;
    private JLabel labelYC;
    private JLabel labelRC;
    private JLabel labelPsPerc;
    private JLabel labelStickGrip;
    private JLabel labelPenaltyTime;
    private JLabel labelPenaltyCount;
    private JLabel labelInfo;


    private JTextField textFieldFind;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldRole;
    private JTextField textFieldNumber;
    private JTextField textFieldTeam;
    private JTextField textFieldMins;
    private JTextField textFieldGoals;
    private JTextField textFieldAssists;
    private JTextField textFieldYC;
    private JTextField textFieldRC;
    private JTextField textFieldPsPerc;
    private JTextField textFieldStickGrip;
    private JTextField textFieldPenaltyTime;
    private JTextField textFieldPenaltyCount;

    private JButton buttonAdd;

    private Font font;

    public View(){
        super("Bookmaker's assistant");
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        setIconImage(new ImageIcon(Objects.requireNonNull(classloader.getResource("Icon.png"))).getImage());
        /*background = new JLabel(new ImageIcon(Objects.requireNonNull(classloader.getResource("Background.jpg"))));
        add(background);*/

        font = new Font("TimesRoman", 0, 14);

        menuBar = new JMenuBar();
        menuSport = new JMenu("Sport");
        footballItem = new JMenuItem("Football");
        hockeyItem = new JMenuItem("Hockey");
        basketItem = new JMenuItem("Basketball");
        menuSport.add(footballItem);
        menuSport.add(hockeyItem);
        menuSport.add(basketItem);
        menuBar.add(menuSport);

        menuMode = new JMenu("Mode");
        editModeItem = new JMenuItem("Edit mode");
        viewModeItem = new JMenuItem("View mode");
        menuMode.add(editModeItem);
        menuMode.add(viewModeItem);
        menuBar.add(menuMode);

        menuHelp = new JMenu("Help");
        helpInfo = new JMenuItem("Help information");
        infoAboutProg = new JMenuItem("Information about programm");
        menuHelp.add(helpInfo);
        menuHelp.add(infoAboutProg);
        menuBar.add(menuHelp);

        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);

        panelTop = new JPanel();
        labelFind = new JLabel("Searсh:");
        panelTop.add(labelFind);
        textFieldFind = new JTextField();
        textFieldFind.setFont(font);
        textFieldFind.setPreferredSize(new Dimension(300, 20));
        panelTop.add(textFieldFind);
        panelTop.setAlignmentX(0.5F);

        contCenter = new Container();
        contCenter.setLayout(new BoxLayout(contCenter,BoxLayout.PAGE_AXIS));
        playersTable = new JTable(new TableModel());
        scrollPane = new JScrollPane(playersTable);
        contCenter.add(scrollPane);

        labelHeader = new JLabel("Statistics");
        labelName = new JLabel("Name");
        labelSurname = new JLabel("Surname");
        labelRole = new JLabel("Role");
        labelNumber = new JLabel("Number");
        labelTeam = new JLabel("Team");
        labelMins = new JLabel("Minutes");
        labelGoals = new JLabel("Goals");
        labelAssists = new JLabel("Assists");
        labelYC = new JLabel("Yellow cards");
        labelRC = new JLabel("Red cards");
        labelPsPerc = new JLabel("Successful passes");
        labelStickGrip = new JLabel("Stick grip");
        labelPenaltyTime = new JLabel("Penalty time");
        labelPenaltyCount = new JLabel("Penalty count");

        textFieldName = new JTextField();
        textFieldName.setFont(font);
        textFieldSurname = new JTextField();
        textFieldSurname.setFont(font);
        textFieldRole = new JTextField();
        textFieldRole.setFont(font);
        textFieldNumber = new JTextField();
        textFieldNumber.setFont(font);
        textFieldTeam = new JTextField();
        textFieldTeam.setFont(font);
        textFieldMins = new JTextField();
        textFieldMins.setFont(font);
        textFieldGoals = new JTextField();
        textFieldGoals.setFont(font);
        textFieldAssists = new JTextField();
        textFieldAssists.setFont(font);
        textFieldYC = new JTextField();
        textFieldYC.setFont(font);
        textFieldRC = new JTextField();
        textFieldRC.setFont(font);
        textFieldPsPerc = new JTextField();
        textFieldPsPerc.setFont(font);
        textFieldStickGrip = new JTextField();
        textFieldStickGrip.setFont(font);
        textFieldPenaltyTime = new JTextField();
        textFieldPenaltyTime.setFont(font);
        textFieldPenaltyCount = new JTextField();
        textFieldPenaltyCount.setFont(font);

        contRight = new Container();
        contRight.setLayout(new BoxLayout(contRight, BoxLayout.PAGE_AXIS));
        labelHeader.setAlignmentX(0.5F);
        contRight.add(labelHeader);
        contInput = new Container();
        contInput.setLayout(new GridLayout(14, 2, 1, 5));
        contInput.add(labelName);
        contInput.add(textFieldName);
        contInput.add(labelSurname);
        contInput.add(textFieldSurname);
        contInput.add(labelRole);
        contInput.add(textFieldRole);
        contInput.add(labelNumber);
        contInput.add(textFieldNumber);
        contInput.add(labelTeam);
        contInput.add(textFieldTeam);
        contInput.add(labelMins);
        contInput.add(textFieldMins);
        contInput.add(labelGoals);
        contInput.add(textFieldGoals);
        contInput.add(labelAssists);
        contInput.add(textFieldAssists);
        contInput.add(labelYC);
        contInput.add(textFieldYC);
        contInput.add(labelRC);
        contInput.add(textFieldRC);
        contInput.add(labelPsPerc);
        contInput.add(textFieldPsPerc);
        contInput.add(labelStickGrip);
        contInput.add(textFieldStickGrip);
        contInput.add(labelPenaltyTime);
        contInput.add(textFieldPenaltyTime);
        contInput.add(labelPenaltyCount);
        contInput.add(textFieldPenaltyCount);
        contRight.add(contInput);
        buttonAdd = new JButton("Add");
        buttonAdd.setAlignmentX(0.5F);
        contRight.add(buttonAdd);



        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        constraints.insets = new Insets(2,2,2,2);
        constraints.weightx = 1.00;
        constraints.weighty = 1.00;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(panelTop, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(contCenter, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(contRight, constraints);
        labelInfo = new JLabel("Information");
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(labelInfo, constraints);

        setVisible(true);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public JLabel getLabelHeader() {
        return labelHeader;
    }

    public JTextField getTextFieldFind() {
        return textFieldFind;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public JTextField getTextFieldRole() {
        return textFieldRole;
    }

    public JTextField getTextFieldNumber() {
        return textFieldNumber;
    }

    public JTextField getTextFieldTeam() {
        return textFieldTeam;
    }

    public JTextField getTextFieldMins() {
        return textFieldMins;
    }

    public JTextField getTextFieldGoals() {
        return textFieldGoals;
    }

    public JTextField getTextFieldAssists() {
        return textFieldAssists;
    }

    public JTextField getTextFieldYC() {
        return textFieldYC;
    }

    public JTextField getTextFieldRC() {
        return textFieldRC;
    }

    public JTextField getTextFieldPsPerc() {
        return textFieldPsPerc;
    }

    public JTextField getTextFieldStickGrip() {
        return textFieldStickGrip;
    }

    public JTextField getTextFieldPenaltyTime() {
        return textFieldPenaltyTime;
    }

    public JTextField getTextFieldPenaltyCount() {
        return textFieldPenaltyCount;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JTable getPlayersTable(){
        return playersTable;
    }

    public JMenuItem getFootballItem() {
        return footballItem;
    }

    public JMenuItem getHockeyItem() {
        return hockeyItem;
    }

    public JMenuItem getBasketItem() {
        return basketItem;
    }

    public JMenuItem getEditModeItem() {
        return editModeItem;
    }

    public JMenuItem getViewModeItem() {
        return viewModeItem;
    }

    public JMenuItem getHelpInfo() {
        return helpInfo;
    }

    public JMenuItem getInfoAboutProg() {
        return infoAboutProg;
    }

    public void setFootballEnabled(boolean b) {
        labelStickGrip.setEnabled(b);
        textFieldStickGrip.setEnabled(b);
        labelPenaltyTime.setEnabled(b);
        textFieldPenaltyTime.setEnabled(b);
        labelPenaltyCount.setEnabled(b);
        textFieldPenaltyCount.setEnabled(b);
    }

    public void setHockeyEnabled(boolean b) {
        labelYC.setEnabled(b);
        textFieldYC.setEnabled(b);
        labelRC.setEnabled(b);
        textFieldRC.setEnabled(b);
        labelPsPerc.setEnabled(b);
        textFieldPsPerc.setEnabled(b);
    }

    public void setBasketEnabled(boolean b) {
        labelYC.setEnabled(b);
        textFieldYC.setEnabled(b);
        labelRC.setEnabled(b);
        textFieldRC.setEnabled(b);
        labelPsPerc.setEnabled(b);
        textFieldPsPerc.setEnabled(b);
        labelStickGrip.setEnabled(b);
        textFieldStickGrip.setEnabled(b);
        labelPenaltyTime.setEnabled(b);
        textFieldPenaltyTime.setEnabled(b);
        labelPenaltyCount.setEnabled(b);
        textFieldPenaltyCount.setEnabled(b);
    }

    public void setAllTFEnabled(boolean b) {
        //labelName.setEnabled(b);
        textFieldName.setEnabled(b);
        //labelSurname.setEnabled(b);
        textFieldSurname.setEnabled(b);
        //labelRole.setEnabled(b);
        textFieldRole.setEnabled(b);
        //labelNumber.setEnabled(b);
        textFieldNumber.setEnabled(b);
        //labelTeam.setEnabled(b);
        textFieldTeam.setEnabled(b);
        //labelMins.setEnabled(b);
        textFieldMins.setEnabled(b);
        //labelGoals.setEnabled(b);
        textFieldGoals.setEnabled(b);
        //labelAssists.setEnabled(b);
        textFieldAssists.setEnabled(b);
        //labelYC.setEnabled(b);
        textFieldYC.setEnabled(b);
        //labelRC.setEnabled(b);
        textFieldRC.setEnabled(b);
        //labelPsPerc.setEnabled(b);
        textFieldPsPerc.setEnabled(b);
        //labelStickGrip.setEnabled(b);
        textFieldStickGrip.setEnabled(b);
        //labelPenaltyTime.setEnabled(b);
        textFieldPenaltyTime.setEnabled(b);
        //labelPenaltyCount.setEnabled(b);
        textFieldPenaltyCount.setEnabled(b);
    }
}
