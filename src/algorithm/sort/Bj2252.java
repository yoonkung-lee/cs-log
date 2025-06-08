package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2252 {
    public static void main(String[] args) throws  IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int compareM = Integer.parseInt(st.nextToken()); // 비교 횟수

        ArrayList<LinkedList<Integer>> graph = new ArrayList<>(N+1);
        int[] indegree = new int[N+1];

        for(int i=1; i<=N+1; i++){
            graph.add(new LinkedList<>());
        }

        for(int i=1; i<= compareM; i++){
            st = new StringTokenizer(in.readLine());

            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            putEdge(graph, front, back);
            indegree[back]++;
        }

        Queue<Integer> line = new LinkedList<>();
        for(int i=1; i< indegree.length; i++){
            if(indegree[i] == 0){
                line.add(i);
            }
        }

        while(!line.isEmpty()){
            int current = line.poll();
            out.write(current+" ");

            int next = getNext(graph, current);
            if(next > 0){
                indegree[next]--;
                if(indegree[next]==0){
                    line.add(next);
                }
            }
        }
        out.flush();
    }

    public static void putEdge(ArrayList<LinkedList<Integer>> graph, int x, int y){
        graph.get(x).add(y);
    }

    public static int getNext(ArrayList<LinkedList<Integer>> graph, int x){
        if(graph.get(x).isEmpty()) return -1;
        return graph.get(x).peek();
    }
}
