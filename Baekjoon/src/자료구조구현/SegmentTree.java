package �ڷᱸ������;

public class SegmentTree {
    static int[] arr = new int[10];
    static long[] data = new long[arr.length*4];

    // ���׸�Ʈ Ʈ�� ����
    public static long init(int node, int start, int end){
        if(start==end){
            return data[node] = arr[start];
        }
        int mid = (start + end)/2;
        return data[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
    }

    public static long sum(int node, int start, int end, int left, int right){
        if(start>right || end<left) // ������ ������ �ȵǴ� ���
            return 0;
        else if (left<=start && end<=right) { // ������ ������ ���Ե� ���
            return data[node];
        }
        // �Ϻκ� ���Ե� ���
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
