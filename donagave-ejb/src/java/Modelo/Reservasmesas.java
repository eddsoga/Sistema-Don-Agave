/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eduardo Soto
 */
@Entity
@Table(name = "reservasmesas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservasmesas.findAll", query = "SELECT r FROM Reservasmesas r"),
    @NamedQuery(name = "Reservasmesas.findByIdReserva", query = "SELECT r FROM Reservasmesas r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reservasmesas.findByFechaReserva", query = "SELECT r FROM Reservasmesas r WHERE r.fechaReserva = :fechaReserva"),
    @NamedQuery(name = "Reservasmesas.findByHoraReserva", query = "SELECT r FROM Reservasmesas r WHERE r.horaReserva = :horaReserva"),
    @NamedQuery(name = "Reservasmesas.findByNombreCliente", query = "SELECT r FROM Reservasmesas r WHERE r.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Reservasmesas.findByNumPersonas", query = "SELECT r FROM Reservasmesas r WHERE r.numPersonas = :numPersonas"),
    @NamedQuery(name = "Reservasmesas.findByLugarAsignada", query = "SELECT r FROM Reservasmesas r WHERE r.lugarAsignada = :lugarAsignada"),
    @NamedQuery(name = "Reservasmesas.findByEstadoReserva", query = "SELECT r FROM Reservasmesas r WHERE r.estadoReserva = :estadoReserva")})
public class Reservasmesas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReserva")
    private Integer idReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaReserva")
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaReserva")
    @Temporal(TemporalType.TIME)
    private Date horaReserva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreCliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numPersonas")
    private int numPersonas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lugarAsignada")
    private String lugarAsignada;
    @Size(max = 50)
    @Column(name = "estadoReserva")
    private String estadoReserva;

    public Reservasmesas() {
    }

    public Reservasmesas(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reservasmesas(Integer idReserva, Date fechaReserva, Date horaReserva, String nombreCliente, int numPersonas, String lugarAsignada) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.nombreCliente = nombreCliente;
        this.numPersonas = numPersonas;
        this.lugarAsignada = lugarAsignada;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(Date horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getLugarAsignada() {
        return lugarAsignada;
    }

    public void setLugarAsignada(String lugarAsignada) {
        this.lugarAsignada = lugarAsignada;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservasmesas)) {
            return false;
        }
        Reservasmesas other = (Reservasmesas) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Reservasmesas[ idReserva=" + idReserva + " ]";
    }
    
}
