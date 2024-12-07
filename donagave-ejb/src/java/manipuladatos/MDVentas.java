/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipuladatos;

import Modelo.Ventas;
import accesodatos.VentasFacade;
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
public class MDVentas {

    @EJB
    private VentasFacade ventasFacade;
    
    public void insertarReserva(Ventas v) {
        ventasFacade.create(v);
    }
    
    public List<Ventas> ventas(){
        return ventasFacade.findAll();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
