/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.templates.comboxes;

import com.sge.entity.Profesor;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author dante
 */
public class ProfeCBValue extends AbstractListModel<Object> implements ComboBoxModel<Object> {

    
    private List<Profesor> list;

    public ProfeCBValue(List<Profesor> list) {
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
