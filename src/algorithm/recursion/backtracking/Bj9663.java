package algorithm.recursion.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9663 { // N-Queen (백트래킹) https://www.acmicpc.net/problem/9663
    static int N;
    static int count = 0;
    static int[] board; // board[i] = i번째 행에서 퀸이 놓인 열 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        solve(0); // 0번째 행부터 시작
        System.out.print(count);
    }

    static void solve(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            board[row] = col;
            if (isSafe(row)) {
                solve(row + 1);
            }
        }
    }

    static boolean isSafe(int row) { // 재귀
        for (int i = 0; i < row; i++) {
            // 같은 열에 있거나, 대각선에 있으면 false
            if (board[i] == board[row] || Math.abs(board[row] - board[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
