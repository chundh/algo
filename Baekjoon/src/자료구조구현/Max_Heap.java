package 자료구조구현;

import java.util.ArrayList;

public class Max_Heap {
    static class heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public int getParent(int pos){
            return pos/2;
        }
        public boolean isLeaf(int pos){
            return pos>arr.size()/2 && pos<=arr.size();
        }

        public int leftChild(int pos){
            return pos*2;
        }
        public int rightChild(int pos){
            return pos*2+1;
        }
        public void add(int pos){
            arr.add(pos);
            int idx = arr.size()-1;
            while(true){
                if(arr.get(idx) > arr.get(getParent(idx))){
                    int data = arr.get(idx);
                    arr.set(idx, arr.get(getParent(idx)));
                    arr.set(getParent(idx), data);
                    idx = getParent(idx);
                }else
                    break;
            }
        }
        public void remove(){
            arr.set(1, arr.get(arr.size()-1));
            arr.remove(arr.size()-1);
            maxHeapify(1);
        }
        public void maxHeapify(int pos){
            if (isLeaf(pos)) {
                return;
            }
            int left_idx = leftChild(pos);
            int right_idx = rightChild(pos);
            if(right_idx>=arr.size()){
                if(arr.get(left_idx) > arr.get(pos)){
                    int data = arr.get(pos);
                    arr.set(pos, arr.get(left_idx));
                    arr.set(left_idx, data);
                    maxHeapify(left_idx);
                }
                return;
            }
            if(arr.get(pos)<arr.get(left_idx) || arr.get(pos) < arr.get(right_idx)) {
                if (arr.get(left_idx) > arr.get(right_idx)) {
                    int data = arr.get(pos);
                    arr.set(pos, arr.get(left_idx));
                    arr.set(left_idx, data);
                    maxHeapify(left_idx);
                }else{
                    int data = arr.get(pos);
                    arr.set(pos, arr.get(right_idx));
                    arr.set(right_idx, data);
                    maxHeapify(right_idx);
                }
            }
        }
        public void print(){
            int cnt = 1;
            for(int i=1; i<arr.size(); i++){
                if(i==cnt){
                    System.out.println();
                    cnt*=2;
                }
                System.out.print(arr.get(i) + " ");
            }
        }
    }

    public static void main(String[] args) {
        heap heap = new heap();
        heap.add(0);
        // 힙 시작
        heap.add(5);
        heap.add(3);
        heap.add(1);
        heap.add(6);
        heap.add(9);
        heap.add(10);
        heap.add(52);
        heap.print();
        heap.remove();
        heap.print();
    }
}
