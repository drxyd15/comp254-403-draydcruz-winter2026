package exercise3;

import java.util.Arrays;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class exercise3 {

    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j=0; j < n-1; j++)
            for (int k=j+1; k < n; k++)
                if (data[j] == data[k])
                    return false;                    // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);   // make copy of data
        Arrays.sort(temp);                     // and sort the copy
        for (int j=0; j < n-1; j++)
            if (temp[j] == temp[j+1])            // check neighboring entries
                return false;                      // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    public static void main(String[] args) {

        int n = 730000;   // change number manually each time (730 000 or 500 000 000)

        int[] data = new int[n]; // create array of integers

        // fill array with unique values
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }

        long start = System.currentTimeMillis();  // start time
        unique1(data);                             // change to unique2(data) to test the other one
        long end = System.currentTimeMillis(); // end time
        System.out.println("n = " + n);
        System.out.println("Time (seconds) = " + (end - start) / 1000.0);
    }
}

// For this exercise I tested unique1 and unique2, gradually increasing n so each runtime is approx. 60s or just under.
// After testing multiple numbers The results concluded unique1 max n was approx. 730,000 (57 seconds, under 60 seconds).
// The highest unique2 max for n was approx 500,000,000 (1.921 seconds). Due to limited memory,
// larger values could not be tested for unique2 because the program throws a heap memory error.
// Therefore, approx 500,000,000 is the largest effective n on my machine.