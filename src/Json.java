import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Json {
    public static HashMap<String, Object> toHashMap (String json) {
        // grabbing the content with some epic #regex (doing this in tiers so it's easier to read)
        //tier 1 (grabbing everything within the outer curly brackets)
        Matcher fullJson = Pattern.compile("\\{(.+)}").matcher(json);

        // tier 2 (making a list of all the objects)
        if (fullJson.find());
        return jsObject(fullJson.group());
    }

    private static HashMap<String, Object> jsObject(String fullJson) {
        Matcher jsonObject = Pattern.compile("(?<=,|^).+?(?:\\{.+?})?(?=,|$)").matcher(fullJson);

        // building tier 3 (making linked pairs)
        HashMap<String, Object> all = new HashMap<>();

        while (jsonObject.find()) {
            Matcher jsonKeyVal = Pattern.compile("\"(.+?)\": \"(.+?)\"").matcher(jsonObject.group(0));
            // making the hashmaps
            if (jsonKeyVal.find())
                all.put(jsonKeyVal.group(1), jsonKeyVal.group(2));
            else {
                // different splitting for maximum inconsistency
                String[] arraySplitThingy = jsonObject.group(0).split("\": \\{");
                all.put(arraySplitThingy[0].substring(1), jsObject(arraySplitThingy[1].substring(0, arraySplitThingy.length)));
            }
        }
        return all;
    }
}
