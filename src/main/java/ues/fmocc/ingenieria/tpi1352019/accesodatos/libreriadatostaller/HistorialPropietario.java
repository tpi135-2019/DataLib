/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "historial_propietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialPropietario.findAll", query = "SELECT h FROM HistorialPropietario h")
    , @NamedQuery(name = "HistorialPropietario.findByIdVehiculo", query = "SELECT h FROM HistorialPropietario h WHERE h.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "HistorialPropietario.findByIdPropietario", query = "SELECT h FROM HistorialPropietario h WHERE h.idPropietario = :idPropietario")
    , @NamedQuery(name = "HistorialPropietario.findByFecha", query = "SELECT h FROM HistorialPropietario h WHERE h.fecha = :fecha")
    , @NamedQuery(name = "HistorialPropietario.findByNumeroRegistro", query = "SELECT h FROM HistorialPropietario h WHERE h.numeroRegistro = :numeroRegistro")})
public class HistorialPropietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private String idVehiculo;
    @Basic(optional = false)
    @Column(name = "id_propietario")
    private Integer idPropietario;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_registro")
    private Integer numeroRegistro;

    public HistorialPropietario() {
    }

    public HistorialPropietario(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public HistorialPropietario(Integer numeroRegistro, String idVehiculo, Integer idPropietario) {
        this.numeroRegistro = numeroRegistro;
        this.idVehiculo = idVehiculo;
        this.idPropietario = idPropietario;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroRegistro != null ? numeroRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialPropietario)) {
            return false;
        }
        HistorialPropietario other = (HistorialPropietario) object;
        return !((this.numeroRegistro == null && other.numeroRegistro != null) || (this.numeroRegistro != null && !this.numeroRegistro.equals(other.numeroRegistro))
                || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))
                || (this.idPropietario != null && !this.idPropietario.equals(other.idPropietario)));
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.HistorialPropietario[ numeroRegistro=" + numeroRegistro + " ]";
    }
}
