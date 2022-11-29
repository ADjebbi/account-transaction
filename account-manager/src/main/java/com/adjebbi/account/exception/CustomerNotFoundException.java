package com.adjebbi.account.exception;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
