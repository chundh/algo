package kakao_test_2020;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//ȿ���� 1,2,3���� ��� �ȵ�. ���ڿ� �񱳿��� �ϳ��ϳ� ���ϴ� ����� ����ϸ� ȿ������ ����� �� ����. Ʈ���̶�� �ڷᱸ���� ����ؾ� ��. ��������.
public class ����˻� {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o" , "fr???", "fro???", "pro?"};
		
		int[] answer = new int[queries.length];
		
		Trie[] trie = new Trie[10000];
		Trie[] reverse_trie = new Trie[10000];

		for(int i=0; i<10000; i++) {
			trie[i] = new Trie();
			reverse_trie[i] = new Trie();
		}
		
		for(int i=0; i<words.length; i++) {  
			trie[words[i].length()].insert(words[i]);
			String data = "";
			for(int j=words[i].length()-1; j>-1; j--) {
				data += words[i].charAt(j);
			}
			reverse_trie[words[i].length()].insert(data);
		}
		
		for(int i=0; i<queries.length; i++) {
			if(queries[i].charAt(0) == '?') {
				String data = "";
				for(int j=queries[i].length()-1; j>-1; j--) {
					data += queries[i].charAt(j);
				}
				reverse_trie[queries[i].length()].search_answer(data, answer, i);
			}
			else {
				trie[queries[i].length()].search_answer(queries[i], answer, i);
			}
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
		 /*
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		 for(int i =0; i<words.length; i++){
	        	//�ܾ�����, �ߺ�����
	            map.put(words[i], map.getOrDefault(words[i], 0)+1);  //�ش� �ǻ��� ������ ������ ���� ��ȯ, ������ 0�� ��ȯ.
	     }
		 Set<String> keySet = map.keySet(); //�ܾ�����.
		 
		
		 for(String key : keySet) {
			 System.out.println(key + " , " + trie.contains(key));
		 }
		 
	     for(int i=0; i<queries.length; i++) {
	    	 int count=0;
	    	 int start=0;
	    	 int end=0;
	    	 int flag=0;
	    	 if(queries[i].charAt(0) == '?') { //?�� �տ����� ����. 
	    		 for(int j=0; j<queries[i].length(); j++) {
		    		 if(queries[i].charAt(j)!='?') {
		    			 end = j-1;
		    			 break;
		    		 }
		    	 }
	    	 }
	    	 else if(queries[i].charAt(0) != '?') {  //?�� �ڿ� ����.
	    		 for(int j=0; j<queries[i].length(); j++) {
		    		 if(queries[i].charAt(j)=='?') {
		    			 start = j;
		    			 break;
		    		 }
		    	 }
	    		 flag=1;
	    	 }
	    	 String data = "";
	    	 if(start==0) {
	    		 data = queries[i].substring(end+1, queries[i].length());
	    	 }
	    	 else {
	    		 data = queries[i].substring(0, start);
	    	 }
	    	 
	    	 for(String key : keySet) {
	    		 int len = 0;
	    		 if(key.length() == queries[i].length()) {
	    			if(flag==0) {  //?�� �տ� �����Ƿ� �ڿ��� ���� üũ
		 	     		for(int j=0; j<data.length(); j++) {
		 	     			if(data.charAt(data.length()-1-j) != key.charAt(key.length()-1-j)) {
		 	     				break;
		 	     			}
		 	     			len++;
		 	     		}
		 	     	}
		 	     	else if(flag==1) {  //?�� �ڿ� �����Ƿ� �տ������� üũ
		 	     		for(int j=0; j<data.length(); j++) {
		 	     			if(data.charAt(j) != key.charAt(j)) {
		 	     				break;
		 	     			}
		 	     			len++;
		 	     		}
		 	     	}
	    			if(len == data.length()) {
	    				count++;
	    			}
	    		}
	 	     }
	    	 answer[i] = count;
	    	 count = 0;
	     }
	     */
	}

}
class Trie {
    
    private TrieNode root;
 
    /* Constructor */
    public Trie()    {
        root = new TrieNode('\u0000');  //��Ʈ ��Ʈ����.
    }
    
