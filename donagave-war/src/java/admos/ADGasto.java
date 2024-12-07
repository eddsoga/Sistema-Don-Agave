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
        if (gasto.getFecha() == null || gasto.getDescripcion()== null || gasto.getProveedor()== null || gasto.getMontoTotal()== 0.0) {
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
    

}
