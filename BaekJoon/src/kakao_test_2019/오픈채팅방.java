package kakao_test_2019;

public class ����ä�ù� {
//78�� ������ �ڵ�. �׽�Ʈ���̽� 26~30���� �ð��ʰ��� ���ж��.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}

	public static void solution(String[] record) {
		info[] info = new info[record.length];
		String[] answer = new String[record.length];
		int answer_index=0;
		
		int index=0;
		for(int i=0; i<record.length; i++) {
			String id = record[i].split(" ")[1];
			info[i] = new info();
			if(record[i].contains("Enter")) {
				String name = record[i].split(" ")[2];
				answer[answer_index] = id + " ���� ���Խ��ϴ�.";
				answer_index++;
				if(getIndex(id, info)==-1) {
					info[index].id = id;
					info[index].name = name;
					index++;
				}
				else {
					info[getIndex(id, info)].name = name;
				}
			}
			else if(record[i].contains("Leave")) {
				answer[answer_index] = id + " ���� �������ϴ�.";
				answer_index++;
			}
			else if(record[i].contains("Change")) {
				String name = record[i].split(" ")[2];
				info[getIndex(id, info)].name = name;
			}
		}
		String[] ans = new String[answer_index];
		for(int i=0 ;i<answer_index; i++) {
			String stat = answer[i].split(" ")[2];
			String id = answer[i].split(" ")[0];
			if(stat.equals("���Խ��ϴ�.")) {
				ans[i] = info[getIndex(id, info)].name + "���� ���Խ��ϴ�.";
			}
			else if(stat.equals("�������ϴ�.")) {
				ans[i] = info[getIndex(id, info)].name + "���� �������ϴ�.";
			}
		}
		
	}
	
	public static int getIndex(String id, info[] record){
		int index = -1;
		for(int i=0; i<record.length; i++) {
			if(record[i].id.equals(id)) {
				index = i;
				break;
			}
			if(record[i].id.equals("null"))
				break;
		}
		return index;
	}
}

class info{
	String id;
	String name;
	
	info(){
		id = "null";
		name = "null";
	}
	
}