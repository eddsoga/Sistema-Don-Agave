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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
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

    public void creaPV() {
        pVentas = new Productosventa();
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

    public Productosventa getUnProductoVenta(int id) {
        return mDProductosVentas.getUnProductoVenta(id);
    }

    public boolean isPSNull() {
        if (productoSeleccionado != null) {
            return false;
        }
        return true;
    }

    public List<Productosventa> productosIDVenta(Ventas idventa) {
        System.out.print("El idventa que se envio al metodo: " + idventa);
        List<Productosventa> resultado = mDProductosVentas.productosIDVenta(idventa);
        System.out.print(resultado);
        return resultado;
    }

    public Productos getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Productos productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public double eliminarArticulo(Ventas idVenta, Productosventa producto) {
        List<Productosventa> lista = mDProductosVentas.productosIDVenta(idVenta);
        Productosventa existente = null;
        for (Productosventa item : lista) {
            if (item.getIdProducto().equals(producto.getIdProducto()) && item.getIdVenta().equals(idVenta)) {
                existente = item;
                System.out.print("Prodcuto Encontrado");
                break;
            }
        }
        if (existente != null) {
            // Si existe, lo elimina
            mDProductosVentas.borrarProductoVenta(existente); // borramos el prodcuto
            System.out.print("Producto Eliminado");
        }
        try {
        } catch (Exception e) {
            System.out.print(e);
        }
        //Actualizamos la lista local
        lista = mDProductosVentas.productosIDVenta(idVenta);
        return getTotalVenta(lista);

    }

    public double añadirArticulo(int cantidad, Productos idProducto, Ventas idVenta, List<Productosventa> lista) {
        // Busca si el producto ya está en la lista
        Productosventa existente = null;

        for (Productosventa item : lista) {
            if (item.getIdProducto().equals(idProducto) && item.getIdVenta().equals(idVenta)) {
                existente = item;
                break;
            }
        }

        if (existente != null) {
            // Si existe, actualiza la cantidad y el subtotal
            existente.setCantidad(existente.getCantidad() + cantidad);
            existente.setSubtotal(existente.getCantidad() * idProducto.getPrecioVenta());
            mDProductosVentas.actualizarProductoVenta(existente); // Asegúrate de tener este método
        } else {
            // Si no existe, crea un nuevo registro
            creaPV();
            pVentas.setCantidad(cantidad);
            pVentas.setIdProducto(idProducto);
            pVentas.setIdVenta(idVenta);
            pVentas.setSubtotal(cantidad * idProducto.getPrecioVenta());
            mDProductosVentas.insertarProducto(pVentas);
            lista.add(pVentas);
        }
        productoSeleccionado = null;
        // Calcula y retorna el total actualizado
        return getTotalVenta(lista);
    }

    public List<Productosventa> findAll() {
        return mDProductosVentas.getAll();
    }

    public double getTotalVenta(List<Productosventa> lista) {
        double total = 0.0;
        for (Productosventa item : lista) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void vCantidad(FacesContext contexto, UIComponent obp, Object valor) {
        int cantidad = (int) valor;
        UIInput ciu = (UIInput) obp;

        if (cantidad <= 0) {
            ciu.setValid(false);
            FacesMessage mensaje1 = new FacesMessage("La cantidad debe ser mayor a 0");
            contexto.addMessage(ciu.getClientId(contexto), mensaje1);
        } else if (isPSNull()) {
            ciu.setValid(false);
            FacesMessage mensaje2 = new FacesMessage("Primero seleccione el producto que quiera añadir");
            contexto.addMessage(ciu.getClientId(contexto), mensaje2);
        }
    }
}
