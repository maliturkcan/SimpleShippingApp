package tr.app.com.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import tr.app.com.entity.Kullanici;
import tr.app.com.facade.KullaniciFacade;
import tr.app.com.service.KullaniciService;
import tr.app.com.session.Util;

@Named(value = "kullaniciBean")
@ViewScoped
public class KullaniciBean implements Serializable {

    @Getter
    @Setter
    private List<Kullanici> kullaniciListesi;

    @Getter
    @Setter
    private boolean kullaniciSecildiMi;

    @Getter
    @Setter
    private Kullanici kullanici;
    
    @Getter
    @Setter
    private Kullanici girisYapanKullanici;

    @Getter
    @Setter
    private Integer sicilNo;

    @EJB
    KullaniciFacade kullaniciFacade;

    @EJB
    private KullaniciService kullaniciService;

    public KullaniciBean() {
        kullaniciSecildiMi = false;
        kullanici = new Kullanici();
    }

    @PostConstruct
    public void init() {
        kullanicilariGetir();
        girisYapanKullanici = Util.getKullanici();
    }

    public void kullanicilariGetir() {
        try {
            kullaniciListesi = kullaniciService.kullanicilariGetir();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void kullaniciyiKaydet() {
        kullaniciFacade.create(kullanici);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Başarılı", "Kullanıcı Başarıyla oluşturuldu"));
    }

    public void kullaniciyiSil(Kullanici silinecekKullanici) {
        kullaniciFacade.remove(silinecekKullanici);
        kullaniciListesi.remove(silinecekKullanici);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Başarılı :", "Kullanıcı Başarıyla silindi"));
   
    }

    public void kullaniciyiGetir() {
        kullanici = kullaniciFacade.find(sicilNo);
    }

    public void kullaniciGuncelle() {
        kullaniciFacade.edit(kullanici);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Başarılı :", "Kullanıcı Başarıyla güncellendi."));
    }

    public void kullaniSec(Kullanici kullanici) {
        this.kullanici = kullanici;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bilgi :", "Güncellenecek Kullanıcı bilgileri aşağıdadır"));
        kullaniciSecildiMi = true;
    }

}
