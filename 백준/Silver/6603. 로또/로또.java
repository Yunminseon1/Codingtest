import java.io.*;
import java.util.*;

public class Main {
    static int arr[], k, result[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;   // ⚠️ 참고: 로또 문제면 보통 0이 종료 조건

            arr = new int[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            back(0, 0);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void back(int depth, int next) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = next; i < k; i++) {
            result[depth] = arr[i];
            back(depth + 1, i + 1);
        }
    }
}
