import java.util.*;
import java.io.*;

class Solution {
    static int a, b;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            String str = br.readLine();
            a = 1;
            b = 1;
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(ch == 'L'){
                    b += a;
                } else {
                    a += b;
                }
            }
            sb.append("#").append(tc).append(" ").append(a).append(" ").append(b).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}