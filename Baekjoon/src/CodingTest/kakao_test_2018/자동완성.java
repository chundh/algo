package CodingTest.kakao_test_2018;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;


public class �ڵ��ϼ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"word","war","warrior","world"};
		
		solution(words);
	}

	public static void solution(String[] words) {
		Tri trie = new Tri();
		for(int i=0; i<words.length; i++) {
			trie.insert(words[i]);
		}
		
		for(int i=0; i<words.length; i++) {
			trie.check(words[i]);
		}
	}
}

class Tri {
    
    private TriNode root;
 
    /* Constructor */
    public Tri()    {
        root = new TriNode('\u0000');  //��Ʈ ��Ʈ����.
    }
    
    /**
     * Function name: insert 
     * �߰�
     */
    public void insert(String word) {
        if (search(word) == true) return;        
        TriNode current = root; 
        
        for (char ch : word.toCharArray() ) {
            TriNode child = current.subNode(ch);
            if (child != null) {            
                current = child;
            }
            else {
                 current.childList.add(new TriNode(ch));
                 current = current.subNode(ch);
            }
            current.count++;
            
            System.out.println(word  + " , " + current.nodeChar + " , " + current.count);
        }
        current.terminal = true;
    }
    
    public int check(String word) {
    	int cnt=0;
    	TriNode current = root; 
    	;  
        for (char ch : word.toCharArray() ) {
        	cnt++;
            TriNode child = current.subNode(ch);
            if (child != null) {            
                current = child;
            }
            else {
                 current.childList.add(new TriNode(ch));
                 current = current.subNode(ch);
            }
            if(current.count==1) {
            	break;
            }
        }
    	System.out.println(current.nodeChar + " , " + cnt);
    	return cnt;
    }
    
    /**
     * Function name: search 
     * �˻�
     */
    public boolean search(String word)
    {
        TriNode current = root;  
        
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
     * Function name: iterator 
     * Tri �� ����� �ܾ� ��� IteratorŸ������ ��ȯ
     */
    public Iterator<String> iterator() {
        Set<String> elementsInTri = new TreeSet<String>();

        recursiveCallPrint(root, "", elementsInTri); // ����� �����͸� elementsInTri�� ����
        Iterator<String> elementsInTriSet = elementsInTri.iterator();
    
        return elementsInTriSet;
    }

    /**
     * Function name: recursiveCallPrint
     */
    private void recursiveCallPrint(TriNode currNode, String key, Set<String> elementsInTri) {
        // adding only the words
        if (currNode.terminal) {
            elementsInTri.add(key);
        }

        LinkedList<TriNode> children = currNode.childList;
        Iterator<TriNode> childIter = children.iterator();

        String sKey = key;

        while (childIter.hasNext()) {
            TriNode nextNode = childIter.next();
            // ���ڿ� ��ġ�� (Ű+����)
            String s = sKey + nextNode.nodeChar;
            // ��� ȣ�� (���� ���, Ű��, �����)
            recursiveCallPrint(nextNode, s, elementsInTri);
        }
    }
    
    /**
     * Function name:printWord �ܼ�ȭ�鿡 ����� ������ ���
     */
    public void printWord() {

        System.out.println("��Elements in the Tri are :");

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
class TriNode implements Comparable<TriNode> {
    
    char nodeChar; //��������
    boolean terminal; //���� ��� ����
    int count; //ī��� (�ش��� ����)
    LinkedList<TriNode> childList; //�ڽ� ��� ����Ʈ
 
    
    /* Constructor */
    public TriNode(char c) {
        childList = new LinkedList<TriNode>();
        terminal = false;
        nodeChar = c;
        count = 0;
    }  
    
    boolean isTerminal() {
        return terminal;
    }
    
    //�ش� ��尡 ������ �ִ�  �ڽ� ���鿡�� �Է¹��� ���ڰ� �ִ��� �˻� 
    public TriNode subNode(char nextChar) {
        
        //System.out.println("subNode: "+nextChar);
        //System.out.println("subNode: "+childList);
        
        //Type1. ���� �˻�.
        if (childList != null) {
            for (TriNode eachChild : childList)
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
    public int compareTo(TriNode o) { // �񱳱��� ����
        TriNode other = o;
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
    
}//End Class TriNode