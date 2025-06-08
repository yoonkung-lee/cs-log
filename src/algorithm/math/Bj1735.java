package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1735 { // 기약분수
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken()); // 첫 번째 분자
        int deno1 = Integer.parseInt(st.nextToken()); // 첫 번째 분모

        st = new StringTokenizer(br.readLine());
        int num2 = Integer.parseInt(st.nextToken()); // 두 번째 분자
        int deno2 = Integer.parseInt(st.nextToken()); // 두 번째 분모

        int totalNum = num1 * deno2 + num2 * deno1;
        int totalDeno = deno1 * deno2;

        // 음수 가능성으로 절댓값 처리 필요
        int gcd = gcd(Math.abs(totalNum), totalDeno);
        System.out.print((totalNum / gcd) + " " + (totalDeno / gcd));
    }
}
