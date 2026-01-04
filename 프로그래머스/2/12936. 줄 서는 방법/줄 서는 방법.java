import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = (int)((k-1) / permutation(n-1-i, n-1-i));
            k = k - permutation(n-1-i, n-1-i) * arr[i];
        }
        boolean[] visited = new boolean[n+1];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        for(int i=0; i<n; i++){
            answer[i] = list.get(arr[i]);
            list.remove(arr[i]);
        }
        return answer;
    }
    
    public long permutation(int n, int r){
        long result = 1;
        for(int i=0; i<r; i++){
            result *= (n-i);
        }
        return result;
    }
}