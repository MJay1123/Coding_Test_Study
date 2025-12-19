import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hm = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : hm.keySet()){
            pq.offer(i);
        }
        int[][] numbers = new int[3][hm.keySet().size()];
        for(int i=0; i<numbers[0].length; i++){
            int number = pq.poll();
            numbers[0][i] = number;
            numbers[1][i] = hm.get(number);
        }
        choose(numbers, new ArrayList<Integer>(), M);
        bw.write(sb.toString());
        bw.flush();
    }
    public static void choose(int[][] numbers, List<Integer> list, int M){
        if(list.size() == M){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<numbers[0].length; i++){
            if(numbers[1][i] > numbers[2][i]) {
                list.add(numbers[0][i]);
                numbers[2][i]++;
                choose(numbers, list, M);
                list.remove(list.size() - 1);
                numbers[2][i]--;
            }
        }
    }
}
