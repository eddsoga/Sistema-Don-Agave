/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipuladatos;

import Modelo.Productos;
import accesodatos.ProductosFacade;
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
public class MDProductos {
    @EJB
    private ProductosFacade productosFacade;
    
    public void insertarProducto(Productos p){
        productosFacade.create(p);
    }
    public List<Productos> productos(){
        return productosFacade.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
