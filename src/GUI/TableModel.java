package GUI;

import DB.Database;
import Model.Player;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    private String[] columnName = {"Name", "Surname", "Number", "Role", "Team","Minutes", "Goals", "Assists"};
    private Database database;

    public TableModel(Database database){
       this.database = database;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Player player = database.getAllPlayerList().get(rowIndex);
        switch (columnIndex){
            case 0:
                return player.getName();
            case 1:
                return player.getSurname();
            case 2:
                return player.getNumber();
            case 3:
                return player.getRole();
            case 4:
                return player.getTeam();
            case 5:
                return player.getMins();
            case 6:
                return player.getGoals();
            case 7:
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

    public void removeRow(int index){
        //
        fireTableDataChanged();
    }

    public void removeAllRow(){
        //
        fireTableDataChanged();
    }

    public void addRow(){
        //
        fireTableDataChanged();
    }
}
