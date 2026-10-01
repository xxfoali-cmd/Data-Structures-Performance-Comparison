/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AIPulse;

/**
 *
 * @author xxfoa
 */
 class AVLNode {
    String token;
    int frequency;
    int height;
    AVLNode left;
    AVLNode right;
    
     AVLNode() {
       this.height = 1;
    }

    AVLNode(String token, int frequency) {
        this.token = token;
        this.frequency = frequency;
        this.height = 1;
    }
}
