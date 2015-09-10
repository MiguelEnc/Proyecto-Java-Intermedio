package com.sge.bs;


import com.sge.dao.ServiceDao;
import com.sge.dao.impl.AulaDaoImpl;
import com.sge.dao.impl.EstudianteDaoImpl;
import com.sge.dao.impl.GrupoDaoImpl;
import com.sge.dao.impl.GrupoUsuarioDaoImpl;
import com.sge.dao.impl.HorarioDaoImpl;
import com.sge.dao.impl.HorarioSesionDaoImpl;
import com.sge.dao.impl.MateriaDaoImpl;
import com.sge.dao.impl.ProfesorDaoImpl;
import com.sge.dao.impl.RegistroDaoImpl;
import com.sge.dao.impl.SesionDaoImpl;
import com.sge.dao.impl.UsuarioDaoImpl;

/**
 *
 * @author Usuario
 */
public class DaoFactory {
    
    public static ServiceDao getDao(DaoEnum de) {
        ServiceDao service=null;
        
        switch(de) {
            case AULA:
                service = new AulaDaoImpl();
                break;
                
            case ESTUDIANTE:
                service = new EstudianteDaoImpl();
                break;
                
            case GRUPO:
                service = new GrupoDaoImpl();
                break;
                
            case GRUPOUSUARIO:
                service = new GrupoUsuarioDaoImpl();
                break;
                
            case HORARIO:
                service = new HorarioDaoImpl();
                break;
                
            case HORARIOSESION:
                service = new HorarioSesionDaoImpl();
                break;
                
            case MATERIA:
                service = new MateriaDaoImpl();
                break;
                
            case PROFESOR:
                service=new ProfesorDaoImpl();
                break;
                
            case REGISTRO:
                service=new RegistroDaoImpl();
                break;
                
            case SESION:
                service=new SesionDaoImpl();
                break;
                
            case USUARIO:
                service=new UsuarioDaoImpl();
                break;
        }
        
        return service;
    
    }
    
}
