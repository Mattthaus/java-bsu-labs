package by.mathew.labs.reader;

import by.mathew.labs.exception.FileReadException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TextReader {
    private static final Logger logger = LogManager.getLogger(TextReader.class);

    public static String parseText(String path) throws FileReadException {
        if (path == null){
            throw new FileReadException("Path can't be null");
        }
        File file = new File(path);
        logger.info("Got absolute path" + file.getAbsolutePath());
        StringBuilder sb = new StringBuilder("");
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                sb.append(scanner.nextLine());
            }
            return sb.toString();
        }
        catch (FileNotFoundException e){
            throw new FileReadException("No such file at path: " + path, e);
        }
    }
}
