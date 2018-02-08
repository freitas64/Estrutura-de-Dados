package recursos;
/*package src.SOURCES;
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import adt.ListADT;
import exception.*;
import java.util.Iterator;

/**
 * 
 * @author RUI MIGUEL RIBEIRO FREITAS
 * @param <T>
 * @Antonio Sanches
 */
public class ArrayList<T> implements ListADT<T> {

    protected final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    protected int rear;
    protected T[] list;

    //-----------------------------------------------------------------
    //  Creates an empty list using the default capacity.
    //-----------------------------------------------------------------
    public ArrayList() {
        rear = 0;
        list = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    //-----------------------------------------------------------------
    //  Creates an empty list using the specified capacity.
    //-----------------------------------------------------------------
    public ArrayList(int initialCapacity) {
        rear = 0;
        list = (T[]) (new Object[initialCapacity]);
    }

    //-----------------------------------------------------------------
    //  Removes and returns the last element in the list.
    //-----------------------------------------------------------------
    @Override
    public T removeLast() throws EmptyCollectionException,ElementNotFoundException{
        T result;

        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        rear--;
        result = list[rear];
        list[rear] = null;

        return result;
    }

    //-----------------------------------------------------------------
    //  Removes and returns the first element in the list.
    //-----------------------------------------------------------------
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        T result = list[0];
        rear--;
        // shift the elements
        for (int scan = 0; scan < rear; scan++) {
            list[scan] = list[scan + 1];
        }


        list[rear] = null;

        return result;
    }

    //-----------------------------------------------------------------
    //  Removes and returns the specified element.
    //-----------------------------------------------------------------
    @Override
    public T remove(T element) throws ElementNotFoundException {
        T result;
        int index = find(element);

        if (index == NOT_FOUND) {
            throw new ElementNotFoundException("list");
        }

        result = list[index];
        rear--;
        // shift the appropriate elements
        for (int scan = index; scan < rear; scan++) {
            list[scan] = list[scan + 1];
        }


        list[rear] = null;

        return result;
    }

    //-----------------------------------------------------------------
    //  Returns a reference to the element at the front of the list.
    //  The element is not removed from the list.  Throws an
    //  EmptyCollectionException if the list is empty.  
    //-----------------------------------------------------------------
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        return list[0];
    }

    //-----------------------------------------------------------------
    //  Returns a reference to the element at the rear of the list.
    //  The element is not removed from the list.  Throws an
    //  EmptyCollectionException if the list is empty.  
    //-----------------------------------------------------------------
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        return list[rear - 1];
    }

    //-----------------------------------------------------------------
    //  Returns true if this list contains the specified element.
    //-----------------------------------------------------------------
    @Override
    public boolean contains(T target) {
        return (find(target) != NOT_FOUND);
    }

    //-----------------------------------------------------------------
    //  Returns the array index of the specified element, or the
    //  constant NOT_FOUND if it is not found.
    //-----------------------------------------------------------------
    private int find(T target) {
        int scan = 0, result = NOT_FOUND;
        boolean found = false;

        if (!isEmpty()) {
            while (!found && scan < rear) {
                if (target.equals(list[scan])) {
                    found = true;
                } else {
                    scan++;
                }
            }
        }

        if (found) {
            result = scan;
        }

        return result;
    }

    //-----------------------------------------------------------------
    //  Returns true if this list is empty and false otherwise. 
    //-----------------------------------------------------------------
    @Override
    public boolean isEmpty() {
        return (rear == 0);
    }

    //-----------------------------------------------------------------
    //  Returns the number of elements currently in this list.
    //-----------------------------------------------------------------
    @Override
    public int size() {
        return rear;
    }

    //-----------------------------------------------------------------
    //  Returns an iterator for the elements currently in this list.
    //-----------------------------------------------------------------
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(list, rear);
    }

    //-----------------------------------------------------------------
    //  Returns a string representation of this list. 
    //-----------------------------------------------------------------
    @Override
    public String toString() {
        String result = "";

        for (int scan = 0; scan < rear; scan++) {
            result = result + list[scan].toString() + "\n";
        }

        return result;
    }

    //-----------------------------------------------------------------
    //  Creates a new array to store the contents of the list with
    //  twice the capacity of the old one.
    //-----------------------------------------------------------------
    protected void expandCapacity() {
        T[] larger = (T[]) (new Object[list.length * 2]);
        //for (int scan = 0; scan < list.length; scan++) {
        //  larger[scan] = list[scan];
        //ou system.arraycopy
        System.arraycopy(list, 0, larger, 0, list.length);
        list = larger;
    }
}