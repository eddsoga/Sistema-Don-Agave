/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipuladatos;

import Modelo.Usuarios;
import accesodatos.UsuariosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Eduardo Soto
 */
@Stateless
@LocalBean
public class MDUsuarios {
    @EJB
    private UsuariosFacade usuariosFacade;

    public Usuarios usuarioUP(Usuarios p) {
        return usuariosFacade.usuario_usu_pass(p.getUsuario(), p.getPassword());
    }
    
    public boolean usuarioExiste(String usuario) {
        return usuariosFacade.usuarioExiste(usuario);
    }
    
    public void insertarPersona(Usuarios p) {
        usuariosFacade.create(p);
    }
    public List<Usuarios> usuarios(){
        return usuariosFacade.findAll();
    }
    
    public Usuarios unUsuario(int id){
        return usuariosFacade.find(id);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
