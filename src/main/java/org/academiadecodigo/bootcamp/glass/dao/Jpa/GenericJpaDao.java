package org.academiadecodigo.bootcamp.glass.dao.Jpa;


import org.academiadecodigo.bootcamp.glass.dao.DAO;

import org.academiadecodigo.bootcamp.glass.model.customer.AbstractModel;
import org.springframework.ui.Model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class GenericJpaDao<T extends AbstractModel> implements DAO<T> {

    protected Class<T> modelType;

    protected EntityManager em;

    public GenericJpaDao(Class<T> modelType) {
        this.modelType = modelType;
    }


    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<T> findAll() {
        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);

        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T findById(Integer id) {
        return em.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(modelType, id));
    }

    public T findByEmail(String email) {
        TypedQuery<T> query = (TypedQuery<T>) em.createQuery(
                "SELECT c FROM Customer c WHERE c.email = :custEmail");
        query.setParameter("custEmail", email);
        return query.getSingleResult();
    }
}
