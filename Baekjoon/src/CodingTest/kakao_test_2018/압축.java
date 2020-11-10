package CodingTest.kakao_test_2018;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS";
		solution(msg);
	}
	
	public static void solution(String msg) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int index=27;
		Trie trie = new Trie();
		for(int i=0; i<26; i++) {
			trie.insert(String.valueOf(Character.valueOf((char) (65 + i))) , i+1);
		}
		int count=0;
		String data="";
		while(true) {
			if(count>=msg.length())
				break;
			for(int i=count; i<msg.length(); i++) {
				data += msg.substring(i, i+1);
				//System.out.println("data : " + data);
				if(!trie.search(data)) {
					trie.insert(data, index);
					index++;
					System.out.println(data + " trie�� �߰�");
					count += data.length()-1;
					data = data.substring(0, data.length()-1);
					arr.add(trie.getNumber(data));
					data = "";
					break;
				}
			}
		}
		System.out.println(arr.size());
		int[] answer = new int[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			answer[i] = arr.get(i);
		}
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
    public void insert(String word, int index) {
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
                 current.number = index;
            }
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
            if (current.subNode(ch) == null) return false; //�ش� ������ ��尡 ������ false����         
            else current = current.subNode(ch);//�ش� ���ڰ� �����ϸ� ���� ��忡 
                                               //���� ��� �����ؼ� �ܰ躰�� ������ 
        }      
        if (current.terminal == true) return true; //���� ��尡 �ܾ��� ������ �˻�
        
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
            if (child.number == 1) {
                current.childList.remove(child);
                return;
            } 
            else {
                child.number--;
                current = child;
            }
        }
        current.terminal = false;
    }
    
    public int getNumber(String word) {
    	TrieNode current = root;  
        
        //���ڿ��� ���� �迭�� �ɰ��� ���ʴ�� ��
        for (char ch : word.toCharArray() ) { 
            if (current.subNode(ch) == null) return -1; //�ش� ������ ��尡 ������ false����         
            else current = current.subNode(ch);//�ش� ���ڰ� �����ϸ� ���� ��忡 
                                               //���� ��� �����ؼ� �ܰ躰�� ������ 
        }      
        if (current.terminal == true) return current.number; //���� ��尡 �ܾ��� ������ �˻�
        
        return -1;
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
    
}    
 

/**
 * Ʈ���� ��� ����
 */
class TrieNode implements Comparable<TrieNode> {
    
    char nodeChar; //��������
    boolean terminal; //���� ��� ����
    int number; //���ι�ȣ 
    LinkedList<TrieNode> childList; //�ڽ� ��� ����Ʈ
 
    
    /* Constructor */
    public TrieNode(char c) {
        childList = new LinkedList<TrieNode>();
        terminal = false;
        nodeChar = c;
        number = 0;
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