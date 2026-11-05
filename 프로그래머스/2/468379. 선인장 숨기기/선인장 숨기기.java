import java.util.*;
class Solution {
    static int M, N, H, W;
    static int MAX;
    static int[][] DROPS;
    static int[][] desert;
    static boolean[][] dropped;
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        M = m; N = n; H = h; W = w; MAX = drops.length;
        DROPS = drops;
        int lastDrop = binarySearch();
        int[][] desert = toArray(lastDrop);
        int[] answer = new int[2];
        int max = drops.length;
        for(int r=0; r<M-H+1; r++){
            for(int c=0; c<N-W+1; c++){
                if(desert[r][c] < max){
                    max = desert[r][c];
                    answer[0] = r;
                    answer[1] = c;
                }
            }
        }
        return answer;
    }
    public int binarySearch(){
        int left = 0;
        int right = DROPS.length - 1;
        int mid = left;
        int result = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            int[][] desert = toArray(mid);
            if(check(desert)){
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public int[][] toArray(int mid){
        int[][] desert = new int[M+1][N+1];
        for(int i=0; i<=mid; i++){
            int dr = DROPS[i][0];
            int dc = DROPS[i][1];
            int sr = Math.max(0, dr-H+1);
            int er = dr;
            int sc = Math.max(0, dc-W+1);
            int ec = dc;
            desert[sr][sc]++;
            desert[sr][ec+1]--;
            desert[er+1][sc]--;
            desert[er+1][ec+1]++;
        }
        for(int r=1; r<=M; r++){
            desert[r][0] += desert[r-1][0];
        }
        for(int c=1; c<=N; c++){
            desert[0][c] += desert[0][c-1];
        }
        for(int r=1; r<=M; r++){
            for(int c=1; c<=N; c++){
                desert[r][c] += desert[r-1][c] + desert[r][c-1] - desert[r-1][c-1];
            }
        }
        return desert;
    }
    public boolean check(int[][] arr){
        for(int r=0; r<M-H+1; r++){
            for(int c=0; c<N-W+1; c++){
                if(arr[r][c] == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkRange(int r, int c){
        return r >= 0 && r < M-H+1 && c >= 0 && c < N-W+1;
    }
}