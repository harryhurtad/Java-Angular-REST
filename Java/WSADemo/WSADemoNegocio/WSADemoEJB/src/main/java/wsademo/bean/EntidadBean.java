/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.bean;

import java.util.List;
import wsademo.remote.EntidadBeanRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
//import javax.persistence.PersistenceUnit;
import wsademo.entity.Entidad;

/**
 *
 * @author fernando
 */
@Stateless(mappedName = "EntidadBean", name = "EntidadBean")
public class EntidadBean implements EntidadBeanRemote {

//    @PersistenceUnit(name = "WSADemoPersistence")
    @PersistenceContext(name = "WSADemoPersistence")
    private EntityManager em;

    @Override
    public List<Entidad> find() {
        TypedQuery<Entidad> typedQuery = em.createNamedQuery("Entidad.findAll", Entidad.class);
        return typedQuery.getResultList();
    }

    @Override
    public Entidad find(Integer id) {
        TypedQuery<Entidad> typedQuery = em.createNamedQuery("Entidad.findById", Entidad.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }
}
