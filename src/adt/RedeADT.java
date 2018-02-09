/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import adt.GraphADT;
import exception.EmptyCollectionException;
import java.util.Iterator;
import tp_ed_blogSocial.User;

/**
 * @author Antonio Sanches 8070027
 * @author José Teixeira 8080328
 * @param <T>
 */
public interface RedeADT<T> extends GraphADT<T> {

    /**
     * Adds a vertex to this graph, associating object with vertex.
     *
     * @param user
     */
    public void addVertex(User user);

    public void removeVertex(User user) throws EmptyCollectionException;;

    public void addEdge(User user1, User user2) throws EmptyCollectionException;

    public void removeEdge(User user1, User user2) throws EmptyCollectionException;

    public int getIndex(User user);

    public Iterator<T> iteratorLongtPath(User  user1, User  user2);

    public Iterator<T> iteratorShortestPath(User user1, User  user2);

    public Iterator<T> iteratorBFS(User  startVertex);

}
