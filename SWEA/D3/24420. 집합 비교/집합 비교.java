import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ASize = Integer.parseInt(st.nextToken());
            int BSize = Integer.parseInt(st.nextToken());
            int[] A = new int[ASize];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<ASize; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            int[] B = new int[BSize];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<BSize; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
            if(ASize == BSize){
                if(compareTwo(A, B)){
                    bw.write("=");
                } else {
                    bw.write("?");
                }
            } else if(ASize > BSize){
                if(compareTwo(B, A)){
                    bw.write(">");
                } else {
                    bw.write("?");
                }
            } else {
                if(compareTwo(A, B)){
                    bw.write("<");
                } else {
                    bw.write("?");
                }   
            }
            bw.write("\n");
		}
        bw.flush();
	}
    public static boolean compareTwo(int[] smallerArray, int[] largerArray){
        for(int i=0; i<smallerArray.length; i++){
            boolean exist = false;
            for(int j=0; j<largerArray.length; j++){
                if(smallerArray[i] == largerArray[j]){
                    exist = true;
                    break;
                }
            }
            if(exist){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}