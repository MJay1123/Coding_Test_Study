import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<N; i++) {
        	hs.add(Integer.parseInt(st.nextToken()));
        }
        int[] arr = new int[hs.size()];
        int index = 0;
        for(int i : hs) {
        	arr[index++] = i;
        }
        Arrays.sort(arr);
        C(arr, 0, new ArrayList<Integer>());
        bw.write(sb.toString());
        bw.flush();
    }
    public static void C(int[] arr, int index, List<Integer> list) {
    	if(list.size() == M) {
    		for(int i=0; i<M; i++) {
    			sb.append(list.get(i)).append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i=index; i<arr.length; i++) {
    		if(list.isEmpty() || list.get(list.size()-1) <= arr[i]) {
    			list.add(arr[i]);
    			C(arr, i, list);
    			list.remove(list.size()-1);
    		}
    	}
    }
}