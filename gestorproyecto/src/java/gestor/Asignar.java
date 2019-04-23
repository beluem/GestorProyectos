/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "asignar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignar.findAll", query = "SELECT a FROM Asignar a")
    , @NamedQuery(name = "Asignar.findByIdAsignar", query = "SELECT a FROM Asignar a WHERE a.idAsignar = :idAsignar")})
public class Asignar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_asignar")
    private Integer idAsignar;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol idRol;
    @JoinColumn(name = "id_usario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsario;

    public Asignar() {
    }

    public Asignar(Integer idAsignar) {
        this.idAsignar = idAsignar;
    }

    public Integer getIdAsignar() {
        return idAsignar;
    }

    public void setIdAsignar(Integer idAsignar) {
        this.idAsignar = idAsignar;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Usuario getIdUsario() {
        return idUsario;
    }

    public void setIdUsario(Usuario idUsario) {
        this.idUsario = idUsario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignar != null ? idAsignar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignar)) {
            return false;
        }
        Asignar other = (Asignar) object;
        if ((this.idAsignar == null && other.idAsignar != null) || (this.idAsignar != null && !this.idAsignar.equals(other.idAsignar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestor.Asignar[ idAsignar=" + idAsignar + " ]";
    }
    
}
