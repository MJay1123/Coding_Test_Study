import java.util.*;
class Solution {
    static class Tuple implements Comparable<Tuple>{
        int index;
        int[] data;
        public Tuple(int index, int[] data){
            this.index = index;
            this.data = data;
        }
        @Override
        public int compareTo(Tuple t){
            if(this.data[COL-1] != t.data[COL-1]){
                return this.data[COL-1] - t.data[COL-1];
            }
            return t.data[0] - this.data[0];
        }
    }
    static int COL;
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        COL = col;
        Tuple[] tuples = new Tuple[data.length];
        for(int i=0; i<data.length; i++){
            tuples[i] = new Tuple(i, data[i]);
        }
        Arrays.sort(tuples);
        int answer = 0;
        for(int i=row_begin-1; i<=row_end-1; i++){
            answer = (answer ^ get(i, tuples[i]));
        }
        return answer;
    }
    public int get(int index, Tuple t){
        int sum = 0;
        for(int i : t.data){
            sum += i % (index+1);
        }
        return sum;
    }
}