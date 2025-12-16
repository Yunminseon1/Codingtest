import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        // 최대값 미리 계산
        int[][] dp = new int[31][31];

        for (int i = 0; i <= 30; i++) {
            dp[0][i] = 1;
            dp[i][i] = 1;
        }

        for (int i = 1; i <= 30; i++) {
            for (int j = i + 1; j <= 30; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(dp[N][M]);
        }
    }
}
