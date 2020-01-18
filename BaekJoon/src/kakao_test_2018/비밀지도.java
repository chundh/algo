package kakao_test_2018;

public class 비밀지도 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		
		solution(n, arr1, arr2);
	}
	
	public static void solution(int n, int[] arr1, int[] arr2) {
		String[] my_arr1 = new String[arr1.length]; 
		String[] my_arr2 = new String[arr2.length]; 
		String[] ans_arr = new String[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			my_arr1[i] = change_num(arr1[i], n);
			my_arr2[i] = change_num(arr2[i], n);
			ans_arr[i] = "";
		}
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<n; j++) {
				if(my_arr1[i].charAt(j) == my_arr2[i].charAt(j)) {
					if(my_arr1[i].charAt(j) == '1') {
						ans_arr[i] += '#';
					}
					else {
						ans_arr[i] += ' ';
					}
				}
				else {
					ans_arr[i] += "#";
				}
			}
		}
		
		for(int i=0; i<arr1.length; i++) {
			System.out.println(ans_arr[i]);
		}
		
	}
	
	public static String change_num(int data, int n) {
		String ans = null;
		ans = Integer.toBinaryString(data);
		if(ans.length()!=n) {
			for(int i=ans.length(); i<n; i++) {
				ans = "0" + ans;
			}
		}
		System.out.println(ans);
		return ans;
	}
}
