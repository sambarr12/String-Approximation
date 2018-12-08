import java.util.ArrayList;
/**
 * Cluster node
 * Defines a level in the hierarchy, a classifier string (center),
 * a set of strings within a cluster, and 
 * a radius (max difference of strings within
 * the cluster)
 * 
 * @author Samuel Barr and Grayson Fenwick
 */
public class Cluster {
    private int level;
    private String classifier;
    private int radius;
    //Denotes beginning of string set
    private StringNode strings;
    //Generally points to last node in set
    private StringNode strCursor;
    private Cluster nextLevel;

    /**
     * Node object to support internal linked list
     * of within cluster
     */
    class StringNode {
        public String s;
        public StringNode next;

        public StringNode(String s, StringNode next) {
            this.s = s;
            this.next = next;
        }
    }

    /**
     * Creates a cluster
     *
     * @param level of cluster
     * @param classifer string to denote type of strings in cluster
     * @param radius max difference of all strings in cluster
     */
    public Cluster(int level, String classifier, int radius) {
        this.level = level;
        this.classifer = classifer;
        this.radius = radius;
        nextLevel = null;
        insertString(classifier);
    }

    /**
     * Inserts a string into the cluster
     *
     * @param s string to insert
     */
    public insertString(String s) {
        if (strings == null) {
            strings = new StringNode(s, null);
            strCursor = strings;
        }
        else {
            StringNode n = new StringNode(s, null);
            strCursor.next = n;
            strCursor = n; 
    }

    /****************ACCESSORS******************/
    public int getLevel() { return level; }
    public String getClassifer() { return classifier; }
    public int getRadius() { return radius; }
    public StringNode getStrings() { return strings; }
    public getNextLevel() { return nextLevel; }


    /****************MUTATORS******************/
    public void setLevel(int level) { this.level = level; }
    public void setClassifer(String classifier) { this.classifer = classifier; }
    public void setRadius(int radius) { this.radius = radius; }
    public void setNextLevel(int level) { nextLevel = level; }

}

