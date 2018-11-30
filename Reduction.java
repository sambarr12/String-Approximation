/**
 * Class designed to take a string and reduce it to
 * canonical form by stripping it of its common suffixes
 * 
 * This class follows Paice's conflation rules for reducing
 * a family of words to a common root
 *
 * USAGE: "java Reduction <WordToReduce>"
 *
 * @author Samuel Barr
 * @version 11.30.2018
 */
public class Reduction {

    public static String reduce(String input) {
        //Covert to lowercase & trim extra spaces
        input = input.toLowerCase();
        input = input.trim();
        
        String output = SS(input);
        
        return output;
    }

    private static String SS(String s) {
        if (s.endsWith("ably")) {
            s = cut(s, "ably");
            s = IS(s);
        }
        else if (s.endsWith("ibly")) {
            s = cut(s, "ibly");
        }    
        else if (s.endsWith("ily")) {
            s = cut(s, "ily");
            s = SS(s);
        }
        else if (s.endsWith("ous")) {
            s = cut(s, "ous");
        }
        else if (s.endsWith("ies")) {
            s = cut(s, "ies") + "y";
            s = ARY(s);
        }
        else if (s.endsWith("s")) {
            s = cut(s, "s");
            s = E(s);
        }
        else if (s.endsWith("ied")) {
            s = cut(s, "ied") + "y";
            s = ARY(s);
        }
        else if (s.endsWith("ed")) {
            s = cut(s, "ed");
            s = ABL(s);
        }
        else if (s.endsWith("ing")) {
            s = cut(s, "ing");
            s = ABL(s);
        }
        else 
            s = E(s);
        return s;
    }

    private static String E(String s) {
        if (s.endsWith("e")) {
            s = cut(s, "e");
            s = ABL(s);
        }
        else if (s.endsWith("al")) {
            s = cut(s, "al");
            s = ION(s);
        }
        else
            s = ION(s);
        return s;
    }

    private static String ION(String s) {
        if (s.endsWith("ion")) {
            s = cut(s, "ion");
            s = AT(s);
        }
        return s;
    }

    private static String ARY(String s) {
        if (s.endsWith("ary")) {
            s = cut(s, "ary");
        }
        else if (s.endsWith("ability")) {
            s = cut(s, "ability");
            s = IS(s);
        }
        else if (s.endsWith("ibility")) {
            s = cut(s, "ibility");
        }
        else if (s.endsWith("ity")) {
            s = cut(s, "ity");
            s = IV(s);
        }
        else if (s.endsWith("ify")) {
            s = cut(s, "ify");
        }
        return s;
    }

    private static String ABL(String s) {
        if (s.endsWith("abl")) {
            s = cut(s, "abl");
            s = IS(s); 
        }
        else if (s.endsWith("ibl")) {
            s = cut(s, "ibl");
        }
        else 
            s = IV(s);

        return s;
    }

    private static String IV(String s) {
        if (s.endsWith("iv")) {
            s = cut(s, "iv");
            s = AT(s);
        }
        else 
            s = AT(s);
            
        return s;
    }

    private static String AT(String s) {
        if (s.endsWith("at")) {
            s = cut(s, "at");
            s = IS(s);
        }
        else
            s = IS(s);

        return s;
    }

    private static String IS(String s) {
        if (s.endsWith("is")) {
            s = cut(s, "is");
        }
        else if (s.endsWith("ific")) {
            s = cut(s, "ific");
        }
        else if (s.endsWith("olv")) {
            s = cut(s, "olv") + "olut";
        }
        return s;
    }

    /**
     * Cuts the suffix off of a given string
     * @param input
     * @param suffix to cut
     */
    private static String cut(String input, String suffix) {
        return input.substring(0, input.length() - suffix.length());
    }
    

    public static void main(String[] args) {
        System.out.println(reduce(args[0]));
    }
}
