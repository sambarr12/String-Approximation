import java.util.Scanner;
import java.util.ArrayList;

public class Approximation {
    
    public static void main(String[] args) {
        StringTree tree = new StringTree();
        Scanner keyboard = new Scanner(System.in);

        int tolerance = Integer.parseInt(args[0]);

        System.out.println("Enter strings to put in dictionary: ");
        String input = "";
        do {
            input = keyboard.nextLine();
            tree.storeString(input);
        } while (!input.equals("exit"));
        
        System.out.println("Enter search strings (tolerance: " + tolerance + ")");
        do {
            input = keyboard.nextLine();
            if (input.equals("exit")) break;

            tree.search(input, 3);
            ArrayList ans = tree.getFound();
            System.out.println("Found Strings: " + ans.size());
            for (int i = 0; i < ans.size(); i++)
                System.out.println(ans.get(i));

            System.out.println();

        } while (!input.equals("exit"));
        
    }
}
