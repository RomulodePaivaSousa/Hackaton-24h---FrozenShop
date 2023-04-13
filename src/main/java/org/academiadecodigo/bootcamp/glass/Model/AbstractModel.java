package org.academiadecodigo.bootcamp.glass.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public abstract class AbstractModel implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {

    }
}
