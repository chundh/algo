package CodingTest.kakao_test_2020;

public class 문자열압축 {

	static int len = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbaccc";
		
		for(int i=1; i<=s.length()/2; i++) {
			System.out.println(i + "개씩 자르기 시작");
			check(s, i, 0, i, 0,0);
		}
		
		System.out.println("answer : " + len);
	}

	public static void check(String s, int i, int start, int end, int count, int mid) {
		System.out.println(start + " 를 시작으로 해서 현재 s는 : " + s + " start : " + start + " count : " + count);
		if(end >= s.length()) {
			if(count!=0) {
				count++;
				mid = start - (count-1)*i;
				
				System.out.println(mid);
				s = s.substring(0,mid) + String.valueOf(count) + s.substring(start, s.length());
				
			}
			System.out.println("최종 s : " + s + "길이는 : " + s.length() + " , 현재 len : " + len);
			if(len!=0) {
				if(s.length()<len) {
					len = s.length();
				}
				return;
			}
			else {
				len = s.length();
				return;
			}
		}
		else if(end + i > s.length()) {
			if(count!=0) {
				count++;
				mid = start - count*i + i;
				
				s = s.substring(0,mid) + String.valueOf(count) + s.substring(start, s.length());
				
			}
			System.out.println("최종 s : " + s + "길이는 : " + s.length() + " , 현재 len : " + len);
			if(len!=0) {
				if(s.length()<len) {
					len = s.length();
				}
				return;
			}
			else {
				len = s.length();
				return;
			}
		}
		
		int flag=0;
		if(s.substring(start,end).equals(s.substring(end,end+i))){
			start = end;
			end = start + i;
			count++;
			flag=1;
			mid += i;
			check(s, i, start, end, count, mid);
		}
		if(flag==0) {
			if(count==0) {
				start = end;
				end = start + i;
				mid += i;
				check(s, i, start, end, count, mid);
			}
			else {
				count++;
				mid = start - count*i + i;
				s = s.substring(0,mid) + String.valueOf(count) + s.substring(start, s.length());
				start = start - count*i + 1 + i + i;
				end = start + i;
				count=0;
				mid = start;
				System.out.println(start + " , " + end);
				check(s, i, start, end, count, mid);
			}
		}
	}
}
