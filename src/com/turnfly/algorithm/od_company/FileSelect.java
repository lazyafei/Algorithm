package com.turnfly.algorithm.od_company;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
class Node {
    Node parent;
    List<Node> children;
    int state;
    int val;

    public Node(int val, Node parent, List<Node> children, int state) {
        this.val = val;
        this.parent = parent;
        this.children = children;
        this.state = state;
    }
}

public class FileSelect {
    Map<Integer, Node> nodes = new HashMap<>();
    int total = 0;

    int selectNodes(int[][] dirTree, int[] operations) {
        Node root = createGraph(dirTree);
        for (int i : operations) {
            Node opNode = nodes.get(i);
            if (opNode.state != 2) {
                select(opNode);
            } else {
                cancel(opNode);
            }
        }
        countState(root);
        return total;
    }

    Node createGraph(int[][] dirTree) {
        Node root = new Node(dirTree[0][1], null, new ArrayList<>(), 0);
        nodes.put(dirTree[0][1], root);
        for (int[] pair : dirTree) {
            if (pair[0] == -1) continue;
            Node parent = nodes.getOrDefault(pair[0], new Node(pair[0], null, new ArrayList<>(), 0));
            Node child = nodes.getOrDefault(pair[1], new Node(pair[1], null, new ArrayList<>(), 0));
            parent.children.add(child);
            child.parent = parent;
            nodes.putIfAbsent(pair[0], parent);
            nodes.putIfAbsent(pair[1], child);
        }
        return root;
    }

    void select(Node node) {

    }

    void cancel(Node node) {
        node.state = 0;
        Node cur = node;
        while (cur.parent != null) {
            Node parent = cur.parent;
            List<Node> bros = parent.children;
            boolean isAll = true;
            for (Node bro : bros) {
                if (bro.state != 0) {
                    isAll = false;
                    break;
                }
            }
            parent.state = isAll ? 0 : 1;
            cur = cur.parent;
        }

        cancelAllChildren(node);
    }

    void cancelAllChildren(Node node) {
        for (Node n : node.children) {
            n.state = 0;
            cancelAllChildren(n);
        }
    }

    void countState(Node node) {
        if (node.state == 0) {
            total++;
        }
        List<Node> children = node.children;
        for (Node n : children) {
            countState(n);
        }
    }
}
