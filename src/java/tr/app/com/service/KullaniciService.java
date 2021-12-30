package tr.app.com.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.app.com.entity.Kullanici;
import tr.app.com.facade.KullaniciFacade;



@Stateless
public class KullaniciService {

    @EJB
    KullaniciFacade kullaniciFacade;
    
    public Kullanici girisKontrol(Integer sicilNo, String sifre) throws Exception {
        return kullaniciFacade.girisKontrol(sicilNo,sifre);
    }

    public List<Kullanici> kullanicilariGetir() throws Exception {
        return kullaniciFacade.kullanicilariGetir() ;
    }

}
