
/**
 * Calculates the difference between two strings
 * using the Damerau-Levenshtein Metric
 *
 * @author Samuel Barr + Grayson Fenwick
 * @version 11/05/18
 */
public class Difference {
    
    /**
     * Wrapper function to calculate difference
     * between two strings
     *
     * @param s1 String to compare to s2
     * @param s2 String to compare to s1
     */ 
    public static int calcDiff(String s1, String s2) {
        int x = 0;
        //If lengths differ, add 1 to result
        if (s1.length() != s2.length()) 
            x = 1;
        return diff(s1, s2, s1.length()-1, s2.length()-1) + x;    
    }
    
    /**
     * Recursive difference function derived by the 
     * dynamic programming approach from the 
     * Damerau-Levenshtein Metric.
     *
     * @param s1 String to compare
     * @param s2 String to compare
     * @param i index of s1
     * @param j index of s2
     */
    private static int diff(String s1, String s2, int i, int j) {
        //If at starting index, set no weight
        if (i == 0 && j == 0)
            return 0;
        //If at an edge, apply weight
        if (i == 0 || j == 0)
            return 1;
        
        int d = 1;
        //Apply no weight for equal characters
        if (s1.charAt(i) == s2.charAt(j))
            d = 0;

        //Apply weights for vertical and horizontal movement
        int ans = Math.min(diff(s1, s2, i-1, j) + 1,
                  Math.min(diff(s1, s2, i, j-1) + 1,
                        diff(s1, s2, i-1, j-1) + d)); 
       
        return ans;
    }

    /**
     * Usage: java Difference *string1* *string2*
     */
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        System.out.println("");
        try {
            s1 = args[0];
            s2 = args[1];
            System.out.println("Difference: " + calcDiff(s1, s2));
        }
        catch (Exception e) {
            System.out.println("Error: too few arguments");
            System.out.println("Usage: java Difference " +
                            "*string1* *string2*");
            System.exit(1);
        }
    }

}
