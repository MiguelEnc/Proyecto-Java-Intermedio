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
@Table(name = "registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findById", query = "SELECT r FROM Registro r WHERE r.id = :id"),
    @NamedQuery(name = "Registro.findByEstudiante", query = "SELECT r FROM Registro r WHERE r.estudiante.id = :estudiante"),
    @NamedQuery(name = "Registro.findByHorarioSesion", query = "SELECT r FROM Registro r WHERE r.horarioSesion.id = :horarioSesion"),
    @NamedQuery(name = "Registro.findByStatus", query = "SELECT r FROM Registro r WHERE r.status = :status"),
    
    @NamedQuery(name = "Registro.findSesionbyEstu",query = 
            "SELECT s.a FROM"
            + "(SELECT e FROM Estudiante e WHERE e.matricula = :matricula) e"
            + "join (SELECT h FROM HorarioSesion h WHERE h.id = :id) hs on(e.horario.sesion.id=hs.horario.sesion.id) "
            + "join (SELECT s FROM Sesion s WHERE s.id = :id) s on(hs.sesion.id=s.sesion.id)"
            + "where e.esdiante.id= :matricula")

})
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "estudiante")    
    @ManyToOne(cascade = CascadeType.ALL)  
    private Estudiante estudiante;
    @JoinColumn(name = "horario_sesion")   
    @ManyToOne(cascade = CascadeType.ALL)
    private HorarioSesion horarioSesion;
    @Column(name = "status")
    private String status;

    public Registro() {
    }

    public Registro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public HorarioSesion getHorarioSesion() {
        return horarioSesion;
    }

    public void setHorarioSesion(HorarioSesion horarioSesion) {
        this.horarioSesion = horarioSesion;
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
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testjpa.Registro[ id=" + id + " ]";
    }
    
}
