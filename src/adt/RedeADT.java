/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import exception.EmptyCollectionException;
import java.util.Iterator;


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
    @Override
    public void addVertex(T vertex);

    /**
     *
     * @param vertex
     * @throws EmptyCollectionException
     */
    @Override
    public void removeVertex(T vertex); /*throws EmptyCollectionException;*/

    @Override
    public void addEdge(T vertex1, T vertex2) throws EmptyCollectionException;

    @Override
    public void removeEdge(T vertex1, T vertex2) throws EmptyCollectionException;

    public int getIndex(T vertex);

    public Iterator<T> iteratorLongtPath(T  vertex1, T  vertex2);

    @Override
    public Iterator<T> iteratorShortestPath(T vertex1, T  vertex2);

    @Override
    public Iterator<T> iteratorBFS(T  startVertex);

}
