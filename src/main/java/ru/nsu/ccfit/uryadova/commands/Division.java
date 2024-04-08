package ru.nsu.ccfit.uryadova.commands;

import ru.nsu.ccfit.uryadova.Base.BaseContext;
import ru.nsu.ccfit.uryadova.Base.Worker;
import ru.nsu.ccfit.uryadova.MyExeptions.CommandArgsAmountException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EmptyStackException;

public class Division implements Worker {

    private static final Logger logger = LogManager.getLogger(Division.class);

    @Override
    public void execute(BaseContext context, String[] args) {
        if (args.length != 0) {
            throw new CommandArgsAmountException("Wrongs amount of parameters");
        }
        try {
            double num1 = context.popReturn();
            double num2 = context.popReturn();
            if (num1 != 0) {
                context.push(num2 / num1);
            } else {
                logger.error("Division by zero");
                throw new ArithmeticException("Division by zero");
            }
        } catch (EmptyStackException ex) {
            logger.error("Stack is empty", ex);
            System.out.println("Stack is empty");
        }
    }
}
