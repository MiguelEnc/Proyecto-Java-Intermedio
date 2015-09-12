package com.sge.template.tables;

import com.sge.entity.Estudiante;
import java.util.List;

/**
 *
 * @author miguel
 */
public class EstudianteTableValue extends GenericTableValue<Estudiante>{

    public EstudianteTableValue(List<Estudiante> estudiantes) {
        lista = estudiantes;
        columnNames = new String[]{"ID", "Nombre", "Apellido", "Matricula", "Correo", "Estatus"};
        clases = new Class[]{Integer.class, String.class, String.class, String.class, String.class, String.class};
    }

    @Override
    public Object getValueAt(int row, int col) {
        
        switch(col){
            case 0:
                return lista.get(row).getId();
            case 1:
                return lista.get(row).getNombre();
            case 2:
                return lista.get(row).getApellido();
            case 3:
                return lista.get(row).getMatricula();
            case 4:
                return lista.get(row).getCorreo();
            case 5:
                return lista.get(row).getStatus();
            default:
                return null;
        }
        
    }
    
}
