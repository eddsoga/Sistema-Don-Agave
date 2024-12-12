/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos.bak;

import Modelo.Usuarios;
import accesodatos.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Eduardo Soto
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "donagave-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    
    public Usuarios usuario_usu_pass(String usuario, String password) {
        Usuarios persona = null;
        try {
            Query consultausuario = em.createNamedQuery("Usuarios.findByUsuarioPassword");
            consultausuario.setParameter("usuario", usuario);
            consultausuario.setParameter("password", password);
            persona = (Usuarios) consultausuario.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return persona;
    }
    
    public boolean usuarioExiste(String usuario) {
        Long count = em.createQuery("SELECT COUNT(u) FROM Usuarios u WHERE u.usuario = :usuario", Long.class)
                .setParameter("usuario", usuario)
                .getSingleResult();
        return count > 0;
    }
    
}
