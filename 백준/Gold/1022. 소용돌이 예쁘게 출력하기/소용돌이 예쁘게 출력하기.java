import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        max = Math.max(max, Math.abs(r1));
        max = Math.max(max, Math.abs(c1));
        max = Math.max(max, Math.abs(r2));
        max = Math.max(max, Math.abs(c2));
        arr = new int[r2-r1+1][c2-c1+1];
        int num = 1;
        int r = 0;
        int c = 0;
        int[][] direction = {{0,1},{-1,0},{0,-1},{1,0}};
        int directionIndex = 0;
        int length = 2;
        if(checkRange(r-r1, c-c1, arr)) {
            arr[r-r1][c-c1] = num;
        }
        num++;
        while(true){
            if(r > max && c > max){
                break;
            }
            for(int i=0; i<length/2; i++){
                r += direction[directionIndex][0];
                c += direction[directionIndex][1];
                if(checkRange(r-r1, c-c1, arr)) {
                    arr[r-r1][c-c1] = num;
                }
                num++;
            }
            length++;
            directionIndex = (directionIndex+1)%4;
        }
        int maxNum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<arr.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<arr[0].length; j++){
                maxNum = Math.max(maxNum, arr[i][j]);
                queue.offer(arr[i][j]);
            }
        }
        int numberLength = (maxNum + "").length();
        bw.write(print(arr, queue, numberLength));
        bw.flush();
    }

    public static String print(int[][] arr, Queue<Integer> queue, int length){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                String str = queue.poll() + "";
                while(str.length() < length){
                    str = " " + str;
                }
                sb.append(str);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public static boolean checkRange(int r, int c, int[][] arr){
        return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
    }
}
