package AmarpalAmrith.EmailExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("SampleText.txt");

        String entireFile = new String(Files.readAllBytes(path));
        String[] splitString = entireFile.split("\\s+");
        String searchCriteria = "@softwire.com";
        int instances = 0;

        for (int i = 0; i < splitString.length; i++) {
            Pattern searchStore = Pattern.compile(".+" + searchCriteria);
            Matcher searchString = searchStore.matcher(splitString[i]);
            boolean containsString = searchString.matches();
            if (containsString) {
                instances++;
            }
        }
        System.out.println("Number of instances of " + searchCriteria + " is: " + instances);

    }


}
