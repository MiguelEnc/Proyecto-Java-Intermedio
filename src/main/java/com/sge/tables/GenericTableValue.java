package com.sge.tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miguel
 */
abstract class GenericTableValue<T> extends AbstractTableModel{
    
    public List<T> lista;
    
    public String columnNames[];
    
    public Class clases[];
    
    
    public int getRowCount() {
        return lista.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public abstract Object getValueAt(int row, int col);

    @Override
    public Class getColumnClass(int index) {
        return clases[index];
    }

    @Override
    public String getColumnName(int index) {
        return columnNames[index];
    }
}
