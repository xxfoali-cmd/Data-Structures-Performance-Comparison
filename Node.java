/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AIPulse;

/**
 *
 * @author xxfoa
 */
 class Node {

    public Node prev;
    public Node next;
    public String token;
    public int frequency;
    
    public Node() {
    prev = next = null;
    token = null;
    frequency = 0;
}

    public Node(String token) {
        prev = next = null;
        this.token = token;
        this.frequency = 1;
    }

}
