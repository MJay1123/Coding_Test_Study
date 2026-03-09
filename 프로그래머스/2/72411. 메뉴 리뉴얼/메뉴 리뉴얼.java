import java.util.*;
class Solution {
    static int N, M;
    static boolean[] menu;
    static boolean[][] dishes;
    static int maxCount;
    static List<String> tempList;
    public List<String> solution(String[] orders, int[] course) {
        N = orders.length;
        M = course.length;
        menu = new boolean[26];
        dishes = new boolean[N][26];
        for(int i=0; i<N; i++){
            for(int j=0; j<orders[i].length(); j++){
                char ch = orders[i].charAt(j);
                int index = ch - 'A';
                menu[index] = true;
                dishes[i][index] = true;
            }
        }
        List<String> answer = new ArrayList<>();
        for(int i=0; i<M; i++){
            int depth = course[i];
            maxCount = 2;
            tempList = new ArrayList<>();
            C(depth, 0, new ArrayList<>());
            for(String str : tempList){
                answer.add(str);
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public static int count(List<Character> list){
        int count = 0;
        for(int i=0; i<N; i++){
            boolean flag = true;
            for(char ch : list){
                if(!dishes[i][ch-'A']){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
    public static void C(int depth, int index, List<Character> list){
        if(list.size() == depth){
            int count = count(list);
            if(count > maxCount){
                maxCount = count;
                tempList.clear();
                StringBuilder sb = new StringBuilder();
                for(char ch : list){
                    sb.append(ch);
                }
                tempList.add(sb.toString());
            } else if(count == maxCount){
                StringBuilder sb = new StringBuilder();
                for(char ch : list){
                    sb.append(ch);
                }
                tempList.add(sb.toString());
            }
            return;
        }
        if(index >= 26){
            return;
        }
        if(menu[index]){
            list.add((char)(index + 'A'));
            C(depth, index+1, list);
            list.remove(list.size()-1);
        }
        C(depth, index+1, list);
    }
}