class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] list = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        int[] score = new int[8];
        for (int i = 0; i < survey.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[j] == survey[i].charAt(0)) {
                    score[j] += (choices[i] - 4);
                    break;
                }
            }
        }
                
        for (int i = 0; i < 4; i++) {
            if (score[i * 2] <= score[i * 2 + 1]) answer += (char)list[i * 2];
            else answer += (char)list[i * 2+1] ;
        }

        return answer;
    }
}