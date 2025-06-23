package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15649 { // 백트레킹 - N과 M (1)
    static int N, M;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 1 ~ N 까지
        M = Integer.parseInt(st.nextToken()); // 한 줄별 출력 갯수

        result = new int[M];
        // 방문 체크
        visited = new boolean[N+1];

        backtrack(0);
        System.out.print(sb);
    }

    static void backtrack(int depth) {
        // 수열 길이가 M이면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 1부터 N까지 순회
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;         // 숫자 사용
                result[depth] = i;         // 현재 위치에 저장
                backtrack(depth + 1);      // 다음 자리로
                visited[i] = false;        // 백트래킹 (복구)
            }
        }
    }
}
