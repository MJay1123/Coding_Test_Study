import java.util.*;
import java.io.*;

public class Main {
    static int width;
    static int height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> horizontalCut = new PriorityQueue<>();
        PriorityQueue<Integer> verticalCut = new PriorityQueue<>();
        int cutCount = Integer.parseInt(br.readLine());
        for(int i=0; i<cutCount; i++){
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(direction == 0){
                horizontalCut.offer(num);
            } else {
                verticalCut.offer(num);
            }
        }
        PriorityQueue<Integer> horizontalLength = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> verticalLength = new PriorityQueue<>(Collections.reverseOrder());
        int prev = 0;
        while(!verticalCut.isEmpty()){
            int cut = verticalCut.poll();
            horizontalLength.add(cut - prev);
            prev = cut;
        }
        horizontalLength.add(width - prev);
        prev = 0;
        while(!horizontalCut.isEmpty()){
            int cut = horizontalCut.poll();
            verticalLength.add(cut - prev);
            prev = cut;
        }
        verticalLength.add(height - prev);
        int answer = horizontalLength.peek() * verticalLength.peek();
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}