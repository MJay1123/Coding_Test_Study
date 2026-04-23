import java.util.*;
class Solution {
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[8];
    static List<Character> list = new ArrayList<>();
    static int count = 0;
    public int solution(int n, String[] data) {
        P(data);
        int answer = count;
        count = 0;
        return answer;
    }
    public void P(String[] data){
        if(list.size() == 8){
            if(check(data)){
                count++;
            }
            return;
        }
        for(int i=0; i<8; i++){
            if(!visited[i]){
                list.add(friends[i]);
                visited[i] = true;
                P(data);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean check(String[] data){
        for(int i=0; i<data.length; i++){
            String str = data[i];
            char A = str.charAt(0);
            char B = str.charAt(2);
            char condition = str.charAt(3);
            int count = str.charAt(4) - '0';
            if(!check(A, B, condition, count)){
                return false;
            }
        }
        return true;
    }
    public boolean check(char A, char B, char condition, int count){
        int index1 = -1;
        int index2 = -1;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == A){
                index1 = i;
            }
            if(list.get(i) == B){
                index2 = i;
            }
        }
        if(condition == '='){
            return Math.abs(index1 - index2) == count + 1;
        } else if(condition == '<'){
            return Math.abs(index1 - index2) < count + 1;
        } else {
            return Math.abs(index1 - index2) > count + 1;
        }
    }
}