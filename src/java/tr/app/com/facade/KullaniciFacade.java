package tr.app.com.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.app.com.entity.Kullanici;


@Stateless
public class KullaniciFacade extends AbstractFacade<Kullanici> {

    @PersistenceContext(unitName = "appProjePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KullaniciFacade() {
        super(Kullanici.class);
    }
//getSingleResult : tek kayıt döner

    public Kullanici girisKontrol(Integer sicilNo, String sifre) throws Exception {
        Kullanici kullanici = null;
        try {
            //  kullanici =  (Kullanici) em.createQuery("SELECT k FROM Kullanici k WHERE k.sicilNo = :sicilNo1 and k.sifre = :sifre1")
            //            .setParameter("sicilNo1", sicilNo).setParameter("sifre1", sifre).getSingleResult();
            kullanici = (Kullanici) em.createNamedQuery("Kullanici.girisKontrol")
                    .setParameter("sicilNo", sicilNo).setParameter("sifre", sifre).getSingleResult();
           // List<Kullanici> = em.createQuery("SELECT k FROM Kullanici k WHERE k.sicilNo >10").getResultList();
        } catch (Exception ex) {
            kullanici = null;
        }

        return kullanici;
    }

    public List<Kullanici> kullanicilariGetir() throws Exception {
        List<Kullanici> kullaniciListesi = null;
        try {
            kullaniciListesi = em.createNamedQuery("Kullanici.kullanicilariGetir").getResultList();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return kullaniciListesi;
    }

}
