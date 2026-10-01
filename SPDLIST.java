/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AIPulse;

/**
 *
 * @author xxfoa
 */
class SPDLIST {

    public Node Head;
    public Node Tail;
    public int size;

    public SPDLIST() {
        Head = Tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(String token) {
        token = token.toLowerCase();
        Node temp = Head;
        while (temp != null) {
            if (temp.token.equals(token)) {
                temp.frequency++;
                return;
            }
            temp = temp.next;
        }
        Node N = new Node(token);
        if (isEmpty()) {
            Head = Tail = N;
        } else {
            N.prev = Tail;
            Tail.next = N;
            Tail = N;
        }
        size++;
    }

    public int search(String token) {
        token = token.toLowerCase();
        Node temp = Head;
        while (temp != null) {
            if (temp.token.equals(token)) {
                return temp.frequency;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void remove(String token) {
        token = token.toLowerCase();
        Node temp = Head;
        while (temp != null) {
            if (temp.token.equals(token)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    Head = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    Tail = temp.prev;
                }
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    public void Traverse() {
        Node temp = Head;
        while (temp != null) {
            System.out.println(temp.token + " " + temp.frequency);
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        String str = "";
        Node temp = Head;
        while (temp != null) {
            str += temp.token + " " + temp.frequency + "\n";
            temp = temp.next;
        }
        return str;
    }
}
