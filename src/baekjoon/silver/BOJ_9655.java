package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ_9655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(N % 2 == 0 ? "CY" : "SK");
        sc.close();
    }
}
