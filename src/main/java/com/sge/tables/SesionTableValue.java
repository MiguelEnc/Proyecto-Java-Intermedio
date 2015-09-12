package com.sge.tables;

import com.sge.entity.Sesion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author miguel
 */
public class SesionTableValue extends GenericTableValue<Sesion>{

    public SesionTableValue(List<Sesion> sesiones) {
        lista = sesiones;
        columnNames = new String[]{"ID", "MateriaID", "ProfesorID", 
                                    "AulaID", "Codigo", "Capacidad", 
                                    "Fecha I", "Fecha F", "Estatus"};
        clases = new Class[]{Integer.class, Integer.class, Integer.class,
                             Integer.class, String.class, Integer.class,
                             Date.class, Date.class, String.class};
    }

    
    @Override
    public Object getValueAt(int row, int col) {
        
        switch(col){
            case 0:
                return lista.get(row).getId();
            case 1:
                return lista.get(row).getMateriaId();
            case 2:
                return lista.get(row).getProfesorId();
            case 3:
                return lista.get(row).getAulaId();
            case 4:
                return lista.get(row).getCodigo();
            case 5:
                return lista.get(row).getCapacidad();
            case 6:
                return lista.get(row).getFechaInicio();
            case 7:
                return lista.get(row).getFechaFin();
            case 8:
                return lista.get(row).getStatus();
            default:
                return null;
        }
    }
    
}
