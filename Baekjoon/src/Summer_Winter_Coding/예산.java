package Summer_Winter_Coding;

import java.util.Arrays;

public class ¿¹»ê {
    public static void main(String[] args) {
        int[] d= {1,3,2,5,4};
        int budget=9;
        System.out.println(solution(d, budget));
    }
    public static int solution(int[] d, int budget){
        Arrays.sort(d);
        int cnt =0;
        for (int i = 0; i < d.length; i++) {
            if(d[i]<=budget){
                budget-=d[i];
                cnt++;
            }else
                break;
        }
        return cnt;
    }
}
