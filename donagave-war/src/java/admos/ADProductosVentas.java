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
    private Productos productoSeleccionado;
    

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
    
    public List<Productosventa> productosIDVenta(Ventas idventa){
        System.out.print("El idventa que se envio al metodo: "+idventa);
        List<Productosventa> resultado=mDProductosVentas.productosIDVenta(idventa);
        System.out.print(resultado);
        return resultado;
    }

    public Productos getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Productos productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
    
    public void añadirArticulo(int cantidad,Productos idProducto,Ventas idVenta){
        creaPV();
        pVentas.setCantidad(cantidad);
        pVentas.setIdProducto(idProducto);
        pVentas.setIdVenta(idVenta);
        mDProductosVentas.insertarProducto(pVentas);
        
    }
    public List<Productosventa> findAll(){
        return mDProductosVentas.getAll();
    }
    

}
