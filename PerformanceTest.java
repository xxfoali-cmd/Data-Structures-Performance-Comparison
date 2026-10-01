/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AIPulse;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author xxfoa
 */
class PerformanceTest {

    public static void runTests(String fileName) throws IOException {
        SPAVL avl = new SPAVL();
        SPDLIST dlist = new SPDLIST();

        String[] tokens = readFile(fileName);

        System.out.println("========== File: " + fileName + " ==========");

        long startTime, endTime;

        startTime = System.nanoTime();
        for (String token : tokens)
            avl.insert(token);
        endTime = System.nanoTime();
        System.out.println("AVL Insert time (ms): " + (endTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        avl.search("the");
        endTime = System.nanoTime();
        System.out.println("AVL Search time (ms): " + (endTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        avl.remove("the");
        endTime = System.nanoTime();
        System.out.println("AVL Remove time (ms): " + (endTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        for (String token : tokens)
            dlist.insert(token);
        endTime = System.nanoTime();
        System.out.println("DList Insert time (ms): " + (endTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        dlist.search("the");
        endTime = System.nanoTime();
        System.out.println("DList Search time (ms): " + (endTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        dlist.remove("the");
        endTime = System.nanoTime();
        System.out.println("DList Remove time (ms): " + (endTime - startTime) / 1000000.0);

        System.out.println();
    }

    public static String[] readFile(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append(" ");
        }
        sc.close();
        return sb.toString().split("\\s+");
    }
}