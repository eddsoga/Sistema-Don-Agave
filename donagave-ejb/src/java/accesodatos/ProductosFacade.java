/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import Modelo.Productos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Eduardo Soto
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> {

    @PersistenceContext(unitName = "donagave-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
    
    public Productos getUnProducto(int id) {
        Productos p = null;
        try {
            Query consultausuario = em.createNamedQuery("Productos.findByIdProducto");
            consultausuario.setParameter("idProducto", id);
            p = (Productos) consultausuario.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return p;
    }
    
    public List<Productos> getPedido(String pedido) {
        List<Productos> p = null;
        try {
            Query consultausuario = em.createNamedQuery("Productos.findByPedido");
            consultausuario.setParameter("tipoProducto", pedido);
            p = (List<Productos>) consultausuario.getResultList();
        } catch (Exception e) {
            return null;
        }
        return p;
    }
    
    @Override
    public void edit(Productos entity) {
        getEntityManager().merge(entity); // Actualizar el registro en la base de datos
    }
}
