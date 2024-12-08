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
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;

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
    
    public Productos getUnProducto(int i){
        return mDProductos.getUnProducto(i);
    }
    
    //VERIFICADORES
    public void vExistencia(FacesContext contexto, UIComponent obp, Object valor) {
        int existencia = (int) valor;
        UIInput ciu = (UIInput) obp;
        if (existencia <= 0) {
            ciu.setValid(false); //error
            FacesMessage mensaje1 = new FacesMessage("La existencia de prodcutos debe ser mayor a 0");
            contexto.addMessage(ciu.getClientId(contexto), mensaje1);
        }
    }
    
    public void vStockIdeal(FacesContext contexto, UIComponent obp, Object valor) {
        int stockIdeal = (int) valor;
        UIInput ciu = (UIInput) obp;
        if (stockIdeal <= 0) {
            ciu.setValid(false); //error
            FacesMessage mensaje1 = new FacesMessage("El Stock ideal debe ser mayor a 0");
            contexto.addMessage(ciu.getClientId(contexto), mensaje1);
        }
    }
    
    public void vPrecioCompra(FacesContext contexto, UIComponent obp, Object valor) {
        double precioCompra = (double) valor;
        UIInput ciu = (UIInput) obp;
        if (precioCompra <= 0) {
            ciu.setValid(false); //error
            FacesMessage mensaje1 = new FacesMessage("El precio de compra debe ser mayor a 0");
            contexto.addMessage(ciu.getClientId(contexto), mensaje1);
        }
    }
    public void vPrecioVenta(FacesContext contexto, UIComponent obp, Object valor) {
        double precioVenta = (double) valor;
        UIInput ciu = (UIInput) obp;
        if (precioVenta <= 0) {
            ciu.setValid(false); //error
            FacesMessage mensaje1 = new FacesMessage("El precio de compra debe ser mayor a 0");
            contexto.addMessage(ciu.getClientId(contexto), mensaje1);
        }
    }
    public void vNombreProducto(FacesContext contexto, UIComponent obp, Object valor) {
        String nombreP = (String) valor;
        UIInput ciu = (UIInput) obp;
        if (nombreP.isBlank() || nombreP.isEmpty()) {
            ciu.setValid(false); //error
            FacesMessage mensaje1 = new FacesMessage("El nombre del producto es obligatorio");
            contexto.addMessage(ciu.getClientId(contexto), mensaje1);
        }
    }
    
}
