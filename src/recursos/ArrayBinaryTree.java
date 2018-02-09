//*******************************************************************
//
// ArrayBinaryTree.java			
//
// Implements the BinaryTreeADT interface using an array
//*******************************************************************

package recursos;

import adt.BinaryTreeADT;
import exception.ElementNotFoundException;
import java.util.Iterator;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T>  {

   protected int count;
   protected T[] tree; 
   private final int capacity = 50;

   //================================================================
   //  Creates an empty binary tree.
   //================================================================
   public ArrayBinaryTree() 
   {
      count = 0;
      tree = (T[]) new Object[capacity];
   }  // constructor BinaryTree

   //================================================================
   //  Creates a binary tree with the specified element as its root.
   //================================================================
   public ArrayBinaryTree (T element) 
   {
      count = 1;
      tree = (T[]) new Object[capacity];

      tree[0] = element;
   }  // constructor BinaryTree



   protected void expandCapacity()
   {
      T[] temp = (T[]) new Object[tree.length * 2];
       System.arraycopy(tree, 0, temp, 0, tree.length);
      tree = temp;
   }
   
   //================================================================
   //  Removes the left subtree of this binary tree.
   //================================================================
   public void removeLeftSubtree() 
   {

   }  // method removeLeftSubtree

   //================================================================
   //  Removes the right subtree of this binary tree.
   //================================================================
   public void removeRightSubtree() 
   {
      
   }  // method removeRightSubtree
   
   //================================================================
   //  Deletes all nodes from the binary tree.
   //================================================================
   public void removeAllElements() 
   {
      count = 0;
      for (int ct=0; ct<tree.length; ct++)      
         tree[ct] = null;
   }  // method removeAllElements
   
   //================================================================
   //  Returns true if the binary tree is empty and false otherwise.
   //================================================================
   @Override
   public boolean isEmpty() 
   {
      return (count == 0);
   }  // method isEmpty

   //================================================================
   //  Returns true if the binary tree is empty and false otherwise.
   //================================================================
   @Override
   public int size() 
   {
      return count;
   }  // method size
   
   //================================================================
   //  Returns true if the tree contains an element that matches the
   //  specified target element and false otherwise.
   //================================================================
   @Override
   public boolean contains (T targetElement) 
   {
      boolean found = false;

      for (int ct=0; ct<count && !found; ct++)
         if (targetElement.equals(tree[ct]))
	       found = true;

      return found;

   }  // method contains

   //================================================================
   //  Returns a reference to the specified target element if it is
   //  found in the binary tree.  Throws a NoSuchElementException if
   //  the specified target element is not found in the binary tree.
   //================================================================
   @Override
   public T find (T targetElement) throws ElementNotFoundException  {
      T temp=null;
	 boolean found = false;

      for (int ct=0; ct<count && !found; ct++)
         if (targetElement.equals(tree[ct]))
         {
	       found = true;
            temp = tree[ct];
         }

      if (!found)
         throw new ElementNotFoundException("binary tree");

      return temp;


   }  // method find



   //================================================================
   //  Returns a string representation of the binary tree.
   //================================================================
   @Override
   public String toString() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
      inorder (0, templist);
      return templist.toString();
   }  // method toString

   //================================================================
   //  Performs an inorder traversal on the binary tree by calling an
   //  overloaded, recursive inorder method that starts with
   //  the root.
   //================================================================
   @Override
   public Iterator<T> iteratorInOrder() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
      inorder (0, templist);
      return templist.iterator();
   }  // method inorder

   //================================================================
   //  Performs a recursive inorder traversal.
   //================================================================
   protected void inorder (int node, ArrayUnorderedList<T> templist) 
   {
      if (node < tree.length)
         if (tree[node] != null) 
 	    {
            inorder ((node+1)*2-1, templist);
            templist.addToRear(tree[node]);
            inorder ((node+1)*(2+1)-1, templist);
         }//if

   }  // method inorder

   //================================================================
   //  Performs an preorder traversal on the binary tree by calling an
   //  overloaded, recursive preorder method that starts with
   //  the root.
   //================================================================
   @Override
   public Iterator<T> iteratorPreOrder() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
      preorder (0, templist);
      return templist.iterator();
   }  // method preorder

   //================================================================
   //  Performs a recursive preorder traversal.
   //================================================================
   protected void preorder (int node, ArrayUnorderedList<T> templist) 
   {
      if (node < tree.length)
         if (tree[node] != null) 
 	    { 
            templist.addToRear(tree[node]);
            inorder ((node+1)*2-1, templist);
            inorder ((node+1)*(2+1)-1, templist);
         }//if

      

   }  // method preorder

   //================================================================
   //  Performs an postorder traversal on the binary tree by calling
   //  an overloaded, recursive postorder method that starts
   //  with the root.
   //================================================================
   @Override
   public Iterator<T> iteratorPostOrder() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
      postorder (0, templist);
      return templist.iterator();
   }  // method postorder

   //================================================================
   //  Performs a recursive postorder traversal.
   //================================================================
   protected void postorder (int node, ArrayUnorderedList<T> templist) 
   {
      if (node < tree.length)
         if (tree[node] != null) 
 	    {
            inorder ((node+1)*2-1, templist); 
            inorder ((node+1)*(2+1)-1, templist);
            templist.addToRear(tree[node]);
            
         }//if


   }  // method postorder

   //================================================================
   //  Performs a levelorder traversal on the binary tree, using a
   //  templist.
   //================================================================
   @Override
   public Iterator<T> iteratorLevelOrder() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
      for (int ct=0; ct<count; ct++)
         templist.addToRear(tree[ct]);
      return templist.iterator();
   }  // method levelorder

    @Override
    public T getRoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}  // class BinaryTree
