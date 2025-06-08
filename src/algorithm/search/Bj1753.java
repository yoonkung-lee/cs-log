package algorithm.search;

import java.io.*;
import java.util.*;

public class Bj1753 { //최단경로 탐색
    // 1줄: 정점 V개 -> Node V개, 간선 E개 -> E번 반복
    // 2줄: 시작점 번호
    // Adjacent node
    static List<Node>[] nodeList;
    static int[] visited;
    static Queue<Integer> queue;
    static int startNode;

    private static class Node {
        int toNode;
        int distance;

        public Node(int toNode, int distance) {
            this.toNode = toNode;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] s = in.readLine().split(" ");
        // 공백제거
        // Integer.parseInt(in.readLine().trim());
        nodeList = new List[Integer.parseInt(s[0])];
        System.out.println("Arrays.toString(nodeList) = " + Arrays.toString(nodeList));
        for(int i=0; i<Integer.parseInt(s[1]); i++){
            nodeList[i] = new ArrayList<>();
        }
        visited = new int[Integer.parseInt(s[1])];
        startNode = Integer.parseInt(in.readLine());

        StringTokenizer stk = new StringTokenizer(in.readLine());
        while(stk.hasMoreTokens()){
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int distance = Integer.parseInt(stk.nextToken());
            nodeList[from].add(new Node(to, distance));
        }

        /*
        for (int i = 0; i < lineList.length; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            lineList[from].add(new Node(to, distance));
        }

        for (Integer distance : lineList) {
            if(Integer.MAX_VALUE == minDistance) { // 2147483647
                out.write("INF" + "\n");
                continue;
            }
            out.write(minDistance +"\n");
        }
        */

        out.flush();
        out.close();
    }

    private void bfs(int startNode) {
        queue = new LinkedList<>();
        queue.add(startNode);

    }
}

