package ru.nsu.ccfit.uryadova.Base;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParseArgs {

    private static final char COMMENT = '#';
    private static final Logger logger = LogManager.getLogger(ParseArgs.class);

    public static void parse(String[] args, BaseContext context, Factory factory) throws Exception{
        if (args.length == 0) {
            logger.error("No arguments given");
        }
        else {
            logger.info("Run parseArgs with context: \n{}", context);
        }
        int lenghtWithoutCommand = args.length - 1;
        String command = args[0];
        String[] additions = new String[lenghtWithoutCommand];
        if (lenghtWithoutCommand > 0) {
            System.arraycopy(args, 1, additions, 0, lenghtWithoutCommand);
        }
        if (!Objects.equals(command.charAt(0), COMMENT)){
            Worker currentCommand = factory.getCommand(command);
            if (currentCommand != null){
                currentCommand.execute(context, additions);
            }
        }
    }

}
