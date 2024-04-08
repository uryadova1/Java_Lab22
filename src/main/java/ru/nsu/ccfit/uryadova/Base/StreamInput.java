package ru.nsu.ccfit.uryadova.Base;

import java.util.Objects;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamInput {

    private static final Logger logger = LogManager.getLogger(StreamInput.class);
    private static final String END_COMMAND = "END";
    private static final String DELIMETER = " ";

    public static void parseStream(BaseContext context) throws Exception {
        logger.info("stream parsing started successfully: \n{}", context);
        Factory factory = new Factory();

        Scanner stream = new Scanner(System.in);
        String curStr = stream.nextLine();
        logger.info("Current command with arguments: {}", curStr);
        while (!Objects.equals(curStr, END_COMMAND)) {
            String[] arguments = curStr.split(DELIMETER);

            ParseArgs.parse(arguments, context, factory);

            curStr = stream.nextLine();
        }
    }
}