    /**
     * Function name: insert 
     * �߰�
     */
    public void insert(String word) {
        if (search(word) == true) return;        
        TrieNode current = root; 
        
        for (char ch : word.toCharArray() ) {
            TrieNode child = current.subNode(ch);
            if (child != null) {            
                current = child;
            }
            else {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.count++;
        }
        current.terminal = true;
    }
    
    /**
     * Function name: search 
     * �˻�
     */
    public boolean search(String word)
    {
        TrieNode current = root;  
        //���ڿ��� ���� �迭�� �ɰ��� ���ʴ�� ��
        for (char ch : word.toCharArray() ) {       	
        	if(ch == '?') {
        		System.out.println("count : " + getCount(current));
        		//answer[index] = getCount(current);
        		return true;
        	}
            if (current.subNode(ch) == null) {
            	return false;
            }
            else current = current.subNode(ch);//�ش� ���ڰ� �����ϸ� ���� ��忡 
                                               //���� ��� �����ؼ� �ܰ躰�� ������
        }      
        
        if (current.terminal == true) {
        	return true; //���� ��尡 �ܾ��� ������ �˻�
        }
        
        return false;
    }
    
    /**
     * Function name: remove 
     * ����
     */
    public void remove(String word) {
        if (search(word) == false) {
            System.out.println(word +"�� �������� �ʴ� ���ڿ��Դϴ�.\n");
            return;
        }             
        TrieNode current = root;
        for (char ch : word.toCharArray()) { 
            TrieNode child = current.subNode(ch);
            if (child.count == 1) {
                current.childList.remove(child);
                return;
            } 
            else {
                child.count--;
                current = child;
            }
        }
        current.terminal = false;
    }

    /**
     * Function name: iterator 
     * Trie �� ����� �ܾ� ��� IteratorŸ������ ��ȯ
     */
    public Iterator<String> iterator() {
        Set<String> elementsInTrie = new TreeSet<String>();

        recursiveCallPrint(root, "", elementsInTrie); // ����� �����͸� elementsInTrie�� ����
        Iterator<String> elementsInTrieSet = elementsInTrie.iterator();
    
        return elementsInTrieSet;
    }

    /**
     * Function name: recursiveCallPrint
     */
    private void recursiveCallPrint(TrieNode currNode, String key, Set<String> elementsInTrie) {
        // adding only the words
        if (currNode.terminal) {
            elementsInTrie.add(key);
            System.out.println(key + "-count : " + currNode.count);
        }

        LinkedList<TrieNode> children = currNode.childList;
        Iterator<TrieNode> childIter = children.iterator();

        String sKey = key;

        while (childIter.hasNext()) {
            TrieNode nextNode = childIter.next();
            // ���ڿ� ��ġ�� (Ű+����)
            String s = sKey + nextNode.nodeChar;
            // ��� ȣ�� (���� ���, Ű��, �����)
            recursiveCallPrint(nextNode, s, elementsInTrie);
        }
    }
    
    /**
     * Function name:printWord �ܼ�ȭ�鿡 ����� ������ ���
     */
    public void printWord() {

        System.out.println("��Elements in the TRIE are :");

        Iterator<String> itr = iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("===================");
    }
    
    public int getCount(TrieNode currNode) {
    	int a = 0;
    	if(currNode.terminal) {
    		return 1;
    	}
    	for(int i=0; i<currNode.childList.size(); i++) {
    		a += getCount(currNode.childList.get(i));
    	}
    	
		return a;
    }
    public boolean search_answer(String word, int[] answer, int index)
    {
        TrieNode current = root;  
        //���ڿ��� ���� �迭�� �ɰ��� ���ʴ�� ��
        for (char ch : word.toCharArray() ) {       	
        	if(ch == '?') {
        		//System.out.println("count : " + getCount(current));
        		answer[index] = getCount(current);
        		return true;
        	}
            if (current.subNode(ch) == null) {
            	return false;
            }
            else current = current.subNode(ch);//�ش� ���ڰ� �����ϸ� ���� ��忡 
                                               //���� ��� �����ؼ� �ܰ躰�� ������
        }      
        
        if (current.terminal == true) {
        	return true; //���� ��尡 �ܾ��� ������ �˻�
        }
        
        return false;
    }
}    
 

/**
 * Ʈ���� ��� ����
 */
class TrieNode implements Comparable<TrieNode> {
    
    char nodeChar; //��������
    boolean terminal; //���� ��� ����
    int count; //ī��� (�ش��� ����)
    LinkedList<TrieNode> childList; //�ڽ� ��� ����Ʈ
 
    
    /* Constructor */
    public TrieNode(char c) {
        childList = new LinkedList<TrieNode>();
        terminal = false;
        nodeChar = c;
        count = 0;
    }  
    
    boolean isTerminal() {
        return terminal;
    }
    
    //�ش� ��尡 ������ �ִ�  �ڽ� ���鿡�� �Է¹��� ���ڰ� �ִ��� �˻� 
    public TrieNode subNode(char nextChar) {
        
        //System.out.println("subNode: "+nextChar);
        //System.out.println("subNode: "+childList);
        
        //Type1. ���� �˻�.
        if (childList != null) {
            for (TrieNode eachChild : childList)
                if (eachChild.nodeChar == nextChar)
                    return eachChild;
          }   
      
        return null;
        
            
        
        //Type2.        
        //�̺а˻�(binary search) �˰��� ���� (childrenList�� ��Ұ� ���ĵ� ���¿�����)
        
        //����Ʈ�� ����ִ� ������ ����. 
        //Collections.sort(childList);
        //System.out.println(childList);      
        
        /*
        int min= 0;
        int max= childList.size() - 1;
        int mid= 0;
        while (min < max) {
            mid = (min + max) / 2;
            if (childList.get(mid).nodeChar == nextChar)
                return childList.get(mid);
            if (childList.get(mid).nodeChar < nextChar)
                min = mid + 1;
            else
                // if (children[mid].nodeChar > nextChar)
                max = mid - 1;
        }
        if (min == max)
            if (childList.get(min).nodeChar == nextChar)
                return childList.get(min);
        
        return null;
        */
    }//subNode()

        
    @Override
    public int compareTo(TrieNode o) { // �񱳱��� ����
        TrieNode other = o;
        if (this.nodeChar < other.nodeChar)
            return -1;
        if (this.nodeChar == other.nodeChar)
            return 0;
        // if (this.nodeChar > other.nodeChar)
        return 1;
    }// compareTo()
    
    
    @Override
    public String toString() {
        return this.nodeChar+"("+this.terminal+") ";
    }//toString()
    
}//End Class TrieNode