package solution.backjoon.silver;

//import util.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S2_1260 {

    private static int N, M, V;
    private static Graph graph;
    private static HashMap<Integer, Boolean> visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        V = Integer.parseInt(inputs[2]);

        graph = new Graph(N);

        for(int i=0; i<M; i++){
            inputs = br.readLine().split(" ");
            graph.addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }

        for(int i=1; i<=N; i++){
            Collections.sort(graph.getAdjVertex(i));
        }
        visited = new HashMap<>();
        dfs(graph, V, visited);

        System.out.println();
        visited = new HashMap<>();
        bfs(graph, V);
    }

    private static void dfs(Graph graph, int currentVertex, HashMap<Integer, Boolean> visited){
        System.out.print(currentVertex+" ");
        visited.put(currentVertex, true);

        for(int nextVertex : graph.getAdjVertex(currentVertex)){
            if (!visited.containsKey(nextVertex)){
                dfs(graph, nextVertex, visited);
            }
        }
    }

    private static void bfs(Graph graph, int currentVertex){
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(currentVertex);
        visited.put(currentVertex, true);

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current+" ");

            for(int next : graph.getAdjVertex(current)){
                if(!visited.containsKey(next)){
                    queue.offer(next);
                    visited.put(next, true);
                }
            }

        }
    }

    private static class Graph {
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

}
