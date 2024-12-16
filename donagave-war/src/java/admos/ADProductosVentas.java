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
import manipuladatos.MDProductos;
import manipuladatos.MDProductosVentas;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Eduardo Soto
 */
@Named(value = "aDProductosVentas")
@SessionScoped
public class ADProductosVentas implements Serializable {

    @EJB
    private MDProductos mDProductos;

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
        try {
            // Imprime información de depuración (si es necesario, reemplazar con logger)
            System.out.println("Eliminando el producto: " + producto.getIdProducto().getNombreProducto());

            // Elimina el producto del carrito
            mDProductosVentas.borrarProductoVenta(producto);
            System.out.println("Producto eliminado del carrito.");

            // Restaura el stock del producto
            int cantidad = producto.getCantidad();
            int nuevoStock = producto.getIdProducto().getExistencia() + cantidad;
            producto.getIdProducto().setExistencia(nuevoStock);
            System.out.println("Nuevo stock del producto: " + nuevoStock);

            // Actualiza las salidas
            int nuevasSalidas = producto.getIdProducto().getSalidas() - cantidad;
            producto.getIdProducto().setSalidas(nuevasSalidas);
            System.out.println("Nuevas salidas del producto: " + nuevasSalidas);

            // Actualiza el producto en la base de datos
            mDProductos.actualizarProducto(producto.getIdProducto());

            // Refresca la lista de productos del carrito
            List<Productosventa> carrito = mDProductosVentas.productosIDVenta(idVenta);

            // Mensaje de éxito
            FacesMessage mensajeExito = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Producto eliminado correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, mensajeExito);

            // Devuelve el total actualizado de la venta
            return getTotalVenta(carrito);

        } catch (Exception e) {
            // Maneja excepciones
            FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al eliminar el artículo.");
            FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            e.printStackTrace();
            return 0.0;
        }
    }

    public double añadirArticulo(int cantidad, Productos idProducto, Ventas idVenta, List<Productosventa> lista) {
        try {
            // Verifica si hay suficiente stock
            if (idProducto.getExistencia() < cantidad) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Stock Insuficiente", "Stock insuficiente.");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                return getTotalVenta(lista);
            }

            // Busca si el producto ya está en la lista
            Productosventa existente = lista.stream()
                    .filter(item -> item.getIdProducto().equals(idProducto) && item.getIdVenta().equals(idVenta))
                    .findFirst().orElse(null);

            if (existente != null) {
                // Actualiza la cantidad y el subtotal
                existente.setCantidad(existente.getCantidad() + cantidad);
                existente.setSubtotal(existente.getCantidad() * idProducto.getPrecioVenta());
                mDProductosVentas.actualizarProductoVenta(existente);
            } else {
                // Crea un nuevo registro
                creaPV();
                pVentas.setCantidad(cantidad);
                pVentas.setIdProducto(idProducto);
                pVentas.setIdVenta(idVenta);
                pVentas.setSubtotal(cantidad * idProducto.getPrecioVenta());
                mDProductosVentas.insertarProducto(pVentas);
                lista.add(pVentas);
            }

            // Actualiza el stock y las salidas
            idProducto.setExistencia(idProducto.getExistencia() - cantidad);
            idProducto.setSalidas(idProducto.getSalidas() + cantidad);
            mDProductos.actualizarProducto(idProducto);

            // Mensaje de éxito
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Artículo añadido correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);

        } catch (Exception e) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrió un error al añadir el artículo.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            e.printStackTrace();
        }

        productoSeleccionado = null;
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
