package solution.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class S1_2667 {

    private static int N, block;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        block = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    list.add(bfs(i, j, map, visited));
                    block++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(block);
        for(int e : list){
            System.out.println(e);
        }
    }

    private static int bfs(int x, int y, int[][] map, boolean[][] visited) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int d=0; d<4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]!=0 && !visited[nx][ny]){
                    map[nx][ny] = map[cx][cy] + 1;
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void printMap(int[][] map){
        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
