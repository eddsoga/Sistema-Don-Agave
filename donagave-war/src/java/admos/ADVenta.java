/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import Modelo.Productos;
import Modelo.Usuarios;
import Modelo.Ventas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
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
    private Ventas ventaSeleccionada;
    private List<Productos> productos;
    private Usuarios vendedor;
    
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
        if (venta.getEstadoVenta()== null || venta.getFechaHoraVenta()== null || venta.getFormaPago() == null ||venta.getGuiaParticular()== null || venta.getMontoTotal()==0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos los campos son obligatorios", ""));
        }
        venta.setMontoTotal(0.0);
        venta.setFechaHoraVenta(new Date());
        venta.setIdUsuario(vendedor);
        mDVentas.insertarVentas(venta);
        venta = new Ventas();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Venta registrada correctamente.", "Venta registrado correctamente."));

    }
     
    public List<Productos> getProductos() {
        return productos;
    }
     
     
    public void prepararVenta(List<Productos> productos, Usuarios vendedor){
        this.productos = productos;
        this.vendedor=vendedor;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    public Ventas getVentaSeleccionada() {
        return ventaSeleccionada;
    }

    public void setVentaSeleccionada(Ventas ventaSeleccionada) {
        this.ventaSeleccionada = ventaSeleccionada;
    }

    public Usuarios getVendedor() {
        return vendedor;
    }
    
    public int getIDCVentaSeleccionada() {
        return ventaSeleccionada.getIdVenta();
    }

    public void setVendedor(Usuarios vendedor) {
        this.vendedor = vendedor;
    }
    
    public void guardarCambiosVenta(Ventas v){
        mDVentas.actualizarVenta(v);
    }
    
    public void cerrarVenta(Ventas venta,double total){
        venta.setEstadoVenta("Finalizada");
        venta.setMontoTotal(total);
        guardarCambiosVenta(venta);
        
    }
    public void abrirVenta(Ventas venta,double total){
        venta.setEstadoVenta("Abierta");
        venta.setMontoTotal(total);
        guardarCambiosVenta(venta);
    }
    public void finalizarVenta(Ventas venta,double total){
        venta.setEstadoVenta("Finalizada");
        venta.setMontoTotal(total);
        guardarCambiosVenta(venta);
    }
    
    
    
    
    

    
}
