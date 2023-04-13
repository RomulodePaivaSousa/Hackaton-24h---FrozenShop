package org.academiadecodigo.bootcamp.glass.DAO.Jpa;


import org.academiadecodigo.bootcamp.glass.DAO.DAO;

import org.springframework.ui.Model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GenericJpaDao<T extends Model> implements DAO<T> {

    protected Class<T> modelType;
    @PersistenceContext
    protected EntityManager em;

    public GenericJpaDao(Class<T> modelType) {
        this.modelType = modelType;
    }

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
        return em.find(modelType,id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {
em.remove(em.find(modelType,id));
    }
}
