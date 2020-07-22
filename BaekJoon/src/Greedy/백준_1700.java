package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준_1700 {

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
			if(list.contains(arr[i])) { //멀티탭에 해당 제품이 꼽혀 있는 경우
				continue;
			}
			else {
				if(list.size()!=n) { //멀티탭에 빈 자리가 있는 경우
					list.add(arr[i]);
				}
				else { //멀티탭에 자리가 없으니 무언가를 뺴야하는 경우
					int max_index = 0;
					ArrayList<Integer> cnt = new ArrayList<Integer>();
					for(int j=i+1; j<k; j++) {
						if(list.contains(arr[j])) { //해당 제품은 추후에 다시 사용 됨.
							if(!cnt.contains(arr[j])) {
								cnt.add(arr[j]);
								if(j>max_index)
									max_index = j;	
							}
						}
					}
					if(max_index==0) { //현재 멀티탭에 꼽힌 것은 후에 다시 사용하지 않음.
						list.set(0, arr[i]);
						answer++;
					}
					else {
						if(cnt.size()==n) {  // 현재 꼽힌것이 모두 후에 사용되므로 가장 마지막에 사용되는 것을 뽑는다.
							int idx = list.indexOf(arr[max_index]);
							list.set(idx, arr[i]);
							answer++;
						}
						else {
							for(int j=0; j<n; j++) {
								if(!cnt.contains(list.get(j))) { //해당 제품은 나중에 사용하지 않음.
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
