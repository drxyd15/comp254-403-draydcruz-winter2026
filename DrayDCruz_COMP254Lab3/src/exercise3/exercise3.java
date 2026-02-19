package exercise3;
import java.io.File;
import java.util.Scanner;

public class exercise3 {


        public static void find(String path, String filename) {

            // Turn the path string into a File object
            File root = new File(path);

            // If path doesn't exist stop
            if (!root.exists()) {
                System.out.println("Path does not exist: " + path);
                return;
            }

            // Start the recursive helper on the root File
            findRecursive(root, filename);
        }

         // Helper method for real recursion.
         // checks the current file/folder, then recurses into children if it's a directory.

        private static void findRecursive(File current, String filename) {

            // Check current entry (file or directory) name
            // File.getName() returns just the last part (e.g., "test.txt")
            if (current.getName().equals(filename)) {
                // Print full path to know exactly where it is
                System.out.println("FOUND: " + current.getAbsolutePath());
            }

            // If it's a directory look inside it
            if (current.isDirectory()) {

                // listFiles() gives the directory contents but can also return null if no permissions
                File[] children = current.listFiles();
                if (children == null) {
                    // Can't read this folder; skip it
                    return;
                }

                // Recur on each child locating the file
                for (File child : children) {
                    findRecursive(child, filename);
                }
            }
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.println("Recursive File Finder (java.io.File)");
            System.out.print("Enter a starting path (folder): ");
            String path = input.nextLine();

            System.out.print("Enter the filename to search for (exact name): ");
            String filename = input.nextLine();

            System.out.println("\nSearching...\n");
            find(path, filename);

            System.out.println("\nDone.");
            input.close();
        }
}


