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
import manipuladatos.MDReservas;
import Modelo.Reservasmesas;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author jairo
 */
@Named(value = "aDReservas")
@SessionScoped
public class ADReserva implements Serializable {

    @EJB
    private MDReservas mDreserva;
    private Reservasmesas reserva;
    private BarChartModel estadoReservaChart;

    public ADReserva() {
        reserva = new Reservasmesas();
    }

    public void registroReserva() {
        if (reserva.getFechaReserva() == null || reserva.getNombreCliente() == null || reserva.getNumPersonas() == 0 || reserva.getEstadoReserva() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos los campos son obligatorios", ""));
        }
        mDreserva.insertarReserva(reserva);
        reserva = new Reservasmesas();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Reserva registrado correctamente.", "Gasto registrado correctamente."));

    }

    public MDReservas getmDreserva() {
        return mDreserva;
    }

    public void setmDreserva(MDReservas mDreserva) {
        this.mDreserva = mDreserva;
    }

    public Reservasmesas getReserva() {
        return reserva;
    }

    public void setReserva(Reservasmesas reserva) {
        this.reserva = reserva;
    }

    public List<Reservasmesas> getReservas() {
        return mDreserva.reservas();
    }

    public void vNombreCliente(FacesContext contexto, UIComponent obp, Object valor) {
        String nombreP = (String) valor;
        UIInput ciu = (UIInput) obp;
        if (nombreP.isBlank() || nombreP.isEmpty()) {
            ciu.setValid(false); //error
            FacesMessage mensaje1 = new FacesMessage("El nombre del cliente no debe estar vacío");
            contexto.addMessage(ciu.getClientId(contexto), mensaje1);
        }
    }

    public void vNumPersonas(FacesContext contexto, UIComponent obp, Object valor) {
        int nPersonas = (int) valor;
        UIInput ciu = (UIInput) obp;
        if (nPersonas <= 0) {
            ciu.setValid(false); //error
            FacesMessage mensaje1 = new FacesMessage("El numero de personas debe ser mayor a 0");
            contexto.addMessage(ciu.getClientId(contexto), mensaje1);
        }
    }

    public void vLugarAsignado(FacesContext contexto, UIComponent obp, Object valor) {
        String nombreL = (String) valor;
        UIInput ciu = (UIInput) obp;
        if (nombreL.isBlank() || nombreL.isEmpty()) {
            ciu.setValid(false); //error
            FacesMessage mensaje1 = new FacesMessage("El Lugar Asignado no puede estar en blanco");
            contexto.addMessage(ciu.getClientId(contexto), mensaje1);
        }
    }

    public void validarFechaReserva(FacesContext contexto, UIComponent obp, Object valorf) {
        Date fechaReserva = (Date) valorf; // Suponiendo que es un objeto Date
        Calendar fechaReservaCal = Calendar.getInstance();
        fechaReservaCal.setTime(fechaReserva);

        Calendar hoyCal = Calendar.getInstance(); // Fecha actual
        Calendar fechaMaxima = Calendar.getInstance();
        fechaMaxima.add(Calendar.YEAR, 1); // Un año desde hoy

        UIInput componente = (UIInput) obp;

        if (fechaReservaCal.before(hoyCal)) {
            // Fecha anterior a hoy
            componente.setValid(false);
            FacesMessage mensaje1 = new FacesMessage("La fecha de reserva no puede ser anterior a hoy.");
            contexto.addMessage(componente.getClientId(contexto), mensaje1);
        } else if (fechaReservaCal.after(fechaMaxima)) {
            // Fecha más allá de un año
            componente.setValid(false);
            FacesMessage mensaje2 = new FacesMessage("La fecha de reserva no puede ser después de un año desde hoy.");
            contexto.addMessage(componente.getClientId(contexto), mensaje2);
        }
    }

    public void vHoraReserva(FacesContext contexto, UIComponent obp, Object valorf) {
        // Verificar si el valor recibido es un Date
        if (!(valorf instanceof Date)) {
            FacesMessage mensaje = new FacesMessage("El valor de horaReserva no es válido.");
            contexto.addMessage(obp.getClientId(contexto), mensaje);
            return;
        }

        Date horaReserva = (Date) valorf;

        // Crear instancias de hora permitidas
        Calendar calHoraInicio = Calendar.getInstance();
        calHoraInicio.set(Calendar.HOUR_OF_DAY, 12); // 12:00
        calHoraInicio.set(Calendar.MINUTE, 0);
        calHoraInicio.set(Calendar.SECOND, 0);

        Calendar calHoraFin = Calendar.getInstance();
        calHoraFin.set(Calendar.HOUR_OF_DAY, 23); // 23:00
        calHoraFin.set(Calendar.MINUTE, 0);
        calHoraFin.set(Calendar.SECOND, 59); // Hasta el último segundo

        Calendar calHoraReserva = Calendar.getInstance();
        calHoraReserva.setTime(horaReserva);

        // Extraer solo horas y minutos para la comparación
        int hora = calHoraReserva.get(Calendar.HOUR_OF_DAY);
        int minuto = calHoraReserva.get(Calendar.MINUTE);

        // Validar si la hora está dentro del rango permitido
        boolean fueraDeRango = (hora < 12 || hora > 23 || (hora == 23 && minuto > 0));
        UIInput componente = (UIInput) obp;

        if (fueraDeRango) {
            componente.setValid(false);
            FacesMessage mensaje = new FacesMessage("La hora de reserva debe estar entre 12:00 y 23:00.");
            contexto.addMessage(componente.getClientId(contexto), mensaje);
        }
    }

    //MÈTODOS PARA GRAFICACIÒN
    public BarChartModel getEstadoReservaChart() {
        createEstadoReservaChart();
        return estadoReservaChart;
    }
    public double promedioPersonasReservas(){
        return mDreserva.contarPromedioPersonas();
    }

    public void setEstadoReservaChart(BarChartModel estadoReservaChart) {
        this.estadoReservaChart = estadoReservaChart;
    }

    private void createEstadoReservaChart() {
        estadoReservaChart = new BarChartModel();

        // Datos de ejemplo para las reservas
        ChartSeries pendiente = new ChartSeries();
        pendiente.setLabel("Pendiente");
        pendiente.set("Pendiente", mDreserva.contarReservasPorEstado("Pendiente"));

        ChartSeries realizada = new ChartSeries();
        realizada.setLabel("Realizada");
        realizada.set("Realizada", mDreserva.contarReservasPorEstado("Realizada"));

        estadoReservaChart.addSeries(pendiente);
        estadoReservaChart.addSeries(realizada);
        estadoReservaChart.setAnimate(true);
        estadoReservaChart.setShowDatatip(true);
        estadoReservaChart.setShowPointLabels(true);
        estadoReservaChart.setTitle("Reservas por Estado");
        estadoReservaChart.setLegendPosition("e"); // Posición de la leyenda (e = este, w = oeste, n = norte, s = sur)
        estadoReservaChart.setShadow(false); // Quitar sombra (opcional)
    }
    
    public long cReservasAnioo(){
        return mDreserva.cReservasAnioo();
    }
    public long cReservasMes(){
        return mDreserva.cReservasMes();
    }

}
