package algorithm.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Bj7785 {//출퇴근 로그로 현재 회사에 있는 사람 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 자동 정렬 제공(오름차순)
        Set<String> company = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] params = br.readLine().split("\\s");
            String name = params[0];
            String log = params[1];

            if("enter".equals(log)) {
                company.add(name);
            } else {
                company.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : ((TreeSet<String>) company).descendingSet()) {
            sb.append(name).append('\n');
        }
        System.out.print(sb);
    }
}
