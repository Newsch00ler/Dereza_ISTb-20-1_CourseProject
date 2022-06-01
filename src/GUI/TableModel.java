package GUI;

import DB.Database;
import Model.Player;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableModel extends AbstractTableModel implements MouseListener {
    private String[] columnName = {"ID", "Name", "Surname", "Number", "Role", "Team","Minutes", "Goals", "Assists"};
    private Database database;

    public TableModel(Database database){
       this.database = database;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Player player = database.getAllPlayerList().get(rowIndex);
        switch (columnIndex){
            case 0:
                return player.getID();
            case 1:
                return player.getName();
            case 2:
                return player.getSurname();
            case 3:
                return player.getNumber();
            case 4:
                return player.getRole();
            case 5:
                return player.getTeam();
            case 6:
                return player.getMins();
            case 7:
                return player.getGoals();
            case 8:
                return player.getAssists();
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return database.getSizeList();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public String getColumnName(int column){
        return columnName[column];
    }

    public Class<? extends Player> getPlSport(int index){
        return database.getPlayerSport(index);
    }

    public void update(){
        fireTableDataChanged();
    }

    public void removeRow(int index){
        fireTableDataChanged();
    }

    public void removeAllRow(){
        //
        fireTableDataChanged();
    }

    public void addRow(){
        fireTableDataChanged();
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2 ){
            JTable obj = (JTable)e.getSource();
            System.out.println("obj.getSelectedColumn()="+obj.getSelectedColumn());
            System.out.println("obj.getSelectedRow()="+obj.getSelectedRow());
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
