package kakao_test_2019;

public class ÈÄº¸Å° {
	static int answer=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},
				{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		solution(relation);
	}
	public static void solution(String[][] relation) {
		int flag= 0;
		for(int i=0; i<relation[0].length; i++) {
			flag=0;
			for(int j=0; j<relation.length; j++) {
				for(int k=j+1; k<relation.length; k++) {
					if(relation[j][i] == relation[k][i]) {
						flag=1;
						break;
					}
				}
				if(flag==1)
					break;
			}
			if(flag==0)
				System.out.println(i);
		}
	}

}
