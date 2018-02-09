/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author ruifreitas
 */
public class EmptyStackException  extends RuntimeException{

    /**
     * *****************************************************************
     * Creates the exception.
  ******************************************************************
     */
    public EmptyStackException() {
        super("The stack is empty.");
    }

    /**
     * *****************************************************************
     * Creates the exception with the specified message.
  ******************************************************************
     * @param message
     */
    public EmptyStackException(String message) {
        super(message);
    }

}
