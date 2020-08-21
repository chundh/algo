package SCPC_6_minor;

import java.util.Scanner;

public class BoundInNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            int Answer = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();
            
            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////


            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
