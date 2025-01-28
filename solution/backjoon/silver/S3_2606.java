package solution.backjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S3_2606 {
    private static int N, M, answer;
    private static Graph graph;
    private static HashMap<Integer, Boolean> visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        answer = 0;

        graph = new Graph(N);
        visited = new HashMap<>();

        for(int i=0; i<M ;i++){
            String[] edges = br.readLine().split(" ");
            graph.addEdge(Integer.parseInt(edges[0]), Integer.parseInt(edges[1]));
        }

        dfs(graph, visited, 1);

        System.out.println(answer);
    }

    private static void dfs(Graph graph, HashMap<Integer, Boolean> visited, int vertex) {
        visited.put(vertex, true);

        for(int next : graph.getAdjVertex(vertex)){
            if(!visited.containsKey(next)){
                dfs(graph, visited, next);
                answer++;
            }
        }
    }

    static class Graph {
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
