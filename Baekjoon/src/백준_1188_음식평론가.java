import java.util.Scanner;

public class 백준_1188_음식평론가 {
    public static int GCD(int a, int b) {
        if(b == 0)	return a;
        return GCD(b, a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 소시지 수
        int k = sc.nextInt(); // 평론가 수

        System.out.println(k - GCD(n,k));

    }
}