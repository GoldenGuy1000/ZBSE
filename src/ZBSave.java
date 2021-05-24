import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ZBSave {

    public static void main(String[] args) {
        ZBSave sav1 = new ZBSave(args[0], args[1]);
    }

    public final String saveNum;
    private final String ZBDir;
    public HashMap<String, Object> saveData;

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
            // reading the file into a string
            RandomAccessFile read = new RandomAccessFile(ZBDir + "saveData_" + saveNum + ".sav", "r");
            String saveString = read.readLine();
            // closing the file because it'll cause weirdness if I don't
            read.close();
            // converting it to a map (basically a dict but java with the funny names)
            saveData = Json.toHashMap(saveString);
            // returning that it worked
            return true;
        }
        // if it doesn't work (throws an error for whatever reason) it'll go print it & return that it failed
        catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * writes back to the file (will overwrite if the file has changed)
     */
    public boolean write() {
        try {
            // creating the writer
            FileWriter write = new FileWriter(ZBDir + "saveData_" + saveNum + ".sav");
            write.write(Json.valueOf(saveData));
            write.close();
            return true;
        }
        // same as read, if it doesn't work it'll return false & go print out the error
        catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }

}
