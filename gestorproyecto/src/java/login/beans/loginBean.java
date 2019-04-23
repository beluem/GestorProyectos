/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.beans;

import gestor.Usuario;
import gestor.controlador.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author usuario
 */
@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    /**
     * @return the usuarioAutenticado
     */
    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    /**
     * @param usuarioAutenticado the usuarioAutenticado to set
     */
    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }
    
    
    private String nombreUsuario;
    private String password;

    @EJB
    private UsuarioFacade usuFacade;
    private Usuario usuarioAutenticado;
    
    

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    

    /**
     * Creates a new instance of loginBean
     */
    public loginBean() {
    }
    
    public String autenticar(){
        
        usuarioAutenticado=usuFacade.encontrarUsuarioxLogin(nombreUsuario);
        
        if(usuarioAutenticado!=null){
            if(usuarioAutenticado.getPass().equals(password)){
                return "ingresar";
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, 
            "El password no corresponde","El password no corresponde"));
            return null;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, 
        "El Usuario no existe","El usuario no existe"));
        return null;
    }
}
