/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import manipuladatos.MDUsuarios;
import Modelo.Usuarios;

/**
 *
 * @author jairo
 */
@Named(value = "aDUsuario")
@SessionScoped
public class ADUsuario implements Serializable {
@EJB
    private MDUsuarios mDUsuarios;
    private Usuarios usuario;
    private String pagina;

    public void creaUsuario() {
        usuario = new Usuarios();

    }

    public ADUsuario() {
        creaUsuario();
    }

    public void registroUsuario() {
        if (usuario.getNombre() == null || usuario.getUsuario() == null || usuario.getRol() == null || usuario.getPassword() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos los campos son obligatorios", ""));
        }
        if (mDUsuarios.usuarioExiste(usuario.getUsuario())) {
            // Muestra un mensaje de error si el usuario ya existe
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "El usuario ya existe. Por favor, elige otro.", "El usuario ya existe. Por favor, elige otro."));
        } else {
            System.out.print(usuario);
            mDUsuarios.insertarPersona(usuario);
            usuario = new Usuarios();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario registrado correctamente.", "Usuario registrado correctamente."));
        }
    }

    public boolean acceso() {
        return (usuario = mDUsuarios.usuarioUP(usuario)) != null;
    }

    public void autenticar() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        if (acceso()) {
            // Guarda la persona autenticada en el mapa de sesión
            contexto.getExternalContext().getSessionMap().put("usuarioActual", usuario);
            pagina = "dashboard";
        } else {
            FacesMessage msj = new FacesMessage("Usuario y/o Contraseña invalidos");
            contexto.addMessage(null, msj);
            pagina = "index";
            creaUsuario();
        }
    }
    
    public void logout() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        pagina = "index";
        FacesMessage msj = new FacesMessage("Adiós!👋🏼");
        contexto.addMessage(null, msj);
        creaUsuario();

    }


    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public MDUsuarios getmDUsuarios() {
        return mDUsuarios;
    }

    public void setmDUsuarios(MDUsuarios mDUsuarios) {
        this.mDUsuarios = mDUsuarios;
    }

    public String pagina() {
        return pagina;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
}
