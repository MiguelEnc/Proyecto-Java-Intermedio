/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.gui;

import com.sge.bs.DaoEnum;
import com.sge.bs.DaoFactory;
import com.sge.dao.GrupoDao;
import com.sge.dao.GrupoUsuarioDao;
import com.sge.dao.UsuarioDao;
import com.sge.entity.Grupo;
import com.sge.entity.GrupoUsuario;
import com.sge.entity.Usuario;
import com.sge.templates.comboxes.GrupoCBValue;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author dante
 */
public class UserToGroup extends javax.swing.JInternalFrame {

    private UserToGroup() {
        initComponents();
        fillList1();
    }
    private static UserToGroup instancia = null;
    private GrupoUsuarioDao grupoUsuarioDao = (GrupoUsuarioDao) DaoFactory.getDao(DaoEnum.GRUPOUSUARIO);
    private GrupoDao grupoDao = (GrupoDao) DaoFactory.getDao(DaoEnum.GRUPO);
    private UsuarioDao usuarioDao = (UsuarioDao) DaoFactory.getDao(DaoEnum.USUARIO);
    private String accion = "";
    private int List1SelectedIndex;
    private int List2SelectedIndex;
    private String List1SelectedValue;
    
    public static UserToGroup getInstancia() {
        try {
            if(instancia==null)
            instancia=new UserToGroup();
        } catch (Exception e) {
            System.out.println("Singleton Error: " + e);
        }
        
        return instancia;
    }
    
    private void fillList1(){
        DefaultListModel listModel = new DefaultListModel();
        
        List<Usuario> items = usuarioDao.getAll();
        
        for(Usuario u : items){
            listModel.addElement(u.getNombreUsuario());
        }
        
        jList1.setModel(listModel);
    }
    
    private void fillList1WithOutUser(String userName){
        DefaultListModel listModel = new DefaultListModel();
        
        List<Usuario> items = usuarioDao.getAll();
        
        for(Usuario u : items){
            if(!u.getNombreUsuario().equals(userName))
                listModel.addElement(u.getNombreUsuario());
        }
        
        jList1.setModel(listModel);
        jList1.updateUI();
    }
    
    private void linkUserToGroup(int userIndex){
        
        Usuario usuario = usuarioDao.findEntity(userIndex);
        
        Grupo grupo = grupoDao.findEntity(jComboBox1.getSelectedIndex() + 1);
        
        List<GrupoUsuario> gU = grupoUsuarioDao.getAll();
        int rows = gU.size();
        
        GrupoUsuario grupoUsuario = new GrupoUsuario();
        
        grupoUsuario.setId(rows + 1);
        grupoUsuario.setGrupo(grupo);
        grupoUsuario.setUsuario(usuario);
        
        grupoUsuarioDao.save(grupoUsuario);
    }
    
    private void fillList2(int index){
        DefaultListModel listModel = new DefaultListModel();
        
        /*
        GrupoUsuario grupoUsuario = null;
        try {
            grupoUsuario = grupoUsuarioDao.getGrupoUsuarioByGrupoId(index + 1);
        } catch (Exception e) {
            System.out.println("GrupoUsuario exception: " + e);
            e.printStackTrace();
        }
        
        if(grupoUsuario != null){
            listModel.addElement(grupoUsuario.getUsuario().getNombreUsuario());
        }
        */
        
        
        listModel.addElement(List1SelectedValue);
        jList2.setModel(listModel);
        jList2.updateUI();
    }
    
    private void fillList2WithOutUser(int index){
        DefaultListModel listModel = new DefaultListModel();
        
        listModel = (DefaultListModel) jList2.getModel();
        listModel.remove(index);
        
        jList2.setModel(listModel);
    }
    
    private void unlinkUserToGroup(int userIndex){
                
        Grupo grupo = grupoDao.findEntity(jComboBox1.getSelectedIndex() + 1);
        
        GrupoUsuario grupoUsuario = grupoUsuarioDao.getGrupoUsuarioByGrupoId(jComboBox1.getSelectedIndex() + 1);
        
        grupoUsuario.setUsuario(null);
        grupoUsuario.setGrupo(grupo);
        
        grupoUsuarioDao.update(grupoUsuario);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        btnPassTo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPassBack = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Agregar Grupo");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel1.setText("Grupo");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel3.setText("Usuarios");

        jList1.setEnabled(false);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setEnabled(false);
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        btnPassTo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnPassTo.setText(">>");
        btnPassTo.setEnabled(false);
        btnPassTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassToActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPassBack.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnPassBack.setText("<<");
        btnPassBack.setEnabled(false);
        btnPassBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassBackActionPerformed(evt);
            }
        });

        List<Grupo> list = grupoDao.getAll();
        GrupoCBValue cv = new GrupoCBValue(list);
        jComboBox1.setModel(cv);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnPassTo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPassBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPassTo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPassBack, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(accion == "pasando")
            linkUserToGroup(jList1.getSelectedIndex() + 1);
        else if(accion == "devolviendo")
                unlinkUserToGroup(jList2.getSelectedIndex() + 1);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        jList1.setSelectedIndex(1);
        jList2.setSelectedIndex(1);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        List1SelectedIndex = jList1.getSelectedIndex();
        
        Object sel =null;
        int[] selectedIx = this.jList1.getSelectedIndices();      

        for (int i = 0; i < selectedIx.length; i++) {
            sel = jList1.getModel().getElementAt(selectedIx[i]);
            if(sel != null)
                List1SelectedValue = (String) sel;
        }
        
        btnPassTo.setEnabled(true);
        btnPassBack.setEnabled(true);
    }//GEN-LAST:event_jList1ValueChanged

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
        List2SelectedIndex = jList2.getSelectedIndex();
        btnPassTo.setEnabled(true);
        btnPassBack.setEnabled(true);
    }//GEN-LAST:event_jList2ValueChanged

    private void btnPassToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassToActionPerformed
        fillList1WithOutUser(jList1.getSelectedValue().toString());
        fillList2(List1SelectedIndex);
        accion = "pasando";
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnPassToActionPerformed

    private void btnPassBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassBackActionPerformed
        fillList2WithOutUser(List2SelectedIndex);
        fillList1();
        accion = "devolviendo";
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnPassBackActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jList1.setEnabled(true);
        jList2.setEnabled(true);
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPassBack;
    private javax.swing.JButton btnPassTo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
}
