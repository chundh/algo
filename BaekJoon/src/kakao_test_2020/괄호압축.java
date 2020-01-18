package kakao_test_2020;

public class 괄호압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(()())()";
		String ans = "";
		System.out.println("answer : " + check(s, ans));
		
	}
	public static String check(String s, String ans) {
		String u = ""; 
		String v = "";
		if(s.length()==0) {
			return "";
		}
		int cnt=0;
		int index=0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(')
				cnt++;
			else if(s.charAt(i) == ')') {
				cnt--;
			}
			if(cnt==0) {
				index = i;
				break;
			}
		}
		u = s.substring(0,index+1);
		v = s.substring(index+1,s.length());
		System.out.println(u + " , " + v);
		if(check_arr(u)) {   //u가 올바른 괄호 문자열이라면
			ans += u;
			String temp = "";
			temp = check(v, ans);
			return u + temp;
		}
		else {  //u가 균형잡힌 문자열이기만 하다면
			String temp = "";
			temp += "(";
			temp += check(v, ans) + ")";
			if(u.length() > 2) {
				for(int i=1; i<u.length()-1; i++) {
					if(u.charAt(i) == '(') {
						temp += ")";
					}
					else {
						temp += "(";
					}
				}
			}
			System.out.println("else : " + temp);
			return temp;
		}
	}
	
	public static Boolean check_arr(String str) {
		int cnt=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(')
				cnt++;
			else if(str.charAt(i) == ')') {
				cnt--;
			}
			if(cnt<0) {
				return false;
			}
		}
		return true;
	}
}
