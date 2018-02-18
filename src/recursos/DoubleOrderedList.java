/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import adt.*;

/**
 *
 * @author ruifreitas
 */
public class DoubleOrderedList<T> extends DoubleList<T> implements OrderedListADT<T> {

	
	public DoubleOrderedList()
	{
		super();
	}
        
       
        @Override
	public void add(T element) {
		DoubleNode<T> previous;
		DoubleNode<T> location;
		T data = null;
		location = head;
		previous = null;
                Comparable<T> comp = (Comparable<T>) element;
		
		while(location != null)
		{
			data = location.getElement();
			if(comp.compareTo(element) < 0)
			{
				previous = location;
				location = location.getNext();
			}
			else
			{
				break;
			}

}
		DoubleNode<T> newNode = new DoubleNode<T>(element);
		if(previous == null)
		{
			newNode.setNext(head);
			head = newNode;
		}
		else
		{
			newNode.setNext(location);
			previous.setNext(newNode);
		}
		count++;
		
	}


}