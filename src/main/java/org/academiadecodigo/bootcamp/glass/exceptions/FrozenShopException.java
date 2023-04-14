package org.academiadecodigo.bootcamp.glass.exceptions;

/**
 * A generic java bank exception to be used as base for concrete types of exceptions
 *
 * @see Exception
 */
public class FrozenShopException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public FrozenShopException(String message) {
        super(message);
    }
}
