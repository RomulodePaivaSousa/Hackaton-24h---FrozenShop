package org.academiadecodigo.bootcamp.glass.model.products;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Medium")
public class MediumSub extends Products {
}
