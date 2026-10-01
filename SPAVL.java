/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AIPulse;

/**
 *
 * @author xxfoa
 */
 class SPAVL {

    AVLNode root;
    int size;

    public SPAVL() {
        this.root = null;
        this.size = 0;
    }

    int height(AVLNode n) {
        return (n == null) ? 0 : n.height;
    }

    int getBalance(AVLNode n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public void insert(String token) {
        token = token.toLowerCase();
        root = insertRec(root, token);
    }

    private AVLNode insertRec(AVLNode node, String token) {
        if (node == null) {
            size++;
            return new AVLNode(token, 1);
        }
        int cmp = token.compareTo(node.token);
        if (cmp < 0)
            node.left = insertRec(node.left, token);
        else if (cmp > 0)
            node.right = insertRec(node.right, token);
        else {
            node.frequency++;
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && token.compareTo(node.left.token) < 0)
            return rotateRight(node);
        if (balance < -1 && token.compareTo(node.right.token) > 0)
            return rotateLeft(node);
        if (balance > 1 && token.compareTo(node.left.token) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && token.compareTo(node.right.token) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public int search(String token) {
        token = token.toLowerCase();
        AVLNode node = searchRec(root, token);
        return (node != null) ? node.frequency : -1;
    }

    private AVLNode searchRec(AVLNode node, String token) {
        if (node == null) return null;
        int cmp = token.compareTo(node.token);
        if (cmp == 0) return node;
        if (cmp < 0) return searchRec(node.left, token);
        return searchRec(node.right, token);
    }

    public void remove(String token) {
        token = token.toLowerCase();
        root = removeRec(root, token);
    }

    private AVLNode removeRec(AVLNode node, String token) {
        if (node == null) return node;

        if (token.compareTo(node.token) < 0)
            node.left = removeRec(node.left, token);
        else if (token.compareTo(node.token) > 0)
            node.right = removeRec(node.right, token);
        else {
            size--;
            if (node.left == null || node.right == null) {
                AVLNode temp = (node.left != null) ? node.left : node.right;
                if (temp == null)
                    node = null;
                else
                    node = temp;
            } else {
                AVLNode temp = minValueAVLNode(node.right);
                node.token = temp.token;
                node.frequency = temp.frequency;
                node.right = removeRec(node.right, temp.token);
            }
        }

        if (node == null) return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0)
            return rotateRight(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0)
            return rotateLeft(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    AVLNode minValueAVLNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public void Traverse() {
        System.out.print(toString());
    }

    @Override
    public String toString() {
        return toStringRec(root);
    }

    private String toStringRec(AVLNode node) {
        if (node == null) return "";
        return toStringRec(node.left) +
               node.token + " " + node.frequency + "\n" +
               toStringRec(node.right);
    }
}