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
@Table(name = "TELEFONO", catalog = "Hilos", schema = "Hilos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t")
    , @NamedQuery(name = "Telefono.findById", query = "SELECT t FROM Telefono t WHERE t.id = :id")
    , @NamedQuery(name = "Telefono.findByPais", query = "SELECT t FROM Telefono t WHERE t.pais = :pais")
    , @NamedQuery(name = "Telefono.findByTelefono", query = "SELECT t FROM Telefono t WHERE t.telefono = :telefono")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 5)
    @Column(name = "PAIS", length = 5)
    private String pais;
    @Size(max = 15)
    @Column(name = "TELEFONO", length = 15)
    private String telefono;

    public Telefono() {
    }

    public Telefono(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.basedatos1.entidades.Telefono[ id=" + id + " ]";
    }
    
}
