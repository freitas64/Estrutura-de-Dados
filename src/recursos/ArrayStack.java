/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import adt.StackADT;
import exception.EmptyCollectionException;

/**
 *
 * @author ruifreitas
 */
public class ArrayStack<T> implements StackADT<T> {

    /**
     * !
     * constant to represent the default capacity of the array!
     */
    private final int DEFAULT_CAPACITY = 100;

    /**
     * int that represents both the number of elements and the next! available
     * position in the array!
     */
    private int top;

    /**
     * !
     * array of generic elements to represent the stack!
     */
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.!
     */
    public ArrayStack() {

        top = 0;
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);

    }

    /**
     * !
     * Creates an empty stack using the specified capacity.!
     *
     * @param initialCapacity represents the specified capacity !
     */
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }

    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }

        stack[top] = element;
        top++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;

    }

    @Override
    public T peek() throws EmptyCollectionException {

        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return top;
    }

    private void expandCapacity() {
        T[] larger = (T[]) (new Object[stack.length * 2]);

        for (int index = 0; index < stack.length; index++) {
            larger[index] = stack[index];
        }

        stack = larger;
    }
    
    @Override
    public String toString(){
        String result = "";

      for (int i=0; i < top; i++) 
         result = result + stack[i].toString() + "\n";

      return result;
}

}
