package GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.PatternSyntaxException;

public class Controller {
    private boolean addClickFlag = false;

    public Controller(){    }

    public void execute(View mainView){
        mainView.getButtonAdd().setEnabled(false);
        mainView.setAllTFEnabled(false);
        mainView.getEditModeItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller.this.addClickFlag = true;
                mainView.getLabelHeader().setText("Add");
                mainView.getButtonAdd().setEnabled(true);
                mainView.setAllTFEnabled(true);
            }
        });
        mainView.getViewModeItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller.this.addClickFlag = false;
                mainView.getLabelHeader().setText("Statistics");
                mainView.getButtonAdd().setEnabled(false);
                mainView.setAllTFEnabled(false);
            }
        });
        mainView.getFootballItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.setAllTFEnabled(true);
                mainView.setFootballEnabled(false);
            }
        });
        mainView.getHockeyItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.setAllTFEnabled(true);
                mainView.setHockeyEnabled(false);
            }
        });
        mainView.getBasketItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainView.setAllTFEnabled(true);
                mainView.setBasketEnabled(false);
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
        /*mainWindow.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String name;
                String role;
                int number;
                String stickGrip;
                int perc;
                try{
                    if (mainWindow.getSurnamePlayer().getText().isEmpty() && mainWindow.getNumberPlayer().getText().isEmpty() && mainWindow.getPercPlayer().getText().isEmpty()){
                        throw new Exception("<html>" + "Игрок не создан!" + "<br>" + "Введите данные!" + "</html>");
                    }
                    else if (mainWindow.getSurnamePlayer().getText().isEmpty() && mainWindow.getNumberPlayer().getText().isEmpty()){
                        throw new Exception("Фамилия и номер игрока не введены!");
                    }
                    else if (mainWindow.getSurnamePlayer().getText().isEmpty() && mainWindow.getPercPlayer().getText().isEmpty()){
                        throw new Exception("Фамилия игрока и процент не введены!");
                    }
                    else if (mainWindow.getNumberPlayer().getText().isEmpty() && mainWindow.getPercPlayer().getText().isEmpty()){
                        throw new Exception("Номер игрока и процент не введены!");
                    }
                    else if (mainWindow.getSurnamePlayer().getText().isEmpty()){
                        throw new Exception("Фамилия игрока не введена!");
                    }
                    else if (mainWindow.getNumberPlayer().getText().isEmpty()){
                        throw new Exception("Номер игрока не введён!");
                    }
                    else if (mainWindow.getPercPlayer().getText().isEmpty()){
                        throw new Exception("Процент не введён!");
                    }
                    name = mainWindow.getSurnamePlayer().getText();
                    role = (String) mainWindow.getComboRole().getSelectedItem();
                    number = Integer.valueOf(mainWindow.getNumberPlayer().getText());
                    stickGrip = (String) mainWindow.getComboStickGrip().getSelectedItem();
                    perc = Integer.valueOf(mainWindow.getPercPlayer().getText());
                    if (number < 1 || number > 99){
                        mainWindow.getNumberPlayer().setText(null);
                        throw new Exception("<html>" + "Неправильно введен номер игрока!" + "<br>" + "Введите число от 1 до 99!" + "</html>");
                    }
                    else if (perc < 0 || perc > 100){
                        mainWindow.getPercPlayer().setText(null);
                        throw new Exception("<html>" + "Неправильно введен процент!"+ "<br>" + "Введите число от 0 до 100!" + "</html>");
                    }
                    else{
                        switch (role) {
                            case "Вратарь":
                                player = new Keeper(name, stickGrip, number, perc);
                                hockeyTeam.add(player);
                                break;
                            case "Защитник":
                                player = new Defender(name, stickGrip, number, perc);
                                hockeyTeam.add(player);
                                break;
                            case "Полузащитник":
                                player = new Midfielder(name, stickGrip, number, perc);
                                hockeyTeam.add(player);
                                break;
                            case "Нападающий":
                                player = new Forward(name, stickGrip, number, perc);
                                hockeyTeam.add(player);
                                break;
                        }
                        mainWindow.clearAdd();
                    }
                    mainWindow.getFindTextField().setEnabled(true);
                    mainWindow.getRemButton().setEnabled(true);
                    mainWindow.getRemAllButton().setEnabled(true);
                    mainWindow.getTableModel().fireTableDataChanged();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(mainWindow, ex.getMessage(), "Предупреждение", JOptionPane.WARNING_MESSAGE);
                }
            }
        });*/
        /*mainView.getTextFieldFind().getDocument().addDocumentListener(new DocumentListener() {
            private void newFilter(){
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(mainView.getTableModel());
                mainView.getPlayersTable().setRowSorter(sorter);
                RowFilter<TableModel, Object>plr = null;
                try {
                    plr = RowFilter.regexFilter(mainView.getTextFieldFind().getText());
                }
                catch (PatternSyntaxException e) {
                    return;
                }
                sorter.setRowFilter(plr);
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
        });*/
    }
}
