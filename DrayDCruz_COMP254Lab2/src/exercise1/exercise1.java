package exercise1;

class exercise1 {
    /**
     * Code for end-of-chapter exercises on asymptotics.
     *
     * @author Michael T. Goodrich
     * @author Roberto Tamassia
     * @author Michael H. Goldwasser
     */

        /** Returns the sum of the integers in given array. */
        public static int example1(int[] arr) {
            int n = arr.length, total = 0;
            for (int j=0; j < n; j++)       // loop from 0 to n-1
                total += arr[j];
            return total;
        }

        // Step 1: 3 ops
        // Step 2: 2n ops
        // Step 3: 3n ops
        // Step 4: 1 op

        // 5n + 4
        // Drop constant and keep 5n (largest growth)
        // 5n
        // Drop 5 from n since Big Oh ignores constant multipliers (growth rate is consistent no matter the constant)
        // left with just n therefore the Big Oh characterization would be
        // Big-Oh = O(n)

        /** Returns the sum of the integers with even index in given array. */
        public static int example2(int[] arr) {
            int n = arr.length, total = 0;
            for (int j=0; j < n; j += 2)    // note the increment of 2
                total += arr[j];
            return total;
        }

        // Step 1: 3 ops
        // Step 2: n ops (2n/2 since we're incrementing by 2, left with n)
        // Step 3: 3n/2 ops
        // Step 4: 1 op

        // Since n is really 2n/2 convert back to fraction to add
        // 2n/2 +3n/2 + 4
        // = 5n/2 + 4
        // Ignore constant multipliers/dividers Drop  5/2 +4
        // Big Oh: O(n)


        /** Returns the sum of the prefix sums of given array. */
        public static int example3(int[] arr) {
            int n = arr.length, total = 0;
            for (int j=0; j < n; j++)       // loop from 0 to n-1
                for (int k=0; k <= j; k++)    // loop from 0 to j
                    total += arr[j];
            return total;
        }

        // Step 1: 3 ops
        // Step 2: 2n ops
        // Step 3: n^2/2 ops (formally n(n+1))
        // Step 4: n(n+1)/2 ops
        // Step 5: 1 op

        // Since we know n^2 is the highest term we know that the Big Oh will be
        // Big Oh: O(n^2)

        /** Returns the sum of the prefix sums of given array. */
        public static int example4(int[] arr) {
            int n = arr.length, prefix = 0, total = 0;
            for (int j=0; j < n; j++) {     // loop from 0 to n-1
                prefix += arr[j];
                total += prefix;
            }
            return total;
        }

        // Step 1: 4 ops
        // Step 2: 2n ops
        // Step 3: 3n ops
        // Step 4: 2n ops
        // Step 5: 1 op
        // 7n + 5
        // Big Oh: O(n)


        /** Returns the number of times second array stores sum of prefix sums from first. */
        public static int example5(int[] first, int[] second) { // assume equal-length arrays
            int n = first.length, count = 0;
            for (int i=0; i < n; i++) {     // loop from 0 to n-1
                int total = 0;
                for (int j=0; j < n; j++)     // loop from 0 to n-1
                    for (int k=0; k <= j; k++)  // loop from 0 to j
                        total += first[k];
                if (second[i] == total) count++;
            }
            return count;
        }

        // Step 1: 3 ops
        // Step 2: 2n ops
        // Step 3: 1n or n ops
        // Step 4: 2n ops (how many times j runs)
        // Step 5: n(n+1)/2 ops (how many times k runs)
        // Step 6: n(n+1)/2 ops (how many times statement inside k loop runs)
        // Step 7:(n^3 + n^2)/2 ops
        // Step 8: 1 op

        //Dominant term is n^3 so we know Big-O = O(n^3)
    }


