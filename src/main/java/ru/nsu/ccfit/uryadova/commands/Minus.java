package ru.nsu.ccfit.uryadova.commands;

import ru.nsu.ccfit.uryadova.Base.BaseContext;
import ru.nsu.ccfit.uryadova.Base.Worker;
import ru.nsu.ccfit.uryadova.MyExeptions.CommandArgsAmountException;

import java.util.EmptyStackException;

public class Minus implements Worker {
    @Override
    public void execute(BaseContext context, String[] args) {
        if (args.length != 0) {
            throw new CommandArgsAmountException("Wrongs amount of parameters");
        }
        try {
            double num1 = context.popReturn();
            double num2 = context.popReturn();
            context.push(num2 - num1);

        } catch (NumberFormatException ex1) {
            System.out.println("Parsing failed: " + ex1);
        }catch (EmptyStackException ex){
            System.out.println("Stack is empty");
        }
    }
}
