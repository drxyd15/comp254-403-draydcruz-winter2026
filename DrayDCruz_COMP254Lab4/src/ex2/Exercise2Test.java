package ex2;


public class Exercise2Test {

    public static void main(String[] args) {

        // create two stacks
        LinkedStack<Integer> S = new LinkedStack<>();
        LinkedStack<Integer> T = new LinkedStack<>();

        // add elements to stack S
        S.push(10);
        S.push(20);
        S.push(30);
        S.push(40);

        // print stacks before transfer
        System.out.println("Before transfer:");
        System.out.println("Stack S: " + S);
        System.out.println("Stack T: " + T);

        // move all elements from S to T
        Exercise2.transfer(S, T);

        // print stacks after transfer
        System.out.println("\nAfter transfer:");
        System.out.println("Stack S: " + S);
        System.out.println("Stack T: " + T);
    }
}
