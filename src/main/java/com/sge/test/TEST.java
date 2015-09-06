package com.sge.test;

import com.sge.bs.DaoEnum;
import com.sge.bs.DaoFactory;
import com.sge.bs.ValidationEnum;
import com.sge.bs.validation.Validation;
import com.sge.bs.validation.ValidationContext;
import com.sge.dao.ProfesorDao;
import com.sge.dao.SesionDao;
import com.sge.entity.Profesor;
import com.sge.entity.Registro;
import com.sge.entity.Sesion;
import com.sge.util.ConnectionDB;
import com.sge.util.ManageUtil;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Usuario
 */
public class TEST {
    
    public static void main(String[] args) {
        /*
        Profesor p=new Profesor();
        p.setApellido("Martinez");
        p.setNombre("Juan");
        p.setCorreo("juan@gmail.com");
       
        Sesion s=new Sesion();
        s.setAulaId(1);
        s.setCapacidad(3);
        s.setCodigo("Sesion2");
        s.setMateriaId(1);
        s.setProfesorId(1);
        s.setFechaFin(new Date());
        s.setFechaInicio(new Date());
        
        
        Registro reg=new Registro();
        reg.setEstudianteId(5);
        reg.setHorarioSesionId(2);
        
        
        
        
//        ProfesorDao pdao=(ProfesorDao) DaoFactory.getDao(DaoEnum.PROFESOR);
//        System.out.println("PDAO:: "+ pdao);
//        
//        pdao.save(p);
        
        SesionDao sesionDao=(SesionDao) DaoFactory.getDao(DaoEnum.SESION);
//        
//        Sesion sesion=sesionDao.findByMateriaId(1);
//        
//        System.out.println("Descripcion de la sesion: "+ sesion.getCodigo());
        
        
        ValidationContext<Registro> context=new ValidationContext<Registro>(ValidationEnum.SESION);
        
        context.execute(reg);
//        sesionDao.save(s);
        
        System.out.println("Done!!");
        
        */
        
        
        EntityManagerFactory factory = ConnectionDB.getInstance();
        System.out.println("Connection open: " + factory.isOpen());
        
        EntityManager em = factory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        
    }
    
}
