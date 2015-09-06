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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "registro", catalog = "escuela", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findById", query = "SELECT r FROM Registro r WHERE r.id = :id"),
    @NamedQuery(name = "Registro.findByEstudianteId", query = "SELECT r FROM Registro r WHERE r.estudianteId = :estudianteId"),
    @NamedQuery(name = "Registro.findByHorarioSesionId", query = "SELECT r FROM Registro r WHERE r.horarioSesionId = :horarioSesionId"),
    @NamedQuery(name = "Registro.findByStatus", query = "SELECT r FROM Registro r WHERE r.status = :status")})
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "estudiante_id")
    private Integer estudianteId;
    
    @Column(name = "horario_sesion_id")
    private Integer horarioSesionId;
    
    @Size(max = 1)
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

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Integer getHorarioSesionId() {
        return horarioSesionId;
    }

    public void setHorarioSesionId(Integer horarioSesionId) {
        this.horarioSesionId = horarioSesionId;
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
        return "com.sge.entity.Registro[ id=" + id + " ]";
    }
    
}
