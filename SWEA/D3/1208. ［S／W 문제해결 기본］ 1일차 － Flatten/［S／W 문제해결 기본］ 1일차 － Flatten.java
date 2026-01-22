import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int test_case = 1; test_case <= 10; test_case++) {
            int dumpCount = Integer.parseInt(br.readLine());
            int[] box = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<100; i++){
                int height = Integer.parseInt(st.nextToken());
                for(int r=1; r<=height; r++){
                    box[r]++;
                }
            }
            int roof = 100;
            while(box[roof] == 0){
                roof--;
            }
            int floor = 1;
            while(box[floor] == 100){
                floor++;
            }
            int count = 0;
            while(count < dumpCount){
                count++;
                box[floor]++;
                if(box[floor] == 100){
                    floor++;
                }
                box[roof]--;
                if(box[roof] == 0){
                    roof--;
                }
            }            
            int answer = roof - floor + 1;
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}