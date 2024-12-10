/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipuladatos;

import Modelo.Reservasmesas;
import accesodatos.ReservasmesasFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Eduardo Soto
 */
@Stateless
@LocalBean
public class MDReservas {
    @EJB
    private ReservasmesasFacade reservaFacade;
    public void insertarReserva(Reservasmesas p) {
        reservaFacade.create(p);
    }
    
    public List<Reservasmesas> reservas(){
        return reservaFacade.findAll();
    }
    // Método para contar reservas por estado en tu EJB (MDReservas)
    public int contarReservasPorEstado(String estado) {
        return reservaFacade.contarPorEstado(estado);  // Asegúrate de tener este método en tu EJB
    }
    public double contarPromedioPersonas(){
        return reservaFacade.promedioNumPersonas();
    }
    
    public long cReservasAnioo(){
        return reservaFacade.contarReservasEsteAnio();
    }
    public long cReservasMes(){
        return reservaFacade.contarReservasEsteMes();
    }
            
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
