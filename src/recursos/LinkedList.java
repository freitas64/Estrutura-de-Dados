package recursos;


import javafx.scene.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tony
 */
public class LinkedList {
    /*
     * front ou head
     */
 
    private Node front;
 
    public LinkedList() {
        front = null;
 
    }
 
    public LinkedList(Node n) {
        this.front = n;
 
    }
 
    /**
     * @return the front
     */
    public Node getFront() {
        return front;
    }
 
    /**
     * @param front the front to set
     */
    public void setFront(Node front) {
        this.front = front;
    }
}