package solution.programmers.level1;

import java.util.Arrays;

public class Park {


    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,5,3}, new String[][]{
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
        {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                    {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        }));
    }

    public static int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);

        for(int i = mats.length-1; i>=0; i--){
            int matLen = mats[i];

            for(int x=0; x<park.length-i; x++){
                for(int y=0; y<park[0].length; y++){
                    boolean chk = true;
                    if(park[x][y].equals("-1")){
                        for(int dx=0; dx<matLen; dx++){
                            for (int dy=0; dy<matLen; dy++){
                                if(x+dx >= park.length || y+dy >= park[0].length || !park[x+dx][y+dy].equals("-1")) {
                                    chk = false;
                                    break;
                                }
                            }
                            if(!chk) break;
                        }
                        if(chk) return matLen;
                    }
                }
            }
        }

        return answer;
    }


}
