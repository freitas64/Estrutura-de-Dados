/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adt;


import exception.ElementNotFoundException;

/**
 *
 * @author ruifreitas
 * @param <T>
 */
public interface UnorderedListADT<T> extends ListADT<T>{
    
    /**
     * Adiciona no inicio
     * @param element 
     */
    public void addToFront(T element);
    /**
     * Adiciona ao fim
     * @param element 
     */
    public void addToRear(T element);
    /**
     * Adiciona a seguir a um elemento
     * @param element
     * @param target 
     * @throws exception.ElementNotFoundException 
     */
    public void addToAfter(T element, T target) throws ElementNotFoundException ;
    
    
    
}
