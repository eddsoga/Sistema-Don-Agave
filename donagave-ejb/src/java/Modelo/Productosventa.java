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
    @NamedQuery(name = "Productosventa.findByCantidad", query = "SELECT p FROM Productosventa p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Productosventa.findByPrecioIndividual", query = "SELECT p FROM Productosventa p WHERE p.precioIndividual = :precioIndividual"),
    @NamedQuery(name = "Productosventa.findByTotalProducto", query = "SELECT p FROM Productosventa p WHERE p.totalProducto = :totalProducto")})
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioIndividual")
    private float precioIndividual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalProducto")
    private float totalProducto;
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

    public Productosventa(Integer idproductosVenta, int cantidad, float precioIndividual, float totalProducto) {
        this.idproductosVenta = idproductosVenta;
        this.cantidad = cantidad;
        this.precioIndividual = precioIndividual;
        this.totalProducto = totalProducto;
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

    public float getPrecioIndividual() {
        return precioIndividual;
    }

    public void setPrecioIndividual(float precioIndividual) {
        this.precioIndividual = precioIndividual;
    }

    public float getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(float totalProducto) {
        this.totalProducto = totalProducto;
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
