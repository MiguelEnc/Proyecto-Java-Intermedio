package com.sge.tables;

import com.sge.entity.Aula;
import java.util.List;

/**
 *
 * @author miguel
 */
public class AulaTableValue extends GenericTableValue<Aula>{
    
    
    public AulaTableValue(List<Aula> aulas){
        lista = aulas;
        columnNames = new String[]{"ID", "Descripcion", "Estatus"};
        clases = new Class[]{Integer.class, String.class, String.class};
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        
        switch(col){
            case 0:
                return lista.get(row).getId();
            case 1:
                return lista.get(row).getDescripcion();
            case 2:
                return lista.get(row).getStatus();
            default:
                return null;
        }
    }

}
