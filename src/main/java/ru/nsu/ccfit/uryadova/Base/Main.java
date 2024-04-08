package ru.nsu.ccfit.uryadova.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static int NO_ARGS = 0;
    private static int ARGS_CNT = 1;

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        if (args.length == ARGS_CNT){
            logger.info("Program starts with file input");
            BaseContext baseContext = new BaseContext(args[0]);
            ReadFromFile.read(baseContext);
        }
        else if (args.length == NO_ARGS){
            logger.info("Program starts with console input");
            BaseContext baseContext = new BaseContext();
            StreamInput.parseStream(baseContext);
        }else {
            logger.error("Wrong amount of arguments given");
        }
    }
}