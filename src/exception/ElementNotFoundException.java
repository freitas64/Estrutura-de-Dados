/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author tony
 */
public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(String arrayList) {
         super ("The target element is not in this " + arrayList);
    }
    
}
