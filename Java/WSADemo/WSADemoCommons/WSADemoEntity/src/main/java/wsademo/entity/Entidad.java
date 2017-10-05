/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "unico_entidad_prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT u FROM Entidad u")
    , @NamedQuery(name = "Entidad.findById", query = "SELECT u FROM Entidad u WHERE u.id = :id")
    , @NamedQuery(name = "Entidad.findByRazonSocial", query = "SELECT u FROM Entidad u WHERE u.razonSocial = :razonSocial")
    , @NamedQuery(name = "Entidad.findByAbreviatura", query = "SELECT u FROM Entidad u WHERE u.abreviatura = :abreviatura")
    , @NamedQuery(name = "Entidad.findByEliminada", query = "SELECT u FROM Entidad u WHERE u.eliminada = :eliminada")})
public class Entidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntidad")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "razonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abreviatura")
    private Character abreviatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esEliminado")
    private boolean eliminada;

    public Entidad() {
    }

    public Entidad(Integer id) {
        this.id = id;
    }

    public Entidad(Integer id, String razonSocial, Character abreviatura, boolean eliminada) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.abreviatura = abreviatura;
        this.eliminada = eliminada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Character getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(Character abreviatura) {
        this.abreviatura = abreviatura;
    }

    public boolean getEsEliminado() {
        return eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }
}