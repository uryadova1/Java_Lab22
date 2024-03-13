package ru.nsu.ccfit.uryadova.Base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class ReadFromFile {

    public static final String DELIMETER = " ";

    public static void read(BaseContext baseContext) throws Exception {
        Factory factory = new Factory();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(baseContext.getFileName()))) {
            String curStr = reader.readLine();
            if (curStr == null) {
                System.out.println("Current string is already empty");
            }
            while (curStr != null) {
                String[] arguments = curStr.split(DELIMETER);

                ParseArgs.parse(arguments, baseContext, factory);

                curStr = reader.readLine();

            }

        }
    }
}
