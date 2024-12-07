/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import manipuladatos.MDProductos;
import Modelo.Productos;
import java.util.List;

/**
 *
 * @author jairo
 */
@Named(value = "aDProducto")
@SessionScoped
public class ADProducto implements Serializable {

    @EJB
    private MDProductos mDProductos;
    private Productos producto;
    
    public ADProducto() {
        producto = new Productos();
    }
    
    public void registroProducto() {
        if (producto.getNombreProducto()== null || producto.getStockIdeal()== 0 || producto.getTipoProducto()== null || producto.getPrecioVenta()== 0.0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos los campos son obligatorios", ""));
        }
        mDProductos.insertarProducto(producto);
        producto = new Productos();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Producto registrado correctamente.", "Producto registrado correctamente."));

    }

    public MDProductos getmDProductos() {
        return mDProductos;
    }

    public void setmDProductos(MDProductos mDProductos) {
        this.mDProductos = mDProductos;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    
    public List<Productos> getProductos(){
        return mDProductos.productos();
    }
    
}
