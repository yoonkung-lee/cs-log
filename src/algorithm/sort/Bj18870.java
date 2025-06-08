package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Bj18870 { // 좌표 압축
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /*
         * 1) 같은 값은 같은 좌표로
         * 2) 작은 수일수록 더 작은 좌표값
         * */

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 새로운 객체, 중복제거, 정렬
        int[] sortedUnique = Arrays.stream(inputs)
                .distinct()
                .sorted()
                .toArray();

        /*
        * sort = arr.clone(); Arrays.copyOf(arr,arr.length);
        * Arrays.sort(sort);
        * */

        // 숫자별 인덱스 정보 저장
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sortedUnique.length; i++) {
            indexMap.put(sortedUnique[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : inputs) {
            sb.append(indexMap.get(num)).append("\n");
        }

        System.out.print(sb);
    }
}
