/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.app.com.entity;

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
 * @author Mehmet Ali
 */
@Entity
@Table(name = "kargo_teslim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KargoTeslim.findAll", query = "SELECT k FROM KargoTeslim k")
    , @NamedQuery(name = "KargoTeslim.findById", query = "SELECT k FROM KargoTeslim k WHERE k.id = :id")
    , @NamedQuery(name = "KargoTeslim.findByTeslimAlan", query = "SELECT k FROM KargoTeslim k WHERE k.teslimAlan = :teslimAlan")
    , @NamedQuery(name = "KargoTeslim.findByTeslimTarihi", query = "SELECT k FROM KargoTeslim k WHERE k.teslimTarihi = :teslimTarihi")
    , @NamedQuery(name = "KargoTeslim.findByAciklama", query = "SELECT k FROM KargoTeslim k WHERE k.aciklama = :aciklama")
    , @NamedQuery(name = "KargoTeslim.findByBarkodNo", query = "SELECT k FROM KargoTeslim k WHERE k.barkodNo = :barkodNo")})
public class KargoTeslim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "teslim_alan")
    private String teslimAlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teslim_tarihi")
    @Temporal(TemporalType.DATE)
    private Date teslimTarihi;
    @Size(max = 100)
    @Column(name = "aciklama")
    private String aciklama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "barkod_no")
    private String barkodNo;

    public KargoTeslim() {
    }

    public KargoTeslim(Integer id) {
        this.id = id;
    }

    public KargoTeslim(Integer id, String teslimAlan, Date teslimTarihi, String barkodNo) {
        this.id = id;
        this.teslimAlan = teslimAlan;
        this.teslimTarihi = teslimTarihi;
        this.barkodNo = barkodNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeslimAlan() {
        return teslimAlan;
    }

    public void setTeslimAlan(String teslimAlan) {
        this.teslimAlan = teslimAlan;
    }

    public Date getTeslimTarihi() {
        return teslimTarihi;
    }

    public void setTeslimTarihi(Date teslimTarihi) {
        this.teslimTarihi = teslimTarihi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getBarkodNo() {
        return barkodNo;
    }

    public void setBarkodNo(String barkodNo) {
        this.barkodNo = barkodNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof KargoTeslim)) {
            return false;
        }
        KargoTeslim other = (KargoTeslim) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.app.com.entity.KargoTeslim[ id=" + id + " ]";
    }
    
}
