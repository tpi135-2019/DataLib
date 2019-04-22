/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "parte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parte.findAll", query = "SELECT p FROM Parte p")
    , @NamedQuery(name = "Parte.findByIdParte", query = "SELECT p FROM Parte p WHERE p.idParte = :idParte")
    , @NamedQuery(name = "Parte.findByNombre", query = "SELECT p FROM Parte p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Parte.findByActivo", query = "SELECT p FROM Parte p WHERE p.activo = :activo")
    , @NamedQuery(name = "Parte.findByDescripcion", query = "SELECT p FROM Parte p WHERE p.descripcion = :descripcion")})
public class Parte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_parte", nullable = false)
    @javax.validation.constraints.NotNull(message = "Identificador no debe ser nulo")
    private Integer idParte;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    @NotNull
    @NotEmpty(message = "Ingrese el nombre de la parte")
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParte")
    private Collection<SubParte> subParteCollection;

    public Parte() {
    }

    public Parte(Integer idParte) {
        this.idParte = idParte;
    }

    public Parte(Integer idParte, String nombre) {
        this.idParte = idParte;
        this.nombre = nombre;
    }

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<SubParte> getSubParteCollection() {
        return subParteCollection;
    }

    public void setSubParteCollection(Collection<SubParte> subParteCollection) {
        this.subParteCollection = subParteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParte != null ? idParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parte)) {
            return false;
        }
        Parte other = (Parte) object;
        return !((this.idParte == null && other.idParte != null) || (this.idParte != null && !this.idParte.equals(other.idParte))
                 || (this.nombre != null && !this.nombre.equals(other.getNombre())));
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.Parte[ idParte=" + idParte + " ]";
    }
    
}
