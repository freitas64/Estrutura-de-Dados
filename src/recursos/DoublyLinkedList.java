/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author ruifreitas
 * @param <T>
 */
public class DoublyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public DoublyLinkedList() {
        this.last = new Node<>(null, null, null);
        this.first = new Node<>(null, null, this.last);

        this.last.setNext(this.first);
        this.size = 0;
    }

    public DoublyLinkedList(Node first) {
        this.first = first;

    }

    public boolean isEmpty() {
        if (this.getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the first
     */
    public Node getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Node first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public Node<T> getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(Node<T> last) {
        this.last = last;
    }

    public boolean add(T elemento) {

        if (elemento != null) {

            Node novoNo = new Node(null, elemento, null);

            novoNo.setNext(this.first.getNext());
            novoNo.setPrevious(this.first);
            this.first.getNext().setPrevious(novoNo);
            this.first.setNext(novoNo);
            this.size++;

            return true;
        }

        return false;
    }

    public boolean remove() {

        if (!isEmpty()) {

            Node aRemover = this.first.getNext();

            this.first.setNext(aRemover.getNext());

            aRemover.getNext().setPrevious(this.first);

            this.size--;

            return true;
        }

        return false;
    }

}
