/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import exception.*;

import adt.*;
import java.util.Iterator;


/**
 *
 * @author User
 */
public class DoubleList<T> implements ListADT<T>, Iterable<T> {

    protected DoubleNode<T> head;
    protected DoubleNode<T> rear;
    public int count;

    public DoubleList() {
        this.head = null;
        this.rear = null;
        this.count = 0;
    }

    public DoubleNode<T> getHead() {
        return head;
    }

    public void setHead(DoubleNode<T> head) {
        this.head = head;
    }

    public DoubleNode<T> getRear() {
        return rear;
    }

    public void setRear(DoubleNode<T> rear) {
        this.rear = rear;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("DoubleList vazia");
        } else {
            T temp = this.getHead().getElement();
            this.head = this.getHead().getNext();
            this.head.setPrevious(null);
            this.setCount(this.count - 1);
            return temp;
        }
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("DoubleList vazia");
        } else {
            T temp = this.getRear().getElement();
            DoubleNode T = head;
            this.rear = this.getRear().getPrevious();
            this.rear.setNext(null);
            this.setCount(this.count - 1);
            return temp;
        }
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("DoubleList vazia");
        }
        boolean found = false;
        DoubleNode<T> previous = null;
        DoubleNode<T> current = this.getHead();
        while (current != null && !found) {
            if (element.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        if (!found) {
            throw new ElementNotFoundException("Elemento nao encontrado");
        }
        if (this.size() == 1) {
            this.head = this.rear = null;
        } else if (current.equals(this.head)) {
            this.head = current.getNext();
        } else if (current.equals(this.rear)) {
            this.rear = previous;
            this.rear.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }
        this.setCount(this.count - 1);
        return current.getElement();

    }

    @Override
    public T first() {
        return this.getHead().getElement();
    }

    @Override
    public T last() {
        return this.getRear().getElement();
    }

    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        if(this.getHead().getElement().equals(target)){
            return true;
        }else{
            if(this.getRear().getElement().equals(target)){
                return true;
            }else{
                DoubleNode x = this.head;
                while(x != null){
                    if(x.getElement().equals(target)){
                        return true;
                    }
                    x = x.getNext();
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.count;
    }

   public class DoubleIterator<T> implements Iterator<T>{
        private DoubleNode<T> start;
        
        
        public DoubleIterator()
	{
		
		start = (DoubleNode<T>) head;
	}
	@Override
	public boolean hasNext() {
		return start == null;
	}

	@Override
	public T next() {
	
		T element = start.getElement();
		start = start.getNext();
		return element;
                
	}

        }
    @Override
	public Iterator<T> iterator() {
		return new DoubleIterator<>();
}

      

}
