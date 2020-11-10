package CodingTest.kakao_test_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 길찾기게임 {

	static int[][] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution(nodeinfo);
	}

	public static void solution(int[][] nodeinfo) {
		ArrayList<spot> arr = new ArrayList<spot>();
		answer = new int[2][nodeinfo.length];
		for(int i=0; i<nodeinfo.length; i++) {
			int a = i+1;
			spot sp = new spot(nodeinfo[i][0], nodeinfo[i][1], a);
			arr.add(sp);
		}
		Collections.sort(arr, new Comparator<spot>() {
			@Override
			public int compare(spot arg0, spot arg1) {
				// TODO Auto-generated method stub
				if (arg0.y > arg1.y) { //반대로 하면 오름차순 <=
					return -1;
				} else {
					if(arg0.y == arg1.y) {
						if(arg0.x>arg0.x)
							return -1;
						else
							return 1;
					}
					return 1;
				} 
			}
			
		});
		BinarySearchTree bst = new BinarySearchTree();
		for(int i=0 ;i<arr.size(); i++) {
			bst.insertBST(arr.get(i).number, arr.get(i).x, arr.get(i).y);
			//System.out.println(arr.get(i).x + " , " + arr.get(i).y + " , " + arr.get(i).number);
		}
		bst.printpre(answer);
		bst.printpost(answer);
		/*
		for(int i=0 ;i<2; i++) {
			for(int j=0; j<answer[0].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println("");
		}
		*/
	}
}
class spot{
	int x;
	int y;
	int number;
	spot(int x, int y, int number){
		this.x = x;
		this.y = y;
		this.number = number;
	}
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    int x;
    int y;
    public TreeNode(){
        this.left = null;
        this.right = null;
        x=0;
    }
    
    public TreeNode(int data, int x, int y){
        this.data = data;
        this.left = null;
        this.right = null;
        this.x = x;
        this.y = y;
    }
    
    public Object getData(){
        return data;
    }
}

class BinarySearchTree {
    private TreeNode root = new TreeNode();
    ArrayList<Integer> pre = new ArrayList<Integer>();
    ArrayList<Integer> post = new ArrayList<Integer>();
    public TreeNode insertKey(TreeNode root, int c, int x, int y) {
        TreeNode p = root;
        TreeNode newNode = new TreeNode(c, x, y);
        
        if(p==null){
            return newNode;
        }else if(p.x>newNode.x){
            p.left = insertKey(p.left, c, x, y);
            return p;
        }else if(p.x<newNode.x){
            p.right = insertKey(p.right, c, x, y);
            return p;
        }else{ 
            return p;
        }
    }
    
    public void insertBST(int c, int x, int y){
        root = insertKey(root, c, x, y);
    }
    
    public TreeNode searchBST(char x){
        TreeNode p = root;
        while(p!=null){
            if(x<p.data) p = p.left;
            else if(x>p.data) p = p.right;
            else return p;
        }
        return p;
    }
    
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    public void preorder(TreeNode root) {
    	if(root!=null) {
    		//System.out.print(root.data + " ");
    		pre.add(root.data);
    		preorder(root.left);
    		preorder(root.right);
    	}	
    }
    public void postorder(TreeNode root) {
    	if(root!=null) {
    		postorder(root.left);
    		postorder(root.right);
    		//System.out.print(root.data + " ");
    		post.add(root.data);
    	}	
    }
    
    public void printpre(int[][] answer){
        preorder(root);
        System.out.println();
        for(int i=0; i<answer[0].length; i++) {
        	answer[0][i] = pre.get(i+1);
        }
    }
    public void printpost(int[][] answer){
        postorder(root);
        System.out.println();
        for(int i=0; i<answer[0].length; i++) {
        	answer[1][i] = post.get(i);
        }
    }
}
