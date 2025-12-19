import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean cycle = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = -1;
        }
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            union(num1, num2, arr);
            if(cycle){
                bw.write(i + "\n");
                break;
            }
        }
        if(!cycle){
            bw.write(0 + "\n");
        }
        bw.flush();
    }
    public static void union(int num1, int num2, int[] arr){
        int root1 = findRoot(num1, arr);
        int root2 = findRoot(num2, arr);
        if(root1 == root2){
            cycle = true;
            return;
        }
        if(arr[root1] <= arr[root2]){
            arr[root1]--;
            arr[root2] = root1;
        } else {
            arr[root2]--;
            arr[root1] = root2;
        }
    }
    public static int findRoot(int num, int[] arr){
        while(true){
            if(arr[num] < 0){
                break;
            }
            num = arr[num];
        }
        return num;
    }
}
