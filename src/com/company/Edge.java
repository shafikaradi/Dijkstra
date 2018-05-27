package com.company;

public class Edge {

    private int weight;
    private Node node;

    public Edge(Node node, int weight){
        this.node = node;
        this.weight = weight;
    }

    public Edge(int weight){

        this.weight = weight;
    }

    public void addNodeToEdge(Node node){

        this.node = node;
    }

    public Node getNode(){
        return node;
    }

    public int getWeight(){
        return weight;
    }


}
