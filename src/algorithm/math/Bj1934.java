package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1934 { //최소공배수: 유클리드 호제법 이용(최대공약수)
    public static int gcd(int a, int b){
        //재귀법
        if(b == 0) return a;
        return gcd(b, a % b);
        
        /*
        while (b != 0) {
            int r = a % b; // a를 b로 나눈 나머지 r 계산
            a = b;         // b를 새로운 a로 설정
            b = r;         // r을 새로운 b로 설정
        }
        // 나머지가 0이 되었을 때 a가 최대공약수
        return a;
        */
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            // 최소공배수 = 두 수 곱한 값 / 최대공약수
            int result = (a * b) / gcd(a, b);
            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
