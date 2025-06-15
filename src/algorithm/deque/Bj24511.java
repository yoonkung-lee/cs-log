package algorithm.deque;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj24511 { //queuestack
    public static void main(String[] args) throws IOException {
        /*
        * 신규 값 삽입 -> pop -> 다음 자료구조로 넘김
        * 이 흐름으로는 stack 자료구조 시, 출력에 영향을 안줌
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 시간 제한 1초인 경우 반복 호출 시 오버헤드 가능성 있음
        int[] structure = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        /*
         * StringTokenizer st = new StringTokenizer(br.readLine());
         * int[] structure = new int[n];
         * for (int i = 0; i < n; i++) structure[i] = Integer.parseInt(st.nextToken());
         */

        int[] values = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 큐(0)인 구조의 초기값만 역순으로 저장
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (structure[i] == 0) {
                deque.addLast(values[i]); //add()도 동일하나 명시적 표현
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int x : input) { //입력된 갯수만큼 출력해야함
            // 새로운 값 뒤에 추가
            deque.addLast(x);
            sb.append(deque.pollFirst()).append(" ");
        }

        System.out.print(sb.toString().trim()); // 마지막 공백 제거
    }
}
