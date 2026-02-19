/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package exercise2;
/**
 * Demonstration of algorithms for computing the prefix averages of an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class exercise2 {

    /**
     * Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j].
     */
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];    // filled with zeros by default
        for (int j = 0; j < n; j++) {
            double total = 0;            // begin computing x[0] + ... + x[j]
            for (int i = 0; i <= j; i++)
                total += x[i];
            a[j] = total / (j + 1);        // record the average
        }
        return a;
    }

    /**
     * Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j].
     */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];    // filled with zeros by default
        double total = 0;              // compute prefix sum as x[0] + x[1] + ...
        for (int j = 0; j < n; j++) {
            total += x[j];               // update prefix sum to include x[j]
            a[j] = total / (j + 1);        // compute average based on current sum
        }
        return a;
    }

    public static void main(String[] args) {

        int n = 10000;     // starting size of array (input size)
        int trials = 10;   // how many times the test is run

        // Testing the faster algorithm (Linear)
        System.out.println("Testing prefixAverage2...");

        // repeat the test multiple times
        for (int t = 0; t < trials; t++) {

            // create an array of size n
            double[] data = new double[n];

            // fill the array with values (0,1,2,3 etc.)
            for (int i = 0; i < n; i++)
                data[i] = i;

            // record start time before running the algorithm
            long start = System.currentTimeMillis();

            // run the algorithm we want to measure
            prefixAverage2(data);

            // record time after it finishes
            long end = System.currentTimeMillis();

            // print how long it took
            System.out.println("n = " + n + " took " + (end - start) + " ms");

            // double the input size for the next trial to help see how runtime grows
            n *= 2;
        }

        // Testing slower algorithm (Quadratic)
        System.out.println("\nTesting prefixAverage1...");

        n = 10000;   // reset n back to the starting size

        for (int t = 0; t < trials; t++) {

            // create and fill array again
            double[] data = new double[n];
            for (int i = 0; i < n; i++)
                data[i] = i;

            // start timing
            long start = System.currentTimeMillis();

            // run slower algorithm
            prefixAverage1(data);

            // stop timing
            long end = System.currentTimeMillis();

            // print result
            System.out.println("n = " + n + " took " + (end - start) + " ms");

            // double size again for next test
            n *= 2;
        }
    }
}

 /*
    Both prefixAverage1 and prefixAverage2 were both tested by creating an array of size n and measuring
    how long each method took to run. From the results, prefixAverage1 becomes slow very quickly as n increases
    because it uses a nested loop. For every element in the array, it recalculates the total from the beginning,
    which causes the running time to grow a lot faster. Because of this, its time complexity is confirmed to be O(n²).

    On the other hand, prefixAverage2 runs much faster and scales much better. It keeps a running total instead
    of recalculating everything every time, so it only needs one loop. This means its time complexity is O(n).
    Overall, the test results show that prefixAverage2 is much more efficient than prefixAverage1 for larger input sizes.
 */

