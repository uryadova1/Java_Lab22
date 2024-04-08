package ru.nsu.ccfit.uryadova.commands;

import ru.nsu.ccfit.uryadova.Base.BaseContext;
import ru.nsu.ccfit.uryadova.Base.Worker;
import ru.nsu.ccfit.uryadova.MyExeptions.CommandArgsAmountException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Push implements Worker {

    private static final Logger logger = LogManager.getLogger(Push.class);

    @Override

    public void execute(BaseContext context, String[] args) {
        if (args.length == 0) {
            throw new CommandArgsAmountException("Wrongs amount of parameters");
        }
        for (String arg : args) {
            if (context.containsArg(arg)) {
                double value = context.getDefine(arg);
                context.push(value);
                logger.info("Num was pushed {}", value);
            } else {
                try {
                    double value = Double.parseDouble(arg);
                    context.push(value);
                    logger.info("Num was pushed {}", value);
                } catch (NumberFormatException ex) {
                    logger.error("Parsing failed: ", ex);
                    System.out.println("Parsing failed: " + ex);
                }
            }
        }
    }

}


