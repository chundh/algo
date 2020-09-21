package DFS;

//테스트 케이스 1번이 통과가안됨. 질문사항에 보면 1번케이스가 이상하다는 말이 많고 중복되는 티켓을 처리해야한다는데 문제가 이해가 안감.
public class 여행경로 {
	static String[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = {{"ICN", "COO"}, {"COO", "ICN"}, {"COO", "ICN"}};
		String[][] copy = new String[tickets.length][tickets[0].length];
		String[] arr = new String[tickets.length+1];
		answer = new String[tickets.length+1];
		int index=0;
		String start="ZZZ";
		String arrive="ZZZ";
		int flag=0;
		int cnt=0;
		/*
		for(int i=0; i<tickets.length; i++) {
			if(tickets[i][0].equals("ICN")) {
				if(tickets[i][1].compareTo(arrive)<0) {
					arrive = tickets[i][1];
					index = i;
				}
			}
		}
		tickets[index][0] = "null";
		tickets[index][1] = "null";
		arr[0] = "ICN";
		arr[1] = arrive;
		DFS(tickets, "ICN", arrive, 1, arr);
		*/
		for(int i=0; i<tickets.length; i++) {
			for(int j=i+1; j<tickets.length; j++) {
				if(!tickets[i][0].equals("null")) {
					if(tickets[i][0].equals(tickets[j][0])){
						if(tickets[i][1].equals(tickets[j][1])) {
								tickets[j][0] = "null";
								tickets[j][1] = "null";
								flag=1;
								cnt++;
						}
					}
				}
			}
		}
		if(flag==1) {
			arr = new String[tickets.length+1-cnt];
			answer = new String[arr.length];
		}
		
		for(int j=0; j<tickets.length; j++) {
			copy[j][0] = tickets[j][0];
			copy[j][1] = tickets[j][1];
		}
		
		for(int i=0; i<tickets.length; i++) {
			if(tickets[i][0].equals("ICN")) {
				start = "ICN";
				arrive = tickets[i][1];
				tickets[i][0] = "null";
				tickets[i][1] = "null";
				arr[0] = "ICN";
				arr[1] = arrive;
				DFS(tickets, "ICN", arrive, 1, arr);
				//copy = tickets;
				for(int j=0; j<tickets.length; j++) {
					tickets[j][0] = copy[j][0];
					tickets[j][1] = copy[j][1];
				}
				arr = new String[tickets.length+1];
			}
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static void DFS(String[][] tickets, String start, String arrive, int count, String[] arr) {
		System.out.println(count + ": " + start + " -> " + arrive);
		if(count==arr.length-1) { //횟수로 모든 티켓을 사용한 경우. tickets의 모든 데이터가 null이면 완성
			int flag = 0;
			for(int i=0; i<tickets.length; i++) {
				if(!tickets[i][0].equals("null")) {
					flag=1;
					return;
				}
			}
			if(flag==0) {
				if(answer[0]==null) {
					for(int i=0; i<arr.length; i++) {
						System.out.println("test:" + arr[i]);
						answer[i] = arr[i];
					}
				}
				else {
					if(arr.length<tickets.length)
						return;
					for(int i=0; i<answer.length; i++) {
						if(answer[i].compareTo(arr[i])>0) {
							answer = arr;
							break;
						}
					}
				}
				return;
			}
		}
		for(int i=0; i<tickets.length; i++) {
			if(tickets[i][0].equals(arrive)){  //티켓의 출발지랑 함수의 인자로 넘어온 도착지가 같은경우 (경유지로 선정가능한 경우)
				start = tickets[i][0];
				arrive = tickets[i][1];
				tickets[i][0] = "null";
				tickets[i][1] = "null"; 
				count++;
				arr[count] = arrive;
				DFS(tickets, start, arrive, count, arr);
			}
		}
	}
}
