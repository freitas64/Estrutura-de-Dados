/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import adt.OrderedListADT;


/**
 *
 * @author ruifreitas
 * @param <T>
 */
public class ArrayOrderedList<T> extends ArrayList<T> 
implements OrderedListADT<T>
{
   //-----------------------------------------------------------------
   //  Creates an empty list using the default capacity.
   //-----------------------------------------------------------------
   public ArrayOrderedList()
   {
      super();
   }

   //-----------------------------------------------------------------
   //  Creates an empty list using the specified capacity.
   //-----------------------------------------------------------------
   public ArrayOrderedList (int initialCapacity)
   {
      super(initialCapacity);
   }

   //-----------------------------------------------------------------
   //  Adds the specified Comparable element to the list, keeping
   //  the elements in sorted order.
   //-----------------------------------------------------------------
  @Override
	public void add(T element) {
		// Checks if the size is sufficient, if not, the array expands
		if (this.rear == this.list.length) {
			this.ExpandeCapacity();
		}

		// Creates a temporary compator
		Comparable<T> comp = (Comparable<T>) element;

		// Checks can be inserted in the last position, without being necessary
		// to go through the whole list
		if (this.size() > 0 && comp.compareTo(this.list[this.rear - 1]) >= 0) {
			this.list[this.rear] = element;
		} else {
			// Scrolls the list to the position where the element will be
			// inserted
			int scan = 0;
			
			while (scan < (this.rear - 1) && comp.compareTo(this.list[scan]) > 0) {
				scan++;
			}
			
			// Drag all elements above the position of the new element to the
			// side (+1)
			for (int index = this.rear; index > scan; index--) {
				this.list[index] = this.list[index - 1];
			}
			
			// Adds the element
			this.list[scan] = element;
		}
		
		// Increments the rear and the count
		this.rear++;
		this.count++;
}
}