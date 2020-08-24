package SCPC_6_minor;

import java.util.ArrayList;
import java.util.Scanner;

public class BoundInNumber {
    static int max_cnt=0;
    static int max_num=0;
    static String[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            int Answer = 0;
            int n = sc.nextInt(); // 숫자의 길이
            int k = sc.nextInt(); // 부분 배열의 길이
            int m = sc.nextInt(); // 구간의 길이
            String num = sc.next();
            boolean[] check = new boolean[num.length()-m];
            solution(num, k, m, check);
            for(int i=0; i<check.length; i++){
                if(!check[i]){
                    if(!check[i-1] && !check[i+1]){
                        String temp_str = num.substring(0,i) + "1" + num.substring(i+1, num.length());
                        System.out.println(temp_str);
                        String[] temp_arr = new String[k];
                        int cnt=0;
                        for(int j=0; j<k; j++){
                            temp_arr[i] = temp_str.substring(i-j, i-j+k);
                            if(Long.parseLong(temp_arr[i])>=max_num && Long.parseLong(temp_arr[i])<=max_num+m){
                                cnt++;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
    public static void solution(String num, int k, int m, boolean[] check){
        arr = new String[num.length()-m];
        for(int i=0; i<arr.length; i++){
            arr[i] = num.substring(i, i+k);
        }
        int cnt=0;
        ArrayList<Long> data = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            long a = Long.parseLong(arr[i]);
            if(data.contains(a))
                continue;
            data.add(a);
            for(int j=0; j<arr.length; j++){
                long b = Long.parseLong(arr[j]);
                if(b>=a && b<=a+m){
                    cnt++;

                }
            }
            if(cnt>max_cnt) {
                max_cnt = cnt;
                max_num = i;
            }
            cnt = 0;
        }
        for(int i=0; i<arr.length; i++){
            long a = Long.parseLong(arr[i]);
            if(Long.parseLong(arr[max_num])<=a && Long.parseLong(arr[max_num])+m>=a){
                check[i] = true;
            }
        }
        System.out.println(max_cnt);
    }
}
