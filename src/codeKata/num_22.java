package codeKata;

import java.util.Scanner;

public class num_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        solutions(a, b);
    }

    private static long solutions(int a, int b) {
        long answer = 0;
        if (a > b) {
            for (int i = b; i <= a; i++) {
                answer += i;
            }
        }
        if (a < b) {
            for (int i = a; i <= b; i++) {
                answer += i;
            }
        }
        if (a == b){
            answer = a;
        }
        return answer;
    }
}

