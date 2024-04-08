package ru.nsu.ccfit.uryadova.commands;

import ru.nsu.ccfit.uryadova.Base.BaseContext;
import ru.nsu.ccfit.uryadova.Base.Worker;
import ru.nsu.ccfit.uryadova.MyExeptions.CommandArgsAmountException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EmptyStackException;

public class Mult implements Worker {

    private static final Logger logger = LogManager.getLogger(Mult.class);

    @Override
    public void execute(BaseContext context, String[] args) {
        if (args.length != 0) {
            throw new CommandArgsAmountException("Wrongs amount of parameters");
        }
        try {
            double num1 = context.popReturn();
            double num2 = context.popReturn();
            context.push(num2 * num1);

        } catch (NumberFormatException ex1) {
            logger.error("Parsing failed:: ", ex1);
            System.out.println("Parsing failed: " + ex1);
        }catch (EmptyStackException ex2){
            logger.error("Stack is empty: ", ex2);
            System.out.println("Stack is empty");
        }
    }
}
