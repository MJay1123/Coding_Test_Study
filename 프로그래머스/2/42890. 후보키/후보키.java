import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        HashSet<Integer> columnsSet = new HashSet<>();
        boolean[][] usedColumns = new boolean[(int)Math.pow(2, relation[0].length)][relation[0].length];
        for(int i=0; i<usedColumns.length; i++){
            int num = i;
            for(int j=0; j<usedColumns[0].length; j++){
                usedColumns[i][relation[0].length-1-j] = num % 2 == 1;
                num /= 2;
            }
        }
        for(int i=0; i<usedColumns.length; i++){
            HashSet<String> hs = new HashSet<>();
            for(int j=0; j<relation.length; j++){
                String data = "";
                for(int k=0; k<usedColumns[0].length; k++){
                    if(usedColumns[i][k]){
                        data += relation[j][k];
                    }
                }
                hs.add(data);
            }
            if(hs.size() == relation.length){
                putIn(columnsSet, i);
            }
        }
        int answer = columnsSet.size();
        return answer;
    }
    
    public void putIn(HashSet<Integer> hs, int num){
        if(hs.size() == 0){
            hs.add(num);
            return;
        }
        for(int i : hs){
            if((i & num) == i || (i & num) == num){
                int temp = Math.min(i, num);
                hs.remove(i);
                hs.add(temp);
                return;
            }
        }
        hs.add(num);
    }
}