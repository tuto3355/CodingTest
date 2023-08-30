class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int maxi = -1;
        int maxj = -1;
        int mini = 100;
        int minj = 100;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    maxi = Math.max(maxi, i + 1);
                    maxj = Math.max(maxj, j + 1);
                    mini = Math.min(mini, i);
                    minj = Math.min(minj, j);
                }
            }
        }
        return new int[]{mini,minj,maxi,maxj};
    }
}