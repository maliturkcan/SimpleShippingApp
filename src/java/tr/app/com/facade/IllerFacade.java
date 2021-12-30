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
import tr.app.com.entity.Iller;

/**
 *
 * @author Mehmet Ali
 */
@Stateless
public class IllerFacade extends AbstractFacade<Iller> {

    @PersistenceContext(unitName = "appProjePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IllerFacade() {
        super(Iller.class);
    }

    public List<Iller> illeriGetir() {
       return em.createNamedQuery("Iller.findAll").getResultList();
    }

}
