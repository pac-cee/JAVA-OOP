import java.util.*;

public class HuffmanCoding {
    static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;
        Node(char ch, int freq) { this.ch = ch; this.freq = freq; }
        Node(int freq, Node left, Node right) { this.ch = '\0'; this.freq = freq; this.left = left; this.right = right; }
        public int compareTo(Node n) { return this.freq - n.freq; }
    }
    public static Node buildHuffmanTree(char[] chars, int[] freqs) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < chars.length; i++) pq.add(new Node(chars[i], freqs[i]));
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node(left.freq + right.freq, left, right));
        }
        return pq.poll();
    }
    public static void printCodes(Node root, String code) {
        if (root == null) return;
        if (root.ch != '\0') System.out.println(root.ch + ": " + code);
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freqs = {5, 9, 12, 13, 16, 45};
        Node root = buildHuffmanTree(chars, freqs);
        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
}
