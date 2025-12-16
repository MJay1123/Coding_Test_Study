import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = (n-1) / w + 1;
        int[][] array = new int[h][w];
        int number = 1;
        int numR = 0;
        int numC = 0;
        for(int i=1; i<=h; i++){
            int r = h-i;
            if(i % 2 == 1){     // 정방향
                for(int c=0; c<w; c++){
                    array[r][c] = number;
                    if(number == num){
                        numR = r;
                        numC = c;
                    }
                    number++;
                }
            } else {            // 역방향
                for(int c=w-1; c>=0; c--){
                    array[r][c] = number;
                    if(number == num){
                        numR = r;
                        numC = c;
                    }
                    number++;
                }
            }
        }
        for(int r=0; r<=numR; r++){
            if(array[r][numC] > n){
                continue;
            }
            answer++;
        }
        return answer;
    }
}