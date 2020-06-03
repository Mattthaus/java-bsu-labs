package by.mathew.labs.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class TextReader {
    private static final Logger logger = LogManager.getLogger(TextReader.class);

    //Читает текст из файла, указанного по пути
    public static String getTextFromPath(String path){
        List<String> textLines = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        try{
            textLines = Files.readAllLines(Paths.get(path));
            for (String line: textLines){
                sb.append(line);
                sb.append('\n');
            }
            sb.deleteCharAt(sb.lastIndexOf("\n"));

            return sb.toString();
        }
        //Исключение если не вышло
        catch (IOException e){
            logger.fatal("Can't get data from text");
            throw new RuntimeException("No input data");
        }
    }
}
