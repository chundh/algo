package 해시;

import java.util.Arrays;
import java.util.HashSet;

public class 전화번호목록 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = {"111113", "1112","12"};
		boolean answer = true;
		Arrays.sort(phone_book);
		for(int i=0; i<phone_book.length; i++) {
			System.out.println(phone_book[i]);
		}
		answer = check(0,phone_book.length-1, phone_book);
		System.out.println(answer);
	}
	public static boolean check(int start, int end, String[] phone_book) {
		int len=0;
		System.out.println(start + " , " + end + " , " + phone_book[start].charAt(0));
		for(int i=start; i<end; i++) {
			for(int j=i+1; j<end+1; j++) {
				if(phone_book[i].length()>phone_book[j].length()) {
					len = phone_book[j].length();
				}
				else {
					len = phone_book[i].length();
				}
				System.out.println(phone_book[i] + " , " + phone_book[j]);
				if(phone_book[i].equals(phone_book[j].substring(0, len))) {
					return false;
				}
			}
		}
		return true;
	}
}
