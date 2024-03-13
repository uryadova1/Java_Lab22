package ru.nsu.ccfit.uryadova.Base;

import java.util.Objects;
import java.util.Scanner;

public class StreamInput {

    private static final String END_COMMAND = "END";
    private static final String DELIMETER = " ";

    public static void parseStream(BaseContext context) throws Exception {

        Factory factory = new Factory();

        Scanner stream = new Scanner(System.in);
        String curStr = stream.nextLine();
        while (!Objects.equals(curStr, END_COMMAND)) {
            String[] arguments = curStr.split(DELIMETER);

            ParseArgs.parse(arguments, context, factory);

            curStr = stream.nextLine();
        }
    }
}
