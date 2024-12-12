/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipuladatos;

import Modelo.Productosventa;
import accesodatos.ProductosventaFacade;
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
public class MDProductosVentas {

    @EJB
    private ProductosventaFacade productosventaFacade;
    
    public void insertarProducto(Productosventa p){
        productosventaFacade.create(p);
    }
    public List<Productosventa> productos(){
        return productosventaFacade.findAll();
    }
    
    public Productosventa getUnProductoVenta(int id){
        return productosventaFacade.getUnProductoVenta(id);
    }
    
    public List<Productosventa> productosIDVenta(int idventa){
        return productosventaFacade.productosIDVenta(idventa);
    }
    
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
