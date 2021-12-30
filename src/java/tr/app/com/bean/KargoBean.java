package tr.app.com.bean;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import tr.app.com.common.GenelIslemler;
import tr.app.com.entity.Ilceler;
import tr.app.com.entity.Iller;
import tr.app.com.entity.KargoKabul;
import tr.app.com.entity.KargoTeslim;
import tr.app.com.facade.KargoKabulFacade;
import tr.app.com.facade.KargoTeslimFacade;
import tr.app.com.service.KargoKabulService;
import tr.app.com.session.Util;

@Named
@ViewScoped
public class KargoBean implements Serializable {

    @EJB
    KargoKabulFacade kargoKabulFacade;

    @EJB
    KargoTeslimFacade kargoTeslimFacade;

    @EJB
    KargoKabulService kargoKabulService;

    @Getter
    @Setter
    private KargoKabul kargoKabul;

    @Getter
    @Setter
    private List<Iller> iller;
    @Getter
    @Setter
    private List<Ilceler> gondericiIlceler;
    @Getter
    @Setter
    private List<Ilceler> aliciIlceler;

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String barkodNo;

    @Getter
    @Setter
    private KargoTeslim kargoTeslim;

    public KargoBean() {
        kargoKabul = new KargoKabul();
        kargoTeslim = new KargoTeslim();
    }

    @PostConstruct
    public void init() {
        gondericiIlceler = new ArrayList<>();
        iller = kargoKabulService.illeriGetir();
        kargoKabul = new KargoKabul();
        gondericiIlceler = kargoKabulService.ilinIlceleriniGetir(1);
        aliciIlceler = kargoKabulService.ilinIlceleriniGetir(1);
    }

    public void kargoKabulEt() {
        try {
            //1 :kabul,2:sevk,3:iptal,4 teslim
            kargoKabul.setKabulTarih(new Date());
            kargoKabul.setKabulIp(InetAddress.getLocalHost().toString());
            kargoKabul.setKabulSicil(Util.getKullanici().getSicilNo());
            kargoKabul.setDurum("1");//Kabul durum 1
            kargoKabul.setAciklama("Kargo Kabul Edildi"); //Kabul Açıklama
            kargoKabulFacade.create(kargoKabul);
            System.out.println(kargoKabul);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Başarılı", "Kargo Kabul Edildi"));
    }

    public void gondericiIlceleriniGetir() {
        gondericiIlceler = kargoKabulService.ilinIlceleriniGetir(kargoKabul.getGondericiIlId());
    }

    public void aliciIlceleriniGetir() {
        aliciIlceler = kargoKabulService.ilinIlceleriniGetir(kargoKabul.getAliciIlId());
    }

    public void kargoSorgulaById() {
        kargoKabul = kargoKabulFacade.find(id);
    }

    public void barkodNumarasinaGoreKargoyuGetir() {
        try {
            kargoKabul = kargoKabulService.barkodNumarasinaGoreKargoyuGetir(barkodNo);
            if (kargoKabul != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Başarılı", "Kargo sorgulandı."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Uyarı : ", "Lütfen barkod numarasını kontrol ediniz"));
            }
            
            // durum 4 ise teslimat yapılmıştır.
            if (kargoKabul.getDurum().equals("4"))
                kargoTeslim = kargoKabulService.teslimatBilgisiGetir(barkodNo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void kargoyuIptalEt() {
        try {
            //1 :kabul,2:sevk,3:iptal,4 teslim
            kargoKabul = kargoKabulService.barkodNumarasinaGoreKargoyuGetir(barkodNo);
            kargoKabul.setDurum("3"); //Kargo Durum : 3 iptal
            kargoKabul.setAciklama("Kargo İptal Edildi");
            kargoKabulFacade.edit(kargoKabul);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Başarılı", "Kargo Iptal Edildi"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void teslimGirisiYap() {
        try {
            kargoTeslim.setTeslimTarihi(new Date());
            kargoTeslim.setBarkodNo(barkodNo);
            kargoTeslimFacade.create(kargoTeslim);
            
            //Ana kaydı da güncelleyiorum
            kargoKabul.setAciklama("Teslim edildi");
            kargoKabul.setDurum("4");
            kargoKabulFacade.edit(kargoKabul);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Başarılı", "Teslim girişi başarıyla yapıldı."));
        } catch (Exception e) {
        }
    }

}
