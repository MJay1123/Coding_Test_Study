import java.util.*;
class Solution {
    static String[] cache;
    static int[] usedIndex;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        cache = new String[cacheSize];
        usedIndex = new int[cacheSize];
        Arrays.fill(usedIndex, -1);
        for(int i=0; i<cities.length; i++){
            String city = cities[i];
            answer += checkCache(city, i);
        }
        return answer;
    }
    public static int checkCache(String city, int index){
        if(cache.length == 0){
            return 5;
        }
        int LRUindex = 0;
        for(int i=0; i<cache.length; i++){
            if(cache[i] != null && cache[i].equalsIgnoreCase(city)){
                usedIndex[i] = index;
                return 1;   // cache hit
            }
            if(usedIndex[LRUindex] > usedIndex[i]){
                LRUindex = i;
            }
        }
        cache[LRUindex] = city;
        usedIndex[LRUindex] = index;
        return 5;   // cache miss
    }
}