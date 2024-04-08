package ru.nsu.ccfit.uryadova.commands;

import ru.nsu.ccfit.uryadova.Base.BaseContext;
import ru.nsu.ccfit.uryadova.Base.Worker;
import ru.nsu.ccfit.uryadova.MyExeptions.CommandArgsAmountException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EmptyStackException;

public class Print implements Worker {

    private static final Logger logger = LogManager.getLogger(Print.class);
    @Override

    public void execute(BaseContext context, String[] args){
        if (args.length != 0){
            throw new CommandArgsAmountException("Wrongs amount of parameters");
        }
        try {
            double num = context.peek();
            System.out.println(num);
            logger.info("Num was written: {}", num);
        }catch (EmptyStackException ex){
            logger.error("Stack is empty: ", ex);
            System.out.println("Stack is empty");
        }
    }
}
