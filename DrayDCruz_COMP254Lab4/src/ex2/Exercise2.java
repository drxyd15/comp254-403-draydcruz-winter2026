package ex2;

// Transfer method to remove from one stack to another

public class Exercise2 {

    // Transfer method
    public static <E> void transfer(LinkedStack<E> S, LinkedStack<E> T) {

        // move elements until S is empty
        while (!S.isEmpty()) {

            // remove top element of S and push it to T
            T.push(S.pop());
        }
    }
}