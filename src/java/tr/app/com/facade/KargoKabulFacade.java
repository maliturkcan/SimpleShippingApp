/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.app.com.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.app.com.entity.KargoKabul;

/**
 *
 * @author Mehmet Ali
 */
@Stateless
public class KargoKabulFacade extends AbstractFacade<KargoKabul> {

    @PersistenceContext(unitName = "appProjePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KargoKabulFacade() {
        super(KargoKabul.class);
    }

    public KargoKabul barkodNumarasinaGoreKargoyuGetir(String barkodNo) throws Exception{
       KargoKabul kargoKabul = null;
       try {
           kargoKabul = (KargoKabul) em.createNamedQuery("KargoKabul.findByBarkodNo").setParameter("barkodNo", barkodNo).getSingleResult();
       }
       catch (Exception ex) {
           kargoKabul = null;
       }
       
       return kargoKabul ;
    }
    
}
