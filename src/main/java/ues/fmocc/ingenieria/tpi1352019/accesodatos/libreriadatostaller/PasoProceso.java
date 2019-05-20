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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "paso_proceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasoProceso.findAll", query = "SELECT p FROM PasoProceso p")
    , @NamedQuery(name = "PasoProceso.findByIdPasoProceso", query = "SELECT p FROM PasoProceso p WHERE p.idPasoProceso = :idPasoProceso")
    , @NamedQuery(name = "PasoProceso.findByNumeroPaso", query = "SELECT p FROM PasoProceso p WHERE p.numeroPaso = :numeroPaso")
    , @NamedQuery(name = "PasoProceso.findByProceso", query = "SELECT ps FROM PasoProceso p JOIN p.idPaso ps WHERE p.idProceso.idProceso = :idProceso AND ps.nombre LIKE UPPER(':paso%') ORDER BY p.numeroPaso")})
public class PasoProceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paso_proceso", nullable = false)
    private Integer idPasoProceso;
    @Basic(optional = false)
    @Column(name = "numero_paso", nullable = false)
    private Integer numeroPaso;
    @ManyToMany(mappedBy = "pasoProcesoCollection")
    private Collection<Reparacion> reparacionCollection;
    @JoinColumn(name = "id_paso", referencedColumnName = "id_paso", nullable = false)
    @ManyToOne(optional = false)
    private Paso idPaso;
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso", nullable = false)
    @ManyToOne(optional = false)
    private Proceso idProceso;

    public PasoProceso() {
    }

    public PasoProceso(Integer idPasoProceso) {
        this.idPasoProceso = idPasoProceso;
    }

    public PasoProceso(Integer idPasoProceso, int numeroPaso) {
        this.idPasoProceso = idPasoProceso;
        this.numeroPaso = numeroPaso;
    }

    public Integer getIdPasoProceso() {
        return idPasoProceso;
    }

    public void setIdPasoProceso(Integer idPasoProceso) {
        this.idPasoProceso = idPasoProceso;
    }

    public Integer getNumeroPaso() {
        return numeroPaso;
    }

    public void setNumeroPaso(Integer numeroPaso) {
        this.numeroPaso = numeroPaso;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    public Paso getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Paso idPaso) {
        this.idPaso = idPaso;
    }

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPasoProceso != null ? idPasoProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasoProceso)) {
            return false;
        }
        PasoProceso other = (PasoProceso) object;
        return !((this.idPasoProceso == null && other.idPasoProceso != null) || (this.idPasoProceso != null && !this.idPasoProceso.equals(other.idPasoProceso))
                || (this.idPaso != null && !this.idPaso.equals(other.idPaso)) 
                || (this.numeroPaso != null && !this.numeroPaso.equals(other.numeroPaso)));
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.PasoProceso[ idPasoProceso=" + idPasoProceso + " ]";
    }

}
