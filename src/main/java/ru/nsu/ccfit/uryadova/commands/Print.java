package ru.nsu.ccfit.uryadova.commands;

import ru.nsu.ccfit.uryadova.Base.BaseContext;
import ru.nsu.ccfit.uryadova.MyExeptions.CommandArgsAmountException;

import java.util.EmptyStackException;

public class Print implements Worker{
    @Override

    public void execute(BaseContext context, String[] args){
        if (args.length != 0){
            throw new CommandArgsAmountException("Wrongs amount of parameters");
        }
        try {
            double num = context.peek();
            System.out.println(num);
        }catch (EmptyStackException ex){
            System.out.println("Stack is empty");
        }
    }
}
