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
    public Productos getUnProducto(int id){
        return productosFacade.getUnProducto(id);
    }
    public void actualizarProducto(Productos p) {
        Productos existente = productosFacade.find(p.getIdProducto());
        if (existente != null) {
            productosFacade.edit(p);
            System.out.println("Producto ediatdo en MDProductos");
        }
    }
    
    public void actualizarProductoo(Productos p) {
        productosFacade.edit(p);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
