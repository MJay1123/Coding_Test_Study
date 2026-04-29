import java.util.*;
class Solution {
    static long total = 0;
    static long[] arr;
    static int l;
    public int solution(int[] queue1, int[] queue2) {
        l = queue1.length;
        arr = new long[l * 2];
        for(int i=0; i<l; i++){
            arr[i] = queue1[i];
            arr[i+l] = queue2[i];
            total += arr[i] + arr[i+l];
        }
        List<int[]> list = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        long sum = arr[0];
        while(true){
            if(sum > total / 2){
                sum -= arr[leftIndex];
                leftIndex++;
            } else if(sum < total / 2){
                rightIndex++;
                if(rightIndex == l*2){
                    break;
                }
                sum += arr[rightIndex];
            } else {
                list.add(new int[]{leftIndex, rightIndex});
                rightIndex++;
                if(rightIndex == l*2){
                    break;
                }
                sum += arr[rightIndex];
                sum -= arr[leftIndex];
                leftIndex++;
            }
        }
        int answer = Integer.MAX_VALUE;
        if(list.size() == 0){
            answer = -1;
        } else {
            for(int[] se : list){
                int s = se[0];
                int e = se[1];
                answer = Math.min(answer, move(s, e));
            }
        }
        return answer;
    }
    public static int move(int s, int e){
        int result = 0;
        if(s < l && e < l || s >= l && e >= l){
            s %= l;
            e %= l;
            if(e == l-1){
                result += s;
            } else {
                result += (e + 1);
                result += l;
                result += s;
            }
        } else {
            result += s;
            result += e % l + 1;
        }
        return result;
    }
}