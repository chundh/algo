package 라인코테;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 프로그래밍5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] dataSource = {{"doc1", "t1", "t2", "t3"},
				{"doc2", "t0", "t2", "t3"},
				{"doc3", "t1", "t6", "t7"},
				{"doc4", "t1", "t2", "t4"},
				{"doc5", "t6", "t1", "t8"},
				{"doc6", "t2", "t100", "t3"},
				{"doc7", "t3", "t1", "t2"},
				{"doc8", "t2", "t4", "t5"},
				{"doc9", "t6", "t1", "t4"},
				{"doc10", "t1", "t14", "t8"},
				{"doc11", "t1", "t12", "t8"}};
		String[] tags = {"t1", "t2", "t3"};
		
		solution(dataSource, tags);
	}
	
	public static void solution(String[][] dataSource, String[] tags) {
		ArrayList<data> arr = new ArrayList<data>();
		int ans_size=0;
		for(int i=0; i<dataSource.length; i++) {
			int cnt=0;
			for(int j=1; j<dataSource[i].length; j++) {
				for(int k=0; k<tags.length; k++) {
					if(tags[k].equals(dataSource[i][j])) {
						cnt++;
					}
				}
			}
			if(cnt!=0)
				ans_size++;
			data d = new data(dataSource[i][0], cnt);
			arr.add(d);
		}
		Comparator<data> comp = new Comparator<data>() {
            @Override
            public int compare(data arg0, data arg1) {
            	if(arg0.cnt<arg1.cnt)
        			return 1;
        		else if(arg0.cnt>arg1.cnt)
        			return -1;
        		else {
        			return arg0.name.compareTo(arg1.name);
        		}
            }
        };
		Collections.sort(arr, comp);
		String[] answer = new String[ans_size];
		for(int i=0; i<arr.size(); i++) {
			if(i==10)
				break;
			if(arr.get(i).cnt==0)
				break;
			System.out.println(arr.get(i).name + " , " + arr.get(i).cnt);
			answer[i] = arr.get(i).name;
		}
	}

}
class data{
	String name;
	int cnt;
	public data(String name, int cnt) {
		this.name = name;
		this.cnt = cnt;
	}
}