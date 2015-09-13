/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.templates.comboxes;

import com.sge.entity.Sesion;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author dante
 */
public class SesionCBValue extends AbstractListModel<Object> implements ComboBoxModel<Object>{

     private List<Sesion> list;

    public SesionCBValue(List<Sesion> listSe) {
        this.list =listSe;
    }
     
    private  String selected;
     
    public int getSize() {
        return  list. size();
    }

    public Object getElementAt(int index) {
        return list.get(index).getCodigo();
    }

    public void setSelectedItem(Object anItem) {
        selected=(String) anItem;
    }

    public Object getSelectedItem() {
        
        return  selected;
        
    } 
}
