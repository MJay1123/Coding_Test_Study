import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int[][] array = makeArray(n, w);
        
        array = reverseArray(array);
        
        int[] index = getIndex(num, array);
        for(int i=0; i<=index[0]; i++){
            if(array[i][index[1]] != 0){
                answer++;
            }
        }
        
        return answer;
    }
    
    public static int[] getIndex(int num, int[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                if(num == array[i][j]){
                    int[] location = new int[2];
                    location[0] = i;
                    location[1] = j;
                    return location;
                }
            }
        }
        return null;
    }
    
    
    public static int[][] reverseArray(int[][] array){
        for(int i=0; i<array.length; i++){
            if(i%2 == 0){
                int[] temp = new int[array[i].length];
                for(int j=0; j<temp.length; j++){
                    temp[j] = array[i][array[i].length-1-j];
                }
                for(int j=0; j<temp.length; j++){
                    array[i][j] = temp[j];
                }
            }
        }
        return array;
    }
    
    public static int[][] makeArray(int n, int w){
        int[][] array = new int[(n/w)+1][w];
        int x = 1;
        for(int i=array.length-1; i>=0; i--){
            for(int j=0; j<array[0].length; j++){
                array[i][j] = x;
                x++;
                if(x > n){
                    return array;
                }
            }
        }
        return array;
    }
}