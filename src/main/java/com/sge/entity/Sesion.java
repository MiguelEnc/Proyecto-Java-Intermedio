package com.sge.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s"),
    @NamedQuery(name = "Sesion.findById", query = "SELECT s FROM Sesion s WHERE s.id = :id"),
    @NamedQuery(name = "Sesion.findByMateriaId", query = "SELECT s FROM Sesion s WHERE s.materiaId.id = :materiaId"),
    @NamedQuery(name = "Sesion.findByProfesorId", query = "SELECT s FROM Sesion s WHERE s.profesorId.id = :profesorId"),
    @NamedQuery(name = "Sesion.findByFechaInicio", query = "SELECT s FROM Sesion s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Sesion.findByFechaFin", query = "SELECT s FROM Sesion s WHERE s.fechaFin = :fechaFin"),
    @NamedQuery(name = "Sesion.findByCodigo", query = "SELECT s FROM Sesion s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Sesion.findByAulaId", query = "SELECT s FROM Sesion s WHERE s.aulaId.id = :aulaId"),
    @NamedQuery(name = "Sesion.findByCapacidad", query = "SELECT s FROM Sesion s WHERE s.capacidad = :capacidad"),
    @NamedQuery(name = "Sesion.findByStatus", query = "SELECT s FROM Sesion s WHERE s.status = :status")})
public class Sesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "materia_id")    
    @ManyToOne(cascade = CascadeType.ALL)
    private Materia materiaId;
    @JoinColumn(name = "profesor_id")   
    @ManyToOne(cascade = CascadeType.ALL)
    private Profesor profesorId;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "aula_id")    
    @ManyToOne(cascade = CascadeType.ALL)
    private Aula aulaId;
    @Column(name = "capacidad")
    private Integer capacidad;
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

    public Materia getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Materia materiaId) {
        this.materiaId = materiaId;
    }

    public Profesor getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Profesor profesorId) {
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

    public Aula getAulaId() {
        return aulaId;
    }

    public void setAulaId(Aula aulaId) {
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
        return "testjpa.Sesion[ id=" + id + " ]";
    }
    
}
