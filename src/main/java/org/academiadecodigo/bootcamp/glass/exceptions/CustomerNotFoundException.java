package org.academiadecodigo.bootcamp.glass.exceptions;


import org.academiadecodigo.bootcamp.glass.errors.ErrorMessage;

/**
 * Thrown to indicate that the customer was not found
 */
public class CustomerNotFoundException extends FrozenShopException {

    /**
     * @see FrozenShopException#FrozenShopException(String)
     */
    public CustomerNotFoundException() {
        super(ErrorMessage.CUSTOMER_NOT_FOUND);
    }
}
