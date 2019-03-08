package AmarpalAmrith.EmailExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3Hashmaps {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("SampleText.txt");
        String entireFile = new String(Files.readAllBytes(path));
        String[] splitString = entireFile.split("\\s+");
        HashMap <String, Integer> storeDomains = new HashMap<>();

        for (int i = 0; i < splitString.length; i++) {
            Pattern searchStore = Pattern.compile(".+@(.+\\..+)");
            Matcher searchString = searchStore.matcher(splitString[i]);
            boolean containsString = searchString.matches();
            if (containsString) {
                storeDomains.put(searchString.group(1),storeDomains.getOrDefault(searchString.group(1), 0) + 1);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do? (select from; top 10, frequency, )");
        System.out.print(">");
        String input = scanner.nextLine().toLowerCase();

        switch (input) {
            case "top 10":
                List <String> allDomains = new ArrayList<>(storeDomains.keySet());
                allDomains.sort(Comparator.comparing(storeDomains::get));
                int counter = 10;
                for (int i = allDomains.size() - 1; i >= allDomains.size() - 10; i--) {
                    System.out.println("Top " + counter + " " + allDomains.get(i) + " = " + storeDomains.get(allDomains.get(i)));
                    counter--;
                }
            case "frequency":
                int requestValue = Utilities.requestInt("To obtain the number of times a domain name occurs, please enter a frequency ", 1);
                for (String domainName : storeDomains.keySet()) {
                    if (storeDomains.get(domainName) > requestValue) {
                        System.out.println(domainName + " with a value of " + storeDomains.get(domainName));
                    }
                }
        }
    }
}
