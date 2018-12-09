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
    private String center;
    private int radius;
    //Denotes beginning of string set
    //private StringNode strings;
    //Generally points to last node in set
    private ArrayList<Cluster> children;
    private ArrayList<String> strings;


    /**
     * Node object to support internal linked list
     * of strings within cluster
     *
    class StringNode {
        public String s;
        public StringNode next;
        public StringNode prev;

        public StringNode(String s, StringNode next) {
            this.s = s;
            this.next = next;
            this.prev = prev;
        }
    }
    */

    /**
     * Creates a cluster
     *
     * @param level of cluster
     * @param classifer string to denote type of strings in cluster
     * @param radius max difference of all strings in cluster
     */
    public Cluster(int level, String center, int radius) {
        this.level = level;
        this.center = center;
        this.radius = radius;
        children = new ArrayList<Cluster>();
        strings = new ArrayList<String>();
        strings.add(center);
    }

    /**
     * Inserts a string into the cluster
     *
     * @param s string to insert
     *
    public void insert(String s) {
        if (strings == null) {
            strings = new StringNode(s, null);
            strCursor = strings;
        }
        else {
            StringNode n = new StringNode(s, null);
            strCursor.next = n;
            strCursor = n; 
       }
    */
    /*
    public void remove() {
        if (strCursor == null) {
            System.out.println("Tried to remove null cursor");
            return;
        }
        //cursor is at start node
        if (strCursor == strings) {
            strCursor.next.prev = null;
            strings = strCursor.next;
            strCursor.next == null;
        }
        //cursor is at end node
        else if (strCursor.next == null) {
            
        }
    }
    */

    public void insertString(String s) {
        //Leaf checking
        //If there are no strings and no children, add to cluster
        if (children.size() == 0) {
            if (strings.size() == 0) {
                strings.add(s);
            }
            //If there is one string and no children, add to cluster
            //and calculate correct radius
            else if (strings.size() == 1) {
                strings.add(s);
                int diff = Difference.calcDiff(s, center);
                if (diff == radius)
                    return;
                if (diff > radius)
                    radius = diff;
            }
            //If multiple strings and no children
            else if (strings.size() > 1) {
                int diff = 0;
                for (int i = 0; i < strings.size(); i++) {
                    diff = Difference.calcDiff(strings.get(i), s);
                    if (diff < radius && children.size() == 0) 
                        children.add(new Cluster(level+1, s, diff));                 
                    else if (diff < radius)
                        children.get(children.size()-1).getStrings().add(s);
                }
            }
        }
        else {
            strings.add(s);
        }
    }

    /****************ACCESSORS******************/
    public int getLevel() { return level; }
    public String getCenter() { return center; }
    public int getRadius() { return radius; }
    public ArrayList<String> getStrings() { return strings; }
    public Cluster getChild(int i) {
        if (i < children.size()) 
            return children.get(i); 
        else
            return null;
    }
    public int getNumChildren() { return children.size(); }


    /****************MUTATORS******************/
    public void setLevel(int level) { this.level = level; }
    public void setCenter(String center) { this.center = center; }
    public void setRadius(int radius) { this.radius = radius; }
    public void addChild(Cluster c) { children.add(c); }

}

