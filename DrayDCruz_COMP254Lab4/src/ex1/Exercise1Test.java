package ex1;


public class Exercise1Test {

    public static void main(String[] args) {

        // create a new list object
        LinkedPositionalList<String> list = new LinkedPositionalList<>();

        // use addLast method to add elements and store positions
        Position<String> p1 = list.addLast("A");
        Position<String> p2 = list.addLast("B");
        Position<String> p3 = list.addLast("C");
        Position<String> p4 = list.addLast("D");

        // print list with foreach
        System.out.println("List contents:");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // test indexOf method
        System.out.println("Index of A: " + Exercise1.indexOf(list, p1));
        System.out.println("Index of B: " + Exercise1.indexOf(list, p2));
        System.out.println("Index of C: " + Exercise1.indexOf(list, p3));
        System.out.println("Index of D: " + Exercise1.indexOf(list, p4));
    }
}
