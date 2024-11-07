package baekjoon.silver.iii.n25239;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static boolean[] checked = new boolean[6];
    static int currentTime;
    static int[] recoveryTime = new int[6];
    static int result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L;

        // 시간 입력
        currentTime = changeTime(br.readLine()) % (12 * 60); // 더하는 경우 다 나누기

        // 영역 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            recoveryTime[i] = Integer.parseInt(st.nextToken());
        }

        // 이벤트 수 입력
        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            // 이벤트 입력
            readString(br.readLine());
        }

        for (int i = 0; i < 6; i++) {
            if (checked[i]) continue;
            result += recoveryTime[i];
        }

        if (result >= 100) bw.write(String.valueOf(100));
        else bw.write(String.valueOf(result));
        bw.newLine();

        bw.flush();
        br.close();
        bw.close();
    }

    private static int changeTime(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private static void readString(String s) throws IOException {
        st = new StringTokenizer(s);

        double time = Double.parseDouble(st.nextToken());
        if (time > 60) return;

        String pattern = st.nextToken();
        switch (pattern) {
            case "^":
                lockClock(currentTime);
                break;
            case "10MIN":
                currentTime = (currentTime + 10) % (12 * 60);
                break;
            case "30MIN":
                currentTime = (currentTime + 30) % (12 * 60);
                break;
            case "50MIN":
                currentTime = (currentTime + 50) % (12 * 60);
                break;
            case "2HOUR":
                currentTime = (currentTime + (2 * 60)) % (12 * 60);
                break;
            case "4HOUR":
                currentTime = (currentTime + (4 * 60)) % (12 * 60);
                break;
            case "9HOUR":
                currentTime = (currentTime + (9 * 60)) % (12 * 60);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pattern);
        }
    }

    private static void lockClock(int currentTime) {
        if (currentTime > 0 && currentTime < (2 * 60)) {
            checked[0] = true;
        } else if (currentTime < (4 * 60)) {
            checked[1] = true;
        } else if (currentTime < (6 * 60)) {
            checked[2] = true;
        } else if (currentTime < (8 * 60)) {
            checked[3] = true;
        } else if (currentTime < (10 * 60)) {
            checked[4] = true;
        } else if (currentTime < (12 * 60)) {
            checked[5] = true;
        }
    }
}
