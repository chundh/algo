package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class ����_1700 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int answer=0;
		int[] arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<k; i++) {
			if(list.contains(arr[i])) { //��Ƽ�ǿ� �ش� ��ǰ�� ���� �ִ� ���
				continue;
			}
			else {
				if(list.size()!=n) { //��Ƽ�ǿ� �� �ڸ��� �ִ� ���
					list.add(arr[i]);
				}
				else { //��Ƽ�ǿ� �ڸ��� ������ ���𰡸� �����ϴ� ���
					int max_index = 0;
					ArrayList<Integer> cnt = new ArrayList<Integer>();
					for(int j=i+1; j<k; j++) {
						if(list.contains(arr[j])) { //�ش� ��ǰ�� ���Ŀ� �ٽ� ��� ��.
							if(!cnt.contains(arr[j])) {
								cnt.add(arr[j]);
								if(j>max_index)
									max_index = j;	
							}
						}
					}
					if(max_index==0) { //���� ��Ƽ�ǿ� ���� ���� �Ŀ� �ٽ� ������� ����.
						list.set(0, arr[i]);
						answer++;
					}
					else {
						if(cnt.size()==n) {  // ���� �������� ��� �Ŀ� ���ǹǷ� ���� �������� ���Ǵ� ���� �̴´�.
							int idx = list.indexOf(arr[max_index]);
							list.set(idx, arr[i]);
							answer++;
						}
						else {
							for(int j=0; j<n; j++) {
								if(!cnt.contains(list.get(j))) { //�ش� ��ǰ�� ���߿� ������� ����.
									list.set(j, arr[i]);
									answer++;
									break;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}
