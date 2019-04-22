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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByIdVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Vehiculo.findByNumeroChasis", query = "SELECT v FROM Vehiculo v WHERE v.numeroChasis = :numeroChasis")
    , @NamedQuery(name = "Vehiculo.findByNumeroMotor", query = "SELECT v FROM Vehiculo v WHERE v.numeroMotor = :numeroMotor")
    , @NamedQuery(name = "Vehiculo.findByVin", query = "SELECT v FROM Vehiculo v WHERE v.vin = :vin")
    , @NamedQuery(name = "Vehiculo.findByColor", query = "SELECT v FROM Vehiculo v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculo.HistorialPropietarios", query = "SELECT p FROM HistorialPropietario h, Propietario p WHERE h.idPropietario = p.idPropietario AND UPPER(h.idVehiculo) = UPPER(:placa)")
})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_vehiculo", nullable = false, length = 20)
    private String idVehiculo;
    @Basic(optional = false)
    @Column(name = "numero_chasis", nullable = false, length = 17)
    private String numeroChasis;
    @Basic(optional = false)
    @Column(name = "numero_motor", nullable = false, length = 11)
    private String numeroMotor;
    @Basic(optional = false)
    @Column(name = "vin", nullable = false, length = 17)
    private String vin;
    @Column(name = "color", length = 45)
    private String color;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo", nullable = false)
    @ManyToOne(optional = false)
    private Modelo idModelo;
    @JoinColumn(name = "id_propietario", referencedColumnName = "id_propietario", nullable = false)
    @ManyToOne(optional = false)
    private Propietario idPropietario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo")
    private Collection<Diagnostico> diagnosticoCollection;

    public Vehiculo() {
    }

    public Vehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(String idVehiculo, String numeroChasis, String numeroMotor, String vin) {
        this.idVehiculo = idVehiculo;
        this.numeroChasis = numeroChasis;
        this.numeroMotor = numeroMotor;
        this.vin = vin;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    public Propietario getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Propietario idPropietario) {
        this.idPropietario = idPropietario;
    }

    @XmlTransient
    public Collection<Diagnostico> getDiagnosticoCollection() {
        return diagnosticoCollection;
    }

    public void setDiagnosticoCollection(Collection<Diagnostico> diagnosticoCollection) {
        this.diagnosticoCollection = diagnosticoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        return !((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))
                || (this.vin != null && !this.vin.equals(other.vin)));

    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }

}
