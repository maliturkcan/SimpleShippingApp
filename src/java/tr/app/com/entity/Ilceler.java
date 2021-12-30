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
@Table(name = "ilceler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ilceler.findAll", query = "SELECT ilce FROM Ilceler ilce")
    , @NamedQuery(name = "Ilceler.findById", query = "SELECT ilce FROM Ilceler ilce WHERE ilce.id = :id")
    , @NamedQuery(name = "Ilceler.findByIlId", query = "SELECT ilce FROM Ilceler ilce WHERE ilce.ilId = :ilId")
    , @NamedQuery(name = "Ilceler.findByIlAdi", query = "SELECT ilce FROM Ilceler ilce WHERE ilce.ilAdi = :ilAdi")
    , @NamedQuery(name = "Ilceler.findByIlceId", query = "SELECT ilce FROM Ilceler ilce WHERE ilce.ilceId = :ilceId")
    , @NamedQuery(name = "Ilceler.findByIlceAdi", query = "SELECT ilce FROM Ilceler ilce WHERE ilce.ilceAdi = :ilceAdi")
    , @NamedQuery(name = "Ilceler.findByDurum", query = "SELECT ilce FROM Ilceler ilce WHERE ilce.durum = :durum")})
public class Ilceler implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "il_adi")
    private String ilAdi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ilce_id")
    private int ilceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ilce_adi")
    private String ilceAdi;
    @Column(name = "durum")
    private Integer durum;

    public Ilceler() {
    }

    public Ilceler(Integer id) {
        this.id = id;
    }

    public Ilceler(Integer id, int ilId, String ilAdi, int ilceId, String ilceAdi) {
        this.id = id;
        this.ilId = ilId;
        this.ilAdi = ilAdi;
        this.ilceId = ilceId;
        this.ilceAdi = ilceAdi;
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

    public int getIlceId() {
        return ilceId;
    }

    public void setIlceId(int ilceId) {
        this.ilceId = ilceId;
    }

    public String getIlceAdi() {
        return ilceAdi;
    }

    public void setIlceAdi(String ilceAdi) {
        this.ilceAdi = ilceAdi;
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
        if (!(object instanceof Ilceler)) {
            return false;
        }
        Ilceler other = (Ilceler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.app.com.entity.Ilceler[ id=" + id + " ]";
    }
    
}
