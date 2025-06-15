package algorithm.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Bj28279 { //덱2
    public static void main(String[] args) throws IOException {
        /*
        * 정수를 저장하는 덱 구현
        * 입력으로 주어지는 명령을 처리
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>(n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int[] ints = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            switch (ints[0]) {
                case 1: deque.addFirst(ints[1]); break;
                case 2: deque.addLast(ints[1]); break;
                case 3: sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n'); break;
                case 4: sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n'); break;
                case 5: sb.append(deque.size()).append('\n'); break;
                case 6: sb.append(deque.isEmpty() ? 1 : 0).append('\n'); break;
                case 7: sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n'); break;
                case 8: sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n'); break;
            }
        }
        System.out.print(sb);
    }
}
