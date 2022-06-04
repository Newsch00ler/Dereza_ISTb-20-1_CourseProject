package GUI;

import DB.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Objects;

public class View extends JFrame {
    private TableModel tableModel;
    private JTable playersTable;
    private JScrollPane scrollPane;

    private JMenuBar menuBar;
    private JMenu menuSport;
    private JMenuItem footballItem;
    private JMenuItem hockeyItem;
    private JMenuItem basketItem;
    private JMenu menuSportV;
    private JMenuItem footballItemV;
    private JMenuItem hockeyItemV;
    private JMenuItem basketItemV;
    private JMenu menuMode;
    private JMenuItem editModeItem;
    private JMenuItem viewModeItem;
    private JMenu menuModeV;
    private JMenuItem editModeItemV;
    private JMenuItem viewModeItemV;
    private JMenu menuHelp;
    private JMenuItem helpInfo;
    private JMenuItem infoAboutProg;
    private JPanel panelTop;
    private Container contCenter;
    private Container contRight;
    private Container contInput;
    private JPopupMenu popupEdit;
    private JPopupMenu popupView;
    private JMenuItem popupDeleteItem;
    private JMenu popupSportMenu;
    private JMenu popupModeMenu;
    private JMenu popupSportMenuV;
    private JMenu popupModeMenuV;

    //private JLabel background;
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
    private JLabel labelRebounds;
    private JLabel labelBlocks;

    private JTextField textFieldFind;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldNumber;
    private JTextField textFieldTeam;
    private JTextField textFieldMins;
    private JTextField textFieldGoals;
    private JTextField textFieldAssists;
    private JTextField textFieldYC;
    private JTextField textFieldRC;
    private JTextField textFieldPsPerc;
    private JTextField textFieldPenaltyTime;
    private JTextField textFieldPenaltyCount;
    private JTextField textFieldRebounds;
    private JTextField textFieldBlocks;

    private JComboBox comboRole;
    private JComboBox comboStickGrip;
    private JButton button;

    private Font font;

    private Color colorFootball1 = new Color(82, 220, 38);
    private Color colorFootball2 = new Color(154, 238, 130);
    private Color colorHockey1 = new Color(92, 92, 231);
    private Color colorHockey2 = new Color(142, 142, 236);
    private Color colorBasket1 = new Color(220, 93, 14);
    private Color colorBasket2 = new Color(225, 154, 116);
    private Color colorStat = new Color(173, 167, 167);

    private String[] itemsRolesFH = {
            "Keeper",
            "Defender",
            "Midfielder",
            "Forward"
    };

    private String[] itemsRolesB = {
            "Defender",
            "Small forward",
            "Power forward",
            "Central"
    };

    private String[] itemsStickGrip = {
            "Left",
            "Right"
    };

