/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import Modelo.Reservasmesas;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.persistence.TypedQuery;

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

    public int contarPorEstado(String estado) {
        // Consulta JPQL para contar las reservas por estado
        String jpql = "SELECT COUNT(r) FROM Reservasmesas r WHERE r.estadoReserva = :estado";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("estado", estado);
        Long result = query.getSingleResult();
        return result != null ? result.intValue() : 0; // Retorna el valor como int
    }

    public double promedioNumPersonas() {
        // Consulta JPQL para obtener la suma total de personas y el total de reservas
        String jpql = "SELECT AVG(r.numPersonas) FROM Reservasmesas r";
        TypedQuery<Double> query = em.createQuery(jpql, Double.class);

        Double result = query.getSingleResult();
        return result != null ? result : 0.0; // Retorna el promedio de personas, o 0 si no hay reservas
    }


    public long contarReservasEsteMes() {
    Calendar cal = Calendar.getInstance();
    int anio = cal.get(Calendar.YEAR);
    int mes = cal.get(Calendar.MONTH);  // El mes en Calendar es 0-11, por eso no necesitas sumarle 1

    // Obtener el primer día y último día del mes
    cal.set(Calendar.DAY_OF_MONTH, 1);
    Date primerDiaDelMes = cal.getTime();
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    Date ultimoDiaDelMes = cal.getTime();

    String jpql = "SELECT COUNT(r) FROM Reservasmesas r WHERE r.fechaReserva BETWEEN :inicio AND :fin";
    Query query = em.createQuery(jpql);
    query.setParameter("inicio", primerDiaDelMes);
    query.setParameter("fin", ultimoDiaDelMes);

    return (Long) query.getSingleResult();
}


public long contarReservasEsteAnio() {
    Calendar cal = Calendar.getInstance();
    int anio = cal.get(Calendar.YEAR);

    // Obtener el primer día del año
    cal.set(Calendar.MONTH, Calendar.JANUARY);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    Date primerDiaDelAnio = cal.getTime();

    // Obtener el último día del año
    cal.set(Calendar.MONTH, Calendar.DECEMBER);
    cal.set(Calendar.DAY_OF_MONTH, 31);
    Date ultimoDiaDelAnio = cal.getTime();

    String jpql = "SELECT COUNT(r) FROM Reservasmesas r WHERE r.fechaReserva BETWEEN :inicio AND :fin";
    Query query = em.createQuery(jpql);
    query.setParameter("inicio", primerDiaDelAnio);
    query.setParameter("fin", ultimoDiaDelAnio);

    return (Long) query.getSingleResult();
}

}
