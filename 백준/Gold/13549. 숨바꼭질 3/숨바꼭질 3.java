
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 3
public class Main {
    static int N;                           // 수빈
    static int K;                           // 동생
    static int[] time;                      // 시간 배열
    static boolean[] visited;               // 방문 배열
    static int[] move = {-1, 1};            // 한 칸씩 이동
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
        // 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
        if(K <= N){
            bw.write(N-K + "\n");
        } else {
            time = new int[K+10];                    // K+1까지의 시간을 담아야 됨
            visited = new boolean[K+10];
            bfs(N);
            bw.write(time[K] + "\n");
        }
        bw.flush();
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int currentLocation = queue.poll();
            int temp = currentLocation;
            while(temp!=0){
                temp *= 2;
                if(!checkRange(temp)){
                    break;
                }
                if(!visited[temp]){
                    queue.add(temp);
                    visited[temp] = true;
                    time[temp] = time[currentLocation];
                }
            }
            for(int i=0; i<2; i++){
                int newLocation = currentLocation + move[i];
                if(checkRange(newLocation) && !visited[newLocation]){
                    queue.add(newLocation);
                    visited[newLocation] = true;
                    time[newLocation] = time[currentLocation]+1;
                }
            }
        }
    }

    public static boolean checkRange(int num){
        return(num >= 0 && num < K+2);
    }
}
