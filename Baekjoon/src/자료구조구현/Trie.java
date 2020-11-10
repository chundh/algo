package 자료구조구현;

import java.util.HashMap;

public class Trie {
    public TrieNode rootNode;

    Trie(){
        this.rootNode = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            // 해당char가 map에 없을 경우 데이터를 map에 넣는다.
            node = node.getChildNode().computeIfAbsent(word.charAt(i), c->new TrieNode());
        }
        // 가장 마지막 노드까지 이동한 후 isLastChar를 true로 만들어준다.
        node.setLastChar(true);
    }

    public boolean contains(String word){
        TrieNode node = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            // 해당 자식 노드에서 word의 i번째 idx에 해당하는 노드로 이동한다. 만약null이라면 없는 것이므로 false
            node = node.getChildNode().get(word.charAt(i));
            if(node==null){
                return false;
            }
        }
        return node.isLastChar();
    }

    public void delete(String word){
        delete(word, this.rootNode, 0);
    }
    private void delete(String word, TrieNode node, int idx){
        char tempChar = word.charAt(idx);
        if(!node.getChildNode().containsKey(tempChar)){
            // 존재하지 않는 단어인 경우
            return;
        }
        TrieNode childnode = node.getChildNode().get(tempChar);
        idx++;
        if (idx==word.length()){
            // 지우고자 하는 단어 끝까지 왔지만 현재 노드가 마지막 노드가 아닌 경우. ex) PI PIE
            if(!childnode.isLastChar()){
                return;
            }
            // 자식 노드가 자식이 없는 경우 -> 삭제 시작 노드.
            if(childnode.getChildNode().isEmpty()){
                node.getChildNode().remove(tempChar);
            }
        }else{
            delete(word, childnode, idx);
            // 현재 노드의 자식노드를 마지막으로 하는 단어가 없고, 자식노드의 자식도 없는 경우 삭제.
            if(!childnode.isLastChar() && childnode.getChildNode().isEmpty())
                node.getChildNode().remove(tempChar);
        }
    }
    public void print(){
        TrieNode node = this.rootNode;
        print("", node);
    }
    private void print(String word, TrieNode node){
        if(node.isLastChar()){
            System.out.println(word);
        }
        for (char next : node.getChildNode().keySet()){
            print(word+next, node.getChildNode().get(next));
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("911");
        trie.insert("97625999");
        trie.insert("91125426");

        trie.print();
    }
}

class TrieNode{
    // 자식 노드 맵
    private HashMap<Character, TrieNode> childNode = new HashMap<>();
    // 마지막 노드인지 여부
    private boolean isLastChar;

    public HashMap<Character, TrieNode> getChildNode() {
        return childNode;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean lastChar) {
        isLastChar = lastChar;
    }
}