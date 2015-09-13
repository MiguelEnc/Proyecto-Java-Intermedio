package com.sge.template.tables;

import com.sge.bs.DaoEnum;
import com.sge.bs.DaoFactory;
import com.sge.dao.SesionDao;
import com.sge.entity.Horario;
import com.sge.entity.Sesion;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miguel
 */
public class SesionHorarioTableValue extends AbstractTableModel{
    
    SesionDao sesionDao = (SesionDao) DaoFactory.getDao(DaoEnum.SESION);
    String columnNames[];
    Class clases[];
    Horario horario;
    Sesion sesion;
    
    public SesionHorarioTableValue(Sesion sesion, Horario horario) {
        this.sesion = sesion;
        this.horario = horario;
        
        columnNames = new String[]{"ID", "MateriaID", "ProfesorID", 
                                    "AulaID", "Codigo", "Capacidad", 
                                    "Fecha I", "Fecha F", "Horario", "Estatus"};
        clases = new Class[]{Integer.class, Integer.class, Integer.class,
                             Integer.class, String.class, Integer.class,
                             Date.class, Date.class, String.class, String.class};
    }

    public Object getValueAt(int row, int col) {
        
        switch(col){
            case 0:
                return sesion.getId();
            case 1:
                return sesion.getMateriaId();
            case 2:
                return sesion.getProfesorId();
            case 3:
                return sesion.getAulaId();
            case 4:
                return sesion.getCodigo();
            case 5:
                return sesion.getCapacidad();
            case 6:
                return sesion.getFechaInicio();
            case 7:
                return sesion.getFechaFin();
            case 8:
                return horario.getDescripcion();
            case 9:
                return sesion.getStatus();
            default:
                return null;
        }
    }

    public int getRowCount() {
        List<Sesion> sesiones = sesionDao.getAll();
        return sesiones.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public Class getColumnClass(int index) {
        return clases[index];
    }

    @Override
    public String getColumnName(int index) {
        return columnNames[index];
    }
}
