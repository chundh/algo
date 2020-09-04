package ����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ���� ���ϴ� ����
 * 1. �����ڸ� ���� ��� ū���� ���� �´�
 * 2. �ڸ����� �ٸ� ��� ū ���� �ڸ����� ���߰� �񱳸� �����Ѵ�.
 * 2-1. �ڸ����� ���߰� ���� ū �ڸ����� ���� ��� ū ���� ��� index�� ���� ���� ���� ���� ū �ڸ����� ������ Ŀ���Ѵ�. (3, 31) -> x (3, 34) -> o
 */

public class ����ū�� {
	public static void main(String args[]) {
		int[] numbers = {2, 20, 200};
		System.out.println(solution(numbers));
	}
	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = (String.valueOf(numbers[i]));
		}

		//�迭 ����, ���� ��Ģ���δ� 2���� ���Ͽ� �� ū ���� �켱������ �ֵ��� ����
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});
		String answer = "";
		//0000 ó�� 0���θ� �����Ǿ������� 0 return
		if (arr[0].equals("0")) return "0";

		//�� ���� ��� ���������� �����Ͽ� answer return
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		return answer;
	}
//		PriorityQueue<Integer> arr1 = new PriorityQueue<>(Comparator.reverseOrder());
//		PriorityQueue<Integer> arr2 = new PriorityQueue<>(Comparator.reverseOrder());
//		PriorityQueue<Integer> arr3 = new PriorityQueue<>(Comparator.reverseOrder());
//		int cnt_1000 = 0;
//		for(int i=0; i<numbers.length; i++){
//			int num = numbers[i];
//			if(num<10){ // ���ڸ� ���� ���
//				int num1 = num + num*10 + num*100 + num * 1000;
//				arr1.add(num1);
//			}else if(num<100){ // ���ڸ� ���� ���
//				int num2 = num + num*100;
//				arr2.add(num2);
//			}else if(num<1000){ // ���ڸ� ���� ���
//				arr3.add(num*10 + num/100);
//			}else{ // 1000 �� ���
//				cnt_1000++;
//			}
//		}
//		StringBuilder answer = new StringBuilder();
//		int num1;
//		int num2;
//		int num3;
//		if (arr1.size() != 0)
//			num1 = arr1.poll();
//		else
//			num1 = -1;
//		if (arr2.size() != 0)
//			num2 = arr2.poll();
//		else
//			num2 = -1;
//		if (arr3.size() != 0)
//			num3 = arr3.poll();
//		else
//			num3 = -1;
//		int flag=0;
//		while (true){
//			if(arr1.size()==0 && arr2.size()==0 && arr3.size()==0 && num1 == -1 && num2 == -1 && num3 == -1){
//				break;
//			}
//			if(flag==1) {
//				if (arr1.size() != 0)
//					num1 = arr1.poll();
//			}
//			if(flag==2) {
//				if (arr2.size() != 0)
//					num2 = arr2.poll();
//			}
//			if(flag==3) {
//				if (arr3.size() != 0)
//					num3 = arr3.poll();
//			}
//			String checknum = maxNum(num1, num2, num3);
//			if(checknum.equals("num1")){
//				answer.append(String.valueOf(num1), 0, 1);
//				num1 = -1;
//				flag=1;
//			}
//			else if(checknum.equals("num2")){
//				answer.append(String.valueOf(num2), 0, 2);
//				num2 = -1;
//				flag=2;
//			}
//			else{
//				answer.append(String.valueOf(num3), 0, 3);
//				num3 = -1;
//				flag=3;
//			}
//		}
//		for(int i=0; i<cnt_1000; i++){
//			answer.append("1000");
//		}
//		if(answer.charAt(0)=='0')
//			return "0";
//		return answer.toString();
//	}

	public static String maxNum(int num1, int num2, int num3){
		if(num1>num2){
			if(num3>num1)
				return "num3";
			return "num1";
		}
		if(num2>num3)
			return "num2";
		return "num3";
	}
}
