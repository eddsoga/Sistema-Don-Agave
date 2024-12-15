/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipuladatos;

import Modelo.Productosventa;
import Modelo.Ventas;
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
    
    public List<Productosventa> productosIDVenta(Ventas idventa){
        return productosventaFacade.productosIDVenta(idventa);
    }
    public List<Productosventa> getAll(){
        return productosventaFacade.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void actualizarProductoVenta(Productosventa p) {
        Productosventa existente = productosventaFacade.find(p.getIdproductosVenta());
        if (existente != null) {
            productosventaFacade.edit(p);
        }
    }
    public void borrarProductoVenta(Productosventa p) {
        Productosventa existente = productosventaFacade.find(p.getIdproductosVenta());
        if (existente != null) {
            productosventaFacade.remove(p);
        }
    }
    
}
