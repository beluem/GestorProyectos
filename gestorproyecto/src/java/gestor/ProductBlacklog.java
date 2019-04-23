/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "product_blacklog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductBlacklog.findAll", query = "SELECT p FROM ProductBlacklog p")
    , @NamedQuery(name = "ProductBlacklog.findByIdProduct", query = "SELECT p FROM ProductBlacklog p WHERE p.idProduct = :idProduct")})
public class ProductBlacklog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private Integer idProduct;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduct")
    private List<Sprint> sprintList;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduct")
    private List<UserHistories> userHistoriesList;

    public ProductBlacklog() {
    }

    public ProductBlacklog(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @XmlTransient
    public List<Sprint> getSprintList() {
        return sprintList;
    }

    public void setSprintList(List<Sprint> sprintList) {
        this.sprintList = sprintList;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @XmlTransient
    public List<UserHistories> getUserHistoriesList() {
        return userHistoriesList;
    }

    public void setUserHistoriesList(List<UserHistories> userHistoriesList) {
        this.userHistoriesList = userHistoriesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductBlacklog)) {
            return false;
        }
        ProductBlacklog other = (ProductBlacklog) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestor.ProductBlacklog[ idProduct=" + idProduct + " ]";
    }
    
}
