package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj12789 { // 도키도키 간식드리미
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Stack<Integer> waiting = new Stack<>();
        int nowNum = 1;

        for (int student : line) {
            //대기줄 확인
            while (!waiting.isEmpty() && waiting.peek() == nowNum) {
                waiting.pop();
                nowNum++;
            }

            if (student == nowNum) {
                nowNum++;
            } else {
                waiting.push(student);
            }
        }

        while (!waiting.isEmpty() && waiting.peek() == nowNum) {
            waiting.pop();
            nowNum++;
        }

        System.out.print(nowNum == n + 1 ? "Nice" : "Sad");
        //System.out.print(waiting.isEmpty() ? "Nice" : "Sad");
    }
}
