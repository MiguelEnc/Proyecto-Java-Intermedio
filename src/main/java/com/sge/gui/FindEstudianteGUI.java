/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.gui;

import com.sge.bs.DaoEnum;
import com.sge.bs.DaoFactory;
import com.sge.dao.EstudianteDao;
import com.sge.dao.MateriaDao;
import com.sge.entity.Estudiante;
import com.sge.entity.Materia;
import com.sge.templates.comboxes.EstuCBValue;
import com.sge.templates.comboxes.MateriaCBValue;
import java.util.List;
import javax.swing.JDesktopPane;



/**
 *
 * @author miguel
 */
public class FindEstudianteGUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form FindEstudianteGUI
     */
    
    private static FindEstudianteGUI instancia;
           
    private FindEstudianteGUI() {
        initComponents();
    }
    
    private String matricula;
    
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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMateriasSelect = new javax.swing.JTable();
        jTextMatriculaSearch = new javax.swing.JTextField();
        jComboBoxMatriculas = new javax.swing.JComboBox();
        jButtonBuscar = new javax.swing.JButton();
        jButtonInscribir = new javax.swing.JButton();
        jRadioselect = new javax.swing.JRadioButton();
        jRadiobuscar = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Mostrar Estudiantes");

        jTableMateriasSelect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Matricula", "Correo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMateriasSelect);

        jTextMatriculaSearch.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jTextMatriculaSearch.setEnabled(false);

        List<Estudiante> list=EstudianteDao.getAll();
        EstuCBValue cv=new EstuCBValue(list);
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

        jButtonInscribir.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jButtonInscribir.setText("Inscribir");
        jButtonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInscribirActionPerformed(evt);
            }
        });

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

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioselect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadiobuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextMatriculaSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(161, 161, 161))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInscribir)
                    .addComponent(jRadioselect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextMatriculaSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jRadiobuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInscribirActionPerformed
        // TODO add your handling code here:
        InscripsionEstudienate inscribir= InscripsionEstudienate.getInstance(matricula);
        if(!inscribir.isVisible())
        {
        } else {
            JDesktopPane desktopPane = getDesktopPane();
            desktopPane.add(inscribir);
        }
        inscribir.setVisible(true);
        
        
    }//GEN-LAST:event_jButtonInscribirActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        
        int id= Integer.parseInt(jTextMatriculaSearch.getText());
        Estudiante list=EstudianteDao.findEntity(id);
        //System.out.println(list.getNombre());
        
        matricula=jTextMatriculaSearch.getText();
        
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

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
        
         matricula=jTextMatriculaSearch.getText();
        
    }//GEN-LAST:event_jComboBoxMatriculasActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonInscribir;
    private javax.swing.JComboBox jComboBoxMatriculas;
    private javax.swing.JRadioButton jRadiobuscar;
    private javax.swing.JRadioButton jRadioselect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMateriasSelect;
    private javax.swing.JTextField jTextMatriculaSearch;
    // End of variables declaration//GEN-END:variables
    private  EstudianteDao EstudianteDao=(EstudianteDao) DaoFactory.getDao(DaoEnum.ESTUDIANTE);
}
