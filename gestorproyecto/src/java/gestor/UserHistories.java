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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "user_histories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHistories.findAll", query = "SELECT u FROM UserHistories u")
    , @NamedQuery(name = "UserHistories.findByIdUser", query = "SELECT u FROM UserHistories u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "UserHistories.findByDescripcion", query = "SELECT u FROM UserHistories u WHERE u.descripcion = :descripcion")})
public class UserHistories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne(optional = false)
    private ProductBlacklog idProduct;

    public UserHistories() {
    }

    public UserHistories(Integer idUser) {
        this.idUser = idUser;
    }

    public UserHistories(Integer idUser, String descripcion) {
        this.idUser = idUser;
        this.descripcion = descripcion;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ProductBlacklog getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(ProductBlacklog idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHistories)) {
            return false;
        }
        UserHistories other = (UserHistories) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestor.UserHistories[ idUser=" + idUser + " ]";
    }
    
}
