import java.util.*;


class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        HashMap<Integer, Integer> a2 = new HashMap<>();
        HashMap<Integer, Integer> a3 = new HashMap<>();
        HashMap<Integer, Integer> a4 = new HashMap<>();

        for (int i = 0; i < weights.length; i++) {
            a2.put(2* weights[i], a2.getOrDefault(2*weights[i],0)+1);
            a3.put(3* weights[i], a3.getOrDefault(3*weights[i],0)+1);
            a4.put(4* weights[i], a4.getOrDefault(4*weights[i],0)+1);
        }
        
        for (int i = 0; i < weights.length; i++){
            for(int j=2; j<=4; j++) {
                int tmp = weights[i]*j;

                if (j!=2 && a2.containsKey(tmp) && a2.get(tmp) > 0) answer+=(long)a2.get(tmp);
                if (j!=3 && a3.containsKey(tmp) && a3.get(tmp) > 0) answer+=(long)a3.get(tmp);
                if (j!=4 && a4.containsKey(tmp) && a4.get(tmp) > 0) answer+=(long)a4.get(tmp);
                
            }
            //answer+=a2.get(2*weights[i])-1;
        }
        answer/=2;
        for(Integer key : a2.keySet())
            answer+=(long)a2.get(key)*(long)(a2.get(key)-1)/2;

        return answer;
    }
}