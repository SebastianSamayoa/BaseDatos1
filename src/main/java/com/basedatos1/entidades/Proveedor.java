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
@Table(name = "PROVEEDOR", catalog = "Hilos", schema = "Hilos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findById", query = "SELECT p FROM Proveedor p WHERE p.id = :id")
    , @NamedQuery(name = "Proveedor.findBySociedad", query = "SELECT p FROM Proveedor p WHERE p.sociedad = :sociedad")
    , @NamedQuery(name = "Proveedor.findByComercial", query = "SELECT p FROM Proveedor p WHERE p.comercial = :comercial")
    , @NamedQuery(name = "Proveedor.findByNit", query = "SELECT p FROM Proveedor p WHERE p.nit = :nit")
    , @NamedQuery(name = "Proveedor.findByIddireccion", query = "SELECT p FROM Proveedor p WHERE p.iddireccion = :iddireccion")
    , @NamedQuery(name = "Proveedor.findByIdtelefono", query = "SELECT p FROM Proveedor p WHERE p.idtelefono = :idtelefono")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "SOCIEDAD", length = 255)
    private String sociedad;
    @Size(max = 255)
    @Column(name = "COMERCIAL", length = 255)
    private String comercial;
    @Size(max = 14)
    @Column(name = "NIT", length = 14)
    private String nit;
    @Column(name = "IDDIRECCION")
    private Integer iddireccion;
    @Column(name = "IDTELEFONO")
    private Integer idtelefono;

    public Proveedor() {
    }

    public Proveedor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSociedad() {
        return sociedad;
    }

    public void setSociedad(String sociedad) {
        this.sociedad = sociedad;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public Integer getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(Integer idtelefono) {
        this.idtelefono = idtelefono;
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
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.basedatos1.entidades.Proveedor[ id=" + id + " ]";
    }
    
}
