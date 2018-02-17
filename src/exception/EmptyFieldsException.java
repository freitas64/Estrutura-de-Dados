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
public class EmptyFieldsException extends Exception {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Empty fields";
    }
}
