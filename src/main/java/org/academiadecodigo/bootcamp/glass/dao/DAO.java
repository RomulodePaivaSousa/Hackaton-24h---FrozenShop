package org.academiadecodigo.bootcamp.glass.dao;

import java.util.List;

import org.academiadecodigo.bootcamp.glass.model.customer.AbstractModel;
import org.springframework.ui.Model;

public interface DAO<T extends AbstractModel> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);


}
