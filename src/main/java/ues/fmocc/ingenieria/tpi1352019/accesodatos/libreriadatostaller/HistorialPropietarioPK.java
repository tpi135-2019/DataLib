/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kevin
 */
@Embeddable
public class HistorialPropietarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_vehiculo", nullable = false, length = 20)
    private String idVehiculo;
    @Basic(optional = false)
    @Column(name = "id_propietario", nullable = false)
    private int idPropietario;

    public HistorialPropietarioPK() {
    }

    public HistorialPropietarioPK(String idVehiculo, int idPropietario) {
        this.idVehiculo = idVehiculo;
        this.idPropietario = idPropietario;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        hash += (int) idPropietario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialPropietarioPK)) {
            return false;
        }
        HistorialPropietarioPK other = (HistorialPropietarioPK) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        if (this.idPropietario != other.idPropietario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.HistorialPropietarioPK[ idVehiculo=" + idVehiculo + ", idPropietario=" + idPropietario + " ]";
    }
    
}
