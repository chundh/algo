
public class 얻을수있는큰수_순열 {
	static int answer=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "1231234";
		int k = 3;
		
		solution(number, k);
	}
	public static void solution(String number, int k) {
		int[] arr = new int[number.length()];
		for(int i=0; i<number.length(); i++) {
			arr[i] = Integer.valueOf(number.charAt(i)) - 48; 
		}
        // nPr 구하기
        int n = arr.length;
        int r = number.length()-k;
        int[] combArr = new int[r];
        doCombination(combArr, arr, n, r, 0, 0);
        
        System.out.println("ans :" + answer);
	}
	
	public static void doCombination(int[] combArr, int[] arr, int n, int r, int index, int target){
        if(r == 0){
            //to-do: combArr permutation
            doPermutation(combArr, 0);
            System.out.println("------------------");
        }else if(target == n) return;
        else{
            combArr[index] = arr[target];
            doCombination(combArr, arr, n, r-1, index+1, target+1);
            doCombination(combArr, arr, n, r, index, target+1);
        }
    }

    public static void doPermutation(int[] arr, int startIdx){
        int length = arr.length;
        if(startIdx == length-1){
        	int data=0;
            for(int i=0; i<arr.length; i++) {
            	System.out.print(arr[i] + " ");
            	data += arr[i]* Math.pow(10, arr.length-1-i);
            }
            System.out.println();
            if(answer<data) {
            	answer = data;
            }
            return;
        }
        for(int i=startIdx; i<length-1; i++){
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx+1);
            swap(arr, startIdx, i);
        }
    }

    public static void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
