package solution.backjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class S1_1697 {
    private static int N, K;
    private static int[] dn = new int[]{-1, 1, 2};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        if(N==K) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    private static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        int[] time = new int[100001];

        queue.add(N);
        visited[N] = true;
        time[N] = 0;

        while(!queue.isEmpty()){
            int curTime = queue.poll();
            if(curTime == K){
                System.out.println(time[K]);
                return;
            }
            if(curTime+1<=100000 && !visited[curTime+1]){
                time[curTime+1] = time[curTime]+1;
                visited[curTime+1] = true;
                queue.offer(curTime+1);
            }
            if(curTime-1>=0 && !visited[curTime-1]){
                time[curTime-1] = time[curTime]+1;
                visited[curTime-1] = true;
                queue.offer(curTime-1);
            }
            if(curTime*2<=100000 && !visited[curTime*2]){
                time[curTime*2] = time[curTime]+1;
                visited[curTime*2] = true;
                queue.offer(curTime*2);
            }
        }

        System.out.println(-1);
    }
}
