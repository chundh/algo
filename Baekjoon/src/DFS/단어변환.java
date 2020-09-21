package DFS;

public class �ܾȯ {
	static int answer = 100; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		int len = target.length();
		int flag=0;
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(target)) {
				flag=1;
				break;
			}
		}
		if(flag==0)
			answer=0;
		else
			DFS(words, begin, target, 0, len);
		
		System.out.println("answer : " + answer);
	}
	//�켱������ target�� ���ڸ����� ���ڸ� begin�� �ռ��� �غ� �ܾ words�� ������� ����. ������ begin�� �ܾ�� ���ڸ��� �ٲ㰡�鼭 words�� �ִ� �ܾ�� ����.
	public static void DFS(String[] words, String begin, String target, int count, int len) {
		System.out.println("word : " + begin);
		String word[] = new String[len];
		for(int i=0; i<len; i++) {
			if(i==0) 
				word[i] = target.substring(0,1) + begin.substring(1,len);
			else if(i==len-1)
				word[i] = begin.substring(0,len-1) + target.substring(len-1,len);
			else
				word[i] = begin.substring(0,i) + target.substring(i,i+1) + begin.substring(i+1, len);
		}
		int flag=0;
		for(int i=0; i<words.length; i++) {
			for(int j=0; j<len; j++) {
				if(word[j].equals(target)) {
					count++;
					if(answer>count) {
						answer = count;
						return;
					}
				}
				if(words[i].equals(word[j])) {  //�迭�� word�� ������ �״�� ����
					System.out.println(word[j]);
					count++;
					words[i] = "";
					flag=1;
					DFS(words, word[j], target, count, len);
				}
			}
		}
		String data = "";
		if(flag==0) {  //�迭�� ���ԵǴ� word�� ������ ���� ���ڸ��� .���� ����ȭ�س��� �迭�� �´� �ܾ ã��
			for(int i=0; i<len; i++) {
				if(i==0) 
					data = "." + begin.substring(1,len);
				else if(i==len-1)
					data = begin.substring(0,len-1) + ".";
				else
					data = begin.substring(0,i) + "." + begin.substring(i+1, len);
				System.out.println(data);
				for(int j=0; j<words.length; j++) {
					if(words[j].matches(data)) {
						count++;
						String a = words[j];
						words[j] = "";
						DFS(words, a, target, count, len);
					}
				}
			}
		}	
	}
}
