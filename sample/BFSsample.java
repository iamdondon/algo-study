package sample;

import util.Graph;

import java.util.*;

public class BFSsample {
    private static HashMap<Integer, Boolean> visited = new HashMap<>(); // visited를 boolean이 아닌 hashMap으로 관리

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        bfs(4, graph);
    }

    public static void bfs(int startVertex, Graph graph){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(startVertex);
        visited.put(startVertex, true);

        while(!queue.isEmpty()){
            int curVertex = queue.poll();
            System.out.print(curVertex+" ");
            for(int nextVertex : graph.getAdjVertex(curVertex)){
                if(!visited.containsKey(nextVertex)){
                    queue.offer(nextVertex);
                    visited.put(nextVertex, true);
                }
            }
        }
    }
}
