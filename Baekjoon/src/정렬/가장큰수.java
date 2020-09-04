package 정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 수를 비교하는 기준
 * 1. 같은자리 수일 경우 큰수가 먼저 온다
 * 2. 자릿수가 다를 경우 큰 수로 자릿수를 맞추고 비교를 진행한다.
 * 2-1. 자릿수를 맞추고 가장 큰 자릿값이 같은 경우 큰 수의 모든 index의 값이 작은 수의 가장 큰 자릿수의 값보다 커야한다. (3, 31) -> x (3, 34) -> o
 */

public class 가장큰수 {
	public static void main(String args[]) {
		int[] numbers = {2, 20, 200};
		System.out.println(solution(numbers));
	}
	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = (String.valueOf(numbers[i]));
		}

		//배열 정렬, 정렬 규칙으로는 2개를 더하여 더 큰 쪽이 우선순위가 있도록 정렬
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});
		String answer = "";
		//0000 처럼 0으로만 구성되어있으면 0 return
		if (arr[0].equals("0")) return "0";

		//그 외의 경우 순차적으로 연결하여 answer return
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
//			if(num<10){ // 한자리 수의 경우
//				int num1 = num + num*10 + num*100 + num * 1000;
//				arr1.add(num1);
//			}else if(num<100){ // 두자리 수의 경우
//				int num2 = num + num*100;
//				arr2.add(num2);
//			}else if(num<1000){ // 세자리 수의 경우
//				arr3.add(num*10 + num/100);
//			}else{ // 1000 인 경우
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
