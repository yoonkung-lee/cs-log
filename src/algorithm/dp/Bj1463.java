package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1463 { // 다이나믹 프로그래밍 https://www.acmicpc.net/problem/1463
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];
        dp[1] = 0; // 1은 이미 1이므로 0회

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.print(dp[X]);
    }
}
