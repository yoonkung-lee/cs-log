package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2798 { //브루트포스
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());


        int n = Integer.parseInt(st.nextToken()); // 카드 갯수
        int m = Integer.parseInt(st.nextToken()); // 목표 합

        st = new StringTokenizer(in.readLine());
        int[] deck = new int[n];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = Integer.parseInt(st.nextToken());
        }

        int maxTotal = 0;
        //반복 범위 최적화
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int total = deck[i] + deck[j] + deck[k];
                    if(total <= m && total > maxTotal) {maxTotal = total;}

                }
            }
        }

        //반복 제한이 없어 중복 범위 제외 조건 필요
        /*for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(i < j && j < k) {
                        int total = deck[i] + deck[j] + deck[k];
                        if(total <= m && total > maxTotal) {maxTotal = total;}
                    }
                }
            }
        }*/
        System.out.println(maxTotal);
    }
}
