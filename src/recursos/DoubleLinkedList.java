/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import exception.ElementNotFoundException;
import adt.ListADT;
import exception.EmptyCollectionException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tony
 */
public class DoubleLinkedList<T> implements ListADT<T> {

    protected DoubleNode front;
    protected DoubleNode back;
    protected int count;

    public DoubleLinkedList() {
        front = null;
        back = null;
    }

    //  Returns a reference to the first element on this list
    @Override
    public T first() throws EmptyCollectionException {
        if (front == null) {
            throw new NoSuchElementException("No front element");
        }
        return (T) front;
    }

   //  Returns a reference to the last element on this list
    @Override
    public T last() throws EmptyCollectionException {
        if (front == null) {
            throw new NoSuchElementException("No back element");
        }
        return (T) back;
    }

    //  Returns true if this list contains the specified target element
    @Override
    public boolean contains(Object target) {
        return find(target) != null;
    }

    //  Returns true if this list contains no elements
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    //  Removes and returns the first element from this list
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (front == null) {
            throw new NoSuchElementException("No front element");
        }
        Object obj = front.getElement();
        if (front == back) {
            front = null;
            back = null;
        } else {
            front.getNext().setPrevious(null);
            front = front.getNext();
        }
        count--;
        return (T) obj;
    }

    //  Removes and returns the last element from this list
    @Override
    public T removeLast() {
        if (front == null) {
            throw new NoSuchElementException("No front element");
        }
        Object obj = back.getElement();
        if (front == back) {
            front = null;
            back = null;
        } else {
            back.getPrevious().setNext(null);
            back = back.getPrevious();
        }
        count--;
        return (T) obj;
    }

    //  Removes and returns the specified element from this list
   
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        DoubleNode node = find(element);
        if (node == null) {
            throw new NoSuchElementException(element + " not found");
        }
        if (front == node) {
            return removeFirst();
        } else if (back == node) {
            return removeLast();
        }
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
        count--;
        return (T) node.getElement();
    }

    //  Returns the number of elements in this list
    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(
                getClass().getName() + ": count=" + count);
        DoubleNode next = front;
        while (next != null) {
            buf.append("\n" + next.getElement());
            next = next.getNext();
        }
        return buf.toString();
    }

    protected DoubleNode find(Object target) {
        DoubleNode next = front;
        while (next != null) {
            Object obj = next.getElement();
            if (target.equals(obj)) {
                return next;
            }
            next = next.getNext();
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new DoubleLinkedList();
    }

}
