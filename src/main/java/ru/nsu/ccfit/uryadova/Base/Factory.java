package ru.nsu.ccfit.uryadova.Base;

import ru.nsu.ccfit.uryadova.MyExeptions.NonExistingCommand;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Factory {
    private static final Logger logger = LogManager.getLogger(Factory.class);
    private static final HashMap<String, Worker> commands = new HashMap<>();
    String COMMANDS_PATH = "src/main/resources/CommandsPaths.txt";

    Factory() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(COMMANDS_PATH))) {
            String line = reader.readLine();
            while (line != null) {
                String delimetr = " ";
                String[] args = line.split(delimetr);
                int CLASS_PATH_POS = 1;
                Class<?> worker = Class.forName(args[CLASS_PATH_POS]);
                var command = worker.getDeclaredConstructor().newInstance();
                if (command instanceof Worker) {
                    commands.put(args[0], (Worker) command);
                } else {
                    throw new NonExistingCommand("Non existing command");
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            logger.error("File " + COMMANDS_PATH + " was not found. Check the path: ", ex);
        } catch (IOException ex2) {
            logger.error("There is an input problem: ", ex2);
        } catch (ClassNotFoundException ex3) {
            logger.error("No such class found: ", ex3);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException ex4) {
            logger.error("Access Error", ex4);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Worker getCommand(String arg) {
        if (commands.containsKey(arg)) {
            return commands.get(arg);
        }
        throw new NonExistingCommand("Non existing command");
    }
}
