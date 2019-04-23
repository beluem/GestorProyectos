/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.controlador;

import gestor.ProductBlacklog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author usuario
 */
@Stateless
public class ProductBlacklogFacade extends AbstractFacade<ProductBlacklog> {

    @PersistenceContext(unitName = "gestorproyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductBlacklogFacade() {
        super(ProductBlacklog.class);
    }
    
}
