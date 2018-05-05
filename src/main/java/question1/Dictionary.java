package question1;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Dictionary {

    public static void main(String[] args) {

        Properties prop = new Properties();
        String path = "src/files/doc.properties";
        doesFileExist(path,prop); //check the path is correct
        List<String> words = new ArrayList<String>();
        words.addAll(Arrays.asList("APPLE","RIDE","CAR"));

        // print the values of the dictionary
        for (int j = 0; j < words.size(); j++){
            System.out.println(words.get(j));
            String [] meanings = prop.getProperty(words.get(j)).split(",");
            for (int i = 0; i< meanings.length;i++){
                System.out.println(meanings[i]);
            }
        }

    }

    private static void doesFileExist(String path, Properties prop){

        InputStream input = null;
        try {

            input = new FileInputStream(path);
            prop.load(input);

        } catch (IOException ex)

        {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
