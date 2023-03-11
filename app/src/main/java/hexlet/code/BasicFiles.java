/*
package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class BasicFiles {
    public static void createFiles() {
        Path path1 = Paths.get("/home/pelmen/java-project-71/app/file1.json");
        Path path2 = Paths.get("/home/pelmen/java-project-71/app/file2.json");


        try {
            Path createdFilePath1 = Files.createFile(path1);
            System.out.println("File created " + createdFilePath1);

            Path createdFilePath2 = Files.createFile(path2);
            System.out.println("File created " + createdFilePath2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String textForFile1 =
                    """
                        {
                          "host": "hexlet.io",
                          "timeout": 50,
                          "proxy": "123.234.53.22",
                          "follow": false
                        }""";
            byte[] bs1 = textForFile1.getBytes();
            Path writtenFilePath1 = Files.write(path1, bs1);
            Path filepath1 = Paths.get(writtenFilePath1.toUri()).toAbsolutePath().normalize();

            String textForFile2 = """
                {
                  "timeout": 20,
                  "verbose": true,
                  "host": "hexlet.io"
                }""";
            byte[] bs2 = textForFile2.getBytes();
            Path writtenFilePath2 = Files.write(path2, bs2);
            Path filepath2 = Paths.get(writtenFilePath2.toUri()).toAbsolutePath().normalize();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/