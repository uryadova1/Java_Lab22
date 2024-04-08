package ru.nsu.ccfit.uryadova.Base;

import java.io.BufferedReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    private static final Logger logger = LogManager.getLogger(ReadFromFile.class);

    public static final String DELIMETER = " ";

    public static void read(BaseContext baseContext) throws Exception {

        logger.info("method got the arguments to start parsing input file: {}", baseContext);

        Factory factory = new Factory();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(baseContext.getFileName()))) {
            String curStr = reader.readLine();
            if (curStr == null) {
                System.out.println("Current string is already empty");
                logger.info("Current string is already empty");
            }else {
                logger.info("Current command with arguments: {}", curStr);
            }
            while (curStr != null) {
                String[] arguments = curStr.split(DELIMETER);

                ParseArgs.parse(arguments, baseContext, factory);

                curStr = reader.readLine();

            }

        }
        catch (IOException ex) {
            logger.error("File reading error: ", ex);
        }
    }
}
