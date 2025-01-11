package util;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int numOfVertex;
    private List<List<Integer>> adjList;

    public Graph(int numOfVertex){
        this.numOfVertex = numOfVertex;
        this.adjList = new ArrayList<>(numOfVertex);

        for(int i=0; i<=numOfVertex; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int des){
        if(!adjList.get(src).contains(des)) {
            adjList.get(src).add(des);
            adjList.get(des).add(src);
        }
    }

    public List<Integer> getAdjVertex(int vertex){
        return adjList.get(vertex);
    }
}
