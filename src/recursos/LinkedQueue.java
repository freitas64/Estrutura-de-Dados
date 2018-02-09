    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

import adt.QueueADT;

/**
 *
 * @author ruifreitas
 */
public class LinkedQueue<T> implements QueueADT<T>{
    
    /**
     * 
     */
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;
 
     
    /**
     *
     */
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
 
    /**
     *
     * @param head
     * @param tail
     * @param size
     */
    public LinkedQueue(LinkedNode<T> head, LinkedNode<T> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }
 
    /**
     *
     * @return
     */
    public LinkedNode<T> getHead() {
        return head;
    }
 
    /**
     *
     * @return
     */
    public LinkedNode<T> getTail() {
        return tail;
    }
 
    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }
 
    /**
     *
     * @param head
     */
    public void setHead(LinkedNode<T> head) {
        this.head = head;
    }
 
    /**
     *
     * @param tail
     */
    public void setTail(LinkedNode<T> tail) {
        this.tail = tail;
    }
 
    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
 
       
    /**
     * 
     * @param element 
     */
    @Override
    public void enqueue(T element) {
 
        LinkedNode<T> tempNode = new LinkedNode<T>(element);
 
        if (isEmpty()) {
            setTail(tempNode);
            setHead(getTail());
            setSize(getSize() + 1);
        } else {
            getTail().setNext(tempNode);
            setTail(tempNode);
            setSize(getSize() + 1);
        }
 
    }
 
    /**
     * 
     * @return 
     */
    @Override
    public T dequeue() {
 
        LinkedNode<T> tempNode = getHead();
        setHead(getHead().getNext());
        setSize(getSize() - 1);
 
        return (T) tempNode.getElement();
    }
 
    /**
     * 
     * @return 
     */
    @Override
    public T first() {
        return (T) getTail();
    }
 
    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return (getHead() == null);
    }
 
    /**
     * 
     * @return 
     */
    @Override
    public int size() {
        return getSize();
    }
 
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        String string = "";
        LinkedNode<T> pos = getHead();
        while (pos != null) {
            string = string + pos.getElement()+ " ";
            pos = pos.getNext();
        }
        return string;
    }
    
}
