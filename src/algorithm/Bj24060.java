package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj24060 { //병합 정렬1
    /*
     * 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수 구하기
     */

    static int K;               // K번째 저장 횟수
    static int count = 0;       // 저장 카운트
    static int result = -1;     // K번째 저장 값
    static int[] tmp;           // 병합에 사용할 임시 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //배열 A 크기
        int N = Integer.parseInt(st.nextToken());
        // 저장 횟수
        K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        tmp = new int[N]; // 임시 배열 초기화

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(A, 0, N - 1);
        System.out.print(result);
    }

    static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    static void merge(int[] A, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        // 두 부분을 정렬해서 tmp에 저장
        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        // 왼쪽 부분 남은 것
        while (i <= mid) {
            tmp[t++] = A[i++];
        }

        // 오른쪽 부분 남은 것
        while (j <= right) {
            tmp[t++] = A[j++];
        }

        // tmp에서 A에 복사하며 저장 횟수 카운트
        t = 0;
        for (int k = left; k <= right; k++) {
            A[k] = tmp[t++];
            count++;
            if (count == K) {
                result = A[k];
            }
        }
    }
}
