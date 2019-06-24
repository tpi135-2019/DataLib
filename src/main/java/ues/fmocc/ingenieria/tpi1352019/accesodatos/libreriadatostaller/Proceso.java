/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "proceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p")
    ,@NamedQuery(name = "Proceso.Sucursal", query = "SELECT DISTINCT su FROM Sucursal su JOIN su.personalCollection pc JOIN pc.especialidadCollection ec WHERE ec.idEspecialidad IN (SELECT p.idEspecialidad.idEspecialidad FROM Proceso p WHERE p.idProceso = :idProceso)")
    , @NamedQuery(name = "Proceso.findByIdProceso", query = "SELECT p FROM Proceso p WHERE p.idProceso = :idProceso")
    , @NamedQuery(name = "Proceso.findByNombre", query = "SELECT p FROM Proceso p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proceso.findByActivo", query = "SELECT p FROM Proceso p WHERE p.activo = :activo")})
public class Proceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proceso", nullable = false)
    private Integer idProceso;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    @NotEmpty(message = "Ingrese un proceso")
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad", nullable = false)
    @ManyToOne(optional = false)
    private Especialidad idEspecialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProceso")
    private Collection<PasoProceso> pasoProcesoCollection;

    public Proceso() {
    }

    public Proceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public Proceso(Integer idProceso, String nombre) {
        this.idProceso = idProceso;
        this.nombre = nombre;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Especialidad getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Especialidad idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<PasoProceso> getPasoProcesoCollection() {
        return pasoProcesoCollection;
    }

    public void setPasoProcesoCollection(Collection<PasoProceso> pasoProcesoCollection) {
        this.pasoProcesoCollection = pasoProcesoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProceso != null ? idProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceso)) {
            return false;
        }
        Proceso other = (Proceso) object;
        return !((this.idProceso == null && other.idProceso != null) || (this.idProceso != null && !this.idProceso.equals(other.idProceso))
                || (this.nombre != null && !this.nombre.equals(other.nombre)));

    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.Proceso[ idProceso=" + idProceso + " ]";
    }

}
