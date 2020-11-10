package CodingTest.kakao_test_2018;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class 압축 {

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
					System.out.println(data + " trie에 추가");
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
        root = new TrieNode('\u0000');  //루트 노트생성.
    }
    
    /**
     * Function name: insert 
     * 추가
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
     * 검색
     */
    public boolean search(String word)
    {
        TrieNode current = root;  
        
        //문자열을 문자 배열로 쪼개서 차례대로 비교
        for (char ch : word.toCharArray() ) { 
            if (current.subNode(ch) == null) return false; //해당 문자의 노드가 없으면 false리턴         
            else current = current.subNode(ch);//해당 문자가 존재하면 현재 노드에 
                                               //서브 노드 저장해서 단계별로 내려감 
        }      
        if (current.terminal == true) return true; //현재 노드가 단어의 끝인지 검사
        
        return false;
    }
    
    /**
     * Function name: remove 
     * 제거
     */
    public void remove(String word) {
        if (search(word) == false) {
            System.out.println(word +"는 존재하지 않는 문자열입니다.\n");
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
        
        //문자열을 문자 배열로 쪼개서 차례대로 비교
        for (char ch : word.toCharArray() ) { 
            if (current.subNode(ch) == null) return -1; //해당 문자의 노드가 없으면 false리턴         
            else current = current.subNode(ch);//해당 문자가 존재하면 현재 노드에 
                                               //서브 노드 저장해서 단계별로 내려감 
        }      
        if (current.terminal == true) return current.number; //현재 노드가 단어의 끝인지 검사
        
        return -1;
    }

    /**
     * Function name: iterator 
     * Trie 에 저장된 단어 목록 Iterator타입으로 반환
     */
    public Iterator<String> iterator() {
        Set<String> elementsInTrie = new TreeSet<String>();

        recursiveCallPrint(root, "", elementsInTrie); // 저장된 데이터를 elementsInTrie에 저장
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
            // 문자열 합치기 (키+문자)
            String s = sKey + nextNode.nodeChar;
            // 재귀 호출 (다음 노드, 키값, 저장셋)
            recursiveCallPrint(nextNode, s, elementsInTrie);
        }
    }
    
    /**
     * Function name:printWord 콘솔화면에 저장된 데이터 출력
     */
    public void printWord() {

        System.out.println("▶Elements in the TRIE are :");

        Iterator<String> itr = iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("===================");
    }
    
}    
 

/**
 * 트라이 노드 정의
 */
class TrieNode implements Comparable<TrieNode> {
    
    char nodeChar; //문자저장
    boolean terminal; //리프 노드 여부
    int number; //색인번호 
    LinkedList<TrieNode> childList; //자식 노드 리스트
 
    
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
    
    //해당 노드가 가지고 있는  자식 노드들에서 입력받은 문자가 있는지 검사 
    public TrieNode subNode(char nextChar) {
        
        //System.out.println("subNode: "+nextChar);
        //System.out.println("subNode: "+childList);
        
        //Type1. 순차 검색.
        if (childList != null) {
            for (TrieNode eachChild : childList)
                if (eachChild.nodeChar == nextChar)
                    return eachChild;
          }   
      
        return null;
        
            
        
        //Type2.        
        //이분검색(binary search) 알고리즘 적용 (childrenList의 요소가 정렬된 상태여야함)
        
        //리스트에 들어있는 데이터 정렬. 
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
    public int compareTo(TrieNode o) { // 비교기준 정의
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