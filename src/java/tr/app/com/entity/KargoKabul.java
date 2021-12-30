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
@Table(name = "kargo_kabul")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KargoKabul.findAll", query = "SELECT k FROM KargoKabul k")
    , @NamedQuery(name = "KargoKabul.findById", query = "SELECT k FROM KargoKabul k WHERE k.id = :id")
    , @NamedQuery(name = "KargoKabul.findByBarkodNo", query = "SELECT k FROM KargoKabul k WHERE k.barkodNo = :barkodNo")
    , @NamedQuery(name = "KargoKabul.findByGondericiAd", query = "SELECT k FROM KargoKabul k WHERE k.gondericiAd = :gondericiAd")
    , @NamedQuery(name = "KargoKabul.findByGondericiSoyad", query = "SELECT k FROM KargoKabul k WHERE k.gondericiSoyad = :gondericiSoyad")
    , @NamedQuery(name = "KargoKabul.findByGondericiIlId", query = "SELECT k FROM KargoKabul k WHERE k.gondericiIlId = :gondericiIlId")
    , @NamedQuery(name = "KargoKabul.findByGondericiIlceId", query = "SELECT k FROM KargoKabul k WHERE k.gondericiIlceId = :gondericiIlceId")
    , @NamedQuery(name = "KargoKabul.findByGondericiAdres", query = "SELECT k FROM KargoKabul k WHERE k.gondericiAdres = :gondericiAdres")
    , @NamedQuery(name = "KargoKabul.findByGondericiTcNo", query = "SELECT k FROM KargoKabul k WHERE k.gondericiTcNo = :gondericiTcNo")
    , @NamedQuery(name = "KargoKabul.findByGondericiTel", query = "SELECT k FROM KargoKabul k WHERE k.gondericiTel = :gondericiTel")
    , @NamedQuery(name = "KargoKabul.findByGondericiEposta", query = "SELECT k FROM KargoKabul k WHERE k.gondericiEposta = :gondericiEposta")
    , @NamedQuery(name = "KargoKabul.findByAliciAd", query = "SELECT k FROM KargoKabul k WHERE k.aliciAd = :aliciAd")
    , @NamedQuery(name = "KargoKabul.findByAliciSoyad", query = "SELECT k FROM KargoKabul k WHERE k.aliciSoyad = :aliciSoyad")
    , @NamedQuery(name = "KargoKabul.findByAliciIlId", query = "SELECT k FROM KargoKabul k WHERE k.aliciIlId = :aliciIlId")
    , @NamedQuery(name = "KargoKabul.findByAliciIlceId", query = "SELECT k FROM KargoKabul k WHERE k.aliciIlceId = :aliciIlceId")
    , @NamedQuery(name = "KargoKabul.findByAliciAdres", query = "SELECT k FROM KargoKabul k WHERE k.aliciAdres = :aliciAdres")
    , @NamedQuery(name = "KargoKabul.findByAliciTcNo", query = "SELECT k FROM KargoKabul k WHERE k.aliciTcNo = :aliciTcNo")
    , @NamedQuery(name = "KargoKabul.findByAliciTel", query = "SELECT k FROM KargoKabul k WHERE k.aliciTel = :aliciTel")
    , @NamedQuery(name = "KargoKabul.findByAliciEposta", query = "SELECT k FROM KargoKabul k WHERE k.aliciEposta = :aliciEposta")
    , @NamedQuery(name = "KargoKabul.findByKabulSicil", query = "SELECT k FROM KargoKabul k WHERE k.kabulSicil = :kabulSicil")
    , @NamedQuery(name = "KargoKabul.findByKabulIp", query = "SELECT k FROM KargoKabul k WHERE k.kabulIp = :kabulIp")
    , @NamedQuery(name = "KargoKabul.findByKabulTarih", query = "SELECT k FROM KargoKabul k WHERE k.kabulTarih = :kabulTarih")
    , @NamedQuery(name = "KargoKabul.findByDurum", query = "SELECT k FROM KargoKabul k WHERE k.durum = :durum")
    , @NamedQuery(name = "KargoKabul.findByAciklama", query = "SELECT k FROM KargoKabul k WHERE k.aciklama = :aciklama")
    , @NamedQuery(name = "KargoKabul.findByRezerve3", query = "SELECT k FROM KargoKabul k WHERE k.rezerve3 = :rezerve3")})
