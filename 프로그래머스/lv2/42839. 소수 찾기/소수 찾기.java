class Solution {
    static boolean[] visit;
    static boolean[] visit2 = new boolean[10000000];
    static int answer = 0;
    static int sosu(int x) {
        visit2[x] = true;
        if(x<=1) return 0;
        for (int i = 2; i * i <= x; i++) {
            if(x%i==0) return 0;
        }
        return 1;
    }
    static void babo(String s, String numbers) {
        if(visit2[Integer.parseInt(s)]==false)
            answer += sosu(Integer.parseInt(s));
        for (int i = 0; i < numbers.length(); i++) {
            if (visit[i] == false) {
                visit[i] = true;
                String s2 = s + numbers.charAt(i);
                babo(s2, numbers);
                visit[i] = false;
            }
        }
    }
    public static int solution(String numbers) {
        visit = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            visit[i] = true;
            String s = String.valueOf(numbers.charAt(i));
            babo(s, numbers);
            visit[i] = false;
        }
        return answer;
    }
}