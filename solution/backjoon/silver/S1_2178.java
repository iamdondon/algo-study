package solution.backjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class S1_2178 {

    private static int N, M;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    private static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        map = new int[N][M];

        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }

        bfs(map, visited);

        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int[][] map, boolean[][] visited){
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            visited[cx][cy] = true;

            for(int d=0; d<4; d++){
                int nx = cx+dx[d];
                int ny = cy+dy[d];

                if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==0 || visited[nx][ny]){
                    continue;
                }

                map[nx][ny] = map[cx][cy]+1;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

    }
}
