/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.app.com.entity;

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
 * @author Mehmet Ali
 */
@Entity
@Table(name = "iller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iller.findAll", query = "SELECT il FROM Iller il")
    , @NamedQuery(name = "Iller.findById", query = "SELECT il FROM Iller il WHERE il.id = :id")
    , @NamedQuery(name = "Iller.findByIlId", query = "SELECT il FROM Iller il WHERE il.ilId = :ilId")
    , @NamedQuery(name = "Iller.findByIlAdi", query = "SELECT il FROM Iller il WHERE il.ilAdi = :ilAdi")
    , @NamedQuery(name = "Iller.findByDurum", query = "SELECT il FROM Iller il WHERE il.durum = :durum")})
public class Iller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "il_id")
    private int ilId;
    @Size(max = 40)
    @Column(name = "il_adi")
    private String ilAdi;
    @Column(name = "durum")
    private Integer durum;

    public Iller() {
    }

    public Iller(Integer id) {
        this.id = id;
    }

    public Iller(Integer id, int ilId) {
        this.id = id;
        this.ilId = ilId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIlId() {
        return ilId;
    }

    public void setIlId(int ilId) {
        this.ilId = ilId;
    }

    public String getIlAdi() {
        return ilAdi;
    }

    public void setIlAdi(String ilAdi) {
        this.ilAdi = ilAdi;
    }

    public Integer getDurum() {
        return durum;
    }

    public void setDurum(Integer durum) {
        this.durum = durum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Iller)) {
            return false;
        }
        Iller other = (Iller) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.app.com.entity.Iller[ id=" + id + " ]";
    }
    
}
