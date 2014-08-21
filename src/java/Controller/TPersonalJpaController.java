/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.PreexistingEntityException;
import Model.TPersonal;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ESTACION
 */
public class TPersonalJpaController implements Serializable {

    public TPersonalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TPersonal TPersonal) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TPersonal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTPersonal(TPersonal.getId()) != null) {
                throw new PreexistingEntityException("TPersonal " + TPersonal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TPersonal TPersonal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPersonal = em.merge(TPersonal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TPersonal.getId();
                if (findTPersonal(id) == null) {
                    throw new NonexistentEntityException("The tPersonal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPersonal TPersonal;
            try {
                TPersonal = em.getReference(TPersonal.class, id);
                TPersonal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TPersonal with id " + id + " no longer exists.", enfe);
            }
            em.remove(TPersonal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TPersonal> findTPersonalEntities() {
        return findTPersonalEntities(true, -1, -1);
    }

    public List<TPersonal> findTPersonalEntities(int maxResults, int firstResult) {
        return findTPersonalEntities(false, maxResults, firstResult);
    }

    private List<TPersonal> findTPersonalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TPersonal.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TPersonal findTPersonal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TPersonal.class, id);
        } finally {
            em.close();
        }
    }

    public int getTPersonalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TPersonal> rt = cq.from(TPersonal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
