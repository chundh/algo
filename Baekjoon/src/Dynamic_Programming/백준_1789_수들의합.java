package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Scanner;

public class ����_1789_�������� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        ArrayList<Long> arr = new ArrayList<>();
        arr.add((long) 1);
        int answer = 0;
        for(int i=2; ; i++){
            long data = arr.get(arr.size()-1)+i;
            if(data>s){
                answer = i-1;
                break;
            }else {
                arr.add(data);
            }
        }
        System.out.println(answer);
    }
}
