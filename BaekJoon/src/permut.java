import java.util.ArrayList;
import java.util.LinkedList;

public class permut {
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		String[] data = {"M~C<2", "M~C>1"};
		//solution(n, data);
		
		String[] arr = {"A","C","F","J","M","N","R","T"};
		permut test = new permut();
		permut.doPermutation(arr, 0, n, data);
		System.out.println(count);
	}
	public static void solution(int n, String[] data, String[] arr) {
		int answer = 0;
		int number = 8;
		int flag=0;
		for(int i=0; i<n; i++) {
			flag=0;
			char first = data[i].charAt(0);
			char second = data[i].charAt(2);
			char opt = data[i].charAt(3);
			char ran = data[i].charAt(4);
			int range = Integer.valueOf(ran)-48;
			//System.out.println(first + " 와 " + second + " 는 " + opt + " 를 " + range + "만큼 적용해야됨");
			if(opt == '=') { //간격이 같길 원하는 경우 -> 두개를 묶어서 순열. 즉 전체 멤버 수가 1이 줄고 나중에 경우의 수에 x2
				for(int j=0; j<8; j++) {
					if(arr[j].equals(String.valueOf(first))) {
						if(j!=7) {
							if(arr[j+1].equals(String.valueOf(second))) {
								flag=1;
							}
						}
					}
					else if(arr[j].equals(String.valueOf(second))) {
						if(j!=7) {
							if(arr[j+1].equals(String.valueOf(first))) {
								flag=1;
							}
						}
					}
				}
			}
			else if(opt == '>') { // 해당 수를 초과하는 간격을 유지를 해야됨. 두 명의 자리는 고정이고 나머지 멤버들의 자리만 정해주면 됨. 두명을 뻈을때 경우의 수에 6p2를 곱하면?
				  				  // 떨어져 있어야 하는 두명의대한 경우의 수 : ex 2초과라면 간격은 3부터. 그러면 6p2+5p2+4p2+3p2+2p2.
				for(int j=0; j<8; j++) {
					if(arr[j].equals(String.valueOf(first))) {
						for(int k=j+1; k<8; k++) {
							if(arr[k].equals(String.valueOf(second))) {
								if(k-j > range) {
									flag=1;
									break;
								}
							}
						}
					}
					else if(arr[j].equals(String.valueOf(second))) {
						for(int k=j+1; k<8; k++) {
							if(arr[k].equals(String.valueOf(first))) {
								if(k-j > range) {
									flag=1;
									break;
								}
							}
						}
					}
				}
			}
			else if(opt == '<') { // 위의 경우와 같음.
				for(int j=0; j<8; j++) {
					if(arr[j].equals(String.valueOf(first))) {
						for(int k=j+1; k<8; k++) {
							if(arr[k].equals(String.valueOf(second))) {
								if(k-j < range) {
									flag=1;
									break;
								}
							}
						}
					}
					else if(arr[j].equals(String.valueOf(second))) {
						for(int k=j+1; k<8; k++) {
							if(arr[k].equals(String.valueOf(first))) {
								if(k-j < range) {
									flag=1;
									break;
								}
							}
						}
					}
				}
			}
			if(flag==0)
				return;
			if(i==n-1)
				count++;
		}
	}

    public static void doPermutation(String[] arr, int startIdx, int n, String[] data){
        int length = arr.length;
        if(startIdx == length-1){
        	//count++;
            //for(String a: arr) System.out.print(a + " ");
            solution(n,data, arr);
            //System.out.println();
            return;
        }

        for(int i=startIdx; i<length; i++){
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx+1, n, data);
            swap(arr, startIdx, i);
        }
    }

    public static void swap(String[] arr, int n1, int n2){
        String temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
    
    
}
