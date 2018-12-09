import java.util.ArrayList;

public class StringTree {
    private Cluster root;
    private int numNodes = 0;
    private ArrayList<String> found;

    public StringTree() {
        found = new ArrayList<String>();
    }

    public void storeString(String s) {
        if (root == null) {
            numNodes++;
            root = new Cluster(numNodes, s, 0);
        }
        else {
            insert(s, root);
        }
    }

    public void insert(String s, Cluster c) {
        int centerDiff = Difference.calcDiff(c.getCenter(), s);
        int min = 1000;
        int minIndex = 0;
        for (int i = 0; i < c.getNumChildren(); i++) {
            Cluster child = c.getChild(i);
            int diff = Difference.calcDiff(s, child.getCenter());
            if (diff < min) {
                min = diff;
                minIndex = i;       
            }
        }
        if (centerDiff < min)
            c.insertString(s);
        else
            insert(s, c.getChild(minIndex));
    }

    /**
     * Wrapper for main serach method
     *
     * @param s String to search for
     * @param tolerance of difference
     */
    public void search(String s, int tolerance) {
        found.clear();
        recursiveSearch(s, tolerance, root);
    }

    /**
     * Checks to see if current cluster is within difference
     * range -- search cluster if it is.
     *
     * Find child with smallest difference and recurse on 
     * that child
     *
     * @param s string to search for
     * @param tolerance of difference
     * @param c Cluster to search
     */
    public void recursiveSearch(String s, int tolerance, Cluster c) {
        int minDiff = 0;
        //Find matches within current cluster
        if (Difference.calcDiff(c.getCenter(), s) <= c.getRadius() + tolerance) {
            ArrayList<String> strings = c.getStrings();
            for (int i = 0; i < strings.size(); i++) {
                if (Difference.calcDiff(strings.get(i), s) < tolerance)
                    found.add(strings.get(i));
            }
        }
        //If at a leaf, return
        if (c.getNumChildren() == 0)
            return;

        //Find child with smallest difference
        int min = 10000;
        int minIndex = 0; 
        for (int i = 0; i < c.getNumChildren(); i++) {
            Cluster child = c.getChild(i);
            int difference = Difference.calcDiff(child.getCenter(), s);
            if (difference < min) {
                min = difference;
                minIndex = i;
            }

        }
        //Recurse on child with smallest difference
        recursiveSearch(s, tolerance, c.getChild(minIndex));        
    }
    
    public ArrayList<String> getFound() { return found; }
}
