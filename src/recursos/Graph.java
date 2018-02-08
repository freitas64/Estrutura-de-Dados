/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import adt.GraphADT;

import exception.EmptyCollectionException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tony
 * @param <T>
 */
public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 50;
    protected int numVertices;   // number of vertices in the graph
    protected boolean[][] adjMatrix;   // adjacency matrix

    protected T[] vertices;

    /**
     * Creates an empty graph.
     */
// values of vertices
    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }
    /*
     * Adds a vertex to the graph, expanding the capacity of the graph
     * if necessary.  It also associates an object with the vertex.
     *
     * @param vertex  the vertex to add to the graph
     */

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    /**
     * ****************************************************************
     * Removes a vertex at the given index from the graph. Note that this may
     * affect the index values of other vertices.
     *
     * @param index
     * ****************************************************************
     */
    public void removeVertex(int index) {
        if (indexIsValid(index)) {
            numVertices--;

            for (int i = index; i < numVertices; i++) {
                vertices[i] = vertices[i + 1];
            }

            for (int i = index; i < numVertices; i++) {
                for (int j = 0; j <= numVertices; j++) {
                    adjMatrix[i][j] = adjMatrix[i + 1][j];
                }
            }

            for (int i = index; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    adjMatrix[j][i] = adjMatrix[j][i + 1];
                }
            }
        }
    }

    /**
     * ****************************************************************
     * Removes a single vertex with the given value from the graph.
     *
     * @param vertex
     * ****************************************************************
     */
    @Override
    public void removeVertex(T vertex) {
        for (int i = 0; i < numVertices; i++) {
            if (vertex.equals(vertices[i])) {
                removeVertex(i);
                return;
            }
        }
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    public void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }
    /*
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1  the first vertex
     * @param vertex2  the second vertex
     */

    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * ****************************************************************
     * Removes an edge between two vertices of the graph.
     *
     * @param index1
     * @param index2
     * ****************************************************************
     */
    public void removeEdge(int index1, int index2)  throws EmptyCollectionException{
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) throws EmptyCollectionException{
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * ****************************************************************
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given index.
     *
     * @param startIndex
     * @return ****************************************************************
     */
    public Iterator<T> iteratorBFS(int startIndex) {
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);

            /**
             * Find all vertices adjacent to x that have not been visited and
             * queue them up
             */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    /**
     * ****************************************************************
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given vertex.
     *
     * @param startVertex
     * @return ****************************************************************
     */
    @Override
    public Iterator<T> iteratorBFS(T startVertex) {
        return iteratorBFS(getIndex(startVertex));
    }

    /**
     * ****************************************************************
     * Returns an iterator that performs a depth first search traversal starting
     * at the given index.
     *
     * **************************************************************** @param
     * startIndex
     * @param startIndex
     * @return
     * @throws exception.EmptyCollectionException
     */
    public Iterator<T> iteratorDFS(int startIndex) throws EmptyCollectionException {
        Integer x;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        boolean[] visited = new boolean[numVertices];

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;

            /**
             * Find a vertex adjacent to x that has not been visited and push it
             * on the stack
             */
            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }
        return resultList.iterator();
    }

    /**
     * ****************************************************************
     * Returns an iterator that performs a depth first search traversal starting
     * at the given vertex.
     * ****************************************************************
     */
    @Override
    public Iterator iteratorDFS(T startVertex) {
        try {
            return iteratorDFS(getIndex(startVertex));
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * ****************************************************************
     * Returns an iterator that contains the indices of the vertices that are in
     * the shortest path between the two given vertices.
     * **************************************************************** @param
     * startIndex
     * @param startIndex
     * @param targetIndex
     * @return
     * @throws exception.EmptyCollectionException
     */
    protected Iterator<Integer> iteratorShortestPathIndices(int startIndex, int targetIndex) throws EmptyCollectionException {
        int index = startIndex;
        int[] pathLength = new int[numVertices];
        int[] predecessor = new int[numVertices];
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<Integer> resultList
                = new ArrayUnorderedList<>();

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)
                || (startIndex == targetIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;
        pathLength[startIndex] = 0;
        predecessor[startIndex] = -1;

        while (!traversalQueue.isEmpty() && (index != targetIndex)) {
            index = (traversalQueue.dequeue()).intValue();

            /**
             * Update the pathLength for each unvisited vertex adjacent to the
             * vertex at the current index.
             */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[index][i] && !visited[i]) {
                    pathLength[i] = pathLength[index] + 1;
                    predecessor[i] = index;
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        if (index != targetIndex) // no path must have been found
        {
            return resultList.iterator();
        }

        LinkedStack<Integer> stack = new LinkedStack<>();
        index = targetIndex;
        stack.push(new Integer(index));
        do {
            index = predecessor[index];
            stack.push(new Integer(index));
        } while (index != startIndex);

        while (!stack.isEmpty()) {
            resultList.addToRear(((Integer) stack.pop()));
        }

        return resultList.iterator();
    }

    /**
     * ****************************************************************
     * Returns an iterator that contains the shortest path between the two
     * vertices.
     *
     * @param startIndex
     * @param targetIndex
     * @return ****************************************************************
     * @throws exception.EmptyCollectionException
     */
    public Iterator<T> iteratorShortestPath(int startIndex, int targetIndex) throws EmptyCollectionException {
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return resultList.iterator();
        }

        Iterator<Integer> it = iteratorShortestPathIndices(startIndex,
                targetIndex);
        while (it.hasNext()) {
            resultList.addToRear(vertices[((Integer) it.next()).intValue()]);
        }
        return resultList.iterator();
    }

    /**
     * ****************************************************************
     * Returns an iterator that contains the shortest path between the two
     * vertices.
     *
     * @param startVertex
     * @param targetVertex
     * @return ****************************************************************
     */
    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        try {
            return iteratorShortestPath(getIndex(startVertex),
                    getIndex(targetVertex));
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (numVertices == 0);
    }

    /**
     * ****************************************************************
     * Returns true if the graph is connected and false otherwise.
     * ****************************************************************
     */
    @Override
    public boolean isConnected() {
        if (isEmpty()) {
            return false;
        }

        Iterator<T> it = iteratorBFS(0);
        int count = 0;

        while (it.hasNext()) {
            it.next();
            count++;
        }
        return (count == numVertices);
    }

    /**
     * ****************************************************************
     * Returns the number of vertices in the graph.
     *
     * @return ****************************************************************
     */
    @Override
    public int size() {
        return numVertices;
    }

    /**
     * ****************************************************************
     * Returns the index value of the first occurrence of the vertex. Returns -1
     * if the key is not found.
     *
     * @param vertex
     * @return ****************************************************************
     */
 
      public int getIndex(T vertex)
   {
      for (int i = 0; i < numVertices; i++)
         if (vertices[i].equals(vertex))
            return i;
      return -1;
   }

    /**
     * ****************************************************************
     * Returns true if the given index is valid.
     *
     * @param index
     * @return ****************************************************************
     */
    protected boolean indexIsValid(int index) {
        return ((index < numVertices) && (index >= 0));
    }

    /**
     * ****************************************************************
     * Creates new arrays to store the contents of the graph with twice the
     * capacity.
     * ****************************************************************
     */
    protected void expandCapacity() {
        T[] largerVertices = (T[]) (new Object[vertices.length * 2]);
        boolean[][] largerAdjMatrix
                = new boolean[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }

        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;
    }

}
