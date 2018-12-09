public class StringTree {
    private Cluster root;
    private int numNodes = 0;

    public void storeString(String s) {
        if (numNodes == 0) {
            numNodes++
            root = new Cluster(numNodes, s, 0);
        }
        else if (numNodes == 1) {
            
        }
    }

    /**
     * Wrapper for main serach method
     *
     * @param s String to search for
     * @param tolerance of difference
     */
    public Cluster search(String s, int tolerance) {
        return recursiveSearch(s, tolerance, root);
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
    public Cluster recursiveSearch(String s, int tolerance, Cluster c) {
        int minDiff = 0;
        if (calcDiff(c.getCenter, s) <= c.getRadius() + tolerance) {
            //TODO: Search within current cluster for match
        }
        //Find child with smallest difference
        int min = 10000;
        int minIndex = 0; 
        for (int i = 0; i < c.getNumChildren(); i++) {
            Cluster child = c.getChild(i);
            int difference = caclDiff(child.getCenter(), s);
            if (difference < min) {
                min = difference;
                minIndex = i;
            }

        }
        //Recurse on child with smallest difference
        search(s, tolerance, c.getChild(minIndex);        
    }

}
