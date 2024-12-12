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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findByIdVenta", query = "SELECT v FROM Ventas v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "Ventas.findByFechaHoraVenta", query = "SELECT v FROM Ventas v WHERE v.fechaHoraVenta = :fechaHoraVenta"),
    @NamedQuery(name = "Ventas.findByMontoTotal", query = "SELECT v FROM Ventas v WHERE v.montoTotal = :montoTotal"),
    @NamedQuery(name = "Ventas.findByFormaPago", query = "SELECT v FROM Ventas v WHERE v.formaPago = :formaPago"),
    @NamedQuery(name = "Ventas.findByGuiaParticular", query = "SELECT v FROM Ventas v WHERE v.guiaParticular = :guiaParticular"),
    @NamedQuery(name = "Ventas.findByEstadoVenta", query = "SELECT v FROM Ventas v WHERE v.estadoVenta = :estadoVenta")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVenta")
    private Integer idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraVenta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoTotal")
    private double montoTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "formaPago")
    private String formaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "guiaParticular")
    private String guiaParticular;
    @Size(max = 50)
    @Column(name = "estadoVenta")
    private String estadoVenta;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Ventas() {
    }

    public Ventas(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Ventas(Integer idVenta, Date fechaHoraVenta, double montoTotal, String formaPago, String guiaParticular) {
        this.idVenta = idVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.montoTotal = montoTotal;
        this.formaPago = formaPago;
        this.guiaParticular = guiaParticular;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(Date fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getGuiaParticular() {
        return guiaParticular;
    }

    public void setGuiaParticular(String guiaParticular) {
        this.guiaParticular = guiaParticular;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(String estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Ventas[ idVenta=" + idVenta + " ]";
    }
    
}
