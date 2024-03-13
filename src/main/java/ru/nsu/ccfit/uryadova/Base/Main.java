package ru.nsu.ccfit.uryadova.Base;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface Command{
    void execute(LinkedList<Integer> stack, List<String> args, Map<Integer, Integer> params);
}

public class Main {
    private static int NO_ARGS = 0;
    private static int ARGS_CNT = 1;
    public static void main(String[] args) throws Exception {
        if (args.length == ARGS_CNT){
            BaseContext baseContext = new BaseContext(args[0]);
            ReadFromFile.read(baseContext);
        }
        else if (args.length == NO_ARGS){
            BaseContext baseContext = new BaseContext();
            StreamInput.parseStream(baseContext);
        }
    }
}