/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.gui;

import com.sge.bs.DaoEnum;
import com.sge.bs.DaoFactory;
import com.sge.dao.EstudianteDao;
import com.sge.dao.RegistroDao;
import com.sge.dao.SesionDao;
import com.sge.entity.Estudiante;
import com.sge.entity.Horario;
import com.sge.entity.HorarioSesion;
import com.sge.entity.Registro;
import com.sge.entity.Sesion;
import com.sge.template.tables.SesionHorarioTableValue;
import com.sge.template.tables.SesionTableValue;
import com.sge.templates.comboxes.EstuCBValue;
import java.util.List;


/**
 *
 * @author miguel
 */
public class FindEstudianteGUI extends javax.swing.JInternalFrame {

    private static FindEstudianteGUI instancia;
    
    private FindEstudianteGUI() {
        initComponents();
    }
    
    private String matricula = "";
    
    public static FindEstudianteGUI getInstance() {
        
        try {
            if(instancia==null) {                
                instancia=new FindEstudianteGUI();
            }
        } catch (Exception e) {
            System.out.println("Siglenton Error:: "+ e);
        }
        
        return instancia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMateriasSelect = new javax.swing.JTable();
        jTextMatriculaSearch = new javax.swing.JTextField();
        jComboBoxMatriculas = new javax.swing.JComboBox();
        jButtonBuscar = new javax.swing.JButton();
        jRadioselect = new javax.swing.JRadioButton();
        jRadiobuscar = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Detalle Estudiante");

        /*/
        List<Sesion> se = sesionDao.getSesionByEstudiante(matricula);
        if(se != null)
        tv = new SesionTableValue(se);
        jTableMateriasSelect.setModel(tv);
        //*/
        jScrollPane1.setViewportView(jTableMateriasSelect);

        jTextMatriculaSearch.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jTextMatriculaSearch.setEnabled(false);

        List<Estudiante> list = estudianteDao.getAll();
        EstuCBValue cv = new EstuCBValue(list);
        jComboBoxMatriculas.setModel(cv);
        jComboBoxMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMatriculasActionPerformed(evt);
            }
        });

        jButtonBuscar.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setEnabled(false);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jRadioselect.setSelected(true);
        jRadioselect.setText("Seleccionar");
        jRadioselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioselectActionPerformed(evt);
            }
        });

        jRadiobuscar.setText("Buscar");
        jRadiobuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadiobuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioselect)
                            .addComponent(jRadiobuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextMatriculaSearch)
                            .addComponent(jComboBoxMatriculas, 0, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioselect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextMatriculaSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jRadiobuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        matricula=jTextMatriculaSearch.getText();
        fillTable(matricula);
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void fillTable(String matricula){
        Estudiante estudiante = estudianteDao.findEstudianteByMateria(matricula);
        
        Registro registro = registroDao.getRegistrosByEstudianteId(estudiante.getId());
        
        HorarioSesion horarioSesion = registro.getHorarioSesion();
        
        Sesion sesion = horarioSesion.getSesion();
        Horario horario = horarioSesion.getHorario();
        
        tv = new SesionHorarioTableValue(sesion, horario);
        jTableMateriasSelect.setModel(tv);
    }
    
    private void jRadioselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioselectActionPerformed
        jRadiobuscar.setSelected(false);
        jComboBoxMatriculas.setEnabled(true);
        jTextMatriculaSearch.setEnabled(false);
        jButtonBuscar.setEnabled(false);
        
    }//GEN-LAST:event_jRadioselectActionPerformed

    private void jRadiobuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadiobuscarActionPerformed
        jRadioselect.setSelected(false);
        jComboBoxMatriculas.setEnabled(false);
        jTextMatriculaSearch.setEnabled(true);
        jButtonBuscar.setEnabled(true);
    }//GEN-LAST:event_jRadiobuscarActionPerformed

    private void jComboBoxMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMatriculasActionPerformed
        matricula=jComboBoxMatriculas.getSelectedItem().toString();
        fillTable(matricula);
    }//GEN-LAST:event_jComboBoxMatriculasActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JComboBox jComboBoxMatriculas;
    private javax.swing.JRadioButton jRadiobuscar;
    private javax.swing.JRadioButton jRadioselect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMateriasSelect;
    private javax.swing.JTextField jTextMatriculaSearch;
    // End of variables declaration//GEN-END:variables
    private EstudianteDao estudianteDao=(EstudianteDao) DaoFactory.getDao(DaoEnum.ESTUDIANTE);
    private SesionDao sesionDao = (SesionDao) DaoFactory.getDao(DaoEnum.SESION);
    private RegistroDao registroDao = (RegistroDao) DaoFactory.getDao(DaoEnum.REGISTRO);
    //private HorarioSesionDao horarioSesionDao = (HorarioSesionDao) DaoFactory.getDao(DaoEnum.HORARIOSESION);
    private SesionHorarioTableValue tv;

}
