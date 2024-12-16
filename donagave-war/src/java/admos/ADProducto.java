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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

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
        if (producto.getNombreProducto() == null || producto.getStockIdeal() == 0 || producto.getTipoProducto() == null || producto.getPrecioVenta() == 0.0) {
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

    public List<Productos> getProductos() {
        return mDProductos.productos();
    }

    public Productos getUnProducto(int i) {
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

    public int getTotalProductos() {
        List<Productos> productos = mDProductos.productos();
        return productos.size();  // Devuelve el total de productos registrados
    }
    
     // MÉTRICAS PARA DASHBOARD
    private double existenciaPromedio;

    public void calcularExistenciaPromedio() {
        List<Productos> listaProductos = getProductos();
        existenciaPromedio = listaProductos.stream()
                .mapToDouble(Productos::getExistencia)
                .average()
                .orElse(0.0);
    }

    public double getExistenciaPromedio() {
        calcularExistenciaPromedio(); // Calcula antes de devolver el valor
        return existenciaPromedio;
    }

    private Map<String, Long> distribucionPorTipoProducto;

    public void calcularDistribucionPorTipoProducto() {
        List<Productos> listaProductos = getProductos();
        distribucionPorTipoProducto = listaProductos.stream()
                .collect(Collectors.groupingBy(Productos::getTipoProducto, Collectors.counting()));
    }

    public Map<String, Long> getDistribucionPorTipoProducto() {
        calcularDistribucionPorTipoProducto(); // Calcula antes de devolver el valor
        return distribucionPorTipoProducto;
    }

    // GRÁFICOS PARA DASHBOARD
    private PieChartModel tipoProductoModel;

    public void initTipoProductoModel() {
        tipoProductoModel = new PieChartModel();
        getDistribucionPorTipoProducto().forEach(tipoProductoModel::set);
        tipoProductoModel.setTitle("Distribución por Tipo de Producto");
        tipoProductoModel.setLegendPosition("e");
        tipoProductoModel.setShowDataLabels(true);
        tipoProductoModel.setDataFormat("percent");
        tipoProductoModel.setShadow(false);
    }

    public PieChartModel getTipoProductoModel() {
        initTipoProductoModel(); // Calcula antes de devolver el modelo
        return tipoProductoModel;
    }

    private BarChartModel existenciaModel;

    public void initExistenciaModel() {
        existenciaModel = new BarChartModel();
        ChartSeries series = new ChartSeries();
        series.setLabel("Existencia");
        existenciaModel.setTitle("Existencia Stock Ideal");
        existenciaModel.setAnimate(true);

        getProductos().forEach(producto -> {
            series.set(producto.getNombreProducto(), producto.getExistencia());
        });

        existenciaModel.addSeries(series);
    }

    public BarChartModel getExistenciaModel() {
        initExistenciaModel(); // Calcula antes de devolver el modelo
        return existenciaModel;
    }
    
    public void prepararEditar(Productos p) {
        this.producto = p;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_producto.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String actualizarProductoo() {
        mDProductos.actualizarProductoo(producto); // Actualizar en la base de datos
        return "registro_producto?faces-redirect=true";
    }
    
}
