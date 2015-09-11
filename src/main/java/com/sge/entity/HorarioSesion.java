package com.sge.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "horario_sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioSesion.findAll", query = "SELECT h FROM HorarioSesion h"),
    @NamedQuery(name = "HorarioSesion.findById", query = "SELECT h FROM HorarioSesion h WHERE h.id = :id"),
    @NamedQuery(name = "HorarioSesion.findBySesion", query = "SELECT h FROM HorarioSesion h WHERE h.sesion.id = :sesion"),
    @NamedQuery(name = "HorarioSesion.findByHorario", query = "SELECT h FROM HorarioSesion h WHERE h.horario.id = :horario")})
public class HorarioSesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "sesion")    
    @ManyToOne(cascade = CascadeType.ALL)
    private Sesion sesion;
    @JoinColumn(name = "horario")    
    @ManyToOne(cascade = CascadeType.ALL)
    private Horario horario;
    

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

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
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
        return "testjpa.HorarioSesion[ id=" + id + " ]";
    }
    
}
