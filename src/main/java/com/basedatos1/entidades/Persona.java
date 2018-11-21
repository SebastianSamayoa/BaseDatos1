/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhoansamayoa
 */
@Entity
@Table(name = "PERSONA", catalog = "Hilos", schema = "Hilos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id")
    , @NamedQuery(name = "Persona.findByDpi", query = "SELECT p FROM Persona p WHERE p.dpi = :dpi")
    , @NamedQuery(name = "Persona.findByPnombre", query = "SELECT p FROM Persona p WHERE p.pnombre = :pnombre")
    , @NamedQuery(name = "Persona.findBySnombre", query = "SELECT p FROM Persona p WHERE p.snombre = :snombre")
    , @NamedQuery(name = "Persona.findByTnombre", query = "SELECT p FROM Persona p WHERE p.tnombre = :tnombre")
    , @NamedQuery(name = "Persona.findByPapellido", query = "SELECT p FROM Persona p WHERE p.papellido = :papellido")
    , @NamedQuery(name = "Persona.findBySapellido", query = "SELECT p FROM Persona p WHERE p.sapellido = :sapellido")
    , @NamedQuery(name = "Persona.findByCapellido", query = "SELECT p FROM Persona p WHERE p.capellido = :capellido")
    , @NamedQuery(name = "Persona.findByNit", query = "SELECT p FROM Persona p WHERE p.nit = :nit")
    , @NamedQuery(name = "Persona.findByNacionalidad", query = "SELECT p FROM Persona p WHERE p.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Persona.findByIdtelefono", query = "SELECT p FROM Persona p WHERE p.idtelefono = :idtelefono")
    , @NamedQuery(name = "Persona.findByIddireccion", query = "SELECT p FROM Persona p WHERE p.iddireccion = :iddireccion")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DPI", nullable = false, length = 25)
    private String dpi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PNOMBRE", nullable = false, length = 50)
    private String pnombre;
    @Size(max = 50)
    @Column(name = "SNOMBRE", length = 50)
    private String snombre;
    @Size(max = 50)
    @Column(name = "TNOMBRE", length = 50)
    private String tnombre;
    @Size(max = 50)
    @Column(name = "PAPELLIDO", length = 50)
    private String papellido;
    @Size(max = 50)
    @Column(name = "SAPELLIDO", length = 50)
    private String sapellido;
    @Size(max = 50)
    @Column(name = "CAPELLIDO", length = 50)
    private String capellido;
    @Size(max = 14)
    @Column(name = "NIT", length = 14)
    private String nit;
    @Size(max = 50)
    @Column(name = "NACIONALIDAD", length = 50)
    private String nacionalidad;
    @Column(name = "IDTELEFONO")
    private Integer idtelefono;
    @Column(name = "IDDIRECCION")
    private Integer iddireccion;

    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(Integer id, String dpi, String pnombre) {
        this.id = id;
        this.dpi = dpi;
        this.pnombre = pnombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getTnombre() {
        return tnombre;
    }

    public void setTnombre(String tnombre) {
        this.tnombre = tnombre;
    }

    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    public String getCapellido() {
        return capellido;
    }

    public void setCapellido(String capellido) {
        this.capellido = capellido;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(Integer idtelefono) {
        this.idtelefono = idtelefono;
    }

    public Integer getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.basedatos1.entidades.Persona[ id=" + id + " ]";
    }
    
}
