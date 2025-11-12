import java.util.Scanner;
public class Fibonacci {

    static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        int prev = 0, curr = 1, next = 0;
        for (int i = 2; i <= n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;  
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("\n--- Non-Recursive (Iterative) Approach ---");
        System.out.println("Fibonacci(" + n + ") = " + fibonacciIterative(n));

        System.out.println("\n--- Recursive Approach ---");
        System.out.println("Fibonacci(" + n + ") = " + fibonacciRecursive(n));

        sc.close();
    }
}


//  Non-Recursive (Iterative):
//    ➤ Time Complexity  : O(n)
//    ➤ Space Complexity : O(1)
//    ➤ Explanation: Loop runs n times, uses constant space.

//  Recursive:
//    ➤ Time Complexity  : O(2^n)
//    ➤ Space Complexity : O(n)
//    ➤ Explanation: Each call generates two more calls, creating an exponential tree of recursive calls.
