package ex1;

 // Finds the index of a position (Position<E> in PositionalList<E>).

public class Exercise1 {

    public static <E> int indexOf(PositionalList<E> list, Position<E> p) {

        int index = 0; // tracks position number (0,1,2 etc.)

        // start from the first position in list
        Position<E> walk = list.first();

        // goes through list one position at a time
        while (walk != null) {

            // if same position is found, return its index
            if (walk == p) {
                return index;
            }

            // move to the next position
            walk = list.after(walk);

            // increase index as position moves forward
            index++;
        }
        // if position was not found
        return -1;
    }
}







