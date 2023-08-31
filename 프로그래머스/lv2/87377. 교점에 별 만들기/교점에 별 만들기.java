import java.util.*;

class Solution {
        public String[] solution(int[][] line) {
            long xmax = Long.MIN_VALUE;
            long xmin = Long.MAX_VALUE;
            long ymax = Long.MIN_VALUE;
            long ymin = Long.MAX_VALUE;
            ArrayList<Long> listx = new ArrayList<>();
            ArrayList<Long> listy = new ArrayList<>();

            for(int i=1; i< line.length; i++){
                for(int j=0; j<i; j++){
                    double A = line[i][0],B = line[i][1],C = line[i][2];
                    double a = line[j][0],b = line[j][1],c = line[j][2];
                    double x = (c*B-C*b)/(A*b-a*B);
                    double y = (c*A-C*a)/(B*a-b*A);

                    double x2 = x - (double)(long)x;
                    double y2 = y - (double)(long)y;

                    if (x2 == 0 && y2==0) {
                        listx.add((long)x);
                        listy.add((long)y);
                        xmax = Math.max(xmax, (long) x);
                        xmin = Math.min(xmin, (long) x);
                        ymax = Math.max(ymax, (long) y);
                        ymin = Math.min(ymin, (long) y);
                    }

                }
            }
            String[][] tmp = new String[(int)(ymax-ymin+1)][(int)(xmax-xmin+1)];
            for(int i=0; i<tmp.length; i++)
                for(int j=0; j<tmp[0].length; j++)
                    tmp[i][j] = ".";
            for(int i=0; i<listy.size(); i++){
                tmp[(int)(listy.get(i)-ymin)][(int)(listx.get(i)-xmin)]="*";
            }
            String[] answer = new String[(int)(ymax-ymin+1)];
            for(int i=0; i<tmp.length; i++){
                answer[tmp.length-1-i]="";
                for(int j=0; j<tmp[0].length; j++)  {
                    answer[tmp.length-1-i] = answer[tmp.length-1-i] + tmp[i][j];
                }
            }
            return answer;
        }
    }