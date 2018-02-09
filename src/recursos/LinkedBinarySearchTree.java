//*******************************************************************
//
// LinkedBinarySearchTree.java			
//
// Implements the BinarySearchTreeADT interface with links
//*******************************************************************

package recursos;

import adt.BinarySearchTreeADT;
import exception.ElementNotFoundException;
import exception.EmptyCollectionException;

public class LinkedBinarySearchTree<T>  extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {
    
    

   //================================================================
   //  Creates an empty binary search tree.
   //================================================================
   public LinkedBinarySearchTree() 
   {
      super();
   }  // constructor BinarySearchTree

   //================================================================
   //  Creates a binary search with the specified element as its
   //  root.
   //================================================================
   public LinkedBinarySearchTree (T element) 
   {
      super (element);
   }  // constructor BinarySearchTree

   //================================================================
   //  Adds the specified object to the binary search tree in the
   //  appropriate position according to its key value.  Note that
   //  equal elements are added to the right.
   //================================================================
   @Override
   public void addElement (T element) 
   {

      BinaryTreeNode<T> temp = new BinaryTreeNode<> (element);
      Comparable<T> comparableElement = (Comparable<T>)element;

      if (isEmpty())
         root = temp;
      else 
      {
         BinaryTreeNode<T> current = root;
         boolean added = false;

         while (!added) 
         {
            if (comparableElement.compareTo(current.element) < 0)

               if (current.left == null) 
               {
                  current.left = temp;
                  added = true;
               } 
               else
                  current = current.left;
            else
               if (current.right == null) 
               {
                  current.right = temp;
                  added = true;
               } 
               else
                  current = current.right;
         }//while
      }//else

      count++;

   }  // method addElement

   //================================================================
   //  Removes the first element that matches the specified target
   //  element from the binary search tree and returns a reference to
   //  it.  Throws a ElementNotFoundException if the specified target
   //  element is not found in the binary search tree.
   //================================================================
   @Override
   public T removeElement (T targetElement) throws ElementNotFoundException 
   { 

      T result = null;

      if (!isEmpty())

         if (((Comparable)targetElement).equals(root.element)) 
         {
            result =  root.element;
            root = replacement (root);
            count--;
         } //if
        else 
        {
            BinaryTreeNode<T> current, parent = root;
            boolean found = false;

            if (((Comparable)targetElement).compareTo(root.element) < 0)
               current = root.left;
            else
               current = root.right;

            while (current != null && !found) 
            {
               if (targetElement.equals(current.element)) 
               {
                  found = true;
                  count--;
                  result =  current.element;
          
                  if (current == parent.left)
                  {
                     parent.left = replacement (current);
                  }
                  else
                  {
                     parent.right = replacement (current);
                  }
               } //if
              else 
              {
                  parent = current;
         
                  if (((Comparable)targetElement).compareTo(current.element) < 0)
                     current = current.left;
                  else
                     current = current.right;
               } //else
            } //while
            if (!found)
               throw new ElementNotFoundException("binary tree");
         } //else

      return result;

   }  // method removeElement

   //================================================================
   //  Removes elements that match the specified target
   //  element from the binary search tree 
   //  Throws a ElementNotFoundException if the sepcified target
   //  element is not found in the binary search tree.
   //================================================================
   @Override
   public void removeAllOccurrences (T targetElement) throws
   ElementNotFoundException 
   {
      removeElement(targetElement);
      
      try
	 {
	   while (contains( (T) targetElement))
          removeElement(targetElement);
	 }
	 catch (ElementNotFoundException ElementNotFoundException)
	 {
	 }
         
   }  // method removeAllOccurrences

   //================================================================
   //  Removes the node with the least value from the binary search
   //  tree and returns a reference to its element.  Throws an
   //  EmptyBinarySearchTreeException if the binary search tree is
   //  empty. 
   //================================================================
   @Override
   public T removeMin() throws EmptyCollectionException 
   {
      T result = null;

      if (isEmpty())
           throw new EmptyCollectionException ("binary tree");
      else 
      {
         if (root.left == null) 
         {
            result = root.element;
            root = root.right;
         } //if
         else 
         {
            BinaryTreeNode<T> parent = root;
            BinaryTreeNode<T> current = root.left;
            while (current.left != null) 
            {
               parent = current;
               current = current.left;
            } //while
            result =  current.element;
            parent.left = current.right;
         } //else

         count--;
      } //else
 
      return result;

   }  // method removeMin

