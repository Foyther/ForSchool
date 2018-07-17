/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfu.project.service.exception;

public class InvalidFormException extends Exception {

    public InvalidFormException() {
    }

    public InvalidFormException(String message) {
        super(message);
    }

    public InvalidFormException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFormException(Throwable cause) {
        super(cause);
    }
    
    
    
}
