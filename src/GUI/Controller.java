package GUI;

import DB.Database;
import Model.BasketballPlayer;
import Model.HockeyPlayer;
import Model.SoccerPlayer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.regex.PatternSyntaxException;

public class Controller {
    private boolean modeFlag = false;
    private int sportFlag = 1;
    private int row;
    private String cell;
    private String name;
    private String surname;
    private int number;
    private String role;
    private String team;
    private int mins;
    private int goals;
    private int assists;
    private int yC;
    private int rC;
    private int pS;
    private String stickGrip;
    private int penTime;
    private int penCount;
    private int rebounds;
    private int blocks;
    public Controller(){}

    public void execute(Database database, View mainView){
        mainView.getLabelHeader().setText("Statistic soccer");
        mainView.getButton().setEnabled(false);
        mainView.setAllEnabledFH(false);
        mainView.getComboRole().setSelectedItem(null);
        mainView.getComboStickGrip().setSelectedItem(null);
        mainView.getMenuSport().setToolTipText("<html>" + "Choice of sport" + "<br>" + "</html>");
        mainView.getMenuMode().setToolTipText("<html>" + "Mode selection" + "<br>" + "</html>");
        mainView.getMenuHelp().setToolTipText("<html>" + "Program information" + "<br>" + "</html>");
        mainView.getTextFieldFind().setToolTipText("<html>" + "The search is performed on all values of the table" + "<br>" + "</html>");

        mainView.getEditModeItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modeFlag = true;
                mainView.clearAll();
                mainView.getButton().setText("Add");
                mainView.getButton().setEnabled(true);
                try{
                    database.getAllPlayerList().clear();
                    if(sportFlag == 1){
                        database.setAllPlayerList(database.getAllSoccersList());
                        mainView.getLabelHeader().setText("Add soccer");
                        mainView.setFootballEnabled(true);
                        mainView.setColorFootball();
                    }
                    else if(sportFlag == 2){
                        database.setAllPlayerList(database.getAllHockeyPlsList());
                        mainView.getLabelHeader().setText("Add hockey player");
                        mainView.setHockeyEnabled(true);
                        mainView.setColorHockey();
                    }
                    else if(sportFlag == 3){
                        database.setAllPlayerList(database.getAllBasketPlsList());
                        mainView.getLabelHeader().setText("Add basketball player");
                        mainView.setBasketEnabled(true);
                        mainView.setColorBasket();
                    }
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mainView.getEditModeItemV().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modeFlag = true;
                mainView.clearAll();
                mainView.getButton().setText("Add");
                mainView.getButton().setEnabled(true);
                try{
                    database.getAllPlayerList().clear();
                    if(sportFlag == 1){
                        database.setAllPlayerList(database.getAllSoccersList());
                        mainView.getLabelHeader().setText("Add soccer");
                        mainView.setFootballEnabled(true);
                        mainView.setColorFootball();
                    }
                    else if(sportFlag == 2){
                        database.setAllPlayerList(database.getAllHockeyPlsList());
                        mainView.getLabelHeader().setText("Add hockey player");
                        mainView.setHockeyEnabled(true);
                        mainView.setColorHockey();
                    }
                    else if(sportFlag == 3){
                        database.setAllPlayerList(database.getAllBasketPlsList());
                        mainView.getLabelHeader().setText("Add basketball player");
                        mainView.setBasketEnabled(true);
                        mainView.setColorBasket();
                    }
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mainView.getViewModeItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modeFlag = false;
                mainView.clearAll();
                mainView.getButton().setText("Add");
                mainView.getButton().setEnabled(false);
                try {
                    database.getAllPlayerList().clear();
                    if(sportFlag == 1){
                        database.setAllPlayerList(database.getAllSoccersList());
                        mainView.getLabelHeader().setText("Statistic soccer");
                        mainView.setAllEnabledFH(false);
                    }
                    else if(sportFlag == 2){
                        database.setAllPlayerList(database.getAllHockeyPlsList());
                        mainView.getLabelHeader().setText("Statistic hockey player");
                        mainView.setAllEnabledFH(false);
                    }
                    else if(sportFlag == 3){
                        database.setAllPlayerList(database.getAllBasketPlsList());
                        mainView.getLabelHeader().setText("Statistic basketball player");
                        mainView.setAllEnabledB(false);
                    }
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mainView.getViewModeItemV().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modeFlag = false;
                mainView.clearAll();
                mainView.getButton().setText("Add");
                mainView.getButton().setEnabled(false);
                try {
                    database.getAllPlayerList().clear();
                    if(sportFlag == 1){
                        database.setAllPlayerList(database.getAllSoccersList());
                        mainView.getLabelHeader().setText("Statistic soccer");
                        mainView.setAllEnabledFH(false);
                    }
                    else if(sportFlag == 2){
                        database.setAllPlayerList(database.getAllHockeyPlsList());
                        mainView.getLabelHeader().setText("Statistic hockey player");
                        mainView.setAllEnabledFH(false);
                    }
                    else if(sportFlag == 3){
                        database.setAllPlayerList(database.getAllBasketPlsList());
                        mainView.getLabelHeader().setText("Statistic basketball player");
                        mainView.setAllEnabledB(false);
                    }
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mainView.getFootballItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                sportFlag = 1;
                if(modeFlag){
                    mainView.getLabelHeader().setText("Add soccer");
                    mainView.getButton().setEnabled(true);
                    mainView.setFootballEnabled(true);
                    mainView.setColorFootball();
                }
                else{
                    mainView.getLabelHeader().setText("Statistic soccer");
                    mainView.getButton().setEnabled(false);
                    mainView.setAllEnabledFH(false);
                }
                try{
                    database.getAllPlayerList().clear();
                    database.setAllPlayerList(database.getAllSoccersList());
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mainView.getFootballItemV().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                sportFlag = 1;
                if(modeFlag){
                    mainView.getLabelHeader().setText("Add soccer");
                    mainView.getButton().setEnabled(true);
                    mainView.setFootballEnabled(true);
                    mainView.setColorFootball();
                }
                else{
                    mainView.getLabelHeader().setText("Statistic soccer");
                    mainView.getButton().setEnabled(false);
                    mainView.setAllEnabledFH(false);
                }
                try{
                    database.getAllPlayerList().clear();
                    database.setAllPlayerList(database.getAllSoccersList());
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mainView.getHockeyItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                sportFlag = 2;
                if(modeFlag){
                    mainView.getLabelHeader().setText("Add hockey player");
                    mainView.getButton().setEnabled(true);
                    mainView.setHockeyEnabled(true);
                    mainView.setColorHockey();
                }
                else{
                    mainView.getLabelHeader().setText("Statistic hockey player");
                    mainView.getButton().setEnabled(false);
                    mainView.setAllEnabledFH(false);
                }
                try{
                    database.getAllPlayerList().clear();
                    database.setAllPlayerList(database.getAllHockeyPlsList());
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mainView.getHockeyItemV().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                sportFlag = 2;
                if(modeFlag){
                    mainView.getLabelHeader().setText("Add hockey player");
                    mainView.getButton().setEnabled(true);
                    mainView.setHockeyEnabled(true);
                    mainView.setColorHockey();
                }
                else{
                    mainView.getLabelHeader().setText("Statistic hockey player");
                    mainView.getButton().setEnabled(false);
                    mainView.setAllEnabledFH(false);
                }
                try{
                    database.getAllPlayerList().clear();
                    database.setAllPlayerList(database.getAllHockeyPlsList());
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mainView.getBasketItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                sportFlag = 3;
                if(modeFlag){
                    mainView.getLabelHeader().setText("Add basketball player");
                    mainView.getButton().setEnabled(true);
                    mainView.setBasketEnabled(true);
                    mainView.setColorBasket();
                }
                else{
                    mainView.getLabelHeader().setText("Statistic basketball player");
                    mainView.getButton().setEnabled(false);
                    mainView.setAllEnabledB(false);
                }
                try{
                    database.getAllPlayerList().clear();
                    database.setAllPlayerList(database.getAllBasketPlsList());
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mainView.getBasketItemV().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.clearAll();
                sportFlag = 3;
                if(modeFlag){
                    mainView.getLabelHeader().setText("Add basketball player");
                    mainView.getButton().setEnabled(true);
                    mainView.setBasketEnabled(true);
                    mainView.setColorBasket();
                }
                else{
                    mainView.getLabelHeader().setText("Statistic basketball player");
                    mainView.getButton().setEnabled(false);
                    mainView.setAllEnabledB(false);
                }
                try{
                    database.getAllPlayerList().clear();
                    database.setAllPlayerList(database.getAllBasketPlsList());
                    mainView.getComboRole().setSelectedItem(null);
                    mainView.getComboStickGrip().setSelectedItem(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainView, "Try later!", "Warning", JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(mainView, ("<html>" + "Information about program:"
                        + "<br>" + "Software product version IntelliJ IDEA 2021.3.3 (Community Edition)"
                        + "<br>" + "Date of last changes in the program: 06/01/2022"
                        + "<br>" + "Author's coordinates: Alexander Igorevich Dereza, Irkutsk National Research Technical University, ISTb-20-1, e-mail: daleks19@mail.ru"
                        + "</html>"), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        mainView.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String tempPl = null;
                if(sportFlag == 1){
                    tempPl = "Soccer";
                }
                else if(sportFlag == 2){
                    tempPl = "Hockey player";
                }
                else if (sportFlag == 3){
                    tempPl = "Basketball player";
                }
                if(mainView.getButton().getText().equals("Add")){
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
                        name = mainView.getTextFieldName().getText();
                        surname = mainView.getTextFieldSurname().getText();
                        number = Integer.parseInt(mainView.getTextFieldNumber().getText());
                        role = (String) mainView.getComboRole().getSelectedItem();
                        team = mainView.getTextFieldTeam().getText();
                        if(sportFlag == 1){
                            if (mainView.getTextFieldYC().getText().isEmpty()){
                                throw new Exception(" yellow cards on the field is not entered!");
                            }
                            else if (mainView.getTextFieldRC().getText().isEmpty()){
                                throw new Exception(" red cards on the field not entered!");
                            }
                            else if (mainView.getTextFieldPsPerc().getText().isEmpty()){
                                throw new Exception(" success passes on the field not entered!");
                            }
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
                                SoccerPlayer soccer = new SoccerPlayer(database.maxID(), name, surname, number, role, team, mins, goals, assists, yC, rC, pS);
                                database.addSoccer(soccer);
                                database.getAllPlayerList().clear();
                                database.setAllPlayerList(database.getAllSoccersList());
                            }
                        }
                        else if(sportFlag == 2){
                            if (mainView.getTextFieldPenaltyTime().getText().isEmpty()){
                                throw new Exception(" penalty time on the field not entered!");
                            }
                            else if (mainView.getTextFieldPenaltyCount().getText().isEmpty()){
                                throw new Exception(" penalty count on the field not entered!");
                            }
                            mins = Integer.parseInt(mainView.getTextFieldMins().getText());
                            goals = Integer.parseInt(mainView.getTextFieldGoals().getText());
                            assists = Integer.parseInt(mainView.getTextFieldAssists().getText());
                            stickGrip = (String) mainView.getComboStickGrip().getSelectedItem();
                            penTime = Integer.parseInt(mainView.getTextFieldPenaltyTime().getText());
                            penCount = Integer.parseInt(mainView.getTextFieldPenaltyCount().getText());
                            if (number < 1 || number > 99){
                                mainView.getTextFieldNumber().setText(null);
                                throw new Exception(" number entered incorrectly! Enter a number from 1 to 99!");
                            }
                            else{
                                HockeyPlayer hockeyPlayer = new HockeyPlayer(database.maxID(), name, surname, number, role, team, mins, goals, assists,stickGrip, penTime, penCount);
                                database.addHockeyPl(hockeyPlayer);
                                database.getAllPlayerList().clear();
                                database.setAllPlayerList(database.getAllHockeyPlsList());
                            }

                        }
                        else if (sportFlag == 3){
                            if (mainView.getTextFieldRebounds().getText().isEmpty()){
                                throw new Exception(" redounds on the field not entered!");
                            }
                            else if (mainView.getTextFieldBlocks().getText().isEmpty()){
                                throw new Exception(" blocks on the field not entered!");
                            }
                            mins = Integer.parseInt(mainView.getTextFieldMins().getText());
                            goals = Integer.parseInt(mainView.getTextFieldGoals().getText());
                            assists = Integer.parseInt(mainView.getTextFieldAssists().getText());
                            rebounds = Integer.parseInt(mainView.getTextFieldRebounds().getText());
                            blocks = Integer.parseInt(mainView.getTextFieldBlocks().getText());
                            if (number < 1 || number > 99){
                                mainView.getTextFieldNumber().setText(null);
                                throw new Exception(" number entered incorrectly! Enter a number from 1 to 99!");
                            }
                            else{
                                BasketballPlayer basketballPlayer = new BasketballPlayer(database.maxID(), name, surname, number, role, team, mins, goals, assists, rebounds, blocks);
                                database.addBasketPl(basketballPlayer);
                                database.getAllPlayerList().clear();
                                database.setAllPlayerList(database.getAllBasketPlsList());
                            }
                        }
                        mainView.getTableModel().update();
                        mainView.clearAll();
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(mainView, tempPl + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    try{
                        row = mainView.getPlayersTable().getSelectedRow();
                        cell = mainView.getPlayersTable().getModel().getValueAt(row,0).toString();
                        if(sportFlag == 1){
                            database.updateSoccer(mainView.getTextFieldName().getText(), mainView.getTextFieldSurname().getText(),  (Integer.parseInt(mainView.getTextFieldNumber().getText())),
                                    mainView.getComboRole().getSelectedItem().toString(), mainView.getTextFieldTeam().getText(), (Integer.parseInt(mainView.getTextFieldMins().getText())),
                                    (Integer.parseInt(mainView.getTextFieldGoals().getText())), (Integer.parseInt(mainView.getTextFieldAssists().getText())),
                                    (Integer.parseInt(mainView.getTextFieldYC().getText())), (Integer.parseInt(mainView.getTextFieldRC().getText())),
                                    (Integer.parseInt(mainView.getTextFieldPsPerc().getText())), (Integer.parseInt(cell)));
                            mainView.getLabelHeader().setText("Add soccer");
                            database.getAllPlayerList().clear();
                            database.setAllPlayerList(database.getAllSoccersList());
                        }
                        else if(sportFlag == 2){
                            database.updateHockeyPl(mainView.getTextFieldName().getText(), mainView.getTextFieldSurname().getText(),  (Integer.parseInt(mainView.getTextFieldNumber().getText())),
                                    mainView.getComboRole().getSelectedItem().toString(), mainView.getTextFieldTeam().getText(), (Integer.parseInt(mainView.getTextFieldMins().getText())),
                                    (Integer.parseInt(mainView.getTextFieldGoals().getText())), (Integer.parseInt(mainView.getTextFieldAssists().getText())),
                                    mainView.getComboStickGrip().getSelectedItem().toString(), (Integer.parseInt(mainView.getTextFieldPenaltyTime().getText())),
                                    (Integer.parseInt(mainView.getTextFieldPenaltyCount().getText())), (Integer.parseInt(cell)));
                            mainView.getLabelHeader().setText("Add hockey player");
                            database.getAllPlayerList().clear();
                            database.setAllPlayerList(database.getAllHockeyPlsList());
                        }
                        else if (sportFlag == 3){
                            database.updateBasketPl(mainView.getTextFieldName().getText(), mainView.getTextFieldSurname().getText(),  (Integer.parseInt(mainView.getTextFieldNumber().getText())),
                                    mainView.getComboRole().getSelectedItem().toString(), mainView.getTextFieldTeam().getText(), (Integer.parseInt(mainView.getTextFieldMins().getText())),
                                    (Integer.parseInt(mainView.getTextFieldGoals().getText())), (Integer.parseInt(mainView.getTextFieldAssists().getText())),
                                    (Integer.parseInt(mainView.getTextFieldRebounds().getText())), (Integer.parseInt(mainView.getTextFieldBlocks().getText())), (Integer.parseInt(cell)));
                            mainView.getLabelHeader().setText("Add basketball player");
                            database.getAllPlayerList().clear();
                            database.setAllPlayerList(database.getAllBasketPlsList());
                        }
                        mainView.getTableModel().update();
                        mainView.clearAll();
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(mainView, tempPl + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    mainView.getButton().setText("Add");
                    mainView.getPlayersTable().clearSelection();
                }
            }
        });
        mainView.getPopupDeleteItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String tempPl = null;
                if(sportFlag == 1){
                    tempPl = "Soccer";
                }
                else if(sportFlag == 2){
                    tempPl = "Hockey player";
                }
                else if (sportFlag == 3){
                    tempPl = "Basketball player";
                }
                try {
                    if (mainView.getPlayersTable().getSelectedRow() == -1) {
                        throw new Exception("not selected!");

                    }
                    else if (mainView.getPlayersTable().getModel().getValueAt(row,0).toString() == null) {
                        throw new Exception("not selected!");
                    }
                    else{
                        row = mainView.getPlayersTable().getSelectedRow();
                        cell = mainView.getPlayersTable().getModel().getValueAt(row,0).toString();
                        database.deletePl(Integer.parseInt(cell));
                        if(sportFlag == 1){
                            mainView.getLabelHeader().setText("Add soccer");
                            database.getAllPlayerList().clear();
                            database.setAllPlayerList(database.getAllSoccersList());
                        }
                        else if(sportFlag == 2){
                            mainView.getLabelHeader().setText("Add hockey player");
                            database.getAllPlayerList().clear();
                            database.setAllPlayerList(database.getAllHockeyPlsList());
                        }
                        else if (sportFlag == 3){
                            mainView.getLabelHeader().setText("Add basketball player");
                            database.getAllPlayerList().clear();
                            database.setAllPlayerList(database.getAllBasketPlsList());
                        }
                    }
                    mainView.getButton().setText("Add");
                    mainView.getTableModel().update();
                    mainView.clearAll();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainView, tempPl + " " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        mainView.getPlayersTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String tempPl = null;
                if(sportFlag == 1){
                    tempPl = "soccer";
                }
                else if(sportFlag == 2){
                    tempPl = "hockey player";
                }
                else if (sportFlag == 3){
                    tempPl = "basketball player";
                }
                if(SwingUtilities.isLeftMouseButton(e)){
                    row = mainView.getPlayersTable().getSelectedRow();
                    cell = mainView.getPlayersTable().getModel().getValueAt(row,0).toString();
                    if(modeFlag){
                        mainView.getLabelHeader().setText("Update " + tempPl);
                        mainView.getButton().setText("Update");
                    }
                    else{
                        if(sportFlag == 1 || sportFlag == 2){
                            mainView.setAllEnabledFH(false);
                        }
                        else if (sportFlag == 3){
                            mainView.setAllEnabledB(false);
                        }

                        //mainView.getComboRole().setSelectedItem(null);
                    }
                    try {
                        if(sportFlag == 1){
                            name = database.getSoccer(Integer.parseInt(cell)).getName();
                            mainView.getTextFieldName().setText(name);
                            surname = database.getSoccer(Integer.parseInt(cell)).getSurname();
                            mainView.getTextFieldSurname().setText(surname);
                            number = database.getSoccer(Integer.parseInt(cell)).getNumber();
                            mainView.getTextFieldNumber().setText(String.valueOf(number));
                            role = database.getSoccer(Integer.parseInt(cell)).getRole();
                            mainView.getComboRole().setSelectedItem(role);
                            team = database.getSoccer(Integer.parseInt(cell)).getTeam();
                            mainView.getTextFieldTeam().setText(team);
                            mins = database.getSoccer(Integer.parseInt(cell)).getMins();
                            mainView.getTextFieldMins().setText(String.valueOf(mins));
                            goals = database.getSoccer(Integer.parseInt(cell)).getGoals();
                            mainView.getTextFieldGoals().setText(String.valueOf(goals));
                            assists = database.getSoccer(Integer.parseInt(cell)).getAssists();
                            mainView.getTextFieldAssists().setText(String.valueOf(assists));
                            yC = database.getSoccer(Integer.parseInt(cell)).getYelCard();
                            mainView.getTextFieldYC().setText(String.valueOf(yC));
                            rC = database.getSoccer(Integer.parseInt(cell)).getRedCard();
                            mainView.getTextFieldRC().setText(String.valueOf(rC));
                            pS = database.getSoccer(Integer.parseInt(cell)).getPsPerc();
                            mainView.getTextFieldPsPerc().setText(String.valueOf(pS));
                        }
                        else if(sportFlag == 2){
                            name = database.getHockeyPl(Integer.parseInt(cell)).getName();
                            mainView.getTextFieldName().setText(name);
                            surname = database.getHockeyPl(Integer.parseInt(cell)).getSurname();
                            mainView.getTextFieldSurname().setText(surname);
                            number = database.getHockeyPl(Integer.parseInt(cell)).getNumber();
                            mainView.getTextFieldNumber().setText(String.valueOf(number));
                            role = database.getHockeyPl(Integer.parseInt(cell)).getRole();
                            mainView.getComboRole().setSelectedItem(role);
                            team = database.getHockeyPl(Integer.parseInt(cell)).getTeam();
                            mainView.getTextFieldTeam().setText(team);
                            mins = database.getHockeyPl(Integer.parseInt(cell)).getMins();
                            mainView.getTextFieldMins().setText(String.valueOf(mins));
                            goals = database.getHockeyPl(Integer.parseInt(cell)).getGoals();
                            mainView.getTextFieldGoals().setText(String.valueOf(goals));
                            assists = database.getHockeyPl(Integer.parseInt(cell)).getAssists();
                            mainView.getTextFieldAssists().setText(String.valueOf(assists));
                            stickGrip = database.getHockeyPl(Integer.parseInt(cell)).getStickGrip();
                            mainView.getComboStickGrip().setSelectedItem(stickGrip);
                            penTime = database.getHockeyPl(Integer.parseInt(cell)).getPenaltyTime();
                            mainView.getTextFieldPenaltyTime().setText(String.valueOf(penTime));
                            penCount = database.getHockeyPl(Integer.parseInt(cell)).getCountPenalty();
                            mainView.getTextFieldPenaltyCount().setText(String.valueOf(penCount));
                        }
                        else if (sportFlag == 3){
                            name = database.getBasketPl(Integer.parseInt(cell)).getName();
                            mainView.getTextFieldName().setText(name);
                            surname = database.getBasketPl(Integer.parseInt(cell)).getSurname();
                            mainView.getTextFieldSurname().setText(surname);
                            number = database.getBasketPl(Integer.parseInt(cell)).getNumber();
                            mainView.getTextFieldNumber().setText(String.valueOf(number));
                            role = database.getBasketPl(Integer.parseInt(cell)).getRole();
                            mainView.getComboRole().setSelectedItem(role);
                            team = database.getBasketPl(Integer.parseInt(cell)).getTeam();
                            mainView.getTextFieldTeam().setText(team);
                            mins = database.getBasketPl(Integer.parseInt(cell)).getMins();
                            mainView.getTextFieldMins().setText(String.valueOf(mins));
                            goals = database.getBasketPl(Integer.parseInt(cell)).getGoals();
                            mainView.getTextFieldGoals().setText(String.valueOf(goals));
                            assists = database.getBasketPl(Integer.parseInt(cell)).getAssists();
                            mainView.getTextFieldAssists().setText(String.valueOf(assists));
                            rebounds = database.getBasketPl(Integer.parseInt(cell)).getRebounds();
                            mainView.getTextFieldRebounds().setText(String.valueOf(rebounds));
                            blocks = database.getBasketPl(Integer.parseInt(cell)).getBlocks();
                            mainView.getTextFieldBlocks().setText(String.valueOf(blocks));
                        }
                    } catch (Exception ex) {}
                }
            }
        });

        mainView.getTextFieldFind().getDocument().addDocumentListener(new DocumentListener() {
            private void newFilter(){
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(mainView.getTableModel());
                mainView.getPlayersTable().setRowSorter(sorter);
                RowFilter<TableModel, Object>player= null;
                try {
                    player = RowFilter.regexFilter("(?i)" + mainView.getTextFieldFind().getText());
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

        mainView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    if(modeFlag){
                        if(sportFlag == 1){
                            mainView.getLabelHeader().setText("Add soccer");
                        }
                        else if(sportFlag == 2){
                            mainView.getLabelHeader().setText("Add hockey player");
                        }
                        else if (sportFlag == 3){
                            mainView.getLabelHeader().setText("Add basketball player");
                        }
                        if(mainView.getButton().getText().equals("Update")){
                            mainView.clearAll();
                        }
                        mainView.getButton().setText("Add");
                    }
                    else{
                        mainView.getComboRole().setSelectedItem(null);
                        mainView.getComboStickGrip().setSelectedItem(null);
                        mainView.clearAll();
                    }
                    mainView.getPlayersTable().clearSelection();
                }
            }
        });
        mainView.getScrollPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    if(modeFlag){
                        mainView.getPopupEdit().show(e.getComponent(), e.getX(), e.getY());
                    }
                    else{
                        mainView.getPopupView().show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });
        mainView.getPlayersTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    if(modeFlag){
                        mainView.getPopupEdit().show(e.getComponent(), e.getX(), e.getY());
                    }
                    else{
                        mainView.getPopupView().show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });

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

        mainView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Yes", "No"};
                int confirm = JOptionPane.showOptionDialog(mainView,"Close and exit?","Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                if(confirm == JOptionPane.YES_OPTION){
                    System.exit(0);
                    mainView.dispose();
                }
            }
        });
    }
}
