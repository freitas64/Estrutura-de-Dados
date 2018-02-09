/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

/**
 *
 * @author ruifreitas
 * @param <T>
 */
public class LinkedNode<T> {
    
     private LinkedNode<T> next;
    private T element;
 
    /**
     * Creates an empty node
     */
    public LinkedNode() {
        next = null;
        element = null;
    }
 
    /**
     * Creates a node storing the specified element
     *
     * @param elem
     */
    public LinkedNode(T elem) {
        next = null;
        element = elem;
    }
 
    /**
     * Returns the node that follows this one
     *
     * @return next
     */
    public LinkedNode<T> getNext() {
        return next;
    }
 
    /**
     * Sets the node that follows this one
     *
     * @param node
     */
    public void setNext(LinkedNode<T> node) {
        next = node;
    }
 
    /**
     * Returns the element stored in this node
     *
     * @return element
     */
    public T getElement() {
        return element;
    }
 
    /**
     * Sets the element stored in this node
     *
     * @param elem
     */
    public void setElement(T elem) {
        element = elem;
    }
   
 
    
}
