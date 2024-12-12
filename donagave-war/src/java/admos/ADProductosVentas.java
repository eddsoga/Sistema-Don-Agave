/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import Modelo.Productos;
import Modelo.Productosventa;
import Modelo.Ventas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import manipuladatos.MDProductosVentas;

/**
 *
 * @author Eduardo Soto
 */
@Named(value = "aDProductosVentas")
@SessionScoped
public class ADProductosVentas implements Serializable {

    @EJB
    private MDProductosVentas mDProductosVentas;
    private Productosventa pVentas;
    

    /**
     * Creates a new instance of ADProductosVentas
     */
    public ADProductosVentas() {
        creaPV();
    }
    public void creaPV(){
        pVentas= new Productosventa();
    }

    public MDProductosVentas getmDProductosVentas() {
        return mDProductosVentas;
    }

    public void setmDProductosVentas(MDProductosVentas mDProductosVentas) {
        this.mDProductosVentas = mDProductosVentas;
    }

    public Productosventa getpVentas() {
        return pVentas;
    }

    public void setpVentas(Productosventa pVentas) {
        this.pVentas = pVentas;
    }
    
    public Productosventa getUnProductoVenta(int id){
        return mDProductosVentas.getUnProductoVenta(id);
    }
    
    public List<Productosventa> productosIDVenta(int idventa){
        return mDProductosVentas.productosIDVenta(idventa);
    }
    public void añadirArticulo(int cantidad,Productos idProducto,Ventas idVenta){
        pVentas= new Productosventa();
        pVentas.setCantidad(cantidad);
        pVentas.setIdProducto(idProducto);
        pVentas.setIdVenta(idVenta);
    }
    
}
