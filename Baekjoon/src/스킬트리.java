
public class 스킬트리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		solution(skill, skill_trees);
	}
	
	public static void solution(String skill, String[] skill_trees) {
		int index=0;
		int answer=0;
		for(int i=0; i<skill_trees.length; i++) {
			String data = skill_trees[i];
			int flag=0;
			index=0;
			for(int j=0; j<data.length(); j++) {
				if(skill.contains(String.valueOf(data.charAt(j)))) {
					if(skill.charAt(index)==data.charAt(j)) {
						index++;
					}
					else {
						flag=1;
						break;
					}
				}
			}
			if(flag==0) {
				answer++;
				System.out.println(i + "번째 사용가능합니다.");
			}
		}
	}

}
