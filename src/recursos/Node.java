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
public class Node<T>{

    private Node<T> previous;
    private T element;
    Node<T> next;

    public Node() {
        this.next = null;
        this.previous = null;
        this.element = null;
    }

    public Node(Node<T> previous, T element, Node<T> next) {
        this.next = next;
        this.previous = previous;
        this.element = element;
    }

    /**
     * @return the next
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node<T> next) {
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

    /**
     * @return the previous
     */
    public Node<T> getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
    
}
