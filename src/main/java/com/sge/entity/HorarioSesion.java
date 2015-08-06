/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "horario_sesion", catalog = "escuela", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioSesion.findAll", query = "SELECT h FROM HorarioSesion h"),
    @NamedQuery(name = "HorarioSesion.findById", query = "SELECT h FROM HorarioSesion h WHERE h.id = :id"),
    @NamedQuery(name = "HorarioSesion.findBySesionId", query = "SELECT h FROM HorarioSesion h WHERE h.sesionId = :sesionId"),
    @NamedQuery(name = "HorarioSesion.findByHorarioId", query = "SELECT h FROM HorarioSesion h WHERE h.horarioId = :horarioId")})
public class HorarioSesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sesion_id")
    private Integer sesionId;
    @Column(name = "horario_id")
    private Integer horarioId;

    public HorarioSesion() {
    }

    public HorarioSesion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSesionId() {
        return sesionId;
    }

    public void setSesionId(Integer sesionId) {
        this.sesionId = sesionId;
    }

    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioSesion)) {
            return false;
        }
        HorarioSesion other = (HorarioSesion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sge.entity.HorarioSesion[ id=" + id + " ]";
    }
    
}
