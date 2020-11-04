package Summer_Winter_Coding;

/**
 * dp�� ����Ѵ�.
 * ó���� ���� ����� �迭�� �����̹Ƿ� �ΰ����� ����� ����Ѵ�.
 * 1. 0~n-1������ �迭
 * 2. 1~n������ �迭
 * ���߿��� ū dp���� �����̴�.
 */

public class ��ƼĿ������2 {
    public static void main(String[] args) {
        int[] sticker = {1, 3};
        System.out.println(solution(sticker));
    }
    public static int solution(int[] sticker){
        if(sticker.length==1)
            return sticker[0];
        int[] dp = new int[sticker.length-1];
        int[] dp2 = new int[sticker.length-1];
        dp[0] = sticker[0];
        dp2[0] = sticker[1];
        for (int i = 1; i < sticker.length-1; i++) {
            dp[i] = Math.max(sticker[i] + getVal(dp, i-2), getVal(dp, i-1));
        }
        for (int i = 1; i < sticker.length-1; i++) {
            dp2[i] = Math.max(sticker[i+1] + getVal(dp2, i-2), getVal(dp2, i-1));
        }
        System.out.println(dp[dp.length-1] + " , " + dp2[dp2.length-1]);
        return Math.max(dp[dp.length-1],dp2[dp2.length-1]);
    }
    public static int getVal(int[] dp, int idx){
        if(idx<0)
            idx+=dp.length;
        return dp[idx];
    }
}
