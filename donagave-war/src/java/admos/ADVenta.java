/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import Modelo.Productos;
import Modelo.Ventas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import manipuladatos.MDVentas;

/**
 *
 * @author jairo
 */
@Named(value = "aDVenta")
@SessionScoped
public class ADVenta implements Serializable {

    @EJB
    private MDVentas mDVentas;
    private Ventas venta;
    private List<Productos> productos;
    
    /**
     * Creates a new instance of ADVenta
     */
    public ADVenta() {
        creaVenta();
    }

    public MDVentas getmDVentas() {
        return mDVentas;
    }

    public void setmDVentas(MDVentas mDVentas) {
        this.mDVentas = mDVentas;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }
    
    public List<Ventas> ventas(){
        return mDVentas.ventas();
    }
    
    public void creaVenta(){
        venta=new Ventas();
    }
     public void registroVenta() {
        if (venta.getCantidadProductos()== 0 || venta.getEstadoVenta()== null || venta.getFechaHoraVenta()== null || venta.getFormaPago() == null ||venta.getGuiaParticular()== null || venta.getIdProducto() == null || venta.getIdUsuario()== null || venta.getIdVenta()== null || venta.getMontoTotal()==0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos los campos son obligatorios", ""));
        }
        mDVentas.insertarVentas(venta);
        venta = new Ventas();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Venta registrada correctamente.", "Venta registrado correctamente."));

    }
     public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }
    
    

    
}
