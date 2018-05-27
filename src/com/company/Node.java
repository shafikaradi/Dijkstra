package com.company;

public class Node <T>{


    private Edge edges [];
    private int counter = 0;
    private int accumulatedWeights = 0;
    private Object key;

    public Node(T key){
        edges = new Edge[5];
        this.key = (T) key;
    }

    public void addEdge(Edge edge){

        this.edges[counter++] = edge;
    }

    public int counter(){
        return this.counter;
    }

    public T getKey(){
        return (T) key;
    }

    public Edge getEdges(int index) {
        return edges[index];
    }

    public int getAccumulatedWeights(){
        return accumulatedWeights;
    }

    public void addWeight(Edge edge){
        accumulatedWeights+=edge.getWeight();
    }
}
