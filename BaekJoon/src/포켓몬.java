
public class 포켓몬 {
	static int answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		포켓몬 ex = new 포켓몬();
		int[] arr = { 3,1,2,3};
        int n = arr.length;
        int r = n/2;
        int[] combArr = new int[n];
        ex.doCombination(combArr, n, r, 0, 0, arr, ex);
        System.out.println(ex.answer);
	}
	 public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr, 포켓몬 ex){
	        if(r == 0){
	        	int count=1;
	        	int data=0;
	            for(int i=0; i<index; i++) {
	            	//System.out.print(arr[combArr[i]] + " ");
	            	if(i==0) {
	            		data = arr[combArr[i]];
	            	}
	            	else {
	            		if(arr[combArr[i]] != data) {
	            			count++;
	            			data = arr[combArr[i]];
	            		}
	            	}
	            }
	            if(ex.answer < count) {
	            	ex.answer = count;
	            }
	            //System.out.println();
	        }else if(target == n) return;
	        else{
	            combArr[index] = target;
	            doCombination(combArr, n, r-1, index+1, target+1, arr, ex); // (i)
	            doCombination(combArr, n, r, index, target+1, arr, ex); //(ii)
	        }
	    }
}
