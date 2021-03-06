/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "reparacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparacion.findAll", query = "SELECT r FROM Reparacion r")
    , @NamedQuery(name = "Reparacion.findByIdReparacion", query = "SELECT r FROM Reparacion r WHERE r.idReparacion = :idReparacion")
    , @NamedQuery(name = "Reparacion.findByFecha", query = "SELECT r FROM Reparacion r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "ReparacionPorPlaca", query = "SELECT DISTINCT (t) FROM Reparacion t where UPPER(t.idDiagnostico.idVehiculo.idVehiculo)= UPPER(:placa)")
    , @NamedQuery(name = "Reaparacion.Personal", query = "SELECT t FROM Reparacion t JOIN FETCH t.personalCollection per where per.idMecanico=:id")
    , @NamedQuery(name = "Reparacion.Fechas", query = "SELECT t FROM Reparacion t JOIN FETCH t.idDiagnostico.idVehiculo ve WHERE t.fecha between :desde and :hasta ")
    , @NamedQuery(name = "Reparacion.Diagnostico", query = "SELECT t FROM Reparacion t WHERE t.idDiagnostico.idDiagnostico=:id")
    , @NamedQuery(name = "Reparacion.findByObservacion", query = "SELECT r FROM Reparacion r WHERE r.observacion = :observacion")})
public class Reparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reparacion", nullable = false)
    private Integer idReparacion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @Past(message = "Fecha de reparacion no puede exceder al periodo actual")
    private Date fecha;
    @Column(name = "observacion", length = 200)
    @Size(min = 10)
    private String observacion;

    @JoinTable(name = "paso_reparacion", joinColumns = {
        @JoinColumn(name = "id_reparacion", referencedColumnName = "id_reparacion", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_paso_proceso", referencedColumnName = "id_paso_proceso", nullable = false)})
    @ManyToMany
    private Collection<PasoProceso> pasoProcesoCollection;

    @JoinTable(name = "pieza_reparacion", joinColumns = {
        @JoinColumn(name = "id_reparacion", referencedColumnName = "id_reparacion", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_pieza", referencedColumnName = "id_pieza", nullable = false)})
    @ManyToMany
    private Collection<Pieza> piezaCollection;

    @JoinTable(name = "personal_reparacion", joinColumns = {
        @JoinColumn(name = "id_reparacion", referencedColumnName = "id_reparacion", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_mecanico", referencedColumnName = "id_mecanico", nullable = false)})
    @ManyToMany
    private Collection<Personal> personalCollection;

    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id_diagnostico", nullable = false)
    @ManyToOne(optional = false)
    private Diagnostico idDiagnostico;

    public Reparacion() {
    }

    public Reparacion(Integer idReparacion) {
        this.idReparacion = idReparacion;
    }

    public Reparacion(Integer idReparacion, Date fecha, String observacion) {
        this.idReparacion = idReparacion;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public Integer getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(Integer idReparacion) {
        this.idReparacion = idReparacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<PasoProceso> getPasoProcesoCollection() {
        return pasoProcesoCollection;
    }

    public void setPasoProcesoCollection(Collection<PasoProceso> pasoProcesoCollection) {
        this.pasoProcesoCollection = pasoProcesoCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Pieza> getPiezaCollection() {
        return piezaCollection;
    }

    public void setPiezaCollection(Collection<Pieza> piezaCollection) {
        this.piezaCollection = piezaCollection;
    }

    @XmlTransient   
    @JsonbTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }

    public Diagnostico getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Diagnostico idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReparacion != null ? idReparacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparacion)) {
            return false;
        }
        Reparacion other = (Reparacion) object;
        return !((this.idReparacion == null && other.idReparacion != null) || (this.idReparacion != null && !this.idReparacion.equals(other.idReparacion))
                || (this.observacion != null && !this.observacion.equals(other.observacion)));

    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.Reparacion[ idReparacion=" + idReparacion + " ]";
    }

}
