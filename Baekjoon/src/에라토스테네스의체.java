public class �����佺�׳׽���ü {
    public static void main(String[] args) {
        int n = 100;
        boolean[] arr = new boolean[n]; // �Ҽ��̸� false�� ����
        arr[0] = true;
        arr[1] = true;
        for(int i=2; i*i<arr.length; i++){
            if(arr[i])
                continue;
            for(int j = i*i; j<n; j+=i){
                arr[j] = true;
            }
        }
        for(int i=0; i<n; i++){
            System.out.println(i + " : " + arr[i]);
        }
    }
}
