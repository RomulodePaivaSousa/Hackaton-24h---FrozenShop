package org.academiadecodigo.bootcamp.glass.DAO;

import java.util.List;
import org.springframework.ui.Model;

public interface DAO<T extends Model> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);


}
