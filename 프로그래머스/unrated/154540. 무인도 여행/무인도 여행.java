import java.util.*;

class Solution {
    public static int[][] visit;
    
    public static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public static int dfs(int x,int y,String[] maps) {
        if(x<0||y<0||x>= visit.length||y>=visit[0].length)
            return 0;
        if(visit[x][y]==1 || maps[x].charAt(y)=='X')
            return 0;
        visit[x][y]=1;
        int sum = 0;
        if(maps[x].charAt(y)!='X')
            sum+=maps[x].charAt(y)-'0';
        for (int i = 0; i < 4; i++) {
            sum+=dfs(x+d[i][0],y+d[i][1],maps);
        }
        return sum;
    }

    public int[] solution(String[] maps) {        

        ArrayList<Integer> arr = new ArrayList<>();

        visit = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                int tmp = dfs(i, j,maps);
                if(tmp!=0) arr.add(tmp);
            }
        }
        Collections.sort(arr);
        if(arr.size()==0) return new int[]{-1};
        int[] answer = new int[arr.size()];
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}