package CodingTest.kakao_test_2019;

import java.util.Arrays;

public class 길찾기게임 {
    static int[][] answer;
    static int idx = 0;
    static class node implements Comparable<node>{
        int num;
        int x;
        int y;
        node left;
        node right;
        public node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }
        @Override
        public int compareTo(node o) {
            if(o.y == this.y)
                return this.x - o.x;
            return o.y - this.y;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution(nodeinfo);
	}

	public static void solution(int[][] nodeinfo) {
        node[] data = new node[nodeinfo.length];
        answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            data[i] = new node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        Arrays.sort(data);
        node root = data[0];
        for (int i = 1; i < data.length; i++) {
            insert(root, data[i]);
        }
        preOrder(root);
        idx = 0;
        postOrder(root);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
	}
	public static void insert(node root, node newNode){
        if(newNode.x < root.x){ // 왼쪽
            if(root.left == null){
                root.left = newNode;
            }else{
                insert(root.left, newNode);
            }
        }else{ // 오른쪽
            if(root.right==null){
                root.right = newNode;
            }else{
                insert(root.right, newNode);
            }
        }
    }
    public static void preOrder(node node){
        answer[0][idx] = node.num;
        idx++;
        if(node.left!=null)
            preOrder(node.left);
        if(node.right != null)
            preOrder(node.right);
    }
    public static void postOrder(node node){
        if (node.left!=null)
            postOrder(node.left);
        if(node.right!=null)
            postOrder(node.right);
        answer[1][idx] = node.num;
        idx++;
    }

}