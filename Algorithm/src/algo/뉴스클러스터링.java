import java.util.ArrayList;

public class 뉴스클러스터링 {
	static int u=0;
	static int v=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "aa1+aa2";
		String str2 = "aaaa12";
		solution(str1, str2);
	}
	
	public static void solution(String str1, String str2) {
		String st1 = "";
		String st2 = "";
		for(int i=0; i<str1.length(); i++) {
			if(str1.charAt(i)>=97 && str1.charAt(i) <= 122) {
				st1 += str1.valueOf(str1.charAt(i)).toUpperCase();
			}
			else {
				st1 += str1.valueOf(str1.charAt(i));
			}
		}
		for(int i=0; i<str2.length(); i++) {
			if(str2.charAt(i)>=97 && str2.charAt(i) <= 122) {
				st2 += str2.valueOf(str2.charAt(i)).toUpperCase();
			}
			else {
				st2 += str2.valueOf(str2.charAt(i));
			}
		}
		System.out.println(st1 +  " , " + st2);
		
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();

		for(int i=0; i<st1.length()-1; i++) {
			if(st1.charAt(i) >=65 && st1.charAt(i) <= 90) {
				if(st1.charAt(i+1) >=65 && st1.charAt(i+1) <= 90) {
					arr1.add(st1.substring(i,i+2));
				}
			}
			else {
				continue;
			}
		}
		for(int i=0; i<st2.length()-1; i++) {
			if(st2.charAt(i) >=65 && st2.charAt(i) <= 90) {
				if(st2.charAt(i+1) >=65 && st2.charAt(i+1) <= 90) {
					arr2.add(st2.substring(i,i+2));
				}
			}
			else {
				continue;
			}
		}
		int len1 = arr1.size();
		int len2 = arr2.size();
		inter(arr1, arr2);
		u = len1 + len2 - v;
		System.out.println("u : " + u + "v : " + v);
		double ans=0;
		if(u==0)
			ans = 65536;
		else
			ans = (double)v/ (double)u;
		int answer = (int)(ans*65536);
		System.out.println(answer);
	}
	
	public static void inter(ArrayList<String> arr1, ArrayList<String> arr2) {
		ArrayList<String> inter = new ArrayList<String>();
		for(int i=0; i<arr2.size(); i++) {
			if(arr1.contains(arr2.get(i))) {
				inter.add(arr2.get(i));
				arr1.remove(arr1.indexOf(arr2.get(i)));
			}
		}
		for(int i=0; i<inter.size(); i++) {
			System.out.println(inter.get(i));
		}
		v = inter.size();
		System.out.println(inter.size());
	}
}
