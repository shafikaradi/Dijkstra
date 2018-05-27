package com.company;

import java.util.HashMap;

public class Graph {

    private Node<String> entryPoint;
    private HashMap <String, Node> nodeHashMap;


    public Graph(){
        nodeHashMap = new HashMap<>();
        buildGraph();


    }

    public Graph(String key){
        nodeHashMap = new HashMap<>();
        buildGraph();
        entryPoint = nodeHashMap.get(key);
    }



    private void buildGraph(){

        Node <String> aNode = new Node<>("9164167093");
        nodeHashMap.put("9164167093", aNode);

        Node <String> bNode = new Node<>("9154356452");
        nodeHashMap.put("9154356452", bNode);

        Node <String> cNode = new Node<>("9264367433");
        nodeHashMap.put("9264367433", cNode);

        Node <String> dNode = new Node<>("9251293844");
        nodeHashMap.put("9251293844", dNode);

        Edge firstEdge = new Edge(1);
        Edge secondEdge = new Edge(2);

        aNode.addEdge(firstEdge);
        aNode.addEdge(secondEdge);

        firstEdge.addNodeToEdge(bNode);
        secondEdge.addNodeToEdge(cNode);

        Edge thirdEdge = new Edge(2);
        Edge fourthEdge = new Edge(1);
        Edge fifthEdge = new Edge(3);

        bNode.addEdge(thirdEdge);
        bNode.addEdge(fourthEdge);

        cNode.addEdge(fifthEdge);

        thirdEdge.addNodeToEdge(cNode);
        fourthEdge.addNodeToEdge(dNode);

        fifthEdge.addNodeToEdge(dNode);


    }

    public Graph getNodeAsEntryPoint(String key){

        entryPoint = nodeHashMap.get(key);

        return this;
    }

    public void findShortestPath(String targetNode){

        int counter = entryPoint.counter();

        if(entryPoint.counter() == 0){

            System.out.println(String.format("The end of the graph has been reached at key %s", entryPoint.getKey()));
            return;
        }else if(entryPoint.counter() == 1){

            Edge edge = entryPoint.getEdges(0);
            entryPoint = edge.getNode();
            entryPoint.addWeight(edge);

            if(entryPoint.getKey().equals(targetNode)) {
                System.out.println(String.format("The key has been found in this road at key %s",entryPoint.getKey()));
                return;
            }

            if(counter == 1){
                findShortestPath(targetNode);
            }

        }else if(entryPoint.counter() > 1){

            Edge edge;

            for(int i = 0; i < counter; i++){

                 if (entryPoint.getAccumulatedWeights() == 0){

                     edge = entryPoint.getEdges(i);
                     entryPoint = edge.getNode();
                     entryPoint.addWeight(edge);

                     if(entryPoint.getKey().equals(targetNode)) {
                         System.out.println(String.format("The key has been found in this road"));
                         return;
                     }

                 }else{

                     edge = entryPoint.getEdges(i);

                     if(entryPoint.getKey().equals(targetNode)) {
                         System.out.println(String.format("The key has been found in this road"));
                         return;
                     }

                     if(edge.getWeight() < entryPoint.getAccumulatedWeights()){


                         entryPoint = edge.getNode();
                         entryPoint.addWeight(edge);
                     }

                     if(i+1 == counter){
                         findShortestPath(targetNode);
                     }



                 }

            }

        }
        return;
    }

}
