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
    private static UserToGroup instancia;
    GrupoUsuarioDao grupoUsuarioDao = (GrupoUsuarioDao) DaoFactory.getDao(DaoEnum.GRUPOUSUARIO);
    GrupoDao grupoDao = (GrupoDao) DaoFactory.getDao(DaoEnum.GRUPOUSUARIO);
    UsuarioDao usuarioDao = (UsuarioDao) DaoFactory.getDao(DaoEnum.USUARIO);
    
    int List1SelectedIndex;
    int List2SelectedIndex;
    
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
        
        UsuarioDao usuarioDao = (UsuarioDao) DaoFactory.getDao(DaoEnum.USUARIO);
        List<Usuario> items = usuarioDao.getAll();
        
        for(Usuario u : items){
            listModel.addElement(u.getNombreUsuario());
        }
        
        jList1.setModel(listModel);
    }
    
    private void fillList1(int index){
        DefaultListModel listModel = new DefaultListModel();
        
        List<Usuario> items = usuarioDao.getAll();
        
        for(Usuario u : items){
            listModel.addElement(u.getNombreUsuario());
        }
        
        listModel.addElement(jList2.getSelectedValue().toString());
        
        jList1.setModel(listModel);
        
        
        linkUserToGroup(index);
        
    }
    
    private void linkUserToGroup(int userIndex){
        
        Usuario usuario = usuarioDao.findEntity(userIndex);
        
        Grupo grupo = grupoDao.findEntity(jComboBox1.getSelectedIndex());
        
        GrupoUsuario grupoUsuario = new GrupoUsuario();
        
        grupoUsuario.setGrupo(grupo);
        grupoUsuario.setUsuario(usuario);
        
        grupoUsuarioDao.save(grupoUsuario);
    }
    
    private void fillList2(int index){
        DefaultListModel listModel = new DefaultListModel();
        
        int grupoId = jComboBox1.getSelectedIndex();
        
        GrupoUsuario grupoUsuario = grupoUsuarioDao.getGrupoUsuarioByGrupoId(grupoId);
        
        listModel.addElement(grupoUsuario.getUsuario().getNombreUsuario());
        listModel.addElement(jList1.getSelectedValue().toString());
        jList2.setModel(listModel);
    }
    
    private void unlinkUserToGroup(int userIndex){
                
        Grupo grupo = grupoDao.findEntity(jComboBox1.getSelectedIndex());
        
        GrupoUsuario grupoUsuario = grupoUsuarioDao.getGrupoUsuarioByGrupoId(jComboBox1.getSelectedIndex());
        
        grupoUsuario.setUsuario(null);
        grupoUsuario.setGrupo(grupo);
        
        grupoUsuarioDao.update(grupoUsuario);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        btnPassTo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnPassTo.setText(">>");
        btnPassTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassToActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPassBack.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnPassBack.setText("<<");
        btnPassBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassBackActionPerformed(evt);
            }
        });

        List<Grupo> list=GrupoDao.getAll();
        GrupoCBValue cv=new GrupoCBValue(list);
        jComboBox1.setModel(cv);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPassTo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPassBack, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        jList1.setSelectedIndex(1);
        jList2.setSelectedIndex(1);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        List1SelectedIndex = jList1.getSelectedIndex();
    }//GEN-LAST:event_jList1ValueChanged

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
        List2SelectedIndex = jList2.getSelectedIndex();
    }//GEN-LAST:event_jList2ValueChanged

    private void btnPassToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassToActionPerformed
        jList1.remove(jList1.getSelectedIndex());
        fillList2(List1SelectedIndex);
    }//GEN-LAST:event_btnPassToActionPerformed

    private void btnPassBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassBackActionPerformed
        jList2.remove(jList2.getSelectedIndex());
        fillList1(List2SelectedIndex);
    }//GEN-LAST:event_btnPassBackActionPerformed


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
    private  GrupoDao GrupoDao=(GrupoDao) DaoFactory.getDao(DaoEnum.GRUPO);
}
