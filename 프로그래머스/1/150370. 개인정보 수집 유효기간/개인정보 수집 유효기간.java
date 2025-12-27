import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayDate = getDate(today);
        int[] termsArray = new int[26];
        for(int i=0; i<terms.length; i++){
            int index = terms[i].charAt(0) - 'A';
            int term = Integer.parseInt(terms[i].split(" ")[1]) * 28;
            termsArray[index] = term;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            int startDate = getDate(privacies[i].split(" ")[0]);
            int categoryIndex = privacies[i].charAt(11) - 'A';
            int period = termsArray[categoryIndex];
            if(todayDate >= startDate + period){
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int getDate(String date){
        String[] arr = date.split("\\.");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        return year * 12 * 28 + month * 28 + day;
    }
}