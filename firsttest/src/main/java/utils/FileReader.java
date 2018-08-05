package utils;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {


    public static Object readFromFile(String filename) throws IOException {

    //    List<String> lines = null;

        Object[] myArr = Files.lines(Paths.get(filename), StandardCharsets.UTF_8).toArray();
        for (Object i:myArr) {
            System.out.println(i);
        };
        return myArr;
    }

    public static void main(String[] args) throws IOException {
        Object myArr = readFromFile("src/main/testData/xssCheatSheet.txt");
    /**    for (Object i:myArr) {
            System.out.println(i);
        };*/
    }
}