    public View(Database database){
        super("Bookmaker's assistant");
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        setIconImage(new ImageIcon(Objects.requireNonNull(classloader.getResource("Icon.png"))).getImage());
        //background = new JLabel(new ImageIcon(Objects.requireNonNull(classloader.getResource("Background.jpg"))));
        //add(background);
        font = new Font("TimesRoman", 0, 14);

        popupEdit = new JPopupMenu();
        popupDeleteItem = new JMenuItem("Delete");
        popupEdit.add(popupDeleteItem);
        popupSportMenu = new JMenu("Sport");
        popupModeMenu = new JMenu("Mode");
        popupEdit.add(popupSportMenu);
        popupEdit.add(popupModeMenu);
        footballItem = new JMenuItem("Football");
        hockeyItem = new JMenuItem("Hockey");
        basketItem = new JMenuItem("Basketball");
        popupSportMenu.add(footballItem);
        popupSportMenu.add(hockeyItem);
        popupSportMenu.add(basketItem);
        editModeItem = new JMenuItem("Edit mode");
        viewModeItem = new JMenuItem("View mode");
        popupModeMenu.add(editModeItem);
        popupModeMenu.add(viewModeItem);
        add(popupEdit);

        popupView = new JPopupMenu();
        popupSportMenuV = new JMenu("Sport");
        popupModeMenuV = new JMenu("Mode");
        popupView.add(popupSportMenuV);
        popupView.add(popupModeMenuV);
        footballItemV = new JMenuItem("Football");
        hockeyItemV = new JMenuItem("Hockey");
        basketItemV = new JMenuItem("Basketball");
        popupSportMenuV.add(footballItemV);
        popupSportMenuV.add(hockeyItemV);
        popupSportMenuV.add(basketItemV);
        editModeItemV = new JMenuItem("Edit mode");
        viewModeItemV = new JMenuItem("View mode");
        popupModeMenuV.add(editModeItemV);
        popupModeMenuV.add(viewModeItemV);
        add(popupView);

        menuBar = new JMenuBar();
        menuBar.setBackground(colorFootball1);
        menuSport = new JMenu("Sport");
        //footballItem = new JMenuItem("Football");
        footballItem.setBackground(colorFootball2);
        //hockeyItem = new JMenuItem("Hockey");
        hockeyItem.setBackground(colorFootball2);
        //basketItem = new JMenuItem("Basketball");
        basketItem.setBackground(colorFootball2);
        menuSport.add(footballItem);
        menuSport.add(hockeyItem);
        menuSport.add(basketItem);
        menuBar.add(menuSport);

        menuMode = new JMenu("Mode");
        //editModeItem = new JMenuItem("Edit mode");
        editModeItem.setBackground(colorFootball2);
        //viewModeItem = new JMenuItem("View mode");
        viewModeItem.setBackground(colorFootball2);
        menuMode.add(editModeItem);
        menuMode.add(viewModeItem);
        menuBar.add(menuMode);

        menuHelp = new JMenu("Help");
        helpInfo = new JMenuItem("Help information");
        helpInfo.setBackground(colorFootball2);
        infoAboutProg = new JMenuItem("About");
        infoAboutProg.setBackground(colorFootball2);
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
        tableModel = new TableModel(database);
        playersTable = new JTable(tableModel){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                TableColumn tableColumn = getColumnModel().getColumn(column);
                switch(column){
                    case 0:
                        tableColumn.setMinWidth(55);
                        tableColumn.setMaxWidth(55);
                        break;
                    case 1:
                        tableColumn.setPreferredWidth(85);
                        break;
                    case 2:
                        tableColumn.setPreferredWidth(85);
                        break;
                    case 3:
                        tableColumn.setMinWidth(55);
                        tableColumn.setMaxWidth(55);
                        break;
                    case 4:
                        tableColumn.setPreferredWidth(85);
                        break;
                    case 5:
                        tableColumn.setPreferredWidth(85);
                        break;
                    case 6:
                        tableColumn.setMinWidth(50);
                        tableColumn.setMaxWidth(50);
                        break;
                    case 7:
                        tableColumn.setMinWidth(50);
                        tableColumn.setMaxWidth(50);
                        break;
                    case 8:
                        tableColumn.setMinWidth(50);
                        tableColumn.setMaxWidth(50);
                        break;
                }
                return component;
            }
        };
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)playersTable.getDefaultRenderer(String.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        playersTable.setBackground(colorFootball2);
        scrollPane = new JScrollPane(playersTable);
        contCenter.setMaximumSize(new Dimension(600, 450));
        contCenter.setPreferredSize(new Dimension(600, 450));
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
        labelRebounds = new JLabel("Rebounds");
        labelBlocks = new JLabel("Blocks");

        textFieldName = new JTextField();
        textFieldName.setFont(font);
        textFieldSurname = new JTextField();
        textFieldSurname.setFont(font);
        comboRole = new JComboBox(itemsRolesFH);
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
        comboStickGrip = new JComboBox(itemsStickGrip);
        textFieldPenaltyTime = new JTextField();
        textFieldPenaltyTime.setFont(font);
        textFieldPenaltyCount = new JTextField();
        textFieldPenaltyCount.setFont(font);
        textFieldRebounds = new JTextField();
        textFieldRebounds.setFont(font);
        textFieldBlocks = new JTextField();
        textFieldBlocks.setFont(font);

        contRight = new Container();
        contRight.setLayout(new BoxLayout(contRight, BoxLayout.PAGE_AXIS));
        labelHeader.setAlignmentX(0.5F);
        contRight.add(labelHeader);
        contInput = new Container();
        contInput.setLayout(new GridLayout(16, 2, 1, 5));
        contInput.add(labelName);
        contInput.add(textFieldName);
        contInput.add(labelSurname);
        contInput.add(textFieldSurname);
        contInput.add(labelRole);
        contInput.add(comboRole);
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
        contInput.add(comboStickGrip);
        contInput.add(labelPenaltyTime);
        contInput.add(textFieldPenaltyTime);
        contInput.add(labelPenaltyCount);
        contInput.add(textFieldPenaltyCount);
        contInput.add(labelRebounds);
        contInput.add(textFieldRebounds);
        contInput.add(labelBlocks);
        contInput.add(textFieldBlocks);
        contInput.setMaximumSize(new Dimension(300, 450));
        contInput.setPreferredSize(new Dimension(300, 450));
        contRight.add(contInput);
        button = new JButton("Add");
        button.setAlignmentX(0.5F);
        //contRight.setPreferredSize(new Dimension(300, 510));
        contRight.add(button);

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

        setVisible(true);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public JScrollPane getScrollPane() { return scrollPane; }

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

    public JComboBox getComboRole() {
        return comboRole;
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

    public JComboBox getComboStickGrip() {
        return comboStickGrip;
    }

    public JTextField getTextFieldPenaltyTime() {
        return textFieldPenaltyTime;
    }

    public JTextField getTextFieldPenaltyCount() {
        return textFieldPenaltyCount;
    }

    public JTextField getTextFieldRebounds() { return textFieldRebounds; }

    public JTextField getTextFieldBlocks() { return textFieldBlocks; }

    public JButton getButton() {
        return button;
    }

    public TableModel getTableModel() { return tableModel; }

    public JTable getPlayersTable(){
        return playersTable;
    }

    public JPopupMenu getPopupEdit() { return popupEdit; }

    public JPopupMenu getPopupView() { return popupView; }

    public JMenuItem getPopupDeleteItem() { return popupDeleteItem; }

    public JMenu getPopupSportMenu() {return popupSportMenu; }

    public JMenu getPopupModeMenu() {return popupModeMenu; }

    public JMenu getMenuSport() { return menuSport; }

    public JMenuItem getFootballItem() {
        return footballItem;
    }

    public JMenuItem getHockeyItem() {
        return hockeyItem;
    }

    public JMenuItem getBasketItem() {
        return basketItem;
    }

    public JMenu getMenuMode() { return menuMode; }

    public JMenuItem getEditModeItem() {
        return editModeItem;
    }

    public JMenuItem getViewModeItem() {
        return viewModeItem;
    }

    public JMenu getMenuHelp() { return menuHelp; }

    public JMenuItem getInfoAboutProg() {
        return infoAboutProg;
    }

    public JMenuItem getHelpInfo() {
        return helpInfo;
    }

    public void setFootballEnabled(boolean b) {
        textFieldName.setEnabled(b);
        textFieldSurname.setEnabled(b);
        comboRole.removeAllItems();
        for(String i : itemsRolesFH){
            comboRole.addItem(i);
        }
        comboRole.setEnabled(b);
        textFieldNumber.setEnabled(b);
        textFieldTeam.setEnabled(b);
        textFieldMins.setEnabled(b);
        textFieldGoals.setEnabled(b);
        textFieldAssists.setEnabled(b);
        labelYC.setEnabled(b);
        textFieldYC.setEnabled(b);
        labelRC.setEnabled(b);
        textFieldRC.setEnabled(b);
        labelPsPerc.setEnabled(b);
        textFieldPsPerc.setEnabled(b);
        labelStickGrip.setEnabled(!b);
        comboStickGrip.setEnabled(!b);
        labelPenaltyTime.setEnabled(!b);
        textFieldPenaltyTime.setEnabled(!b);
        labelPenaltyCount.setEnabled(!b);
        textFieldPenaltyCount.setEnabled(!b);
        labelRebounds.setEnabled(!b);
        textFieldRebounds.setEnabled(!b);
        labelBlocks.setEnabled(!b);
        textFieldBlocks.setEnabled(!b);
    }

    public void setColorFootball(boolean b){
        menuBar.setBackground(colorFootball1);
        footballItem.setBackground(colorFootball2);
        hockeyItem.setBackground(colorFootball2);
        basketItem.setBackground(colorFootball2);
        editModeItem.setBackground(colorFootball2);
        viewModeItem.setBackground(colorFootball2);
        helpInfo.setBackground(colorFootball2);
        infoAboutProg.setBackground(colorFootball2);
        playersTable.setBackground(colorFootball2);
    }

    public void setHockeyEnabled(boolean b) {
        textFieldName.setEnabled(b);
        textFieldSurname.setEnabled(b);
        comboRole.removeAllItems();
        for(String i : itemsRolesFH){
            comboRole.addItem(i);
        }
        comboRole.setEnabled(b);
        textFieldNumber.setEnabled(b);
        textFieldTeam.setEnabled(b);
        textFieldMins.setEnabled(b);
        textFieldGoals.setEnabled(b);
        textFieldAssists.setEnabled(b);
        labelYC.setEnabled(!b);
        textFieldYC.setEnabled(!b);
        labelRC.setEnabled(!b);
        textFieldRC.setEnabled(!b);
        labelPsPerc.setEnabled(!b);
        textFieldPsPerc.setEnabled(!b);
        labelStickGrip.setEnabled(b);
        comboStickGrip.setEnabled(b);
        labelPenaltyTime.setEnabled(b);
        textFieldPenaltyTime.setEnabled(b);
        labelPenaltyCount.setEnabled(b);
        textFieldPenaltyCount.setEnabled(b);
        labelRebounds.setEnabled(!b);
        textFieldRebounds.setEnabled(!b);
        labelBlocks.setEnabled(!b);
        textFieldBlocks.setEnabled(!b);
    }

    public void setColorHockey(boolean b) {
        menuBar.setBackground(colorHockey1);
        footballItem.setBackground(colorHockey2);
        hockeyItem.setBackground(colorHockey2);
        basketItem.setBackground(colorHockey2);
        editModeItem.setBackground(colorHockey2);
        viewModeItem.setBackground(colorHockey2);
        helpInfo.setBackground(colorHockey2);
        infoAboutProg.setBackground(colorHockey2);
        playersTable.setBackground(colorHockey2);
    }

    public void setBasketEnabled(boolean b) {
        textFieldName.setEnabled(b);
        textFieldSurname.setEnabled(b);
        comboRole.removeAllItems();
        for(String i : itemsRolesB){
            comboRole.addItem(i);
        }
        comboRole.setEnabled(b);
        textFieldNumber.setEnabled(b);
        textFieldTeam.setEnabled(b);
        textFieldMins.setEnabled(b);
        textFieldGoals.setEnabled(b);
        textFieldAssists.setEnabled(b);
        labelYC.setEnabled(!b);
        textFieldYC.setEnabled(!b);
        labelRC.setEnabled(!b);
        textFieldRC.setEnabled(!b);
        labelPsPerc.setEnabled(!b);
        textFieldPsPerc.setEnabled(!b);
        labelStickGrip.setEnabled(!b);
        comboStickGrip.setEnabled(!b);
        labelPenaltyTime.setEnabled(!b);
        textFieldPenaltyTime.setEnabled(!b);
        labelPenaltyCount.setEnabled(!b);
        textFieldPenaltyCount.setEnabled(!b);
        labelRebounds.setEnabled(b);
        textFieldRebounds.setEnabled(b);
        labelBlocks.setEnabled(b);
        textFieldBlocks.setEnabled(b);
    }

    public void setColorBasket(boolean b) {
        menuBar.setBackground(colorBasket1);
        footballItem.setBackground(colorBasket2);
        hockeyItem.setBackground(colorBasket2);
        basketItem.setBackground(colorBasket2);
        editModeItem.setBackground(colorBasket2);
        viewModeItem.setBackground(colorBasket2);
        helpInfo.setBackground(colorBasket2);
        infoAboutProg.setBackground(colorBasket2);
        playersTable.setBackground(colorBasket2);
    }

    public void setAllEnabled(boolean b) {
        menuBar.setBackground(colorStat);
        footballItem.setBackground(colorStat);
        hockeyItem.setBackground(colorStat);
        basketItem.setBackground(colorStat);
        editModeItem.setBackground(colorStat);
        viewModeItem.setBackground(colorStat);
        helpInfo.setBackground(colorStat);
        infoAboutProg.setBackground(colorStat);
        playersTable.setBackground(colorStat);
        textFieldName.setEnabled(b);
        textFieldSurname.setEnabled(b);
        comboRole.removeAllItems();
        for(String i : itemsRolesFH){
            comboRole.addItem(i);
        }
        comboRole.setEnabled(b);
        textFieldNumber.setEnabled(b);
        textFieldTeam.setEnabled(b);
        textFieldMins.setEnabled(b);
        textFieldGoals.setEnabled(b);
        textFieldAssists.setEnabled(b);
        labelYC.setEnabled(!b);
        textFieldYC.setEnabled(b);
        labelRC.setEnabled(!b);
        textFieldRC.setEnabled(b);
        labelPsPerc.setEnabled(!b);
        textFieldPsPerc.setEnabled(b);
        labelStickGrip.setEnabled(!b);
        comboStickGrip.setEnabled(b);
        labelPenaltyTime.setEnabled(!b);
        textFieldPenaltyTime.setEnabled(b);
        labelPenaltyCount.setEnabled(!b);
        textFieldPenaltyCount.setEnabled(b);
        labelRebounds.setEnabled(!b);
        textFieldRebounds.setEnabled(b);
        labelBlocks.setEnabled(!b);
        textFieldBlocks.setEnabled(b);
    }

    public void clearAll(){
        getTextFieldName().setText(null);
        getTextFieldSurname().setText(null);
        getComboRole().setSelectedIndex(0);
        getTextFieldNumber().setText(null);
        getTextFieldTeam().setText(null);
        getTextFieldMins().setText(null);
        getTextFieldGoals().setText(null);
        getTextFieldAssists().setText(null);
        getTextFieldYC().setText(null);
        getTextFieldRC().setText(null);
        getTextFieldPsPerc().setText(null);
        getComboStickGrip().setSelectedIndex(0);
        getTextFieldPenaltyTime().setText(null);
        getTextFieldPenaltyCount().setText(null);
        getTextFieldRebounds().setText(null);
        getTextFieldBlocks().setText(null);
        getTableModel().fireTableDataChanged();
    }
}
