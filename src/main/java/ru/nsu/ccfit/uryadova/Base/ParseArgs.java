package ru.nsu.ccfit.uryadova.Base;

import java.util.Objects;

public class ParseArgs {

    private static final char COMMENT = '#';

    public static void parse(String[] args, BaseContext context, Factory factory) throws Exception{
        int lenghtWithoutCommand = args.length - 1;
        String command = args[0];
        String[] additions = new String[lenghtWithoutCommand];
        if (lenghtWithoutCommand > 0) {
            System.arraycopy(args, 1, additions, 0, lenghtWithoutCommand);
        }
        if (!Objects.equals(command.charAt(0), COMMENT)){
            Worker currentCommand = factory.getCommand(command);
            if (currentCommand != null){
                currentCommand.execute(context, additions);
            }
        }
    }

}
