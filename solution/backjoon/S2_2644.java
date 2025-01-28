package solution.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S2_2644 {
    private static int N, M, x, y;
    private static Graph graph;
    private static int answer = -1;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new Graph(N);
        visited = new boolean[N+1];

        String[] inputs = br.readLine().split(" ");
        int p1 = Integer.parseInt(inputs[0]);
        int p2 = Integer.parseInt(inputs[1]);

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            inputs = br.readLine().split(" ");
            x = Integer.parseInt(inputs[0]);
            y = Integer.parseInt(inputs[1]);
            graph.addEdge(x, y);
        }

        dfs(graph, visited, p1, p2, 0);

        System.out.println(answer);
    }

    private static void dfs(Graph graph, boolean[] visited, int p1, int p2, int depth) {
        depth++;

        for(int next : graph.getAdjVertex(p1)){
            if(next == p2){
                answer = depth;
                return;
            }

            if (!visited[next]){
                visited[next] = true;
                dfs(graph, visited, next, p2, depth);
            }
        }
    }

    private static void printGraph(Graph graph) {
        for(int i=1; i<=N; i++){
            System.out.print(i+" : ");
            for(int child : graph.getAdjVertex(i)){
                System.out.print(child + " ");
            }
            System.out.println();
        }
    }

    static class Graph{
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
            if (!adjList.get(src).contains(des)){
                adjList.get(src).add(des);
                adjList.get(des).add(src);
            }
        }

        public List<Integer> getAdjVertex(int vertex){
            return adjList.get(vertex);
        }
    }
}
