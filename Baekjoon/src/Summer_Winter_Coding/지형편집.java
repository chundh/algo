package Summer_Winter_Coding;

/**
 * ������ 10������� ����.
 * �̺�Ž���� ���� ������ �ٿ������µ�, middle������ ���� middle+1�� ���� ���ؼ� ���⸦ �Ǵ��Ѵ�.
 * �������� �� ������ �����̹Ƿ�, min=middle+1�� �ٲ��ش�. �׿��� ���� max = middle-1�̴�.
 */

public class �������� {
    public static void main(String[] args) {
        int[][] land = {{4, 4, 3}, {3, 2, 2}, {2, 1, 0}};
        int P = 5;
        int Q = 3;
        System.out.println(solution(land, P, Q));
    }
    public static long solution(int[][] land, int P, int Q){
        long answer = Long.MAX_VALUE;
        long max = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < land.length; i++) {
            for(int j=0; j<land[0].length; j++){
                max = Math.max(max, land[i][j]);
                min = Math.min(min, land[i][j]);
            }
        }
        while(min<=max){
            long temp = 0;
            long temp2 = 0;
            long target = (min+max)/2;
            temp = calc(land, target, P, Q);
            temp2 = calc(land, target+1, P, Q);

            if(temp>temp2){
                min = target+1;
                answer = Math.min(answer, temp2);
            }else{
                max = target-1;
                answer = Math.min(answer, temp);
            }
        }
        return answer;
    }
    private static long calc(int[][] land, long hei, int P, int Q){
        long data=0;
        for (int i = 0; i < land.length; i++) {
            for(int j=0; j<land[0].length; j++){
                int temp = land[i][j];
                if(temp<hei){
                    data += (hei-temp)*P;
                }else
                    data += (temp-hei)*Q;
            }
        }
        return data;
    }
}