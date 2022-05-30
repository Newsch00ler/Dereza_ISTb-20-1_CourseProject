package GUI;

import DB.Database;
import Model.SoccerPlayer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Controller {
    private boolean modeFlag = false;
    private int sportFlag = 1;

    public Controller(){}

    public void execute(View mainView){
        mainView.getMenuSport().setToolTipText("<html>" + "Choice of sport" + "<br>" + "</html>");
        mainView.getMenuMode().setToolTipText("<html>" + "Mode selection" + "<br>" + "</html>");
        mainView.getMenuHelp().setToolTipText("<html>" + "Program information" + "<br>" + "</html>");
        mainView.getTextFieldFind().setToolTipText("<html>" + "The search is performed on all values of the table" + "<br>" + "</html>");

        mainView.getTextFieldNumber().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldMins().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldGoals().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldGoals().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldAssists().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldYC().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldRC().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldPsPerc().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldPenaltyTime().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldPenaltyCount().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldRebounds().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        mainView.getTextFieldBlocks().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        mainView.getButtonAdd().setEnabled(false);
        mainView.getLabelHeader().setText("Statistic");
        mainView.setAllEnabled(false);
        mainView.getEditModeItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                modeFlag = true;
                sportFlag = 1;
                mainView.getLabelHeader().setText("Add soccer");
                mainView.getButtonAdd().setEnabled(true);
                mainView.setFootballEnabled(true);
            }
        });
        mainView.getViewModeItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                modeFlag = false;
                mainView.getLabelHeader().setText("Statistic");
                mainView.getButtonAdd().setEnabled(false);
                mainView.setAllEnabled(false);
            }
        });
        mainView.getFootballItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                if(modeFlag){
                    sportFlag = 1;
                    mainView.getLabelHeader().setText("Add soccer");
                    mainView.getButtonAdd().setEnabled(true);
                    mainView.setFootballEnabled(true);
                }
                else{
                    mainView.getButtonAdd().setEnabled(false);
                    mainView.setAllEnabled(false);
                }
            }
        });
        mainView.getHockeyItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                if(modeFlag){
                    sportFlag = 2;
                    mainView.getLabelHeader().setText("Add hockey player");
                    mainView.getButtonAdd().setEnabled(true);
                    mainView.setHockeyEnabled(true);
                }
                else{
                    mainView.getButtonAdd().setEnabled(false);
                    mainView.setAllEnabled(false);
                }
            }
        });
        mainView.getBasketItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                if(modeFlag){
                    sportFlag = 3;
                    mainView.getLabelHeader().setText("Add basketball player");
                    mainView.getButtonAdd().setEnabled(true);
                    mainView.setBasketEnabled(true);
                }
                else{
                    mainView.getButtonAdd().setEnabled(false);
                    mainView.setAllEnabled(false);
                }
            }
        });
        mainView.getHelpInfo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(mainView, ("<html>" + "Information:"
                        + "<br>" + "Minutes - time on the field"
                        + "<br>" + "Assists - passes for goals"
                        + "<br>" + "Successful passes - number of accurate passes"
                        + "<br>" + "Stick grip - which side the player is holding the stick"
                        + "<br>" + "Penalty time - time of all violations"
                        + "<br>" + "Penalty count - count of all violations"
                        + "</html>"), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mainView.getInfoAboutProg().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(mainView, ("<html>" + "Information about programm:"
                        + "<br>" + "Software product version IntelliJ IDEA 2021.3.3 (Community Edition)"
                        + "<br>" + "Date of last changes in the program: 06/01/2022"
                        + "<br>" + "Author's coordinates: Alexander Igorevich Dereza, Irkutsk National Research Technical University, ISTb-20-1, e-mail: daleks19@mail.ru"
                        + "</html>"), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mainView.addWindowListener(new WindowAdapter() {
            /*@Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Yes", "No"};
                int confirm = JOptionPane.showOptionDialog(mainView,"Close and exit?","Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                if(confirm == JOptionPane.YES_OPTION){
                    System.exit(0);
                    mainView.dispose();
                }
            }*/
        });
        /*mainView.getRemButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = mainView.getPlayersTable().getSelectedRow();
                try {
                    if (index == -1) {
                        throw new Exception("Игрок не выбран!");
                    }
                    else{
                        JOptionPane.showMessageDialog(mainView, "Игрок " + mainView.getTableModel().getItem(index) + " удалён!", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                        mainView.getTableModel().removeRow(index);
                    }
                    if (mainView.getTableModel().getRowCount() == 0) {
                        mainView.getFindTextField().setEnabled(false);
                        mainView.getRemButton().setEnabled(false);
                        mainView.getRemAllButton().setEnabled(false);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainView, ex.getMessage(), "Предупреждение", JOptionPane.WARNING_MESSAGE); //
                }
            }
        });*/
        /*mainWindow.getRemAllButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainWindow.getTableModel().removeAllRow();
                JOptionPane.showMessageDialog(mainWindow, "Все игроки удалены!", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                mainWindow.getFindTextField().setEnabled(false);
                mainWindow.getRemButton().setEnabled(false);
                mainWindow.getRemAllButton().setEnabled(false);
            }
        });*/
        mainView.getButtonAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String name;
                String surname;
                int number;
                String role;
                String team;
                int mins;
                int goals;
                int assists;
                int yC;
                int rC;
                int pS;
                String stickGrip;
                int penTime;
                int penCount;
                int rebounds;
                int blocks;
                try{
                    if (mainView.getTextFieldName().getText().isEmpty() && mainView.getTextFieldSurname().getText().isEmpty() && mainView.getTextFieldNumber().getText().isEmpty() &&
                            mainView.getTextFieldTeam().getText().isEmpty() && mainView.getTextFieldMins().getText().isEmpty() && mainView.getTextFieldGoals().getText().isEmpty() &&
                            mainView.getTextFieldAssists().getText().isEmpty() && mainView.getTextFieldYC().getText().isEmpty() && mainView.getTextFieldRC().getText().isEmpty() &&
                            mainView.getTextFieldPsPerc().getText().isEmpty() && mainView.getTextFieldPenaltyTime().getText().isEmpty() && mainView.getTextFieldPenaltyCount().getText().isEmpty() &&
                            mainView.getTextFieldRebounds().getText().isEmpty() && mainView.getTextFieldBlocks().getText().isEmpty()){
                        throw new Exception(" not created! Enter data!");
                    }
                    else if (mainView.getTextFieldName().getText().isEmpty()){
                        throw new Exception(" name not entered!");
                    }
                    else if (mainView.getTextFieldSurname().getText().isEmpty()){
                        throw new Exception(" surname not entered!");
                    }
                    else if (mainView.getTextFieldNumber().getText().isEmpty()){
                        throw new Exception(" number not entered!");
                    }
                    else if (mainView.getTextFieldTeam().getText().isEmpty()){
                        throw new Exception(" team not entered!");
                    }
                    else if (mainView.getTextFieldMins().getText().isEmpty()){
                        throw new Exception(" minutes on the field is not entered!");
                    }
                    else if (mainView.getTextFieldGoals().getText().isEmpty()){
                        throw new Exception(" goals on the field not entered!");
                    }
                    else if (mainView.getTextFieldAssists().getText().isEmpty()){
                        throw new Exception(" assists on the field not entered!");
                    }
                    if(sportFlag == 1){
                        if (mainView.getTextFieldYC().getText().isEmpty()){
                            throw new Exception(" minutes on the field is not entered!");
                        }
                        else if (mainView.getTextFieldRC().getText().isEmpty()){
                            throw new Exception(" goals on the field not entered!");
                        }
                        else if (mainView.getTextFieldPsPerc().getText().isEmpty()){
                            throw new Exception(" assists on the field not entered!");
                        }
                        name = mainView.getTextFieldName().getText();
                        surname = mainView.getTextFieldSurname().getText();
                        number = Integer.parseInt(mainView.getTextFieldNumber().getText());
                        role = (String) mainView.getComboRole().getSelectedItem();
                        team = mainView.getTextFieldTeam().getText();
                        mins = Integer.parseInt(mainView.getTextFieldMins().getText());
                        goals = Integer.parseInt(mainView.getTextFieldGoals().getText());
                        assists = Integer.parseInt(mainView.getTextFieldAssists().getText());
                        yC = Integer.parseInt(mainView.getTextFieldYC().getText());
                        rC = Integer.parseInt(mainView.getTextFieldRC().getText());
                        pS = Integer.parseInt(mainView.getTextFieldPsPerc().getText());
                        if (number < 1 || number > 99){
                            mainView.getTextFieldNumber().setText(null);
                            throw new Exception(" number entered incorrectly! Enter a number from 1 to 99!");
                        }
                        else{
                            //player = new SoccerPlayer(name, stickGrip, number, perc);
                            //hockeyTeam.add(player);
                        }
                        mainView.clearAll();
                    }
                    else if(sportFlag == 2){
                        if (mainView.getTextFieldYC().getText().isEmpty()){
                            throw new Exception(" minutes on the field is not entered!");
                        }
                        else if (mainView.getTextFieldRC().getText().isEmpty()){
                            throw new Exception(" goals on the field not entered!");
                        }
                        else if (mainView.getTextFieldPsPerc().getText().isEmpty()){
                            throw new Exception(" assists on the field not entered!");
                        }
                        name = mainView.getTextFieldName().getText();
                        surname = mainView.getTextFieldSurname().getText();
                        number = Integer.parseInt(mainView.getTextFieldNumber().getText());
                        role = (String) mainView.getComboRole().getSelectedItem();
                        team = mainView.getTextFieldTeam().getText();
                        mins = Integer.parseInt(mainView.getTextFieldMins().getText());
                        goals = Integer.parseInt(mainView.getTextFieldGoals().getText());
                        assists = Integer.parseInt(mainView.getTextFieldAssists().getText());
                        yC = Integer.parseInt(mainView.getTextFieldYC().getText());
                        rC = Integer.parseInt(mainView.getTextFieldRC().getText());
                        pS = Integer.parseInt(mainView.getTextFieldPsPerc().getText());
                        if (number < 1 || number > 99){
                            mainView.getTextFieldNumber().setText(null);
                            throw new Exception(" number entered incorrectly! Enter a number from 1 to 99!");
                        }
                        else{
                            //player = new SoccerPlayer(name, stickGrip, number, perc);
                            //hockeyTeam.add(player);
                        }
                        mainView.clearAll();
                    }
                    else if (sportFlag == 3){
                        if (mainView.getTextFieldYC().getText().isEmpty()){
                            throw new Exception(" minutes on the field is not entered!");
                        }
                        else if (mainView.getTextFieldRC().getText().isEmpty()){
                            throw new Exception(" goals on the field not entered!");
                        }
                        else if (mainView.getTextFieldPsPerc().getText().isEmpty()){
                            throw new Exception(" assists on the field not entered!");
                        }
                        name = mainView.getTextFieldName().getText();
                        surname = mainView.getTextFieldSurname().getText();
                        number = Integer.parseInt(mainView.getTextFieldNumber().getText());
                        role = (String) mainView.getComboRole().getSelectedItem();
                        team = mainView.getTextFieldTeam().getText();
                        mins = Integer.parseInt(mainView.getTextFieldMins().getText());
                        goals = Integer.parseInt(mainView.getTextFieldGoals().getText());
                        assists = Integer.parseInt(mainView.getTextFieldAssists().getText());
                        yC = Integer.parseInt(mainView.getTextFieldYC().getText());
                        rC = Integer.parseInt(mainView.getTextFieldRC().getText());
                        pS = Integer.parseInt(mainView.getTextFieldPsPerc().getText());
                        if (number < 1 || number > 99){
                            mainView.getTextFieldNumber().setText(null);
                            throw new Exception("number entered incorrectly! Enter a number from 1 to 99!");
                        }
                        else{
                            //player = new SoccerPlayer(name, stickGrip, number, perc);
                            //hockeyTeam.add(player);
                        }
                        mainView.clearAll();
                    }
                }
                catch (Exception ex){
                    if(sportFlag == 1){
                        JOptionPane.showMessageDialog(mainView, "Soccer" + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(sportFlag == 2){
                        JOptionPane.showMessageDialog(mainView, "Hockey player" + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else if (sportFlag == 3){
                        JOptionPane.showMessageDialog(mainView, "Basketball player" + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        mainView.getTextFieldFind().getDocument().addDocumentListener(new DocumentListener() {
            private void newFilter(){
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(mainView.getTableModel());
                mainView.getPlayersTable().setRowSorter(sorter);
                RowFilter<TableModel, Object>player= null;
                try {
                    player = RowFilter.regexFilter(mainView.getTextFieldFind().getText());
                }
                catch (PatternSyntaxException e) {
                    return;
                }
                sorter.setRowFilter(player);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                newFilter();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                newFilter();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                newFilter();
            }
        });
    }
}
