package GUI;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    private String[] columnName = {"1", "2", "3", "4", "5"};

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        /*switch (columnIndex){
            case 0:
                return
            case 1:
                return
            case 2:
                return
            case 3:
                return
            case 4:
                return
        }*/
        return "";
    }

    @Override
    public int getRowCount() {
        return 0;
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
