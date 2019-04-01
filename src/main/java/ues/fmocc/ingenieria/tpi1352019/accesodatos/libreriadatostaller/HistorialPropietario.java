/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "historial_propietario", catalog = "taller", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialPropietario.findAll", query = "SELECT h FROM HistorialPropietario h")
    , @NamedQuery(name = "HistorialPropietario.findByIdVehiculo", query = "SELECT h FROM HistorialPropietario h WHERE h.historialPropietarioPK.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "HistorialPropietario.findByIdPropietario", query = "SELECT h FROM HistorialPropietario h WHERE h.historialPropietarioPK.idPropietario = :idPropietario")
    })
public class HistorialPropietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistorialPropietarioPK historialPropietarioPK;

    public HistorialPropietario() {
    }

    public HistorialPropietario(HistorialPropietarioPK historialPropietarioPK) {
        this.historialPropietarioPK = historialPropietarioPK;
    }

    public HistorialPropietario(String idVehiculo, int idPropietario) {
        this.historialPropietarioPK = new HistorialPropietarioPK(idVehiculo, idPropietario);
    }

    public HistorialPropietarioPK getHistorialPropietarioPK() {
        return historialPropietarioPK;
    }

    public void setHistorialPropietarioPK(HistorialPropietarioPK historialPropietarioPK) {
        this.historialPropietarioPK = historialPropietarioPK;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historialPropietarioPK != null ? historialPropietarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialPropietario)) {
            return false;
        }
        HistorialPropietario other = (HistorialPropietario) object;
        if ((this.historialPropietarioPK == null && other.historialPropietarioPK != null) || (this.historialPropietarioPK != null && !this.historialPropietarioPK.equals(other.historialPropietarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.HistorialPropietario[ historialPropietarioPK=" + historialPropietarioPK + " ]";
    }
    
}
