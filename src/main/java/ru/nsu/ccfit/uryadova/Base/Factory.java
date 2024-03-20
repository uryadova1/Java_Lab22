package ru.nsu.ccfit.uryadova.Base;

import ru.nsu.ccfit.uryadova.MyExeptions.NonExistingCommand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Factory {
    private static final HashMap<String, Worker> commands = new HashMap<>();

    Factory() throws IOException {
        String COMMANDS_PATH = "/home/tyzzko/IdeaProjects/Java_Lab22/src/main/java/ru/nsu/ccfit/uryadova/Base/CommandsPaths.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(COMMANDS_PATH))) {
            String line = reader.readLine();
            while (line != null) {
                String delimetr = " ";
                String[] args = line.split(delimetr);
                int CLASS_PATH_POS = 1;
                Class<?> worker = Class.forName(args[CLASS_PATH_POS]);
                int COMMAND_POS = 0;
                if (!commands.containsKey(COMMAND_POS)) {
                    commands.put(args[COMMAND_POS], (Worker) worker.newInstance());
                } else {
                    throw new NonExistingCommand("Non existing command");
                }
                line = reader.readLine();
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
            throw new RuntimeException(e1);
        }
    }

    public Worker getCommand(String arg) {
        if (commands.containsKey(arg)) {
            return commands.get(arg);
        }
        throw new NonExistingCommand("Non existing command");
    }
}
