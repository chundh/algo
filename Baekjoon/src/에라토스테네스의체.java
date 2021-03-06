import java.util.ArrayList;

public class 에라토스테네스의체 {
    public static void main(String[] args) {
        int n = 10;
        boolean[] arr = new boolean[n+1]; // 소수이면 false로 저장
        arr[0] = true;
        arr[1] = true;
        ArrayList<Integer> info = new ArrayList<>();
        for(int i=2; i*i<=arr.length; i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                arr[j] = true;
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " : " + arr[i]);
        }
    }
}
