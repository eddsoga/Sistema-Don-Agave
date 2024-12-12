/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eduardo Soto
 */
@Entity
@Table(name = "productosventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productosventa.findAll", query = "SELECT p FROM Productosventa p"),
    @NamedQuery(name = "Productosventa.findByIdproductosVenta", query = "SELECT p FROM Productosventa p WHERE p.idproductosVenta = :idproductosVenta"),
    @NamedQuery(name = "Productosventa.findByIdVenta", query = "SELECT p FROM Productosventa p WHERE p.idVenta = :idVenta"),
    @NamedQuery(name = "Productosventa.findByCantidad", query = "SELECT p FROM Productosventa p WHERE p.cantidad = :cantidad")})
public class Productosventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproductosVenta")
    private Integer idproductosVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Productos idProducto;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    @ManyToOne(optional = false)
    private Ventas idVenta;

    public Productosventa() {
    }

    public Productosventa(Integer idproductosVenta) {
        this.idproductosVenta = idproductosVenta;
    }

    public Productosventa(Integer idproductosVenta, int cantidad) {
        this.idproductosVenta = idproductosVenta;
        this.cantidad = cantidad;
    }

    public Integer getIdproductosVenta() {
        return idproductosVenta;
    }

    public void setIdproductosVenta(Integer idproductosVenta) {
        this.idproductosVenta = idproductosVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public Ventas getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Ventas idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductosVenta != null ? idproductosVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productosventa)) {
            return false;
        }
        Productosventa other = (Productosventa) object;
        if ((this.idproductosVenta == null && other.idproductosVenta != null) || (this.idproductosVenta != null && !this.idproductosVenta.equals(other.idproductosVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Productosventa[ idproductosVenta=" + idproductosVenta + " ]";
    }
    
}
