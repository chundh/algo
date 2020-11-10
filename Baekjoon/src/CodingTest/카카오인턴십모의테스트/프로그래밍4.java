package CodingTest.카카오인턴십모의테스트;

public class 프로그래밍4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		
		solution(k, room_number);
	}
	
	public static void solution(long k, long[] room_number) {
		TreeNode[] arr = new TreeNode[(int) k];
		int[] answer = new int[room_number.length];
		for(int i=1; i<arr.length; i++) {
			arr[i] = new TreeNode(i);
		}
		for(int i=0; i<room_number.length; i++) {
			TreeNode cur = arr[(int) room_number[i]];
			int data = cur.getData(arr[(int) room_number[i]]);
			//System.out.println(data);
			answer[i] = data;
			cur = cur.getNode(cur);
			cur.right = arr[data+1];
			//System.out.println(cur.getData(cur));
		}
		/*
		long[] arr = new long[200000];
		long[] answer = new long[room_number.length];
		for(int i=0; i<room_number.length; i++) {
			if(arr[(int) room_number[i]]==0) {
				arr[(int) room_number[i]] = -1;
				answer[i] = room_number[i];
			}	
			else {
				for(int j=(int) room_number[i]; j<k; j++) {
					if(arr[j] != -1) {
						arr[j] = -1;
						answer[i] = j;
						break;
					}
						
				}
			}
		}
		*/
	}

}

class TreeNode {
    int data;
    TreeNode right;
    
    public TreeNode(){
        this.right = null;
    }
    
    public TreeNode(int data){
        this.data = data;
        this.right = null;
    }
    
    public int getData(TreeNode cur){
        while(true) {
        	if(cur.right==null) {
        		break;
        	}
        	cur = cur.right;
        }
        return cur.data;
    }
    public TreeNode getNode(TreeNode cur){
        while(true) {
        	if(cur.right==null) {
        		break;
        	}
        	cur = cur.right;
        }
        return cur;
    }
}

class SearchTree {
    private TreeNode root = new TreeNode();
    
    public TreeNode insertKey(TreeNode root, char x) {
        TreeNode p = root;
        TreeNode newNode = new TreeNode(x);
        
        if(p==null){
            return newNode;
        }else{ 
        	p.right = insertKey(p.right, x);
            return p;
        }
    }
    
    public void insertBST(char x){
        root = insertKey(root, x);
    }
    
    public TreeNode searchBST(int x){
        TreeNode p = root;
        while(p!=null){
        	p = p.right;
        }
        return p;
    }
    
    
}
