/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ESTACION
 */
@Entity
@Table(name = "T_PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPersonal.findAll", query = "SELECT t FROM TPersonal t"),
    @NamedQuery(name = "TPersonal.findById", query = "SELECT t FROM TPersonal t WHERE t.id = :id"),
    @NamedQuery(name = "TPersonal.findByNombre", query = "SELECT t FROM TPersonal t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TPersonal.findByTelefono", query = "SELECT t FROM TPersonal t WHERE t.telefono = :telefono")})
public class TPersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TELEFONO")
    private String telefono;

    public TPersonal() {
    }

    public TPersonal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof TPersonal)) {
            return false;
        }
        TPersonal other = (TPersonal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TPersonal[ id=" + id + " ]";
    }
    
}
