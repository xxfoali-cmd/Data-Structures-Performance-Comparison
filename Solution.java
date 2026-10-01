/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AIPulse;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author xxfoa
 */
public class Solution {

    static SPAVL avl = new SPAVL();
    static SPDLIST dlist = new SPDLIST();
    static int lastCommand = 0;

    public static void main(String[] args) throws IOException{
       
        PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/small.txt");
        PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/medium.txt");
        PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/large.txt");
        PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/xlarge.txt");
        PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/massive.txt");
    
        
        
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            int command = Integer.parseInt(line.substring(0, 1));
            String rest = line.length() > 2 ? line.substring(2).trim() : "";

            if (command == 1) {
                lastCommand = 1;
                String[] tokens = rest.split(" ");
                for (String token : tokens) {
                    avl.insert(token);
                }

            } else if (command == 2) {
                lastCommand = 2;
                String[] tokens = rest.split(" ");
                for (String token : tokens) {
                    dlist.insert(token);
                }

            } else if (command == 3) {
                if (lastCommand == 1) {
                    System.out.println(avl.search(rest));
                } else {
                    System.out.println(dlist.search(rest));
                }

            } else if (command == 4) {
                if (lastCommand == 1) {
                    avl.remove(rest);
                } else {
                    dlist.remove(rest);
                }

            } else if (command == 5) {
                if (lastCommand == 1) {
                    avl.Traverse();
                } else {
                    System.out.print(dlist.toString());
                }

            } else {
                System.out.println(-1);
                break;
            }
        }
    }
}
