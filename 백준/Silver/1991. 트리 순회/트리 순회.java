import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        Node left;
        Node right;
        char val;

        public Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void createNode(Node head, char root, char left, char right) {

        if (head.val == root) {
            head.left = (left == '.' ? null : new Node(left, null, null));
            head.right = (right == '.' ? null : new Node(right, null, null));
        }

        else {
            if (head.left != null) createNode(head.left, root, left, right);
            if (head.right != null) createNode(head.right, root, left, right);
        }
    }

    public static void preOrder(Node node) {
        if (node == null) return;
        sb.append(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        sb.append(node.val);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node header = new Node('A', null, null);

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char root = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            createNode(header, root, left, right);
        }

        preOrder(header);
        sb.append("\n");
        inOrder(header);
        sb.append("\n");
        postOrder(header);

        System.out.println(sb);


    }
}