/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author ruifreitas
 * @param <T>
 */
public class ArrayIterator<T> implements Iterator {

    private int count;    // the number of elements in the collection
    private int current;  // the current position in the iteration 
    private T[] items;

    //-----------------------------------------------------------------
    //  Sets up this iterator using the specified items.
    //-----------------------------------------------------------------
    public ArrayIterator(T[] collection, int size) {
        items = collection;
        count = size;
        current = 0;
    }

    //-----------------------------------------------------------------
    //  Returns true if this iterator has at least one more element
    //  to deliver in the iteraion.
    //-----------------------------------------------------------------
    @Override
    public boolean hasNext() {
        return (current < count);
    }

    //-----------------------------------------------------------------
    //  Returns the next element in the iteration. If there are no
    //  more elements in this itertion, a NoSuchElementException is
    //  thrown.
    //-----------------------------------------------------------------
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        current++;
        return items[current - 1];

    }

    //-----------------------------------------------------------------
    //  The remove operation is not supported in this collection.
    //-----------------------------------------------------------------
    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
