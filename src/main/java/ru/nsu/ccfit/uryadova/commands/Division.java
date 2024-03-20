package ru.nsu.ccfit.uryadova.commands;

import ru.nsu.ccfit.uryadova.Base.BaseContext;
import ru.nsu.ccfit.uryadova.Base.Worker;
import ru.nsu.ccfit.uryadova.MyExeptions.CommandArgsAmountException;

import java.util.EmptyStackException;

public class Division implements Worker {
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
                throw new ArithmeticException("Division by zero");
            }
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
        }
    }
}
