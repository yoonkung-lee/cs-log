package algorithm.recursion;

import java.util.*;

public class Bj16198 {
    static int maxEnergy = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 구슬 개수
        List<Integer> balls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            balls.add(sc.nextInt());
        }

        dfs(balls, 0);  // 초기 에너지 0으로 시작
        System.out.print(maxEnergy);
    }

    static void dfs(List<Integer> balls, int energy) {
        int size = balls.size();

        if (size == 2) {  // 양 끝만 남았을 때 종료
            maxEnergy = Math.max(maxEnergy, energy);
            return;
        }

        for (int i = 1; i < size - 1; i++) {  // 양 끝 제외한 구슬 선택
            int gained = balls.get(i - 1) * balls.get(i + 1);  // 에너지 계산
            int removed = balls.remove(i);  // 구슬 제거
            dfs(balls, energy + gained);  // 다음 단계로 재귀
            balls.add(i, removed);  // 원상복구 (백트래킹)
        }
    }
}
