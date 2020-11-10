package CodingTest.프로그래머스11월코드챌린지;

public class programming3 {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 3};
        solution(a);
    }
    public static void solution(int[] a){
        int[] len = new int[500001];
        int answer = 0;
        int max=0;
        if(a.length==1){
            return;
        }
        if(a[0]!=a[1]){
            len[a[0]]++;
        }
        for (int i = 1; i < a.length-1; i++) {
            if(a[i]==a[i-1]){
                if(i+2<a.length && a[i]==a[i+2]) {
                    if (i + 3 < a.length - 1) {
                        if (a[i] != a[i + 3]) {
                            len[a[i]]++;
                        }
                    }
                    continue;
                }
            }
            if(a[i]!=a[i-1] || a[i]!=a[i+1]){
                len[a[i]]++;
            }
        }
        if(a[a.length-1]!=a[a.length-2])
            len[a[a.length-1]]++;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(len[i], max);
            System.out.println(i + " : " + len[i]);
        }
        System.out.println(max*2);
    }
}
