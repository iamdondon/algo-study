package solution.backjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class G5_7569 {
    private static int X, Y, Z, answer;
    private static int[][][] tomatos;

    private static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1, 0, 0};
    private static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    private static ArrayDeque<Point> queue;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        Y = Integer.parseInt(inputs[0]);
        X = Integer.parseInt(inputs[1]);
        Z = Integer.parseInt(inputs[2]);

        tomatos = new int[Z][X][Y];
        queue = new ArrayDeque<>();

        for(int z=0; z<Z; z++){
            for(int x=0; x<X; x++){
                inputs = br.readLine().split(" ");
                for(int y=0; y<Y; y++){
                    tomatos[z][x][y] = Integer.parseInt(inputs[y]);
                }
            }
        }

        for(int z=0; z<Z; z++){
            for(int x=0; x<X; x++){
                for(int y=0; y<Y; y++){
                    if(tomatos[z][x][y] == 1){
                        queue.add(new Point(z, x, y));
                    }
                }
            }
        }

        bfs();
        checkTomatos();
    }

    private static void checkTomatos() {
        int answer = 0;

        for(int z=0; z<Z; z++){
            for(int x=0; x<X; x++){
                for(int y=0; y<Y; y++){
                    if(tomatos[z][x][y] == 0){
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, tomatos[z][x][y]);
                }
            }
        }

        if(answer == 1) System.out.println(0);
        else System.out.println(answer-1);
    }

    private static void bfs() {
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int cz = cur.getZ();
            int cx = cur.getX();
            int cy = cur.getY();

            for(int d=0; d<6; d++){
                int nz = cz + dz[d];
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx>=0 && ny>=0 && nz>=0 && nx<X && ny<Y && nz<Z && tomatos[nz][nx][ny]==0){
                    tomatos[nz][nx][ny] = tomatos[cz][cx][cy]+1;
                    queue.add(new Point(nz, nx, ny));
                }
            }
        }
    }

    static class Point{
        private int x, y, z;

        public Point(int z, int x, int y){
            this.z = z;
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }
}
