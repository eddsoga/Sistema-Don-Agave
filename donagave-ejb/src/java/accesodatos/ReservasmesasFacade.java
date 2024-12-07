/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import Modelo.Reservasmesas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eduardo Soto
 */
@Stateless
public class ReservasmesasFacade extends AbstractFacade<Reservasmesas> {

    @PersistenceContext(unitName = "donagave-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservasmesasFacade() {
        super(Reservasmesas.class);
    }
    
}
