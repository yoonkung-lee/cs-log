package algorithm.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Bj1269 { // 대칭 차집합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] counts = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int aCount = counts[0];
        int bCount = counts[1];

        // 리팩토링: Stream 방식
        Set<Integer> aSet = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        int sameCount = (int) Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .filter(aSet::contains)
                .count();

        // 기존 로직
        /*int sameCount = 0;
        Set<String> aSet = new HashSet();

        String[] aElements = br.readLine().split(" ");
        String[] bElements = br.readLine().split(" ");

        aSet.addAll(Arrays.asList(aElements));

        for (String element : bElements) {
            if(aSet.contains(element)) sameCount++;
        }*/

        int result = (aCount - sameCount) + (bCount - sameCount);
        System.out.print(result);
    }
}
