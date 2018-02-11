/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import adt.RedeADT;
import recursos.*;

import exception.ElementNotFoundException;
import exception.EmptyCollectionException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Rui Freitas 8060071
 * 
 * @param <T>
 */
public class Rede<T> extends Graph<T> implements RedeADT<T> {

    double[][] adjMatrix;    // adjacency matrix //mudado
    User[] vertices;
    ArrayList<T> al = new ArrayList<>();

    /**
     * ****************************************************************
     * Creates an empty network.
     * ****************************************************************
     */
    public Rede() {
        numVertices = 0;
        this.adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = new User[DEFAULT_CAPACITY];

    }

    /**
     * ****************************************************************
     * Adds a vertex to the graph, expanding the capacity of the graph if
     * necessary.
     * ****************************************************************
     */
    public void addVertex() {
        if (numVertices == vertices.length) {
            expandCapacity();
        }

        vertices[numVertices] = null;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = Double.POSITIVE_INFINITY;
            adjMatrix[i][numVertices] = Double.POSITIVE_INFINITY;
        }
        numVertices++;
    }

    /**
     * Adiciona um user ao vertice
     *
     * @param user
     */
    @Override
    public void addVertex(T user) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = (User) user;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = Double.POSITIVE_INFINITY;
            adjMatrix[i][numVertices] = Double.POSITIVE_INFINITY;
        }
        numVertices++;
    }

    /**
     * ****************************************************************
     * Removes a vertex at the given index from the graph. Note that this may
     * affect the index values of other vertices.
     * ****************************************************************
     */
    @Override
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
     * Remove um user do vertice user
     *
     * @param user
     * @throws exception.EmptyCollectionException
     */
    @Override
    public void removeVertex(T user)  {
        for (int i = 0; i < numVertices; i++) {
            if (user.equals(vertices[i])) {
                removeVertex(i);
                return;
            }
        }
    }

    /**
     * Remove um user do vertice pelo id do user
     *
     * @param id
     */
    public void removeVertexById(long id) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].getID() == id) {
                removeVertex(i);
                return;
            }
        }
    }

    /**
     * Retorna um user pelo id do user
     *
     * @param id
     * @return
     */
    public User getDataById(long id) {

        User p = null;
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].getID() == id) {
                p = vertices[i];
            }
        }
        return p;
    }

    /**
     * return o index da do utilizador no vertice
     *
     * @param user
     * @return ****************************************************************
     */
    @Override
    public int getIndex(T user) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(user)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ****************************************************************
     * Inserts an edge between two vertices of the graph.
     *
     * ****************************************************************
     * @param user1
     * @param user2
     */
    @Override
    public void addEdge(int user1, int user2) {
        if (indexIsValid(user1) && indexIsValid(user2)) {
            adjMatrix[user1][user2] = 1;
            adjMatrix[user2][user1] = 1;
        }
    }

    /**
     * adiciona uma ligação dando dois vertices neste caso utilizadores
     *
     * @param user1
     * @param user2
     * @throws EmptyCollectionException
     */
    @Override
    public void addEdge(T user1, T user2)  {
        addEdge(getIndex(user1), getIndex(user2));
    }

    /**
     * ****************************************************************
     * Removes an edge between two vertices of the graph.
     *
     * **************************************************************** 
     * @param user1
     * @param user2
     */
    @Override
    public void removeEdge(int user1, int user2) {
        if (indexIsValid(user1) && indexIsValid(user2)) {
            adjMatrix[user1][user2] = Double.POSITIVE_INFINITY;
            adjMatrix[user2][user1] = Double.POSITIVE_INFINITY;
        }
    }

    /**
     * remove a ligacao dos vertices(user)
     *
     * @param pessoa1
     * @param pessoa2
     * @throws EmptyCollectionException
     */
    @Override
    public void removeEdge(T user1,T user2) throws EmptyCollectionException {
        removeEdge(getIndex(user1), getIndex(user2));
    }

    
    /**
     * Adiciona uma amizade pelo id de cada utilizador.
     *
     * @param id1
     * @param id2
     * @throws EmptyCollectionException
     */
    public void addEdgeById(long id1, long id2) throws EmptyCollectionException {

        T u1 = null;
        T u2 = null;

        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].getID()== id1) {
                u1 = (T) vertices[i];
            }

        }

        for (int j = 0; j < numVertices; j++) {
            if (vertices[j].getID() == id2) {
                u2 = (T) vertices[j];

            }
        }

        if (u1 != null || u2 != null) {
            addEdge(u1, u2);
        }

    }

    /**
     * Remove uma amizade pelo id de ambas
     *
     * @param id1
     * @param id2
     * @throws EmptyCollectionException
     */
    public void removeEdgeById(long id1, long id2) throws EmptyCollectionException {
        T u1 = null;
        T u2 = null;

        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].getID() == id1) {
                u1 = (T) vertices[i];
            }

        }

        for (int j = 0; j < numVertices; j++) {
            if (vertices[j].getID() == id2) {
                u2 = (T) vertices[j];

            }
        }

        if (u1 != null || u2 != null) {
            removeEdge(u1, u2);
        }
    }

    /**
     * ****************************************************************
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given vertex.
     *
     * **************************************************************** @param
     * startUser
     * @param startUser
     * @param startVertex
     * @return
     */
    @Override
    public Iterator<T> iteratorBFS(T startUser) {
        return iteratorBFS(getIndex(startUser));
    }
    
    public Iterator<T> iteratorBFS(T startUser,int maxValue) {
        return iteratorBFS(getIndex(startUser),maxValue);
    }
    
    
    /**
     * ****************************************************************
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given index.
     *
     * @return ****************************************************************
     */

    @Override
    public Iterator<T> iteratorBFS(int startIndex){
         return iteratorBFS(startIndex,Integer.MAX_VALUE);
    }
    
   
    public Iterator<T> iteratorBFS(int startIndex, int maxLevel) {
        
        
        LinkedQueue<Pair<Integer>> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        
        traversalQueue.enqueue(new Pair(startIndex,0));
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            
            Pair<Integer> elemento = traversalQueue.dequeue();
            int x = elemento.getLeft();
            int level = elemento.getRight();
             
            resultList.addToRear((T) vertices[x]);
            if (level >= maxLevel){
            continue;
            }

            /**
             * Find all vertices adjacent to x that have not been visited and
             * queue them up
             */
            for (int i = 0; i < numVertices; i++) {
                if ((adjMatrix[x][i] < Double.POSITIVE_INFINITY)
                        && !visited[i]) {
                    traversalQueue.enqueue(new Pair<>(i,level+1));
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    /**
     * ****************************************************************
     * Creates new arrays to store the contents of the graph with twice the
     * capacity.
     * ****************************************************************
     */
    @Override
    protected void expandCapacity() {
        User[] largerVertices = new User[vertices.length * 2];
        double[][] largerAdjMatrix
                = new double[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }

        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;
    }

    /**
     * ****************************************************************
     * Returns an iterator that contains the long path between the two vertices.
     *
     * **************************************************************** 
     * @param user1
     * @param user2
     * @return
     */
    @Override
    public Iterator<T> iteratorLongtPath(T user1, T user2) {
        try {
            return iteratorLongtPath(getIndex(user1),
                    getIndex(user2));
        } catch (EmptyCollectionException | ElementNotFoundException ex) {
            Logger.getLogger(Rede.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * ****************************************************************
     * Returns an iterator that contains the shortest path between the two
     * vertices.
     *
     * **************************************************************** 
     * @param user1
     * @param user1
     * @return
     */
    @Override
    public Iterator<T> iteratorShortestPath(T user1, T user2) {
        try {
            return iteratorShortestPath(getIndex(user1),
                    getIndex(user2));
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Rede.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    

    /*
     *return o número de pessoas registadas de uma determinada cidade.
     */

//    public int numHabitantesCity(String city) {
//        int count = 0;
//        for (int i = 0; i < numVertices; i++) {
//            if (vertices[i].getCity().equals(city)) {
//                count++;
//            }
//        }
//
//        return count;
//    }
    
    
    /**
     * ****************************************************************
     * Returns the weight of the least weight path in the network. Returns
     * positive infinity if no path is found.
     *
     * **************************************************************** @param
     * startIndex
     * @param startIndex
     * @param targetIndex
     * @return
     * @throws exception.EmptyCollectionException
     */
    public double longPathWeight(int startIndex, int targetIndex) throws EmptyCollectionException, ElementNotFoundException {
        double result = 0;
        
       
        int index1, index2;
        
        Iterator it = iteratorLongPathIndices(startIndex,
                targetIndex);

        if (it.hasNext()) {
            index1 = ((Integer) it.next()).intValue();
        } else {
            return result;
        }

        while (it.hasNext()) {
            index2 = ((Integer) it.next()).intValue();
            result += adjMatrix[index1][index2];
            index1 = index2;
        }

        return result;
    }

    /**
     * ****************************************************************
     * Returns an iterator that contains the indices of the vertices that are in
     * the long path between the two given vertices.
     *
     * **************************************************************** @param
     * startIndex
     * @param targetIndex
     * @return
     * @throws exception.EmptyCollectionException
     */
    protected Iterator<Integer> iteratorLongPathIndices(int startIndex, int targetIndex) throws EmptyCollectionException, ElementNotFoundException {

        int index;
        double weight;
        int[] predecessor = new int[numVertices];
        LinkedHeap<Double> traversalMinHeap = new LinkedHeap<>();
        ArrayUnorderedList<Integer> arrU = new ArrayUnorderedList<>();
        ArrayOrderedList<Double> resultList = new ArrayOrderedList<>();
        LinkedStack<Integer> stack = new LinkedStack<>();

        int[] pathIndex = new int[numVertices];
        double[] pathWeight = new double[numVertices];

        //adiciona pesos a matrix "0"
        for (int i = 0; i < numVertices; i++) {
            pathWeight[i] = 0;
        }

        //preenche vertices a falso
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) || (startIndex == targetIndex) || isEmpty()) {
            return arrU.iterator();
        }

        pathWeight[startIndex] = 0;
        predecessor[startIndex] = -1;
        visited[startIndex] = true;
        weight = 0;

        /**
         * Update the pathWeight for each vertex except the startVertex. Notice
         * that all vertices not adjacent to the startVertex will have a
         * pathWeight of infinity for now.
         */
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (adjMatrix[startIndex][i] < Double.POSITIVE_INFINITY) {
                    pathWeight[i] = pathWeight[startIndex] + adjMatrix[startIndex][i];

                } else {
                    pathWeight[i] = 0.0;
                }
                predecessor[i] = startIndex;
                resultList.add(pathWeight[i]);

            }
        }

        do {
            weight = resultList.removeLast();

            resultList = new ArrayOrderedList<>();

            if (weight == Double.POSITIVE_INFINITY) // no possible path
            {
                return arrU.iterator();
            } else {
                index = getIndexOfAdjVertexWithWeightOf(visited, pathWeight, weight);
                visited[index] = true;
            }

            /**
             * Update the pathWeight for each vertex that has has not been
             * visited and is adjacent to the last vertex that was visited.
             * Also, add each unvisited vertex to the heap.
             */
            for (int i = 0; i < numVertices; i++) {

                if ((adjMatrix[index][i] < Double.POSITIVE_INFINITY) && !visited[i]) {
                    resultList.add(pathWeight[i]);
                }

                if (!visited[i]) {
                    if ((adjMatrix[index][i] != Double.POSITIVE_INFINITY) && (pathWeight[index] + adjMatrix[index][i]) > pathWeight[i]) {
                        pathWeight[i] = pathWeight[index] + adjMatrix[index][i];
                        predecessor[i] = index;
                    }
                    resultList.add(pathWeight[i]);
                }
            }

        } while (!resultList.isEmpty() && !visited[targetIndex]);

        index = targetIndex;
        stack.push(new Integer(index));
        do {
            index = predecessor[index];
            stack.push(new Integer(index));
        } while (index != startIndex);

        while (!stack.isEmpty()) {
            arrU.addToRear((stack.pop()));

        }

        return arrU.iterator();
    }

    public Iterator<T> iteratorLongtPath(int startIndex, int targetIndex) throws EmptyCollectionException, ElementNotFoundException {
        ArrayUnorderedList templist = new ArrayUnorderedList();
        
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return templist.iterator();
        }

        Iterator<Integer> it = iteratorLongPathIndices(startIndex, targetIndex);
        while (it.hasNext()) {
            templist.addToRear(vertices[(it.next())]);
        }
        return templist.iterator();

    }

    /**
     * ****************************************************************
     * Returns an iterator that contains the indices of the vertices that are in
     * the shortest path between the two given vertices.
     *
     * **************************************************************** @return
     * @return
     * @throws exception.EmptyCollectionException
     */
    @Override
    protected Iterator<Integer> iteratorShortestPathIndices(int startIndex, int targetIndex) throws EmptyCollectionException {
        int index;
        double weight;
        int[] predecessor = new int[numVertices];
        LinkedHeap<Double> traversalMinHeap = new LinkedHeap<>();
        ArrayUnorderedList<Integer> resultList
                = new ArrayUnorderedList<>();
        LinkedStack<Integer> stack = new LinkedStack<>();

        int[] pathIndex = new int[numVertices];
        double[] pathWeight = new double[numVertices];

        for (int i = 0; i < numVertices; i++) {
            pathWeight[i] = Double.POSITIVE_INFINITY;
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)
                || (startIndex == targetIndex) || isEmpty()) {
            return resultList.iterator();
        }

        pathWeight[startIndex] = 0;
        predecessor[startIndex] = -1;
        visited[startIndex] = true;
        weight = 0;

        /**
         * Update the pathWeight for each vertex except the startVertex. Notice
         * that all vertices not adjacent to the startVertex will have a
         * pathWeight of infinity for now.
         */
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                pathWeight[i] = pathWeight[startIndex] + adjMatrix[startIndex][i];
                predecessor[i] = startIndex;
                traversalMinHeap.addElement(new Double(pathWeight[i]));
            }
        }

        do {
            weight = (traversalMinHeap.removeMin()).doubleValue();
            traversalMinHeap.removeAllElements();
            if (weight == Double.POSITIVE_INFINITY) // no possible path
            {
                return resultList.iterator();
            } else {
                index = getIndexOfAdjVertexWithWeightOf(visited, pathWeight,
                        weight);
                visited[index] = true;
            }

            /**
             * Update the pathWeight for each vertex that has has not been
             * visited and is adjacent to the last vertex that was visited.
             * Also, add each unvisited vertex to the heap.
             */
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i]) {
                    if ((adjMatrix[index][i] < Double.POSITIVE_INFINITY)
                            && (pathWeight[index] + adjMatrix[index][i]) < pathWeight[i]) {//<
                        pathWeight[i] = pathWeight[index] + adjMatrix[index][i];
                        predecessor[i] = index;
                    }
                    traversalMinHeap.addElement(new Double(pathWeight[i]));
                }
            }
        } while (!traversalMinHeap.isEmpty() && !visited[targetIndex]);

        index = targetIndex;
        stack.push(new Integer(index));
        do {
            index = predecessor[index];
            stack.push(new Integer(index));
        } while (index != startIndex);

        while (!stack.isEmpty()) {
            resultList.addToRear((stack.pop()));
        }

        return resultList.iterator();
    }

    /**
     * ****************************************************************
     * Returns an iterator that contains the shortest path between the two
     * vertices.
     *
     * @return ********************************************************* @throws
     * exception.EmptyCollectionException
     */
    @Override
    public Iterator<T> iteratorShortestPath(int startIndex, int targetIndex) throws EmptyCollectionException {
        ArrayUnorderedList templist = new ArrayUnorderedList();
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return templist.iterator();
        }

        Iterator<Integer> it = iteratorShortestPathIndices(startIndex,
                targetIndex);
        while (it.hasNext()) {
            templist.addToRear(vertices[(it.next()).intValue()]);
        }
        return templist.iterator();
    }

    /**
     * ****************************************************************
     * Returns the index of the the vertex that that is adjacent to the vertex
     * with the given index and also has a pathWeight equal to weight.
     *
     * **************************************************************** @param
     * visited
     * @param pathWeight
     * @param weight
     * @return
     */
    protected int getIndexOfAdjVertexWithWeightOf(boolean[] visited, double[] pathWeight, double weight) {
        for (int i = 0; i < numVertices; i++) {
            if ((pathWeight[i] == weight) && !visited[i]) {
                for (int j = 0; j < numVertices; j++) {
                    if ((adjMatrix[i][j] < Double.POSITIVE_INFINITY)
                            && visited[j]) {
                        return i;
                    }
                }
            }
        }

        return -1;  // should never get to here
    }

   

    /**
     * ****************************************************************
     * Returns a string representation of the adjacency matrix.
     * ****************************************************************
     */
    @Override
    public String toString() {
        if (numVertices == 0) {
            return "Graph is empty";
        }

        String result = new String("");

        /**
         * Print the adjacency Matrix
         */
        result += "Adjacency Matrix\n";
        result += "----------------\n";
        result += "index\t";

        for (int i = 0; i < numVertices; i++) {
            result += "" + vertices[i].getName();
            if (i < 10) {
                result += " ";
            }
        }
        result += "\n\n";

        for (int i = 0; i < numVertices; i++) {
            result += "" + vertices[i].getName() + "\t";

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] < Double.POSITIVE_INFINITY) {
                    result += "1     ";
                } else {
                    result += "0     ";
                }
            }
            result += "\n";
        }

        /**
         * Print the vertex values
         */
        result += "\n\nVertex id Values";
        result += "\n----------------\n";
        result += "index\tid\tvalue\n\n";

        for (int i = 0; i < numVertices; i++) {
            result += "" + i + "\t";
            result += "" + vertices[i].getID() + "\t";
            result += vertices[i].getName() + "\n";
        }

        /**
         * Print the weights of the edges
         */
        result += "\n\nWeights of Edges";
        result += "\n----------------\n";
        result += "index\tweight\n\n";

        for (int i = 0; i < numVertices; i++) {
            for (int j = numVertices - 1; j > i; j--) {
                if (adjMatrix[i][j] < Double.POSITIVE_INFINITY) {
                    result += vertices[i].getName() + " --- " + vertices[j].getName() + "\t";
                    result += adjMatrix[i][j] + "\n";
                }
            }
        }

        result += "\n";
        return result;
    }


    /**
     * ****************************************************************
     * Returns the weight of the least weight path in the network. Returns
     * positive infinity if no path is found.
     *
     * **************************************************************** @param
     * startVertex
     * @param targetVertex
     * @return
     * @throws exception.EmptyCollectionException
     */
    public double longPathWeight(T startVertex, T targetVertex) throws EmptyCollectionException, ElementNotFoundException {
        return longPathWeight(getIndex(startVertex),
                getIndex(targetVertex));
    }

    /**
     * return o caminnho minimo de amizades de uma dada cidade.
     *
     * @param city
     * @return
     * @throws exception.EmptyCollectionException
     */
    public Rede mstNetwork(String city) throws EmptyCollectionException {

        double adjMatrixTemp[][] = new double[numVertices][numVertices];
        double adjMatrixDefault[][] = new double[numVertices][numVertices];
        adjMatrixDefault = adjMatrix;

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] < Double.POSITIVE_INFINITY && vertices[i].getName().equals(city) && vertices[j].getName().equals(city)) {
                    adjMatrixTemp[i][j] = adjMatrix[i][j];
                } else {
                    adjMatrixTemp[i][j] = Double.POSITIVE_INFINITY;
                }

            }
        }
        adjMatrix = adjMatrixTemp;
        int x, y;
        int index;
        double weight;
        int[] edge = new int[2];
        LinkedHeap<Double> minHeap = new LinkedHeap<>();
        Rede<User> resultGraph = new Rede<>();

        resultGraph.adjMatrix = new double[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                resultGraph.adjMatrix[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        resultGraph.vertices = new User[numVertices];

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        edge[0] = 0;
        resultGraph.vertices[0] = this.vertices[0];
        resultGraph.numVertices++;
        visited[0] = true;

        /**
         * Add all edges, which are adjacent to the starting vertex, to the heap
         */
        for (int i = 0; i < numVertices; i++) {
            minHeap.addElement(new Double(adjMatrix[0][i]));
        }

        while ((resultGraph.size() < this.size()) && !minHeap.isEmpty()) {
            /**
             * Get the edge with the smallest weight that has exactly one vertex
             * already in the resultGraph
             */
            do {
                weight = (minHeap.removeMin()).doubleValue();
                edge = getEdgeWithWeightOf(weight, visited);
            } while (!indexIsValid(edge[0]) || !indexIsValid(edge[1]));

            x = edge[0];
            y = edge[1];
            if (!visited[x]) {
                index = x;
            } else {
                index = y;
            }

            /**
             * Add the new edge and vertex to the resultGraph
             */
            resultGraph.vertices[index] = this.vertices[index];
            visited[index] = true;
            resultGraph.numVertices++;

            resultGraph.adjMatrix[x][y] = this.adjMatrix[x][y];
            resultGraph.adjMatrix[y][x] = this.adjMatrix[y][x];

            /**
             * Add all edges, that are adjacent to the newly added vertex, to
             * the heap
             */
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i] && (this.adjMatrix[i][index]
                        < Double.POSITIVE_INFINITY)) {
                    edge[0] = index;
                    edge[1] = i;
                    minHeap.addElement(adjMatrix[index][i]);
                }
            }
        }
        adjMatrix = adjMatrixDefault;
        return resultGraph;
    }

    /**
     * ****************************************************************
     * Returns the edge with the given weight. Exactly one vertex of the edge
     * must have been visited.
     *
     * **************************************************************** @param
     * weight
     * @param visited
     * @return
     */
    protected int[] getEdgeWithWeightOf(double weight, boolean[] visited) {
        int[] edge = new int[2];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if ((adjMatrix[i][j] == weight) && (visited[i] ^ visited[j])) {
                    edge[0] = i;
                    edge[1] = j;
                    return edge;
                }
            }
        }

        /**
         * Will only get to here if a valid edge is not found
         */
        edge[0] = -1;
        edge[1] = -1;
        return edge;
    }

    public User[] getVertices() {
        return vertices;
    }

    public void setVertices(User[] vertices) {
        this.vertices = vertices;
    }

    /**
     * Check if vertices contains a vertice equal to v.
     *
     * @param v
     * @return true if vertices contains a vertice equal to v
     */
    public boolean checkVertice(User v) {

        User u;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null) {
                u = vertices[i];
                if (u.equals(v)) {
                    return false;
                }
            }

        }
        return true;
    }

}
