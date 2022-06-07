package GUI;

import DB.Database;
import Model.Player;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
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

    public void update(){
        fireTableDataChanged();
    }
}
