package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class BasicFiles {
    public static void createFiles() {
        Path filepath1 = Paths.get("/home/pelmen/java-project-71/app/temp/file1.json");
        Path filepath2 = Paths.get("/home/pelmen/java-project-71/app/temp/file2.json");


        try {
            Path createdFilePath1 = Files.createFile(filepath1);
            System.out.println("File created " + createdFilePath1);

            Path createdFilePath2 = Files.createFile(filepath2);
            System.out.println("File created " + createdFilePath2);
        } catch (Exception e) {
           e.printStackTrace();
      }

        try {
        String textForFile1 =
                "{\n" +
                "  \"host\": \"hexlet.io\",\n" +
                "  \"timeout\": 50,\n" +
                "  \"proxy\": \"123.234.53.22\",\n" +
                "  \"follow\": false\n" +
                "}";
        byte[] bs1 = textForFile1.getBytes();
        Path writtenFilePath1 = Files.write(filepath1, bs1);
        String content1 = Files.readString(writtenFilePath1);
        System.out.println(content1);
        System.out.println();

        String textForFile2 = "{\n" +
                "  \"timeout\": 20,\n" +
                "  \"verbose\": true,\n" +
                "  \"host\": \"hexlet.io\"\n" +
                "}";
        byte[] bs2 = textForFile2.getBytes();
        Path writtenFilePath2 = Files.write(filepath2, bs2);
        String content2 = Files.readString(writtenFilePath2);
        System.out.println(content2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}