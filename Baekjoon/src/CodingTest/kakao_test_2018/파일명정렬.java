package CodingTest.kakao_test_2018;

import java.util.Arrays;

public class 파일명정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG", "F-15"};

		solution(files);
	}
	
	public static void solution(String[] files) {
		int start=0;
		int end=0;
		String head="";
		String tail = "";
		data[] arr = new data[files.length];
		for(int i=0; i<files.length; i++) {
			start =0;
			end=0;
			for(int j=0; j<files[i].length(); j++) {
				if(Integer.valueOf(files[i].charAt(j))<=57 && Integer.valueOf(files[i].charAt(j))>=48) {
					if(start == 0)
						start = j;
				}
				else {
					if(start != 0) {
						end = j;
						break;
					}
				}
			}
			if(end==0)
				end = files[i].length();
			head = files[i].substring(0,start);
			tail = files[i].substring(end,files[i].length());
			int num = Integer.valueOf(files[i].substring(start, end));
			data data = new data(head,tail, num, files[i].substring(start, end));
			arr[i] = data;
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].head + " , " + arr[i].num_data + " , " + arr[i].tail);
		}
	}
}

class data implements Comparable<data>{
	String head;
	String tail;
	int num;
	String num_data;
	public data(String head, String tail, int num, String num_data) {
		this.head = head;
		this.tail = tail;
		this.num = num;
		this.num_data = num_data;
	}
	@Override
	public int compareTo(data p) {
		// TODO Auto-generated method stub
		if(this.head.compareToIgnoreCase(p.head)>0)
			return 1;
		else if(this.head.compareToIgnoreCase(p.head)<0)
			return -1;
		
		if(this.num > p.num)
			return 1;
		else if(this.num<p.num)
			return -1;
		
		return 0;
		
	}
}
