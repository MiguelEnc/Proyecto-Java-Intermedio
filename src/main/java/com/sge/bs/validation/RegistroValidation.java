package com.sge.bs.validation;

import com.sge.bs.DaoEnum;
import com.sge.bs.DaoFactory;
import com.sge.dao.RegistroDao;
import com.sge.dao.SesionDao;
import com.sge.entity.Registro;
import com.sge.entity.Sesion;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class RegistroValidation implements Validation<Registro> {

    private RegistroDao registroDao=(RegistroDao) DaoFactory.getDao(DaoEnum.REGISTRO);
    private SesionDao sesionDao=(SesionDao) DaoFactory.getDao(DaoEnum.SESION);
    
    public void doExcution(Registro object) {
       
        if(validate(object)){
            registroDao.save(object);
            JOptionPane.showMessageDialog(null, "La seleccion se ha guardado satisfactoriamente.");
        }else{
            JOptionPane.showMessageDialog(null, "La sesion seleccionada no tiene cupos disponibles.");
        }
    }

    private boolean validate(Registro reg) {
        
        int sesionId = reg.getHorarioSesion().getSesion().getId();
        Sesion sesion = sesionDao.findEntity(sesionId);
        int capacidad = sesion.getCapacidad();
        
        if(capacidad > 0){
            capacidad--;
            sesion.setCapacidad(capacidad);
            return true;
        }else
            return false;
    }
    
    
    

   
    
}
