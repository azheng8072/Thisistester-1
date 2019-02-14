package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Java program to read CSV file in Java. In this program we will read
 * list of books stored in CSV file as comma separated values.
 *
 * @author WINDOWS 8
 *
 */
public class CSVReader {

    public static void main(String... args) {
        List<Message> messages = readCSV("src/writtenmsg.txt");

        // let's print all the person read from CSV file
        for (Message m : messages) {
            System.out.println(m);
        }
}

    public static List<Message> readCSV(String fileName) {
        List<Message> messages = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {

                String[] attributes = line.split(",");

                Message message = makemessage(attributes);

                messages.add(message);

                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return messages;
    }

    private static Message makemessage(String[] metadata) {
        int bottlenum = Integer.parseInt(metadata[0]);
        String savedbottlemessage = metadata[1];

        return new Message(bottlenum, savedbottlemessage);
    }

}
