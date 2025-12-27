import java.util.*;
class Solution {
    static HashSet<Integer> hs = new HashSet<>();
    static boolean[] isPrime;
    public int solution(String numbers) {
        isPrime = new boolean[(int)Math.pow(10, numbers.length())];
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i=2; i<=Math.sqrt(isPrime.length); i++){
            if(!isPrime[i]){
                for(int j=2; i*j<isPrime.length; j++){
                    isPrime[i*j] = true;
                }
            }
        }
        int[] numberArr = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            numberArr[i] = numbers.charAt(i) - '0';
        }
        Arrays.sort(numberArr);
        for(int depth=1; depth<=numberArr.length; depth++){
            boolean[] visited = new boolean[numberArr.length];
            List<Integer> list = new ArrayList<>();
            getNumber(numberArr, visited, list, depth);
        }
        System.out.println(hs);
        int answer = hs.size();
        return answer;
    }
    public void getNumber(int[] numberArr, boolean[] visited, List<Integer> list, int depth){
        if(list.size() == depth){
            int result = 0;
            for(int i=0; i<list.size(); i++){
                result += Math.pow(10, i) * list.get(list.size()-1-i);
            }
            if(!isPrime[result]){
                hs.add(result);
            }
            return;
        }
        for(int i=0; i<numberArr.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            list.add(numberArr[i]);
            getNumber(numberArr, visited, list, depth);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
