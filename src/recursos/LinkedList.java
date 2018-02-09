/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.util.Iterator;
import exception.*;
/**
 *
 * @author ruifreitas
 */
public class LinkedList<T> implements Iterable<T>{
    
    private Element head;

    public Element getHead() {
        return head;
    }

    public void setHead(Element head) {
        this.head = head;
    }
    
    public void addElemento(T newElemento) {
        if (head == null) {
            head = new Element(newElemento);
        } else {
            Element x = head;
            while (x.next != null) {
                x = x.next;
            }
            Element y = new Element(newElemento);
            x.next = y;
        }
    }
    
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        T elementToReturn;
        if (head.getValor() == element) {
            elementToReturn = (T) head.getValor();
            head = head.next;
            
        } else {
            while (head.next.getValor() != element) {
                head = head.next;
            }
            elementToReturn = (T) head.getValor();
            head.next = head.next.next;
        }
        return elementToReturn;
    }

    public void Print() {
        Element x = head;
        while (x != null) {
            System.out.println(x.getValor());
            x = x.next;
        }
    }
    public String toStringR(Element e){
        if(e == null){
            return ".";
        }else{
            return e.getValor() + " " + toStringR(e.getNext()); 
        }
    }
    public String toStringR(){
        String str = toStringR(head);
        return str;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<>();
    }
    
    public class BasicIterator<T> implements Iterator<T>{

        @Override
        public boolean hasNext() {
            if(head != null)
                return true;
            return false;
        }

        @Override
        public T next() {
            Object retorno = head.getValor();
            head = head.getNext();
            return (T) retorno;
        }
        
    
}

    @Override
    public String toString() {
        return "LinkedList{" + "head=" + head.getValor() + iterator().next().toString()+'}';
    }
    
}
