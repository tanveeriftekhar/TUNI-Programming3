package fi.tuni.prog3.sevenzipsearch;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File:");
        String fileName = scanner.nextLine();
        System.out.println("Query:");
        String searchWord = scanner.nextLine();
        System.out.println();

        try (SevenZFile sevenZFile = new SevenZFile(new File(fileName))) {
            int lineNumber = 1;

            SevenZArchiveEntry entry;
            while ((entry = sevenZFile.getNextEntry()) != null) {
                String entryName = entry.getName();
                if (entryName.endsWith(".txt")) {
                    System.out.println(entryName);
                    ByteArrayOutputStream contentBuffer = new ByteArrayOutputStream();
                    int len;
                    byte[] buffer = new byte[4096];
                    while ((len = sevenZFile.read(buffer, 0, buffer.length)) != -1) {
                        contentBuffer.write(buffer, 0, len);
                    }

                    String content = new String(contentBuffer.toByteArray(), "UTF-8");
                    searchAndPrintResults(content, searchWord, lineNumber);
                    lineNumber = 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchAndPrintResults(String content, String searchWord, int lineNumber) {
        Scanner scanner = new Scanner(content);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String lineLowerCase = line.toLowerCase();
            String searchWordLowerCase = searchWord.toLowerCase();

            if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                line = line.replaceAll("(?i)" + searchWord, searchWord.toUpperCase());
                System.out.println(lineNumber + ": " + line);
            }

            lineNumber++;
        }
        System.out.println();
    }
}
