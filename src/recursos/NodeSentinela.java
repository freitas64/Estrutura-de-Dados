/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

/**
 *
 * @author ruifreitas
 */
public class NodeSentinela<T> {
 
     
    private NodeSentinela<T> next;
    private T element;
 
    public NodeSentinela() {
        
        next = null;
        element = null;
    }
 
    public NodeSentinela( T element) {
        
        this.next = null;
        this.element = element;
    }
 
 
 
 
 
   
 
    /**
     * @return the next
     */
    public NodeSentinela<T> getNext() {
        return next;
    }
 
    /**
     * @param next the next to set
     */
    public void setNext(NodeSentinela<T> next) {
        this.next = next;
    }
 
    /**
     * @return the element
     */
    public T getElement() {
        return element;
    }
 
    /**
     * @param element the element to set
     */
    public void setElement(T element) {
        this.element = element;
    }
}
