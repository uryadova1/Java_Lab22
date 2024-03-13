package ru.nsu.ccfit.uryadova.commands;

import ru.nsu.ccfit.uryadova.Base.BaseContext;
import ru.nsu.ccfit.uryadova.MyExeptions.CommandArgsAmountException;


public class Push implements Worker {
    @Override

    public void execute(BaseContext context, String[] args) {
        if (args.length == 0) {
            throw new CommandArgsAmountException("Wrongs amount of parameters");
        }
        for (String arg : args) {
            if (context.containsArg(arg)) {
                double value = context.getDefine(arg);
                context.push(value);
            } else {
                try {
                    double value = Double.parseDouble(arg);
                    context.push(value);
                } catch (NumberFormatException ex) {
                    System.out.println("Parsing failed: " + ex);
                }
            }
        }
    }

}
