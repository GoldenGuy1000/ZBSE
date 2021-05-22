import java.io.IOException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZBSave {

    public static void main(String[] args) {
        ZBSave sav1 = new ZBSave("00", "C:\\Users\\Oliver.baconation\\AppData\\Local\\ZaplingBygone\\");
    }

    public final String saveNum;
    private final String ZBDir;

    /**
     * reads the file & initialises the save number/directory of the saves
     *
     * @param saveNumber The save number you want to access
     *                   ex: the save number for save 1 is 00 so put that
     *                   (it's a string because it's easier & I'm not doing math or anything with it)
     * @param ZBSaveLoc The directory of where the save data for Zapling Bygone is
     *                  C:\Users\User\AppData\Local\ZaplingBygone (replace User with your user name)
     */
    public ZBSave(String saveNumber, String ZBSaveLoc) {
        saveNum = saveNumber;
        ZBDir = ZBSaveLoc;
        read();
    }

    /**
     * refreshes the data from the file (will remove any unsaved modifications)
     * @return returns if it successfully read the file or not as a boolean
     */
    public boolean read() {
        try {
            // reading the file into an array
            FileReader read = new FileReader(ZBDir + "saveData_" + saveNum + ".sav");
            char[] saveRaw = new char[32768];
            read.read(saveRaw);

            // making it a string
            String saveString = String.valueOf(saveRaw);
            // grabbing the content with some epic #regex (doing this in tiers so it's easier to read)
            //tier 1 (grabbing everything within the outer curly brackets)
            Matcher fullJson = Pattern.compile("\\{(.+)}").matcher(saveString);
            // tier 2 (making a list of all the objects
            fullJson.find();
            Matcher jsonObject = Pattern.compile("(?<=,|^).+?(?:\\{.+?})?(?=,|$)").matcher(fullJson.group(1));
            while(jsonObject.find()) {
                System.out.println(jsonObject.group());
            }


            // returning that it worked
            return true;
        }
        // if it doesn't work it prints what happened & returns that
        catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * writes back to the file (will overwrite if the file has changed)
     */
    public void write() {

    }



}
