package solution.programmers.level1;

public class VideoPlayer {
    public static void main(String[] args) {
        System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        System.out.println(solution("07:22", "04:05",	"00:15", "04:07", new String[]{"next"}));
        System.out.println(solution("30:00", "15:00", "15:10", "15:30", new String[]{"next", "next"}));
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();

        String[] videoArr = video_len.split(":");
        int videoMm = Integer.parseInt(videoArr[0]);
        int videoSs = Integer.parseInt(videoArr[1]);
        int videoLen = videoMm*60+videoSs;

        String[] posArr = pos.split(":");
        int posMm = Integer.parseInt(posArr[0]);
        int posSs = Integer.parseInt(posArr[1]);
        int posLen = posMm*60+posSs;

        String[] opStartArr = op_start.split(":");
        int opStartMm = Integer.parseInt(opStartArr[0]);
        int opStartSs = Integer.parseInt(opStartArr[1]);
        int opStartLen = opStartMm*60+opStartSs;

        String[] opEndArr = op_end.split(":");
        int opEndMm = Integer.parseInt(opEndArr[0]);
        int opEndSs = Integer.parseInt(opEndArr[1]);
        int opEndLen = opEndMm*60+opEndSs;

        for (String command : commands) {
            if (posLen >= opStartLen && posLen <= opEndLen){
                posMm = opEndMm;
                posSs = opEndSs;
                posLen = opEndLen;
            }
            if ("prev".equals(command)) {
                if(posLen <= 10){
                    posMm = 0;
                    posSs = 0;
                } else {
                    posLen -= 10;
                    posMm = posLen / 60;
                    posSs = posLen % 60;
                }
            } else if ("next".equals(command)) {
                if(videoLen - posLen < 10){
                    posMm = videoMm;
                    posSs = videoSs;
                } else {
                    posLen += 10;
                    posMm = posLen / 60;
                    posSs = posLen % 60;
                }
            }

            posLen = posMm*60 + posSs;
        }
        if (posLen >= opStartLen && posLen <= opEndLen){
            posLen = opEndLen;
        }

        posMm = posLen / 60;
        posSs = posLen % 60;

        if(posMm<10) sb.append("0");
        sb.append(posMm).append(":");

        if(posSs<10) sb.append("0");
        sb.append(posSs);

        return sb.toString();
    }
}
