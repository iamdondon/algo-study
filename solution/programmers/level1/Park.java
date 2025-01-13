package solution.programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class Park {

    public static void main(String[] args) {

    }

    private int[] dx = new int[]{0, 0, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0};

    public static int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);

        for(int i = mats.length-1; i>0; i--){
            int matLen = mats[i];

            for(int x=0; x<park.length; x++){
                for(int y=0; y<park[0].length; y++){
                    if(!park[x][y].equals("-1")) continue;

                    dfs(x, y, mats, matLen);
                }
            }
        }

        return answer;
    }

    private static void dfs(int x, int y, int[] mats, int matLen) {

    }
}
