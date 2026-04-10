package ex1;

import java.util.Random;
import ex1.maps.ChainHashMap;

public class Exercise1Test {

    public static void main(String[] args) {
        int n = 50000;  // number of keys to test
        int[] keys = generateRandomKeys(n);

        double[] loadFactors = {0.25, 0.50, 0.75, 1.00};

        System.out.println("Testing ChainHashMap with random keys");
        System.out.println("Number of keys: " + n);
        System.out.println();

        for (double lf : loadFactors) {
            testMap(keys, lf);
            System.out.println("--------------------------------------");
        }
    }

    /**
     * Generates an array of random integer keys.
     */
    private static int[] generateRandomKeys(int n) {
        Random rand = new Random();
        int[] keys = new int[n];

        for (int i = 0; i < n; i++) {
            keys[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        return keys;
    }

    /**
     * Tests insertion and retrieval for one chosen load factor.
     */
    private static void testMap(int[] keys, double loadFactor) {
        ChainHashMap<Integer, Integer> map = new ChainHashMap<>(17, loadFactor);

        // Measure insertion time
        long startPut = System.nanoTime();
        for (int key : keys) {
            map.put(key, key);
        }
        long endPut = System.nanoTime();

        // Measure retrieval time
        long startGet = System.nanoTime();
        for (int key : keys) {
            map.get(key);
        }
        long endGet = System.nanoTime();

        long putTime = endPut - startPut;
        long getTime = endGet - startGet;

        System.out.println("Load factor limit: " + loadFactor);
        System.out.println("Final size: " + map.size());
        System.out.println("Insertion time: " + putTime / 1_000_000.0 + " ms");
        System.out.println("Search time:    " + getTime / 1_000_000.0 + " ms");
    }
}