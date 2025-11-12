// Program: Huffman Encoding using Greedy Algorithm (Simple Version)
// Author: Omkar Chechare

import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
    char ch;
    int freq;
    HuffmanNode left, right;

    HuffmanNode(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    public int compareTo(HuffmanNode other) {
        return this.freq - other.freq;
    }
}

public class SimpleHuffman {

    // Generate Huffman Codes
    static void printCodes(HuffmanNode root, String code) {
        if (root == null)
            return;

        // If leaf node, print character and its code
        if (root.left == null && root.right == null)
            System.out.println(root.ch + " : " + code);

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Step 1: Count frequency of each character
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        // Step 2: Create min-heap (priority queue)
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e : freq.entrySet())
            pq.add(new HuffmanNode(e.getKey(), e.getValue()));

        // Step 3: Build Huffman Tree
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode newNode = new HuffmanNode('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }

        // Step 4: Print Huffman Codes
        System.out.println("\nHuffman Codes:");
        printCodes(pq.peek(), "");

        sc.close();
    }
}

/*
📊 Complexity:
Time  : O(n log n)
Space : O(n)
*/
