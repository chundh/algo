package 자료구조구현;

public class SegmentTree {
    static int[] arr = new int[10];
    static long[] data = new long[arr.length*4];

    // 세그먼트 트리 생성
    public static long init(int node, int start, int end){
        if(start==end){
            return data[node] = arr[start];
        }
        int mid = (start + end)/2;
        return data[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
    }

    public static long sum(int node, int start, int end, int left, int right){
        if(start>right || end<left) // 범위에 포함이 안되는 경우
            return 0;
        else if (left<=start && end<=right) { // 범위에 완전히 포함된 경우
            return data[node];
        }
        // 일부분 포함된 경우
        int mid = (start+end)/2;
        return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
    }
    public static void update(int node, int start, int end, int idx, int diff){
        if(start>idx || end<idx) return;
        data[node] += diff;
        if (start==end) return;
        int mid = (start+end)/2;
        update(node*2, start, mid, idx, diff);
        update(node*2+1, mid+1, end, idx, diff);
    }
}
