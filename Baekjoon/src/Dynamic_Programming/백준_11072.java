package Dynamic_Programming;

import java.util.Scanner;

//���� ū �����ϴ� ����

public class ����_11072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] list = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			list[i] = 1;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(list[j]>=list[i] && arr[i]<arr[j])
					list[i] = list[j] + 1;
			}
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			if(max<list[i])
				max = list[i];
		}
		System.out.println(max);
	}

}
