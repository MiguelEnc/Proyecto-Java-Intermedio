/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "sesion", catalog = "escuela", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s"),
    @NamedQuery(name = "Sesion.findById", query = "SELECT s FROM Sesion s WHERE s.id = :id"),
    @NamedQuery(name = "Sesion.findByMateriaId", query = "SELECT s FROM Sesion s WHERE s.materiaId = :materiaId"),
    @NamedQuery(name = "Sesion.findByProfesorId", query = "SELECT s FROM Sesion s WHERE s.profesorId = :profesorId"),
    @NamedQuery(name = "Sesion.findByFechaInicio", query = "SELECT s FROM Sesion s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Sesion.findByFechaFin", query = "SELECT s FROM Sesion s WHERE s.fechaFin = :fechaFin"),
    @NamedQuery(name = "Sesion.findByCodigo", query = "SELECT s FROM Sesion s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Sesion.findByAulaId", query = "SELECT s FROM Sesion s WHERE s.aulaId = :aulaId"),
    @NamedQuery(name = "Sesion.findByCapacidad", query = "SELECT s FROM Sesion s WHERE s.capacidad = :capacidad"),
    @NamedQuery(name = "Sesion.findByStatus", query = "SELECT s FROM Sesion s WHERE s.status = :status")})
public class Sesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "materia_id")
    private Integer materiaId;
    @Column(name = "profesor_id")
    private Integer profesorId;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "aula_id")
    private Integer aulaId;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Size(max = 1)
    @Column(name = "status")
    private String status;

    public Sesion() {
    }

    public Sesion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getAulaId() {
        return aulaId;
    }

    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sge.entity.Sesion[ id=" + id + " ]";
    }
    
}
