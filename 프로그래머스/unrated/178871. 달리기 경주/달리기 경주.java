import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i],i);
        }
        for (int i = 0; i < callings.length; i++) {
            int x = map.get(callings[i]);
            String tmp = players[x];
            players[x] = players[x - 1];
            players[x - 1] = tmp;

            map.put(players[x], x);
            map.put(players[x-1],x-1);
        }
        return players;
    }
}