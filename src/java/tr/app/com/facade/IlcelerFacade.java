/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.app.com.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.app.com.entity.Ilceler;

/**
 *
 * @author Mehmet Ali
 */
@Stateless
public class IlcelerFacade extends AbstractFacade<Ilceler> {

    @PersistenceContext(unitName = "appProjePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IlcelerFacade() {
        super(Ilceler.class);
    }

    public List<Ilceler> ilinIlceleriniGetir(Integer ilId) {
        return em.createNamedQuery("Ilceler.findByIlId").setParameter("ilId", ilId).getResultList();
    }
    
}
