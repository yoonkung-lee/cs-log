package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1929 {
    //에라토스테네스의 체 알고리즘: 에라토스테네스가 고안한 효율적인 소수 판별 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]); //3
        int n = Integer.parseInt(input[1]); //16

        boolean[] isNotPrime = new boolean[n + 1]; // false면 소수
        isNotPrime[0] = isNotPrime[1] = true; // 0과 1은 소수 아님

        for (int i = 2; i * i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}
