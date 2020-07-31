package īī�����Ͻʸ����׽�Ʈ;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;




public class ���α׷���3 {
	public static void main(String args[]) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"}; 
		String[] banned_id = {"fr*do"};
		
		solution(user_id, banned_id);
	}
	
	public static void solution(String[] user_id, String[] banned_id) {
		Trie[] trie = new Trie[8];
		int[] answer = new int[banned_id.length];
		
		for(int i=1; i<8; i++) {
			trie[i] = new Trie();
		}
		
		for(int i=0; i<user_id.length; i++) {  
			trie[user_id[i].length()].insert(user_id[i]);
		}
		for(int i=0; i<banned_id.length; i++) {
			trie[banned_id[i].length()].search_answer(banned_id[i], answer, i, trie[banned_id[i].length()].root);
		}
	}
}

class Trie {
    
    TrieNode root;
 
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
    public boolean search_answer(String word, int[] answer, int index, TrieNode current)
    {
    	int cnt=0;
        //���ڿ��� ���� �迭�� �ɰ��� ���ʴ�� ��
        for (char ch : word.toCharArray() ) {      
        	System.out.println(current.nodeChar + "------");
        	cnt++;
        	if(ch=='*') {
        		for(int i=0; i<current.childList.size(); i++) {
        			System.out.println(current.childList.get(i).nodeChar);
            		current.subNode(current.childList.get(i).nodeChar);
            		String w = word.substring(cnt, word.length());
            		System.out.println(w);
            		search_answer(w, answer, index, current);
            	}
        		return false;
        	}
            if (current.subNode(ch) == null) {
            	return false;
            }
            else { 
            	current = current.subNode(ch);//�ش� ���ڰ� �����ϸ� ���� ��忡 
            }                             //���� ��� �����ؼ� �ܰ躰�� ������
        }      
        
        if (current.terminal == true) {
        	System.out.println(word);
        	answer[index]++;
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