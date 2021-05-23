import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Json {
    /**
     * when it finds an object it calls itself
     * @param json a nice json object {"like": "this"}
     * @return a hashmap
     */
    public static HashMap<String, Object> toHashMap (String json) {
        // if there's curly brackets this gets rid of them
        Matcher noCurlyBracket = Pattern.compile("\\{(.+)}").matcher(json);
        if (noCurlyBracket.find())
        json = noCurlyBracket.group(1).trim();

        // yes I really did spend 10 hours on regex to make this move along
        Matcher jsonObject = Pattern.compile("\"(.+?)\": (?:\"(.+?)\"|\\{(.+?)})").matcher(json);

        // making output map
        HashMap<String, Object> all = new HashMap<>();

        while (jsonObject.find()) {
            // populating the hashmap
            if (jsonObject.group(3)==null) {
                all.put(jsonObject.group(1).trim(), jsonObject.group(2).trim());
            }
            // epic recursion if it's an array
            else if (jsonObject.group(2)==null){
                all.put(jsonObject.group(1).trim(), toHashMap(jsonObject.group(3).trim()));
            }
            // just in case my regex *somehow* broke
            else {
                System.out.println("matching didn't work for some reason with this element:\t" + jsonObject.group(0));
            }
        }
        return all;
    }
}
//todo fix how it deals with decimals & make it return the proper type (like Double & stuff)