package ex3;

/**
 * Tests the concatenate method.
 */
public class Exercise3Test {
    public static void main(String[] args) {

        // create two queues
        LinkedQueue<Integer> Q1 = new LinkedQueue<>();
        LinkedQueue<Integer> Q2 = new LinkedQueue<>();

        // add elements to first queue
        Q1.enqueue(1);
        Q1.enqueue(2);
        Q1.enqueue(3);

        // add elements to second queue
        Q2.enqueue(4);
        Q2.enqueue(5);
        Q2.enqueue(6);

        // print queues before concatenate
        System.out.println("Before concatenate:");
        System.out.println("Q1: " + Q1);
        System.out.println("Q2: " + Q2);

        // attach Q2 to the end of Q1
        Q1.concatenate(Q2);

        // print queues after concatenate
        System.out.println("\nAfter concatenate:");
        System.out.println("Q1: " + Q1);
        System.out.println("Q2: " + Q2);
    }
}
