/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.bs;


import com.sge.dao.ServiceDao;
import com.sge.dao.impl.AulaDaoImpl;
import com.sge.dao.impl.EstudianteDaoImpl;
import com.sge.dao.impl.ProfesorDaoImpl;
import com.sge.dao.impl.RegistroDaoImpl;
import com.sge.dao.impl.SesionDaoImpl;

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
                //service = new EstudianteDaoImpl();
                break;
                
            case GRUPO:
                //service = new GrupoDaoImpl();
                break;
                
            case GRUPOUSUARIO:
                //service = new GrupoUsuarioDaoImpl();
                break;
                
            case HORARIO:
                //service = new HorarioDaoImpl();
                break;
                
            case HORARIOSESION:
                //service = new HorarioSesionDaoImpl();
                break;
                
            case MATERIA:
                //service = new MateriaDaoImpl();
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
                //service=new UsuarioDaoImpl();
                break;
        }
        
        return service;
    
    }
    
}
