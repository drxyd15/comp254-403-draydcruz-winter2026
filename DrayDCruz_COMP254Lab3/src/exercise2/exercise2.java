package exercise2;
import java.util.Scanner;

public class exercise2 {
    public static boolean isPalindrome(String s) {

        // BASE CASE
        // If the string has 0 or 1 characters, it is automatically a palindrome.
        if (s.length() <= 1) {
            return true;
        }

        // Checks first and last chars
        // If they are different, it cannot be a palindrome.
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        // RECURSIVE
        // Remove the first and last characters and check remaining middle part.
        // racecar  -> check aceca
        // aceca   ->  check cec
        // cec     -> check e
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Palindrome Checker");
        System.out.println("Type a word or phrase (type 'exit' to quit)\n");

        while (true) {
            System.out.print("Enter text: ");
            String userInput = input.nextLine();

            // allow user to quit
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            // remove spaces and make lowercase for fair checking
            String cleaned = userInput.replaceAll("\\s+", "").toLowerCase();

            if (isPalindrome(cleaned)) {
                System.out.println("This IS a palindrome\n");
            } else {
                System.out.println("This is NOT a palindrome\n");
            }
        }
        input.close();
        System.out.println("Goodbye!");
    }
}


