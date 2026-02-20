package exercise1;

public class exercise1 {
    public static int multiply(int m, int n) {

        // BASE CASE
        // If m is 0, then we add n 0 times, which is still 0. Stops recursion from going on infinitely.
        if (m == 0) {
            return 0;
        }
        // RECURSIVE CASE
        //  "Take group of n, calculate the rest of the groups by multiplying (m-1) * n."
        //  m * n meaning "add n, m times"
        // using subtraction (m - 1) to count down and addition (n + ...) to create the product
        return n + multiply(m - 1, n);  // same as multiply(m, n)
    }

    public static void main(String[] args) {
        // Testing the method
        int a = 5;
        int b = 3;

        // multiply(5, 3)
        System.out.println(a + " x " + b + " = " + multiply(a, b));

        //Extra
        System.out.println("4 x 7 = " + multiply(4, 7));  // 28
        System.out.println("8 x 2 = " + multiply(8, 2));  // 16
        System.out.println("1 x 9 = " + multiply(1, 9));  // 9
        System.out.println("0 x 6 = " + multiply(0, 6));  // 0 (base case)
    }
}



