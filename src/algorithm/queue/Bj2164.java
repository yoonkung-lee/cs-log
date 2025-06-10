package algorithm.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2164 { // 카드2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        long start = System.currentTimeMillis();
//        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= cnt; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

//        System.out.print(queue.poll());

        long end = System.currentTimeMillis();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.out.println("===== LinkedList =====");
        System.out.println("===== ArrayDeque =====");
        System.out.println("사용 메모리 : " + (double)usedMemory/1024/1024 + "MB");
        System.out.println("걸린 시간 : " + (end - start)+"ms");
    }
}
