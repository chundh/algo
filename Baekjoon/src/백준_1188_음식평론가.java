import java.util.Scanner;

public class ����_1188_������а� {
    public static int GCD(int a, int b) {
        if(b == 0)	return a;
        return GCD(b, a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // �ҽ��� ��
        int k = sc.nextInt(); // ��а� ��

        System.out.println(k - GCD(n,k));

    }
}