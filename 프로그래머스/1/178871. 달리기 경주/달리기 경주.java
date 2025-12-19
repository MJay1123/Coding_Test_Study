import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }
        for (String name : callings) {
            pass(name, playerMap, players);
        }
        return players;
    }
    public void pass(String name, HashMap<String, Integer> playerMap, String[] players){
        int right = playerMap.get(name);
        int left = right - 1;
        String leftName = players[left];
        playerMap.replace(leftName, right);
        playerMap.replace(name, left);
        players[left] = name;
        players[right] = leftName;
    }
}
