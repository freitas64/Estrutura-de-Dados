package recursos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tony
 */
public class LinkedListNs<T> {

    private NodeSentinela primeiro, ultimo;
    private int size;

    public LinkedListNs() {
        primeiro = null;
        ultimo = null;

        size = 0;

    }

    public LinkedListNs(NodeSentinela n, NodeSentinela s) {
        this.primeiro = n;
        this.ultimo = s;

    }

    /**
     * @return the primeiro
     */
    public NodeSentinela getPrimeiro() {
        return primeiro;
    }

    /**
     * @param front
     */
    public void setPrimeiro(NodeSentinela front) {
        this.primeiro = front;
    }

    public void add(T element) {
        NodeSentinela novo = new NodeSentinela(element);
        if (element == null) {
            throw new IllegalArgumentException("Nulo");
        } else {
            this.setSize(size + 1);

            if (isEmpty()) {
                ultimo = novo;

            } else {
                novo.setNext(primeiro);

                primeiro = novo;
            }

        }

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
     * @return the ultimo
     */
    public NodeSentinela getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodeSentinela ultimo) {
        this.ultimo = ultimo;
    }
}
