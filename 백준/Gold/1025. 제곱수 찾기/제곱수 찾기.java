import java.io.*;
import java.util.*;

public class Main {
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] arr = new String[N][M];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine().split("");
        }
        List<String> result = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                getNumber(arr, result, i, j);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> squareNumber = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<=100000; i++){
            if(i * i <= 999999999){
                squareNumber.offer(i*i);
            } else {
                break;
            }
        }
        for(int i=0; i<result.size(); i++){
            pq.offer(Integer.parseInt(result.get(i)));
        }
        while(!pq.isEmpty()){
            int num = pq.poll();
            while(squareNumber.peek() > num){
                squareNumber.poll();
            }
            if(squareNumber.peek() == num){
                answer = num;
                break;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void getNumber(String[][] arr, List<String> result, int rs, int cs){
        result.add(arr[rs][cs]);
        for(int dr = -8; dr <= 8; dr++){
            for(int dc = -8; dc <= 8; dc++){
                if(dr == 0 && dc == 0){
                    continue;
                }
                int r = rs;
                int c = cs;
                StringBuilder sb = new StringBuilder();
                sb.append(arr[r][c]);
                while(checkRange(arr, r+dr, c+dc)){
                    r += dr;
                    c += dc;
                    sb.append(arr[r][c]);
                    result.add(sb.toString());
                }
            }
        }
    }

    public static boolean checkRange(String[][] arr, int r, int c){
        return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
    }
}

