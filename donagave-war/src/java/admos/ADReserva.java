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
import java.util.List;

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
    
    public ADReserva() {
        reserva = new Reservasmesas();
    }
    
    public void registroReserva() {
        if (reserva.getFechaReserva()== null || reserva.getNombreCliente()== null || reserva.getNumPersonas()== 0 || reserva.getEstadoReserva()== null) {
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
    
    public List<Reservasmesas> getReservas(){
        return mDreserva.reservas();
    }
}
