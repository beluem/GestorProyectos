/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.controlador;

import gestor.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author usuario
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "gestorproyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    //Metodo especifico utilizando los nameQuery para buscar los usuarios
    
    public Usuario encontrarUsuarioxLogin(String nombreUsuario){
        Query q=em.createNamedQuery("Usuario.findByUsername", Usuario.class).setParameter("username", nombreUsuario);
        
        List<Usuario> listado=q.getResultList();
        
        if(!listado.isEmpty()){
            return listado.get(0);
            
        }
        return null;
    }
      
}