public class KargoKabul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "barkod_no")
    private String barkodNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "gonderici_ad")
    private String gondericiAd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "gonderici_soyad")
    private String gondericiSoyad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gonderici_il_id")
    private int gondericiIlId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gonderici_ilce_id")
    private int gondericiIlceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "gonderici_adres")
    private String gondericiAdres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gonderici_tc_no")
    private Long gondericiTcNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "gonderici_tel")
    private String gondericiTel;
    @Size(max = 45)
    @Column(name = "gonderici_eposta")
    private String gondericiEposta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "alici_ad")
    private String aliciAd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "alici_soyad")
    private String aliciSoyad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alici_il_id")
    private int aliciIlId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alici_ilce_id")
    private int aliciIlceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "alici_adres")
    private String aliciAdres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alici_tc_no")
    private Long aliciTcNo;
    @Size(max = 16)
    @Column(name = "alici_tel")
    private String aliciTel;
    @Size(max = 45)
    @Column(name = "alici_eposta")
    private String aliciEposta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kabul_sicil")
    private int kabulSicil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "kabul_ip")
    private String kabulIp;
    @Column(name = "kabul_tarih")
    @Temporal(TemporalType.DATE)
    private Date kabulTarih;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "durum")
    private String durum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "aciklama")
    private String aciklama;
    @Size(max = 50)
    @Column(name = "rezerve3")
    private String rezerve3;

    public KargoKabul() {
    }

    public KargoKabul(Integer id) {
        this.id = id;
    }

    public KargoKabul(Integer id, String barkodNo, String gondericiAd, String gondericiSoyad, int gondericiIlId, int gondericiIlceId, String gondericiAdres, Long gondericiTcNo, String gondericiTel, String aliciAd, String aliciSoyad, int aliciIlId, int aliciIlceId, String aliciAdres, Long aliciTcNo, int kabulSicil, String kabulIp, String durum, String aciklama) {
        this.id = id;
        this.barkodNo = barkodNo;
        this.gondericiAd = gondericiAd;
        this.gondericiSoyad = gondericiSoyad;
        this.gondericiIlId = gondericiIlId;
        this.gondericiIlceId = gondericiIlceId;
        this.gondericiAdres = gondericiAdres;
        this.gondericiTcNo = gondericiTcNo;
        this.gondericiTel = gondericiTel;
        this.aliciAd = aliciAd;
        this.aliciSoyad = aliciSoyad;
        this.aliciIlId = aliciIlId;
        this.aliciIlceId = aliciIlceId;
        this.aliciAdres = aliciAdres;
        this.aliciTcNo = aliciTcNo;
        this.kabulSicil = kabulSicil;
        this.kabulIp = kabulIp;
        this.durum = durum;
        this.aciklama = aciklama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarkodNo() {
        return barkodNo;
    }

    public void setBarkodNo(String barkodNo) {
        this.barkodNo = barkodNo;
    }

    public String getGondericiAd() {
        return gondericiAd;
    }

    public void setGondericiAd(String gondericiAd) {
        this.gondericiAd = gondericiAd;
    }

    public String getGondericiSoyad() {
        return gondericiSoyad;
    }

    public void setGondericiSoyad(String gondericiSoyad) {
        this.gondericiSoyad = gondericiSoyad;
    }

    public int getGondericiIlId() {
        return gondericiIlId;
    }

    public void setGondericiIlId(int gondericiIlId) {
        this.gondericiIlId = gondericiIlId;
    }

    public int getGondericiIlceId() {
        return gondericiIlceId;
    }

    public void setGondericiIlceId(int gondericiIlceId) {
        this.gondericiIlceId = gondericiIlceId;
    }

    public String getGondericiAdres() {
        return gondericiAdres;
    }

    public void setGondericiAdres(String gondericiAdres) {
        this.gondericiAdres = gondericiAdres;
    }

    public Long getGondericiTcNo() {
        return gondericiTcNo;
    }

    public void setGondericiTcNo(Long gondericiTcNo) {
        this.gondericiTcNo = gondericiTcNo;
    }

    public String getGondericiTel() {
        return gondericiTel;
    }

    public void setGondericiTel(String gondericiTel) {
        this.gondericiTel = gondericiTel;
    }

    public String getGondericiEposta() {
        return gondericiEposta;
    }

    public void setGondericiEposta(String gondericiEposta) {
        this.gondericiEposta = gondericiEposta;
    }

    public String getAliciAd() {
        return aliciAd;
    }

    public void setAliciAd(String aliciAd) {
        this.aliciAd = aliciAd;
    }

    public String getAliciSoyad() {
        return aliciSoyad;
    }

    public void setAliciSoyad(String aliciSoyad) {
        this.aliciSoyad = aliciSoyad;
    }

    public int getAliciIlId() {
        return aliciIlId;
    }

    public void setAliciIlId(int aliciIlId) {
        this.aliciIlId = aliciIlId;
    }

    public int getAliciIlceId() {
        return aliciIlceId;
    }

    public void setAliciIlceId(int aliciIlceId) {
        this.aliciIlceId = aliciIlceId;
    }

    public String getAliciAdres() {
        return aliciAdres;
    }

    public void setAliciAdres(String aliciAdres) {
        this.aliciAdres = aliciAdres;
    }

    public Long getAliciTcNo() {
        return aliciTcNo;
    }

    public void setAliciTcNo(Long aliciTcNo) {
        this.aliciTcNo = aliciTcNo;
    }

    public String getAliciTel() {
        return aliciTel;
    }

    public void setAliciTel(String aliciTel) {
        this.aliciTel = aliciTel;
    }

    public String getAliciEposta() {
        return aliciEposta;
    }

    public void setAliciEposta(String aliciEposta) {
        this.aliciEposta = aliciEposta;
    }

    public int getKabulSicil() {
        return kabulSicil;
    }

    public void setKabulSicil(int kabulSicil) {
        this.kabulSicil = kabulSicil;
    }

    public String getKabulIp() {
        return kabulIp;
    }

    public void setKabulIp(String kabulIp) {
        this.kabulIp = kabulIp;
    }

    public Date getKabulTarih() {
        return kabulTarih;
    }

    public void setKabulTarih(Date kabulTarih) {
        this.kabulTarih = kabulTarih;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getRezerve3() {
        return rezerve3;
    }

    public void setRezerve3(String rezerve3) {
        this.rezerve3 = rezerve3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof KargoKabul)) {
            return false;
        }
        KargoKabul other = (KargoKabul) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.app.com.entity.KargoKabul[ id=" + id + " ]";
    }
    
}
