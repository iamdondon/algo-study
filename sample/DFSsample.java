package sample;

import util.Graph;

import java.util.HashMap;

public class DFSsample {
    private static HashMap<Integer, Boolean> visited = new HashMap<>(); // visited를 boolean이 아닌 hashMap으로 관리

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        dfs(4, graph);
    }

    public static void dfs(int curVertex, Graph graph){
        System.out.println(curVertex);
        visited.put(curVertex, true);
        for(int nextVertex : graph.getAdjVertex(curVertex)){
            if(!visited.containsKey(nextVertex)){
                dfs(nextVertex, graph);
            }
        }
    }
}
