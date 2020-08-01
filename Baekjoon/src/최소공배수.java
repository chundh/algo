public class 최소공배수 {

	public void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,6,8,14};
		
		solution(arr);
	}
	
	public int solution(int[] arr) {
		int lcm = arr[0]; // @1
		
		for(int i=1; i<arr.length; i++) { // @2
			lcm = getLcm(lcm, arr[i]);
		}
		
		return lcm;
	}
	
	public int getGcd(int a, int b) { // @3
		int tmp;
		while(b != 0) {
			tmp = b;
			b = a % b;
			a = tmp;
		}
		
		return a;
	}
	
	public int getLcm(int a, int b) { // @4
		if(a<=0 || b<=0) return -1;
		return a * b / getGcd(a, b);
	}
}
