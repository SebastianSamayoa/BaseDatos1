/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "persona", catalog = "Hilos", schema = "Hilos", uniqueConstraints = {@UniqueConstraint(columnNames = {"idpersona"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona")
    , @NamedQuery(name = "Persona.findByPnombre", query = "SELECT p FROM Persona p WHERE p.pnombre = :pnombre")
    , @NamedQuery(name = "Persona.findBySnombre", query = "SELECT p FROM Persona p WHERE p.snombre = :snombre")
    , @NamedQuery(name = "Persona.findByPapellido", query = "SELECT p FROM Persona p WHERE p.papellido = :papellido")
    , @NamedQuery(name = "Persona.findBySapellido", query = "SELECT p FROM Persona p WHERE p.sapellido = :sapellido")
    , @NamedQuery(name = "Persona.findByNit", query = "SELECT p FROM Persona p WHERE p.nit = :nit")})
public class Persona implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pnombre", nullable = false, length = 50)
    private String pnombre;
    @Size(max = 50)
    @Column(name = "snombre", length = 50)
    private String snombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "papellido", nullable = false, length = 50)
    private String papellido;
    @Size(max = 50)
    @Column(name = "sapellido", length = 50)
    private String sapellido;
    @Size(max = 50)
    @Column(name = "nit", length = 50)
    private String nit;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpersona", nullable = false)
    private Integer idPersona;
    @OneToMany(mappedBy = "personaid")
    @JsonManagedReference
    private List<Usuario> usuarioList;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String pnombre, String papellido) {
        this.idPersona = idPersona;
        this.pnombre = pnombre;
        this.papellido = papellido;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }


    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.basedatos1.entidades.Persona[ idPersona=" + idPersona + " ]";
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
}
