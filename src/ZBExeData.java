import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// this version is developed for Zapling Bygone 110521
public class ZBExeData {
    public static void main(String[] args) {

        String ZaplingDir = "F:\\Program Files (x86)\\ZaplingBygone_110521\\";
        System.out.println(getRoomNames(ZaplingDir));

    }

    public static ArrayList<String> getRoomNames(String ZaplingDir) {
        // setting filepath
        String inputFile = ZaplingDir + "ZaplingBygone.exe";

        // declaring the list
        ArrayList<String> areaList = new ArrayList<>();
        // making the buffer that gets looked through for rooms
        char[] chars = new char[20000];

        try {
            // opening file
            FileReader ZBExe = new FileReader(inputFile);

            //skipping to the bit where the room names are
            ZBExe.skip(0xbcd59f);

            // reading in that bit
            ZBExe.read(chars);

            Matcher m = Pattern.compile("(?<=(gml_RoomCC_))(([^_]+?_?){1,3})(?=(_0_Create))").matcher(String.valueOf(chars));
            while(m.find())
            {
                areaList.add(m.group(2));
            }

            return areaList;
        }


        // if file path is wrong or some update broke it you'll be told about it
        catch (IOException e) {
            System.out.println(e);
            areaList.add("it broke lmao");
            return areaList;
        }

    }
}
