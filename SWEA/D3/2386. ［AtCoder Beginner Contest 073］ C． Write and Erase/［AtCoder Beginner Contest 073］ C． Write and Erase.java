import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            HashSet<Integer> hs = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(br.readLine());
                if(!hs.contains(num)){
                    hs.add(num);
                } else {
                    hs.remove(num);
                }
            }
            int answer = hs.size();
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
}