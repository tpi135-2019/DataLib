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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "propietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietario.findAll", query = "SELECT p FROM Propietario p")
    , @NamedQuery(name = "Propietario.findByIdPropietario", query = "SELECT p FROM Propietario p WHERE p.idPropietario = :idPropietario")
    , @NamedQuery(name = "Propietario.findByNombre", query = "SELECT p FROM Propietario p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Propietario.findByApellido", query = "SELECT p FROM Propietario p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Propietario.findByDireccion", query = "SELECT p FROM Propietario p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Propietario.findByTelefono", query = "SELECT p FROM Propietario p WHERE p.telefono = :telefono")})
public class Propietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_propietario", nullable = false)
    private Integer idPropietario;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Column(name = "direccion", length = 200)
    private String direccion;
    @Column(name = "telefono", length = 45)
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropietario")
    private Collection<Vehiculo> vehiculoCollection;

    public Propietario() {
    }

    public Propietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Propietario(Integer idPropietario, String nombre, String apellido) {
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPropietario != null ? idPropietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietario)) {
            return false;
        }
        Propietario other = (Propietario) object;
        return !((this.idPropietario == null && other.idPropietario != null) || (this.idPropietario != null && !this.idPropietario.equals(other.idPropietario))
                || (!this.nombre.isEmpty() && !this.nombre.equals(other.nombre)));
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.Propietario[ idPropietario=" + idPropietario + " ]";
    }
    
}
