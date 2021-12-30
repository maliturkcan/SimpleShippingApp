
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
import lombok.Data;

@Entity
@Table(name = "kullanici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanici.girisKontrol", query = "SELECT k FROM Kullanici k WHERE k.sicilNo = :sicilNo and k.sifre = :sifre")
    , @NamedQuery(name = "Kullanici.kullanicilariGetir", query = "SELECT k FROM Kullanici k")
    , @NamedQuery(name = "Kullanici.findById", query = "SELECT k FROM Kullanici k WHERE k.id = :id")
    , @NamedQuery(name = "Kullanici.findBySicilNo", query = "SELECT k FROM Kullanici k WHERE k.sicilNo = :sicilNo")})

@Data
public class Kullanici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sicil_no")
    private Integer sicilNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "sifre")
    private String sifre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ad")
    private String ad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "soyad")
    private String soyad;

}
