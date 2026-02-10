import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static int answer;
    static int[][] map;
    static boolean[][] visited;
    static List<Location> houseList, chickenList;
    static class Location {
    	int r;
    	int c;
    	public Location(int r, int c){
    		this.r = r;
    		this.c = c;
    	}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
        answer = 10000;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 1){
                    houseList.add(new Location(r, c));
                } else if(map[r][c] == 2){
                    chickenList.add(new Location(r, c));
                }
            }
        }
        int[] choose = new int[M];
        C(0, choose, 0);
        bw.write(answer + "\n");
        bw.flush();
    }
    public static void C(int index, int[] choose, int depth){
        if(depth == M){
        	int sum = 0;
        	for(Location house : houseList) {
        		sum += getChickenDistance(house, choose);
        	}
        	answer = Math.min(answer, sum);
        	return;
        }
        if(index == chickenList.size()){
            return;
        }
        choose[depth] = index;
        C(index+1, choose, depth+1);
        C(index+1, choose, depth);
    }
    public static int getChickenDistance(Location house, int[] choose) {
        int result = 10000;
        for(int i=0; i<M; i++) {
        	result = Math.min(result, getDistance(house, chickenList.get(choose[i])));
        }
        return result;
    }
    public static int getDistance(Location loc1, Location loc2) {
    	int r1 = loc1.r;
    	int c1 = loc1.c;
    	int r2 = loc2.r;
    	int c2 = loc2.c;
    	return Math.max(r1, r2) - Math.min(r1, r2) + Math.max(c1, c2) - Math.min(c1, c2);
    }
}
