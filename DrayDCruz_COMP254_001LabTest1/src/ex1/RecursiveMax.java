package ex1;

public class RecursiveMax {

    // recursive method to find max
    public static int findMax(int[] A, int n) {

        // Base case, there's only one element in array
        if (n == 1) {
            return A[0];
        }

        // recursive case, find max of rest of array
        int maxRest = findMax(A, n - 1);

        // compare last element with max of rest
        return Math.max(A[n - 1], maxRest);
    }

    public static void main(String[] args) {

        int[] data = {3, 13, 22, 59, 12, 25, 72};

        // use findmax to find max element
        int max = findMax(data, data.length);

        System.out.println("Maximum value = " + max);
    }
}

