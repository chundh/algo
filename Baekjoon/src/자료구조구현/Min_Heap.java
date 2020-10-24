package 자료구조구현;

import java.util.ArrayList;

public class Min_Heap {
    static class heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public boolean isLeaf(int pos){
            return pos < arr.size() && pos>=arr.size()/2;
        }
        public int parent(int pos){
            return pos/2;
        }
        public int leftChild(int pos){
            return pos*2;
        }
        public int rightChild(int pos){
            return pos*2+1;
        }
        public void add(int num){
            int idx = arr.indexOf(num);
            while(true){
                if(arr.get(idx) < arr.get(parent(idx))){
                    int data = arr.get(idx);
                    arr.set(idx, arr.get(parent(idx)));
                    arr.set(parent(idx), data);
                }else
                    return;
            }
        }
    }
}
