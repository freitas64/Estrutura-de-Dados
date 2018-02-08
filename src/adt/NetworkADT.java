/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;


import exception.EmptyCollectionException;
import java.util.Iterator;
import tp_ed_blogSocial.User;

/**
 * @author Antonio Sanches 8070027
 * @author José Teixeira 8080328
 * @param <T>
 */
public interface NetworkADT<T> extends GraphADT<T> {

    /**
     * Adds a vertex to this graph, associating object with vertex.
     *
     * @param pessoa
     */
    public void addVertex(User pessoa);

    public void removeVertex(User pessoa) throws EmptyCollectionException;;

    public void addEdge(User pessoa1, User pessoa2) throws EmptyCollectionException;

    public void removeEdge(User pessoa1, User pessoa2) throws EmptyCollectionException;

    public int getIndex(User pessoa);

    public Iterator<T> iteratorLongtPath(User pessoa1, User pessoa2);

    public Iterator<T> iteratorShortestPath(User pessoa1, User pessoa2);

    public Iterator<T> iteratorBFS(User startVertex);

}
