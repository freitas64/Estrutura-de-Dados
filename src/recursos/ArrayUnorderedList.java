/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;


import adt.UnorderedListADT;
import exception.ElementNotFoundException;


/**
 *
 * @author ruifreitas
 * @param <T>
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>
{
   //-----------------------------------------------------------------
   //  Creates an empty list using the default capacity.
   //-----------------------------------------------------------------
   public ArrayUnorderedList()
   {
      super();
   }

   //-----------------------------------------------------------------
   //  Creates an empty list using the specified capacity.
   //-----------------------------------------------------------------
   public ArrayUnorderedList (int initialCapacity)
   {
      super(initialCapacity);
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the front of the list.
   //-----------------------------------------------------------------
   @Override
   public void addToFront (T element)
   {
      if (size() == list.length) {
           ExpandeCapacity();
       }

      // shift elements to make room
      for (int scan=rear; scan > 0; scan--) {
           list[scan] = list[scan-1];
       }

      list[0] = element;
      rear++;
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the rear of the list.
   //-----------------------------------------------------------------
   @Override
   public void addToRear (T element)
   {
      if (size() == list.length) {
         ExpandeCapacity();
       }

      list[rear] = element;
      rear++;
   }

   //-----------------------------------------------------------------
   //  Adds the specified element after the specified target element.
   //  Throws a ElementNotFoundException if the target is not found.
   //-----------------------------------------------------------------
    @Override
    public void addToAfter(T element, T target) throws ElementNotFoundException {
     if (size() == list.length) {
           ExpandeCapacity();
       }

      int scan = 0;
      while (scan < rear && !target.equals(list[scan])) {
           scan++;
       }
      
      if (scan == rear) {
           throw new ElementNotFoundException ("list");
       }
    
      scan++;
      for (int scan2=rear; scan2 > scan; scan2--) {
           list[scan2] = list[scan2-1];
       }

      list[scan] = element;
      rear++;    
    }

}
