package tr.app.com.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.app.com.entity.Ilceler;
import tr.app.com.entity.Iller;
import tr.app.com.entity.KargoKabul;
import tr.app.com.entity.KargoTeslim;
import tr.app.com.facade.IlcelerFacade;
import tr.app.com.facade.IllerFacade;
import tr.app.com.facade.KargoKabulFacade;
import tr.app.com.facade.KargoTeslimFacade;

@Stateless
public class KargoKabulService {

    @EJB
    KargoKabulFacade kargoKabulFacade;

    @EJB
    KargoTeslimFacade kargoTeslimFacade;

    @EJB
    IllerFacade illerFacade;

    @EJB
    IlcelerFacade ilcelerFacade;

    public KargoKabul barkodNumarasinaGoreKargoyuGetir(String barkodNo) throws Exception {
        return kargoKabulFacade.barkodNumarasinaGoreKargoyuGetir(barkodNo);
    }

    public List<Iller> illeriGetir() {
        return illerFacade.illeriGetir();
    }

    public List<Ilceler> ilinIlceleriniGetir(Integer ilId) {
        return ilcelerFacade.ilinIlceleriniGetir(ilId);
    }

    public KargoTeslim teslimatBilgisiGetir(String barkodNo) throws Exception {
        return kargoTeslimFacade.teslimatBilgisiGetir(barkodNo);
    }

}
