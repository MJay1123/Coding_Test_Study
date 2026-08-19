import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            int num = Integer.parseInt(br.readLine());
            int[] arr = toArray(num);
            int max = num;
            int min = num;
            for(int i=0; i<arr.length; i++){
                for(int j=i+1; j<arr.length; j++){
					swap(arr, i, j);
                    if(arr[0] != 0){
                        int result = toNumber(arr);
                        max = Math.max(max, result);
                        min = Math.min(min, result);
                    }
                    swap(arr, i, j);
                }
            }
         	sb.append("#").append(tc).append(" ").append(min).append(" ").append(max).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int[] toArray(int num){
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            list.add(num % 10);
            num /= 10;
        }
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(list.size()-1-i);
        }
        return arr;
    }
    public static int toNumber(int[] arr){
        int result = 0;
        for(int i=0; i<arr.length; i++){
            result *= 10;
            result += arr[i];
        }
     	return result;
    }
    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}