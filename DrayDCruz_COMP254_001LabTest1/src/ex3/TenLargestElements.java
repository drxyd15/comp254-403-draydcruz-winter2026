package ex3;

  /**
    TenLargestElements finds the ten largest elements in a given array. The algorithm performs up to 10
    linear searches of the array. Since 10 is a constant, the running time is already known to be O(n).
   */

public class TenLargestElements {

     // Returns the indices of the ten largest elements in array A.
     // If array has less than 10 elements, it returns all.
    public static int[] tenLargest(int[] A) {

        int n = A.length;   // # of elements in the array
        int k = 10;         // # of largest elements we want

        // if array has less than 10 elements, adjust k
        if (n < k) k = n;

        // array to store indices of the largest elements found
        int[] indices = new int[k];

        // checks/tracks which elements in array are already selected
        boolean[] used = new boolean[n];

        // repeat the search k # of times to find the next largest element
        for (int i = 0; i < k; i++) {

            int maxIndex = -1;   // will store index of current largest value

            // scan entire array to find largest unused element
            for (int j = 0; j < n; j++) {

                // select element if it has not been used yet AND maxIndex not set OR current element is larger
                if (!used[j] && (maxIndex == -1 || A[j] > A[maxIndex])) {
                    maxIndex = j;
                }
            }

            // store index of the largest element found in this pass
            indices[i] = maxIndex;

            // mark element as used so it won't be selected again
            used[maxIndex] = true;
        }

        return indices;  // return indices of the ten largest values
    }

    public static void main(String[] args) {

        // sample array
        int[] data = {8, 3, 15, 289, 105, 21, 6, 30, 1, 9, 12, 25, 500, 211, 101};

        // call method
        int[] result = tenLargest(data);

        // print results
        System.out.println("Ten largest elements:");

        // use indices to print actual values
        for (int i : result) {
            System.out.print(data[i] + " ");
        }
    }
}

