import java.util.*;
import java.io.*;

public class Main {
    static int height, width;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(br.readLine());
        int[][] location = new int[count+1][2];
        for(int i=0; i<=count; i++){
            st = new StringTokenizer(br.readLine());
            location[i][0] = Integer.parseInt(st.nextToken());
            location[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] myLoc = getLocation(location[count][0], location[count][1]);
        int answer = 0;
        for(int i=0; i<count; i++){
            int[] storeLoc = getLocation(location[i][0], location[i][1]);
            int distance = getDistance(storeLoc, myLoc);
            distance = Math.min(distance, width * 2 + height * 2 - distance);
            answer += distance;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
    public static int[] getLocation(int loc, int dist){
        int[] arr = new int[2];
        switch(loc){
            case 1:     // North
                arr[0] = 0;
                arr[1] = dist;
                break;
            case 2:     // South
                arr[0] = height;
                arr[1] = dist;
                break;
            case 3:     // West
                arr[0] = dist;
                arr[1] = 0;
                break;
            case 4:     // East
                arr[0] = dist;
                arr[1] = width;
                break;
        }
        return arr;
    }
    public static int getDistance(int[] arr1, int[] arr2){
        if((arr1[0] == 0 || arr1[0] == height) && arr1[0] == arr2[0]){
            return Math.abs(arr1[1] - arr2[1]);
        }
        if((arr1[1] == 0 || arr1[1] == width) && arr1[1] == arr2[1]){
            return Math.abs(arr1[0] - arr2[0]);
        }
        int result = 0;
        if((arr1[0] == 0 || arr1[1] == width) && ((arr2[0] == 0 || arr2[1] == width))){
            result = Math.abs((arr1[0] + arr1[1]) - (arr2[0] + arr2[1]));
        } else if((arr1[0] == height || arr1[1] == 0) && (arr2[0] == height || arr2[1] == 0)){
            result = Math.abs((arr1[0] + arr1[1]) - (arr2[0] + arr2[1]));
        } else {
            result = arr1[0] + arr1[1] + arr2[0] + arr2[1];
        }
        return result;
    }
}