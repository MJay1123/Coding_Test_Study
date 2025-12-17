import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);
        for(int i=mats.length-1; i>=0; i--){
            int size = mats[i];
            boolean possible = false;
            for(int r=0; r<park.length; r++){
                for(int c=0; c<park[0].length; c++){
                    if(check(park, size, r, c)){
                        possible = true;
                    }
                }
            }
            if(possible){
                answer = size;
                System.out.println(answer);
            }
            if(answer > 0){
                break;
            }
        }
        return answer;
    }
    public boolean check(String[][] park, int size, int r, int c){
        for(int nr=r; nr<r+size; nr++){
            for(int nc=c; nc<c+size; nc++){
                if(!checkRange(nr, nc, park) || !park[nr][nc].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkRange(int r, int c, String[][] park){
        return r >= 0 && c >= 0 && r < park.length && c < park[0].length;
    }
}