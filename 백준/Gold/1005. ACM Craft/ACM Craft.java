import java.io.*;
import java.util.*;

public class Main {
    static int T;   // 테스트 케이스의 수
    static int N;   // 건물의 수
    static int K;   // 건설순서 규칙의 수
    static int W;   // 마지막 건물 번호
    static int[] buildingTime;
    static boolean[][] buildingRule;
    static int[] minimumTime;
    static Node[] nodes;

    static class Node {
        int number;
        boolean visited;
        int degree;
        List<Integer> fromNodes;
        List<Integer> toNodes;
        public Node(int number){
            this.number = number;
            this.visited = false;
            this.degree = 0;
            this.fromNodes = new ArrayList<>();
            this.toNodes = new ArrayList<>();
        }

        @Override
        public String toString(){
            return number + "\n" + fromNodes + "\n" + toNodes;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            buildingTime = new int[N + 1];
            buildingRule = new boolean[N + 1][N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildingTime[i] = Integer.parseInt(st.nextToken());
            }
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                buildingRule[num1][num2] = true;
            }
            W = Integer.parseInt(br.readLine());

            // 문제 풀이
            Queue<Node> queue = new LinkedList<>();
            nodes = new Node[N+1];
            minimumTime = new int[N+1];
            for(int i=1; i<=N; i++){
                Node node = new Node(i);
                List<Integer> toNodes = new ArrayList<>();
                List<Integer> fromNodes = new ArrayList<>();
                for(int j=1; j<=N; j++){
                    if(buildingRule[j][i]){
                        fromNodes.add(j);
                    }
                    if(buildingRule[i][j]){
                        toNodes.add(j);
                    }
                }
                node.fromNodes = fromNodes;
                node.toNodes = toNodes;
                node.degree = fromNodes.size();
                if(fromNodes.isEmpty()){
                    minimumTime[node.number] = buildingTime[node.number];
                    node.visited = true;
                    queue.offer(node);
                }
                nodes[i] = node;
            }
            while(!queue.isEmpty()){
                Node currentNode = queue.poll();
                for(int num : currentNode.fromNodes){
                    Node fromNode = nodes[num];
                    minimumTime[currentNode.number] = Math.max(minimumTime[currentNode.number], minimumTime[fromNode.number] + buildingTime[currentNode.number]);

                }
                for(int num : currentNode.toNodes){
                    Node toNode = nodes[num];
                    toNode.degree -= 1;
                    if(toNode.degree == 0){
                        toNode.visited = true;
                        queue.offer(toNode);
                    }
                }
            }
            bw.write(minimumTime[W] + "\n");
        }
        bw.flush();
    }
}
