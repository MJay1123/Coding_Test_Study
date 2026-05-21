import java.util.*;
import java.io.*;
class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String number = st.nextToken();
            List<Character> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                if(list.size() == 0){
                    list.add(number.charAt(i));
                } else {
                    if(list.get(list.size() - 1) == number.charAt(i)){
                        list.remove(list.size() - 1);
                    } else {
                        list.add(number.charAt(i));
                    }
                }
            }
			sb.append("#").append(test_case).append(" ");
            for(char ch : list){
                sb.append(ch);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}