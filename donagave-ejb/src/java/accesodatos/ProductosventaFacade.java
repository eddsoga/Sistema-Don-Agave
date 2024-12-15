/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import Modelo.Productosventa;
import Modelo.Ventas;
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
public class ProductosventaFacade extends AbstractFacade<Productosventa> {

    @PersistenceContext(unitName = "donagave-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosventaFacade() {
        super(Productosventa.class);
    }
    
    public List<Productosventa> productosIDVenta(Ventas idventa) {
        List<Productosventa> ventas = null;
        try {
            Query consultausuario = em.createNamedQuery("Productosventa.findByIdVenta");
            consultausuario.setParameter("idVenta", idventa);
            ventas = consultausuario.getResultList();
        } catch (Exception e) {
            return null;
        }
        return ventas;
    }
    
    public Productosventa getUnProductoVenta(int id) {
        Productosventa p = null;
        try {
            Query consultausuario = em.createNamedQuery("Productosventa.findByIdproductosVenta");
            consultausuario.setParameter("idproductosVenta", id);
            p = (Productosventa) consultausuario.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return p;
    }
    
    
}
