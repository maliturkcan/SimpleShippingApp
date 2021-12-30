/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.app.com.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.app.com.entity.KargoTeslim;

/**
 *
 * @author Mehmet Ali
 */
@Stateless
public class KargoTeslimFacade extends AbstractFacade<KargoTeslim> {

    @PersistenceContext(unitName = "appProjePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KargoTeslimFacade() {
        super(KargoTeslim.class);
    }
    
    public KargoTeslim teslimatBilgisiGetir(String barkodNo) throws Exception{
       KargoTeslim kargoTeslim = null;
       try {
           kargoTeslim = (KargoTeslim) em.createNamedQuery("KargoTeslim.findByBarkodNo").setParameter("barkodNo", barkodNo).getSingleResult();
       }
       catch (Exception ex) {
           kargoTeslim = null;
       }
       
       return kargoTeslim ;
    }
    
}