   //================================================================
   //  Removes the node with the highest value from the binary
   //  search tree and returns a reference to its element.  Throws an
   //  EmptyBinarySearchTreeException if the binary search tree is
   //  empty. 
   //================================================================
   @Override
   public T removeMax() throws EmptyCollectionException 
   {
      T result = null;

      if (isEmpty())
           throw new EmptyCollectionException ("binary tree");
      else 
      {
         if (root.right == null) 
         {
            result =  root.element;
            root = root.left;
         } //if
         else 
         {
              BinaryTreeNode<T> parent = root;
              BinaryTreeNode<T> current = root.right;

              while (current.right != null) 
              {
                 parent = current;
                 current = current.right;
              } //while

              result =  current.element;
              parent.right = current.left;
           } //else

         count--;
      } //else

      return result;

   }  // method removeMax

   //================================================================
   //  Returns the element with the least value in the binary search
   //  tree.  It does not remove the node from the binary search
   //  tree.  Throws an EmptyBinarySearchTreeException if the binary
   //  search tree is empty.
   //================================================================
   @Override
   public T findMin() throws EmptyCollectionException 
   {
      T result = null;

      if (isEmpty())
           throw new EmptyCollectionException ("binary tree");
      else 
      {
         BinaryTreeNode<T> current = root;
        
         while (current.left != null)
            current = current.left;
       
         result = current.element;
      } //else

      return result;

   }  // method findMin

   //================================================================
   //  Returns the element with the highest value in the binary
   //  search tree.  It does not remove the node from the binary
   //  search tree.  Throws an EmptyBinarySearchTreeException if the 
   //  binary search tree is empty.
   //================================================================
   @Override
   public T findMax() throws EmptyCollectionException 
   {
      T result = null;

      if (isEmpty())
           throw new EmptyCollectionException ("binary tree");
      else 
      {
         BinaryTreeNode<T> current = root;
      
         while (current.right != null)
            current = current.right;

        result = current.element;
      } //else
 
      return result;

   }  // method findMax

   //================================================================
   //  Returns a reference to the specified target element if it is
   //  found in the binary tree.  Throws a NoSuchElementException if
   //  the specified target element is not found in the binary tree.
   //================================================================
   @Override
   public T find (T targetElement) throws ElementNotFoundException 
   {

	 BinaryTreeNode<T> current = root; 
	 BinaryTreeNode<T> temp = current;

   
      if (!(current.element.equals(targetElement)) && (current.left !=null)&&(((Comparable)current.element).compareTo(targetElement) > 0))
		current = findagain( targetElement, current.left);

      else if (!(current.element.equals(targetElement)) && (current.right != null)) 
		current = findagain( targetElement, current.right); 

      if (!(current.element.equals(targetElement)))
         throw new ElementNotFoundException ("binarytree");

      return current.element;

   }  // method find

   //================================================================
   //  Returns a reference to the specified target element if it is
   //  found in the binary tree.  
   //================================================================
   private BinaryTreeNode<T> findagain (T targetElement, BinaryTreeNode<T> next) 
   {
	 BinaryTreeNode<T> current = next;
      if (!(next.element.equals(targetElement)) && (next.left !=null) &&(((Comparable)next.element).compareTo(targetElement) > 0))
 		next = findagain( targetElement, next.left); 
	 else if (!(next.element.equals(targetElement)) && (next.right != null))
 		next = findagain( targetElement, next.right);                     
      
	 return next;

   }  // method findagain


   //================================================================
   //  Returns a reference to a node that will replace the one
   //  specified for removal.  In the case where the removed
   //  node has two children, the inorder successor is used
   //  as its replacement.
   //================================================================
   protected BinaryTreeNode<T> replacement (BinaryTreeNode<T> node) 
   {
      BinaryTreeNode<T> result = null;

      if ((node.left == null)&&(node.right==null))
            result = null;
      else if ((node.left != null)&&(node.right==null))
            result = node.left;
      else if ((node.left == null)&&(node.right != null))
            result = node.right;
      else
      {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;

            while (current.left != null) 
            {
               parent = current;
               current = current.left;
            }//while

            if (node.right == current)
               current.left = node.left;
            else
            {
               parent.left = current.right;
               current.right = node.right;
               current.left = node.left;
            }
            result = current;
      }//else
      return result;


   }  // method replacement

}  // class BinarySearchTree
