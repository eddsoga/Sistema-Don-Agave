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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eduardo Soto
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Productos.findByTipoProducto", query = "SELECT p FROM Productos p WHERE p.tipoProducto = :tipoProducto"),
    @NamedQuery(name = "Productos.findByEntrada", query = "SELECT p FROM Productos p WHERE p.entrada = :entrada"),
    @NamedQuery(name = "Productos.findBySalidas", query = "SELECT p FROM Productos p WHERE p.salidas = :salidas"),
    @NamedQuery(name = "Productos.findByExistencia", query = "SELECT p FROM Productos p WHERE p.existencia = :existencia"),
    @NamedQuery(name = "Productos.findByStockIdeal", query = "SELECT p FROM Productos p WHERE p.stockIdeal = :stockIdeal"),
    @NamedQuery(name = "Productos.findByPrecioCompra", query = "SELECT p FROM Productos p WHERE p.precioCompra = :precioCompra"),
    @NamedQuery(name = "Productos.findByPrecioVenta", query = "SELECT p FROM Productos p WHERE p.precioVenta = :precioVenta")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoProducto")
    private String tipoProducto;
    @Column(name = "entrada")
    private Integer entrada;
    @Column(name = "salidas")
    private Integer salidas;
    @Column(name = "existencia")
    private Integer existencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockIdeal")
    private int stockIdeal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioCompra")
    private double precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioVenta")
    private double precioVenta;

    public Productos() {
    }

    public Productos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Productos(Integer idProducto, String nombreProducto, String tipoProducto, int stockIdeal, double precioCompra, double precioVenta) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.stockIdeal = stockIdeal;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public Integer getSalidas() {
        return salidas;
    }

    public void setSalidas(Integer salidas) {
        this.salidas = salidas;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public int getStockIdeal() {
        return stockIdeal;
    }

    public void setStockIdeal(int stockIdeal) {
        this.stockIdeal = stockIdeal;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Productos[ idProducto=" + idProducto + " ]";
    }
    
}
