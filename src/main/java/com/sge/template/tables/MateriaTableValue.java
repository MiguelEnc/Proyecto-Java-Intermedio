package com.sge.template.tables;

import com.sge.entity.Materia;
import java.util.List;

/**
 *
 * @author miguel
 */
public class MateriaTableValue extends GenericTableValue<Materia>{

    public MateriaTableValue(List<Materia> materias){
        lista = materias;
        columnNames = new String[]{"ID", "Nombre", "Estatus"};
        clases = new Class[]{Integer.class, String.class, String.class};
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0:
                return lista.get(row).getId();
            case 1:
                return lista.get(row).getNombre();
            case 2:
                return lista.get(row).getStatus();
            default:
                return null;
        }
    }
    
}
