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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByIdMecanico", query = "SELECT p FROM Personal p WHERE p.idMecanico = :idMecanico")
    ,@NamedQuery(name = "Personal.personal.sucursal", query = "SELECT t FROM Personal t WHERE t.idSucursal.nombre like CONCAT('%', :name, '%')")
    ,@NamedQuery(name = "Personal.SucursalNombreLike", query = "SELECT p FROM Personal p WHERE p.idSucursal.idSucursal = :idSucursal AND CONCAT(p.nombre, ' ', p.apellido) LIKE CONCAT(:nombre, '%')")
    , @NamedQuery(name = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Personal.findByApellido", query = "SELECT p FROM Personal p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Personal.findByFechaContratacion", query = "SELECT p FROM Personal p WHERE p.fechaContratacion = :fechaContratacion")
    , @NamedQuery(name = "Personal.Reparacion", query = "SELECT t FROM Personal t JOIN FETCH t.reparacionCollection rep WHERE rep.idReparacion=:id")
    , @NamedQuery(name = "Personal.Proceso", query = "SELECT DISTINCT t FROM Personal t JOIN FETCH t.especialidadCollection es JOIN FETCH es.procesoCollection pro WHERE pro.idProceso=:id")
    , @NamedQuery(name = "Personal.findByActivo", query = "SELECT p FROM Personal p WHERE p.activo = :activo")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mecanico", nullable = false)
    private Integer idMecanico;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    @NotEmpty(message = "Ingrese un nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Column(name = "fecha_contratacion")
    @Temporal(TemporalType.DATE)
    @Past(message = "La fecha de contratacion no puede exceder a la fecha actual")
    private Date fechaContratacion;
    @Column(name = "activo")
    private Boolean activo;
    @JoinTable(name = "personal_especialidad", joinColumns = {
        @JoinColumn(name = "id_mecanico", referencedColumnName = "id_mecanico", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad", nullable = false)})
    @ManyToMany
    private Collection<Especialidad> especialidadCollection;
    @ManyToMany(mappedBy = "personalCollection")
    private Collection<Reparacion> reparacionCollection;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false)
    @ManyToOne(optional = false)
    private Sucursal idSucursal;

    public Personal() {
    }

    public Personal(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Personal(Integer idMecanico, String nombre, String apellido) {
        this.idMecanico = idMecanico;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
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

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Especialidad> getEspecialidadCollection() {
        return especialidadCollection;
    }

    public void setEspecialidadCollection(Collection<Especialidad> especialidadCollection) {
        this.especialidadCollection = especialidadCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMecanico != null ? idMecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        return !((this.idMecanico == null && other.idMecanico != null) || (this.idMecanico != null && !this.idMecanico.equals(other.idMecanico))
                || (this.nombre != null && !this.nombre.equals(other.nombre)));

    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi1352019.accesodatos.libreriadatostaller.Personal[ idMecanico=" + idMecanico + " ]";
    }

}
