import java.util.*;

class Solution {
    
    private static class Node {
        boolean removed;
        Node prev;
        Node next;
    }
    
    static Node[] nodeArr = new Node[1_000_000];
    
    public String solution(int n, int k, String[] cmd) {
        
        for (int i = 0; i < n; i++) {
            nodeArr[i] = new Node();
        }
        
        for (int i = 1; i < n; i++) {
            nodeArr[i - 1].next = nodeArr[i];
            nodeArr[i].prev = nodeArr[i - 1];
        }
        
        Node cur = nodeArr[k];
        Stack<Node> stack = new Stack<>();
        
        for (String c : cmd) {
            char ch = c.charAt(0);
            
            if (ch == 'U') {
                int index = Integer.parseInt(c.substring(2));
                
                for (int i = 0; i < index; i++) {
                    cur = cur.prev;
                }
                
            } else if (ch == 'D') {
                int index = Integer.parseInt(c.substring(2));
                
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
                
            } else if (ch == 'C') {
                
                stack.push(cur);
                cur.removed = true;
                
                Node up = cur.prev;
                Node down = cur.next;
                
                if (up != null) {
                    up.next = down;
                }
                
                if (down != null) {
                    down.prev = up;
                    cur = down;
                } else {
                    cur = up;
                }
                
            } else { // 'Z'
                if (!stack.isEmpty()) {
                    Node node = stack.pop();
                    node.removed = false;
                    
                    Node up = node.prev;
                    Node down = node.next;
                    
                    
                    if (up != null) {
                        up.next = node;
                    }
                    
                    if (down != null) {
                        down.prev = node;
                    }
                    
                }
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            Node node = nodeArr[i];
            
            if (node.removed) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }
        
        return sb.toString();
    }
}