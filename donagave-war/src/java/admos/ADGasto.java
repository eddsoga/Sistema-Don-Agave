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
import manipuladatos.MDGastos;
import Modelo.Gastos;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author jairo
 */
@Named(value = "aDGasto")
@SessionScoped
public class ADGasto implements Serializable {

    @EJB
    private MDGastos mDGasto;
    private Gastos gasto;

    public ADGasto() {
        gasto = new Gastos();
    }

    public void registroGasto() {
        if (gasto.getFecha() == null || gasto.getDescripcion() == null || gasto.getProveedor() == null || gasto.getMontoTotal() == 0.0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos los campos son obligatorios", ""));
        }
        mDGasto.insertarGasto(gasto);
        gasto = new Gastos();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Gasto registrado correctamente.", "Gasto registrado correctamente."));

    }

    public MDGastos getmDGasto() {
        return mDGasto;
    }

    public void setmDGasto(MDGastos mDGasto) {
        this.mDGasto = mDGasto;
    }

    public Gastos getGasto() {
        return gasto;
    }

    public void setGasto(Gastos gasto) {
        this.gasto = gasto;
    }

    public List<Gastos> getGastos() {
        return mDGasto.gastos();
    }

    private double transaccionMasGrande;

    public void calcularTransaccionMasGrande() {
        List<Gastos> listaGastos = getGastos();
        if (!listaGastos.isEmpty()) {
            transaccionMasGrande = listaGastos.stream()
                    .mapToDouble(Gastos::getMontoTotal)
                    .max()
                    .orElse(0.0);
        }
    }

    public double getTransaccionMasGrande() {
        calcularTransaccionMasGrande(); // Calcula antes de devolver el valor
        return transaccionMasGrande;
    }

    private Map<String, Long> distribucionFormaPago;

    public void calcularDistribucionFormaPago() {
        List<Gastos> listaGastos = getGastos();
        distribucionFormaPago = listaGastos.stream()
                .collect(Collectors.groupingBy(Gastos::getFormaPago, Collectors.counting()));
    }

    public Map<String, Long> getDistribucionFormaPago() {
        calcularDistribucionFormaPago(); // Calcula antes de devolver el valor
        return distribucionFormaPago;
    }
    private Map<String, Double> porcentajePorTipoActividad;

    public void calcularPorcentajePorTipoActividad() {
        List<Gastos> listaGastos = getGastos();
        int totalGastos = listaGastos.size();
        porcentajePorTipoActividad = listaGastos.stream()
                .collect(Collectors.groupingBy(Gastos::getTipoActividad,
                        Collectors.summingDouble(gasto -> 1.0)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> (e.getValue() / totalGastos) * 100
                ));
    }

    public Map<String, Double> getPorcentajePorTipoActividad() {
        calcularPorcentajePorTipoActividad(); // Calcula antes de devolver el valor
        return porcentajePorTipoActividad;
    }

    private PieChartModel formaPagoModel;

    public void initFormaPagoModel() {
         formaPagoModel = new PieChartModel();
    
    // Agregar datos al gráfico
    getDistribucionFormaPago().forEach(formaPagoModel::set);
    
    // Configuración del gráfico
    formaPagoModel.setTitle("Distribución por Forma de Pago"); // Título del gráfico
    formaPagoModel.setLegendPosition("e"); // Posición de la leyenda (e = este, w = oeste, n = norte, s = sur)
    formaPagoModel.setShowDataLabels(true); // Mostrar etiquetas de los datos
    formaPagoModel.setDataFormat("percent"); // Mostrar valores (puede ser 'percent' para porcentajes)
    formaPagoModel.setShadow(false); // Quitar sombra (opcional)
    }

    public PieChartModel getFormaPagoModel() {
        initFormaPagoModel(); // Calcula antes de devolver el modelo
        return formaPagoModel;
    }
    private BarChartModel actividadModel;

public void initActividadModel() {
    actividadModel = new BarChartModel();
    ChartSeries series = new ChartSeries();
    series.setLabel("Porcentaje");
    actividadModel.setTitle("Distribuciòn Tipos de Actividad");
    actividadModel.setAnimate(true);
    getPorcentajePorTipoActividad().forEach(series::set);
    actividadModel.addSeries(series);
    actividadModel.setShowDatatip(true);
    actividadModel.setShowPointLabels(true);
}

public BarChartModel getActividadModel() {
    initActividadModel(); // Calcula antes de devolver el modelo
    return actividadModel;
}
}
