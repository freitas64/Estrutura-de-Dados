/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import adt.StackADT;
import exception.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author ruifreitas
 * @param <T>
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count;
    private LinearNode<T> top;
    private Element item;
    private Node first;

    @Override
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<>(element);

        temp.setNext(top);
        top = temp;
        count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() throws EmptyCollectionException {
        return count;
    }

    @Override
    public String toString() {
        String result = "";
        LinearNode current = top;

        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }
    public Iterator<T> iterator() {
        return new LinkedStackIterator();
}
    private class LinkedStackIterator implements Iterator<T> {

        private LinearNode<T> current = top;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.getElement();
            current = current.getNext();
            return data;
        }

        @Override
        public void remove() {
            //To change body of implemented methods use File | Settings | File Templates.
        }
        
        public T peek() {
		if (count == 0) {
			throw new EmptyStackException();
		}
		return (T) first.getElement();
	}
    }


}
