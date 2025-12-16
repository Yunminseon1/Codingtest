import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int min = 256, max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int bestTime = Integer.MAX_VALUE;
        int bestHeight = 0;

        // 모든 높이 시도
        for (int h = min; h <= max; h++) {
            int remove = 0;
            int add = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = map[i][j] - h;
                    if (diff > 0) remove += diff;
                    else add -= diff;
                }
            }

            // 인벤토리 가능 여부
            if (remove + B < add) continue;

            int time = remove * 2 + add;

            // 최소 시간 or 시간 같고 높이 더 큼
            if (time < bestTime || (time == bestTime && h > bestHeight)) {
                bestTime = time;
                bestHeight = h;
            }
        }

        System.out.println(bestTime + " " + bestHeight);
    }
}
