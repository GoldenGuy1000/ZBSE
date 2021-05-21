import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class ZBSave {
    public String saveNum;
    private String ZBDir;

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
    }

    /**
     * refreshes the data from the file (will remove any unsaved modifications)
     */
    public void read() {

    }

    /**
     * writes back to the file (will overwrite if the file has changed)
     */
    public void write() {

    }



}