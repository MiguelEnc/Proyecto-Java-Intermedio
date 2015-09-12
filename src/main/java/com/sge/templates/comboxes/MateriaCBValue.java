/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.templates.comboxes;


import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import com.sge.entity.Materia;

/**
 *
 * @author dante
 */
 public class MateriaCBValue extends AbstractListModel<Object> implements ComboBoxModel<Object>{

     private List<Materia> list;

    public MateriaCBValue(List<Materia> list) {
     this.list =list;
    }
     
     
     private  String selected;


     
    public int getSize() {
        return  list. size();
    }

    public Object getElementAt(int index) {
        return list.get(index).getNombre();
    }

    public void setSelectedItem(Object anItem) {
        selected=(String) anItem;
    }

    public Object getSelectedItem() {
        
        return  selected;
        
    } 
}
