import java.util.*;
class Solution {
    static HashMap<Character, int[]> hm = new HashMap<>();
    public int[] solution(String[] park, String[] routes) {
        int[][] arr = {{-1,0},{1,0},{0,1},{0,-1}};
        hm.put('N', arr[0]);
        hm.put('S', arr[1]);
        hm.put('E', arr[2]);
        hm.put('W', arr[3]);
        Location loc = new Location(0,0);
        for(int r=0; r<park.length; r++){
            for(int c=0; c<park[0].length(); c++){
                if(park[r].charAt(c) == 'S'){
                    loc = new Location(r, c);
                }
            }
        }
        for(int i=0; i<routes.length; i++){
            char direction = routes[i].charAt(0);
            int distance = Integer.parseInt(routes[i].substring(2));
            move(loc, direction, distance, park);
        }
        int[] answer = new int[2];
        answer[0] = loc.r;
        answer[1] = loc.c;
        return answer;
    }
    class Location {
        int r;
        int c;
        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public boolean checkRange(int r, int c, String[] park){
        return r >= 0 && r < park.length && c >= 0 && c < park[0].length();
    }
    public void move(Location loc, char direction, int distance, String[] park){
        int r = loc.r;
        int c = loc.c;
        for(int d=0; d<distance; d++){
            r += hm.get(direction)[0];
            c += hm.get(direction)[1];
            if(!checkRange(r, c, park) || park[r].charAt(c) == 'X'){
                return;
            }
        }
        loc.r = r;
        loc.c = c;
    }
}