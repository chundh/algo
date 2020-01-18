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
			//System.out.println(first + " �� " + second + " �� " + opt + " �� " + range + "��ŭ �����ؾߵ�");
			if(opt == '=') { //������ ���� ���ϴ� ��� -> �ΰ��� ��� ����. �� ��ü ��� ���� 1�� �ٰ� ���߿� ����� ���� x2
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
			else if(opt == '>') { // �ش� ���� �ʰ��ϴ� ������ ������ �ؾߵ�. �� ���� �ڸ��� �����̰� ������ ������� �ڸ��� �����ָ� ��. �θ��� �Q���� ����� ���� 6p2�� ���ϸ�?
				  				  // ������ �־�� �ϴ� �θ��Ǵ��� ����� �� : ex 2�ʰ���� ������ 3����. �׷��� 6p2+5p2+4p2+3p2+2p2.
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
			else if(opt == '<') { // ���� ���� ����.
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
