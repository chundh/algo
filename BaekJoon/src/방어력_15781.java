import java.util.*;
public class ¹æ¾î·Â_15781 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		ArrayList<Integer> helmet = new ArrayList<>();
		ArrayList<Integer> vest = new ArrayList<>();
		for(int i=0; i<a; i++) {
			helmet.add(sc.nextInt());
		}
		for(int i=0; i<b; i++) {
			vest.add(sc.nextInt());
		}
		int ba = 0;
		int bb = 0;
		
		for(int i=0; i<a;i++) {
			if(helmet.get(i)>ba)
				ba = helmet.get(i);
		}
		for(int i=0; i<b;i++) {
			if(vest.get(i)>bb)
				bb = vest.get(i);
		}
		System.out.println(ba+bb);
	}
}
