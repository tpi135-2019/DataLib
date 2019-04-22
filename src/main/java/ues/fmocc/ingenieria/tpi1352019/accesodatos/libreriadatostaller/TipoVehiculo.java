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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "tipo_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVehiculo.findAll", query = "SELECT t FROM TipoVehiculo t")
    , @NamedQuery(name = "TipoVehiculo.findByIdTipoVehiculo", query = "SELECT t FROM TipoVehiculo t WHERE t.idTipoVehiculo = :idTipoVehiculo")
    , @NamedQuery(name = "TipoVehiculo.findByNombre", query = "SELECT t FROM TipoVehiculo t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoVehiculo.findByDescripcion", query = "SELECT t FROM TipoVehiculo t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoVehiculo.findByCantidadEjes", query = "SELECT t FROM TipoVehiculo t WHERE t.cantidadEjes = :cantidadEjes")
    , @NamedQuery(name = "TipoVehiculo.findByActivo", query = "SELECT t FROM TipoVehiculo t WHERE t.activo = :activo")})
public class TipoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_vehiculo", nullable = false)
    private Integer idTipoVehiculo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    @NotBlank(message = "Ingrese el tipo")
    private String nombre;
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @Column(name = "cantidad_ejes", length = 45)
    private String cantidadEjes;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoVehiculo")
    private Collection<Modelo> modeloCollection;

    public TipoVehiculo() {
    }

    public TipoVehiculo(Integer idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public TipoVehiculo(Integer idTipoVehiculo, String nombre) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombre = nombre;
    }

    public Integer getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(Integer idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidadEjes() {
        return cantidadEjes;
    }

    public void setCantidadEjes(String cantidadEjes) {
        this.cantidadEjes = cantidadEjes;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Modelo> getModeloCollection() {
        return modeloCollection;
    }

    public void setModeloCollection(Collection<Modelo> modeloCollection) {
        this.modeloCollection = modeloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoVehiculo != null ? idTipoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVehiculo)) {
            return false;
        }
        TipoVehiculo other = (TipoVehiculo) object;
        return !((this.idTipoVehiculo == null && other.idTipoVehiculo != null) || (this.idTipoVehiculo != null && !this.idTipoVehiculo.equals(other.idTipoVehiculo))
                || (this.nombre != null && !this.nombre.equals(other.nombre)));
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.TipoVehiculo[ idTipoVehiculo=" + idTipoVehiculo + " ]";
    }
    
}
