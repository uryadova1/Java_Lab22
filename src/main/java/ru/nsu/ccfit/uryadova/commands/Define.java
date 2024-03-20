package ru.nsu.ccfit.uryadova.commands;

import ru.nsu.ccfit.uryadova.Base.BaseContext;
import ru.nsu.ccfit.uryadova.Base.Worker;
import ru.nsu.ccfit.uryadova.MyExeptions.CommandArgsAmountException;


public class Define implements Worker {

    @Override
    public void execute(BaseContext context, String[] args) throws Exception{
        if (args.length == 0) {
            throw new CommandArgsAmountException("Wrongs amount of parameters");
        }
        double num;
        String name = args[0];
        String value = args[1];
        try {
            num = Double.parseDouble(value);
            context.define(name, num);
        }catch (NumberFormatException ex){
            System.out.println("Incorrect format of num");
        }
    }
}
